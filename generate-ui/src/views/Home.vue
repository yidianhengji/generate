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
        <template>
          <a href="javascript:void(0);">设置</a>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { resGenGetTable } from "../api";
import { IS_OK } from "../api/path";
export default {
  name: "Home",
  data() {
    return {
      tableData: []
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