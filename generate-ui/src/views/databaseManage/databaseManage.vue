<template>
  <div class="home">
    <div>
      <el-button type="primary" size="small" @click="loadingUpdateBtn" :loading="loadingUpdate">更新表</el-button>
    </div>
    <el-table
      ref="singleTable"
      border
      size="mini"
      :data="tableData"
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column type="index" width="80" align="center" label="序号"></el-table-column>
      <el-table-column property="tableSchema" label="数据库名称" width="200"></el-table-column>
      <el-table-column property="tableName" label="表名称" width="200"></el-table-column>
      <el-table-column property="tableComment" label="表注释"></el-table-column>
      <el-table-column property="tableCollation" label="表排序规则"></el-table-column>
      <el-table-column property="createTime" label="创建时间"></el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">预览</el-button>
          <el-button @click="handleEditClick(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="handleClick2(scope.row)" type="text" size="small">下载</el-button>
        </template>
      </el-table-column>
    </el-table>
    <a-el-dialog title="代码预览" :visible.sync="centerDialogVisible" width="60%" top="20px">
      <el-tabs v-model="activeName">
        <el-tab-pane label="entity.java" name="entity">
          <pre>{{tabArrar["templates/java/entity.vm"]}}</pre>
        </el-tab-pane>
        <el-tab-pane label="dao.java" name="dao">
          <pre>{{tabArrar["templates/java/dao.vm"]}}</pre>
        </el-tab-pane>
        <el-tab-pane label="service.java" name="service">
          <pre>{{tabArrar["templates/java/service.vm"]}}</pre>
        </el-tab-pane>
        <el-tab-pane label="serviceImpl.java" name="serviceImpl">
          <pre>{{tabArrar["templates/java/serviceImpl.vm"]}}</pre>
        </el-tab-pane>
        <el-tab-pane label="controller.java" name="controller">
          <pre>{{tabArrar["templates/java/controller.vm"]}}</pre>
        </el-tab-pane>
        <el-tab-pane label="mapper.xml" name="mapper">
          <pre>{{tabArrar["templates/xml/mapper.vm"]}}</pre>
        </el-tab-pane>
      </el-tabs>
      <template slot="footer">
        <el-button @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
      </template>
    </a-el-dialog>
    <a-el-dialog title="修改生成配置" :visible.sync="editDialogVisible" width="80%" top="20px">
      <databaseManageConfig :uidObj="uidObj" v-if="editDialogVisible"></databaseManageConfig>
    </a-el-dialog>
  </div>
</template>

<script>
import { resGenGenTemplate, resApiDatabaseQueryPage } from "../../api";
import { IS_OK } from "../../api/path";
import { databaseUpdate } from "./databaseUpdate.js";
import databaseManageConfig from "./databaseManageConfig.vue";

export default {
  name: "DatabaseManage",
  mixins: [databaseUpdate],
  components: {
    databaseManageConfig,
  },
  data() {
    return {
      tableData: [],
      centerDialogVisible: false,
      editDialogVisible: false,
      activeName: "entity",
      tabArrar: [],
      uidObj: {},
      ruleForm: {
        name: "",
      },
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getApiResGenGetTable();
  },
  methods: {
    async getApiResGenGetTable() {
      const res = await resApiDatabaseQueryPage({
        pageSize: 10,
        pageNum: 1,
        projectId: localStorage.getItem("projectId"),
      });
      if (res.data.code === IS_OK) {
        this.tableData = res.data.data.list;
      }
    },
    async getApiResGenGenTemplate(tableSchema, tableName, type) {
      const res = await resGenGenTemplate({ tableSchema, tableName, type });
      if (res.data.code === IS_OK) {
        this.tabArrar = res.data.data;
      }
    },
    handleClick(row) {
      this.centerDialogVisible = true;
      this.getApiResGenGenTemplate(row.tableSchema, row.tableName, 2);
    },
    handleClick2(row) {
      this.getApiResGenGenTemplate(row.tableSchema, row.tableName, 2);
    },
    handleEditClick(row) {
      this.editDialogVisible = true;
      this.uidObj = row;
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style lang="stylus" scoped>
.home {
  padding: 10px;
  box-sizing: border-box;
}
</style>