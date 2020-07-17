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
      <el-tabs v-model="activeInfoName">
        <el-tab-pane label="基本信息" name="basic">
          <el-form
            :model="ruleForm"
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
          >
            <el-row :gutter="20">
              <el-col :span="12">
                <el-form-item label="表名称" prop="name">
                  <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="表描述" prop="name">
                  <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="20">
              <el-col :span="12">
                <el-form-item label="实体类名称" prop="name">
                  <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="作者" prop="name">
                  <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="20">
              <el-col :span="24">
                <el-form-item label="实体类名称" prop="name">
                  <el-input type="textarea" v-model="ruleForm.name" rows="5"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-form-item style="text-align: center;">
              <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
              <el-button @click="resetForm('ruleForm')">取消</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="字段信息" name="field">
          <el-table
            ref="singleTable1"
            border
            size="mini"
            :data="columns"
            row-key="columnId"
            highlight-current-row
            style="width: 100%"
          >
            <el-table-column label="序号" type="index" min-width="5%" class-name="allowDrag" />
            <el-table-column
              label="字段列名"
              prop="columnName"
              min-width="10%"
              :show-overflow-tooltip="true"
            />
            <el-table-column label="字段描述" min-width="10%">
              <template slot-scope="scope">
                <el-input v-model="scope.row.columnComment"></el-input>
              </template>
            </el-table-column>
            <el-table-column
              label="物理类型"
              prop="columnType"
              min-width="10%"
              :show-overflow-tooltip="true"
            />
            <el-table-column label="Java类型" min-width="11%">
              <template slot-scope="scope">
                <el-select v-model="scope.row.javaType">
                  <el-option label="Long" value="Long" />
                  <el-option label="String" value="String" />
                  <el-option label="Integer" value="Integer" />
                  <el-option label="Double" value="Double" />
                  <el-option label="BigDecimal" value="BigDecimal" />
                  <el-option label="Date" value="Date" />
                </el-select>
              </template>
            </el-table-column>
            <el-table-column label="java属性" min-width="10%">
              <template slot-scope="scope">
                <el-input v-model="scope.row.javaField"></el-input>
              </template>
            </el-table-column>

            <el-table-column label="插入" min-width="5%">
              <template slot-scope="scope">
                <el-checkbox true-label="1" v-model="scope.row.isInsert"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column label="编辑" min-width="5%">
              <template slot-scope="scope">
                <el-checkbox true-label="1" v-model="scope.row.isEdit"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column label="列表" min-width="5%">
              <template slot-scope="scope">
                <el-checkbox true-label="1" v-model="scope.row.isList"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column label="查询" min-width="5%">
              <template slot-scope="scope">
                <el-checkbox true-label="1" v-model="scope.row.isQuery"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column label="查询方式" min-width="10%">
              <template slot-scope="scope">
                <el-select v-model="scope.row.queryType">
                  <el-option label="=" value="EQ" />
                  <el-option label="!=" value="NE" />
                  <el-option label=">" value="GT" />
                  <el-option label=">=" value="GTE" />
                  <el-option label="<" value="LT" />
                  <el-option label="<=" value="LTE" />
                  <el-option label="LIKE" value="LIKE" />
                  <el-option label="BETWEEN" value="BETWEEN" />
                </el-select>
              </template>
            </el-table-column>
            <el-table-column label="必填" min-width="5%">
              <template slot-scope="scope">
                <el-checkbox true-label="1" v-model="scope.row.isRequired"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column label="显示类型" min-width="12%">
              <template slot-scope="scope">
                <el-select v-model="scope.row.htmlType">
                  <el-option label="文本框" value="input" />
                  <el-option label="文本域" value="textarea" />
                  <el-option label="下拉框" value="select" />
                  <el-option label="单选框" value="radio" />
                  <el-option label="复选框" value="checkbox" />
                  <el-option label="日期控件" value="datetime" />
                </el-select>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="生成信息" name="generate">14</el-tab-pane>
      </el-tabs>
    </a-el-dialog>
  </div>
</template>

<script>
import { resGenGetTable, resGenGenTemplate } from "../../api";
import { IS_OK } from "../../api/path";
export default {
  name: "DatabaseManage",
  data() {
    return {
      tableData: [],
      centerDialogVisible: false,
      editDialogVisible: false,
      activeName: "entity",
      activeInfoName: "basic",
      tabArrar: [],
      ruleForm: {
        name: ""
      },
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" }
        ]
      },
      columns: [
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3209,
          tableId: 299,
          columnName: "notice_id",
          columnComment: "公告ID",
          columnType: "int(4)",
          javaType: "Integer",
          javaField: "noticeId",
          isPk: "1",
          isIncrement: "1",
          isRequired: null,
          isInsert: "1",
          isEdit: null,
          isList: null,
          isQuery: null,
          queryType: "EQ",
          htmlType: "input",
          dictType: "",
          sort: 1,
          list: false,
          required: false,
          pk: true,
          superColumn: false,
          usableColumn: false,
          increment: true,
          insert: true,
          edit: false,
          query: false
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3210,
          tableId: 299,
          columnName: "notice_title",
          columnComment: "公告标题",
          columnType: "varchar(50)",
          javaType: "String",
          javaField: "noticeTitle",
          isPk: "0",
          isIncrement: "0",
          isRequired: "1",
          isInsert: "1",
          isEdit: "1",
          isList: "1",
          isQuery: "1",
          queryType: "EQ",
          htmlType: "input",
          dictType: "",
          sort: 2,
          list: true,
          required: true,
          pk: false,
          superColumn: false,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: true
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3211,
          tableId: 299,
          columnName: "notice_type",
          columnComment: "公告类型（1通知 2公告）",
          columnType: "char(1)",
          javaType: "String",
          javaField: "noticeType",
          isPk: "0",
          isIncrement: "0",
          isRequired: "1",
          isInsert: "1",
          isEdit: "1",
          isList: "1",
          isQuery: "1",
          queryType: "EQ",
          htmlType: "select",
          dictType: "",
          sort: 3,
          list: true,
          required: true,
          pk: false,
          superColumn: false,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: true
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3212,
          tableId: 299,
          columnName: "notice_content",
          columnComment: "公告内容",
          columnType: "varchar(2000)",
          javaType: "String",
          javaField: "noticeContent",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: "1",
          isList: "1",
          isQuery: "1",
          queryType: "EQ",
          htmlType: "textarea",
          dictType: "",
          sort: 4,
          list: true,
          required: false,
          pk: false,
          superColumn: false,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: true
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3213,
          tableId: 299,
          columnName: "status",
          columnComment: "公告状态（0正常 1关闭）",
          columnType: "char(1)",
          javaType: "String",
          javaField: "status",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: "1",
          isList: "1",
          isQuery: "1",
          queryType: "EQ",
          htmlType: "radio",
          dictType: "",
          sort: 5,
          list: true,
          required: false,
          pk: false,
          superColumn: false,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: true
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3214,
          tableId: 299,
          columnName: "create_by",
          columnComment: "创建者",
          columnType: "varchar(64)",
          javaType: "String",
          javaField: "createBy",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: null,
          isList: null,
          isQuery: null,
          queryType: "EQ",
          htmlType: "input",
          dictType: "",
          sort: 6,
          list: false,
          required: false,
          pk: false,
          superColumn: true,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: false,
          query: false
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3215,
          tableId: 299,
          columnName: "create_time",
          columnComment: "创建时间",
          columnType: "datetime",
          javaType: "Date",
          javaField: "createTime",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: null,
          isList: null,
          isQuery: null,
          queryType: "EQ",
          htmlType: "datetime",
          dictType: "",
          sort: 7,
          list: false,
          required: false,
          pk: false,
          superColumn: true,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: false,
          query: false
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3216,
          tableId: 299,
          columnName: "update_by",
          columnComment: "更新者",
          columnType: "varchar(64)",
          javaType: "String",
          javaField: "updateBy",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: "1",
          isList: null,
          isQuery: null,
          queryType: "EQ",
          htmlType: "input",
          dictType: "",
          sort: 8,
          list: false,
          required: false,
          pk: false,
          superColumn: true,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: false
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3217,
          tableId: 299,
          columnName: "update_time",
          columnComment: "更新时间",
          columnType: "datetime",
          javaType: "Date",
          javaField: "updateTime",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: "1",
          isList: null,
          isQuery: null,
          queryType: "EQ",
          htmlType: "datetime",
          dictType: "",
          sort: 9,
          list: false,
          required: false,
          pk: false,
          superColumn: true,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: false
        },
        {
          searchValue: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null,
          dataScope: null,
          params: {},
          columnId: 3218,
          tableId: 299,
          columnName: "remark",
          columnComment: "备注",
          columnType: "varchar(255)",
          javaType: "String",
          javaField: "remark",
          isPk: "0",
          isIncrement: "0",
          isRequired: null,
          isInsert: "1",
          isEdit: "1",
          isList: "1",
          isQuery: null,
          queryType: "EQ",
          htmlType: "input",
          dictType: "",
          sort: 10,
          list: true,
          required: false,
          pk: false,
          superColumn: true,
          usableColumn: false,
          increment: false,
          insert: true,
          edit: true,
          query: false
        }
      ]
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
      this.getApiResGenGenTemplate(row.tableSchema, row.tableName, 1);
    },
    handleEditClick(row) {
      this.editDialogVisible = true;
      console.log(row);
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
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