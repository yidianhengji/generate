<template>
  <div style="width: 40%; margin: 0 auto; padding-top: 140px;">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>项目配置</span>
      </div>
      <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="140px" size="small">
          <el-form-item label="项目地址" prop="projectPath">
            <el-input v-model="ruleForm.projectPath" placeholder="F:\shop\generate\generate"></el-input>
          </el-form-item>
          <el-form-item label="java地址" prop="javaPath">
            <el-input v-model="ruleForm.javaPath" placeholder="src\main\java"></el-input>
          </el-form-item>
          <el-form-item label="项目包名" prop="packagePath">
            <el-input v-model="ruleForm.packagePath" placeholder="com\pg\generate"></el-input>
          </el-form-item>
          <el-form-item label="项目包" prop="packagePathT">
            <el-input v-model="ruleForm.packagePathT" placeholder="com.pg.generate"></el-input>
          </el-form-item>
          <el-form-item label="mapper地址" prop="mapperPath">
            <el-input v-model="ruleForm.mapperPath" placeholder="src\main\resources\mapper"></el-input>
          </el-form-item>
          <el-form-item label="数据库名称" prop="databaseName">
            <el-input v-model="ruleForm.databaseName"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">保存</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
import { resApiProjectsQueryOne, resApiProjectsUpdate } from "../../api";
import { IS_OK } from "../../api/path";
export default {
  name: "projectPath",
  data() {
    return {
      ruleForm: {
        projectPath: "",
        javaPath: "",
        packagePath: "",
        packagePathT: "",
        mapperPath: "",
        databaseName: ""
      },
      rules: {}
    };
  },
  created() {
    this.getResApiProjectsQueryOne();
  },
  methods: {
    async getResApiProjectsQueryOne() {
      const res = await resApiProjectsQueryOne({
        projectId: localStorage.getItem("projectId")
      });
      if (res.data.code === IS_OK) {
        this.ruleForm = res.data.data;
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
        if (valid) {
          const res = await resApiProjectsUpdate(this.ruleForm);
          if (res.data.code === IS_OK) {
            setTimeout(() => {
              this.$message({
                type: "success",
                message: "修改成功"
              });
            }, 500);
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
  }
};
</script>

<style lang="stylus" scoped></style>