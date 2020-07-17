import request from "./config";
import { API_PATH } from "./path";

export const resGenGetTable = () => request(API_PATH + "gen/genTable", null, "GET");
export const resGenGetTableColumn = data => request(API_PATH + "gen/genTableColumn", data, "GET");
export const resGenGenTemplate = data => request(API_PATH + "gen/genTemplate", data, "GET");

/**
 * 项目管理
 */
export const resApiProjectsQueryPage = data => request(API_PATH + "projects/queryPage", data, "POST");
export const resApiProjectsQueryAll = data => request(API_PATH + "projects/queryAll", data, "GET");
export const resApiProjectsQueryOne = data => request(API_PATH + "projects/queryOne", data, "GET");
export const resApiProjectsSave = data => request(API_PATH + "projects/save", data, "POST");
export const resApiProjectsUpdate = data => request(API_PATH + "projects/update", data, "PUT");
export const resApiProjectsDelete = data => request(API_PATH + "projects/delete", data, "DELETE");