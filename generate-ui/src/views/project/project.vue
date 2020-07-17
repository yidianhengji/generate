<template>
  <div class="app-wrapper">
    <div class="project-box">
      <div class="title">
        <h4>选择项目</h4>
        <a href="javascript:void(0);" @click="handleNewProjectBtn">新建项目</a>
      </div>
      <div class="body">
        <ul>
          <li v-for="(item,index) in dataList" :key="index">
            <div class="top" :style="{background: colorArr[index%4]}"></div>
            <div class="bottom">
              <h3>{{item.projectName}}</h3>
              <p>{{item.description}}</p>
              <span @click="handleLink(item.projectId)">进入项目</span>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <el-drawer :visible.sync="drawer" :with-header="false" :before-close="beforeClose">
      <div class="project-from">
        <h4>项目基本信息</h4>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm">
          <el-form-item label="项目名称" prop="projectName">
            <el-input v-model="ruleForm.projectName"></el-input>
          </el-form-item>
          <el-form-item label="项目描述" prop="description">
            <el-input
              type="textarea"
              v-model="ruleForm.description"
              maxlength="50"
              show-word-limit
              rows="3"
            ></el-input>
          </el-form-item>
          <el-form-item size="large">
            <el-button type="primary" @click="handleSubmit('ruleForm')">立即创建</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import { resApiProjectsSave, resApiProjectsQueryAll } from "../../api";
import { IS_OK } from "../../api/path";
export default {
  name: "Project",
  data() {
    return {
      colorArr: ["#4ba8fa", "#fac23e", "#906cd9", "#7d91b3"],
      drawer: false,
      dataList: [],
      ruleForm: {
        projectName: "",
        description: ""
      },
      rules: {
        projectName: [
          { required: true, message: "请输入项目名称", trigger: "blur" },
          { min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getResApiProjectsQueryAll();
  },
  methods: {
    async getResApiProjectsQueryAll() {
      const res = await resApiProjectsQueryAll();
      if (res.data.code === IS_OK) {
        this.dataList = res.data.data;
      }
    },
    handleSubmit(formName) {
      this.$refs[formName].validate(async valid => {
        if (valid) {
          const res = await resApiProjectsSave(this.ruleForm);
          if (res.data.code === IS_OK) {
            setTimeout(() => {
              this.$message({
                type: "success",
                message: "新增成功"
              });
              this.getResApiProjectsQueryAll();
              this.beforeClose();
            }, 500);
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    handleNewProjectBtn() {
      this.drawer = true;
    },
    beforeClose() {
      this.$refs.ruleForm.resetFields();
      this.drawer = false;
    },
    handleLink(projectId) {
      localStorage.setItem("projectId", projectId);
      this.$router.push("/projectPath");
    }
  }
};
</script>

<style scoped lang="stylus">
.app-wrapper {
  width: 100%;
  height: 100%;
  background: #fafbfc;

  .project-from {
    padding: 30px;
    height: 100%;

    > h4 {
      font-size: 24px;
      font-family: '黑体';
      color: #384354;
      margin-bottom: 30px;
    }

    /deep/ .el-form-item__label {
      width: 100%;
      text-align: left;
      font-size: 16px;
      font-family: '黑体';
      color: #384354;
    }
  }

  .project-box {
    width: 1080px;
    margin: 0 auto;
    padding-top: 120px;
    background: #fafbfc;

    .title {
      display: flex;
      align-items: center;

      h4 {
        flex: 1;
        font-size: 24px;
        font-family: '黑体';
        color: #384354;
      }
    }

    .body {
      margin-top: 40px;

      ul {
        display: flex;
        flex-wrap: wrap;

        li {
          flex: 0 0 256px;
          margin-right: 18px;
          box-shadow: 0 5px 6px #eee;
          margin-bottom: 20px;

          &:nth-child(4n+4) {
            margin-right: 0px;
          }

          .top {
            width: 256px;
            height: 180px;
            background: #4ba8fa;
            border-radius: 4px 4px 0 0;
          }

          .bottom {
            background: #fff;
            padding: 15px 10px 10px;
            border-radius: 0 0 4px 4px;
            box-sizing: border-box;

            h3 {
              font-size: 18px;
              font-family: '黑体';
              color: #384354;
            }

            p {
              color: #aeb7c4;
              font-size: 14px;
              line-height: 18px;
              margin: 6px 0 8px;
              font-family: '黑体';
            }

            span {
              color: #aeb7c4;
              font-size: 16px;
              font-family: '黑体';
              cursor: pointer;

              &:hover {
                opacity: 0.8;
                color: #409eff;
              }
            }
          }
        }
      }
    }
  }
}
</style>