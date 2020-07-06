<template>
  <div style="width: 40%; margin: 0 auto; padding-top: 140px;">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>项目地址</span>
      </div>
      <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="140px" size="small">
          <el-form-item label="项目地址" prop="name">
            <el-input v-model="ruleForm.name" placeholder="F:\shop\generate\generate"></el-input>
          </el-form-item>
          <el-form-item label="java地址" prop="name">
            <el-input v-model="ruleForm.name" placeholder="src\main\java"></el-input>
          </el-form-item>
          <el-form-item label="项目包名" prop="name">
            <el-input v-model="ruleForm.name" placeholder="com\pg\generate"></el-input>
          </el-form-item>
          <el-form-item label="项目包" prop="name">
            <el-input v-model="ruleForm.name" placeholder="com.pg.generate"></el-input>
          </el-form-item>
          <el-form-item label="mapper地址" prop="name">
            <el-input v-model="ruleForm.name" placeholder="src\main\resources\mapper"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "projectPath",
  data() {
    return {
      ruleForm: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" }
        ],
        region: [
          { required: true, message: "请选择活动区域", trigger: "change" }
        ],
        date1: [
          {
            type: "date",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        date2: [
          {
            type: "date",
            required: true,
            message: "请选择时间",
            trigger: "change"
          }
        ],
        type: [
          {
            type: "array",
            required: true,
            message: "请至少选择一个活动性质",
            trigger: "change"
          }
        ],
        resource: [
          { required: true, message: "请选择活动资源", trigger: "change" }
        ],
        desc: [{ required: true, message: "请填写活动形式", trigger: "blur" }]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
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