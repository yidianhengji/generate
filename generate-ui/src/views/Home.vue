<template>
  <div class="home">
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
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="提示" :visible.sync="centerDialogVisible" width="60%">
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

      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { resGenGetTable, resGenGenTemplate } from "../api";
import { IS_OK } from "../api/path";
export default {
  name: "Home",
  data() {
    return {
      tableData: [],
      centerDialogVisible: false,
      activeName: "entity",
      tabArrar: []
    };
  },
  created() {
    this.getApiResGenGetTable();
  },
  methods: {
    async getApiResGenGetTable() {
      const res = await resGenGetTable();
      if (res.data.code === IS_OK) {
        this.tableData = res.data.data;
      }
    },
    async getApiResGenGenTemplate(tableSchema, tableName) {
      const res = await resGenGenTemplate({ tableSchema, tableName });
      if (res.data.code === IS_OK) {
        this.tabArrar = res.data.data;
      }
    },
    handleClick(row) {
      this.centerDialogVisible = true;
      this.getApiResGenGenTemplate(row.tableSchema, row.tableName);
      console.log(row);
    }
  }
};
</script>

<style lang="stylus" scoped>
.home {
  padding: 10px;
  box-sizing: border-box;
}
</style>