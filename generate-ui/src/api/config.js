import axios from "axios";
import { IS_OK } from "./path";
import { Message, MessageBox } from "element-ui";
let count = 0;

export default function request(url, data = {}, method = "GET") {
  return new Promise(resolve => {
    let promise;
    // 请求之前统一拦截，并设置请求头
    axios.interceptors.request.use(
      config => {
        if (localStorage.getItem("uid")) {
          config.headers.uid = `${localStorage.getItem("uid")}`;
        }
        return config;
      },
      err => {
        return Promise.reject(err);
      }
    );
    // 调用方法
    if (method === "GET") {
      promise = axios.get(url, { params: data });
    } else if (method === "POST") {
      promise = axios.post(url, data);
    } else if (method === "PUT") {
      promise = axios.put(url, data);
    } else if (method === "DELETE") {
      promise = axios.delete(url, data);
    }
    // 请求成功后的统一拦截处理
    promise
      .then(res => {
        resolve(res);
        if (res.data.code !== IS_OK) {
          let msg = res.data.msg ? res.data.msg : "后台没提示";
          Message.error(msg);
        }
      })
      .catch(err => {
        console.log(err.response);
        if (count == 0) {
          if (err.response.status === 401) {
            MessageBox.confirm(err.response.data.msg, "系统提示", {
              confirmButtonText: "重新登录",
              showClose: false,
              showCancelButton: false,
              type: "error"
            }).then(() => {
              document.dispatchEvent(new Event("logout"));
            });
          } else {
            Message.error(err.message);
          }
          count++;
        }
      });
  });
}
