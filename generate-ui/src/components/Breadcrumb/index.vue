<template>
  <el-breadcrumb class="app-breadcrumb" separator="/">
    <el-breadcrumb-item v-for="(item, index) in arr" :key="index">
      {{
      item
      }}
    </el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script>
export default {
  data() {
    return {
      menus: [],
      arr: []
    };
  },
  created() {
    let getMenu = localStorage.getItem("menu");
    this.menus = JSON.parse(getMenu);
    this.getBreadcrumb(this.$route.path);
  },
  methods: {
    getBreadcrumb(name) {
      this.getList(this.menus, name);
    },
    getList(data, name) {
      if (data && data.length > 0) {
        data.map(item => {
          if (item.pageUrl == name) {
            this.arr.push(item.menuName);
            this.getParentList(this.menus, item.upMenuId);
          }
          if (item.children && item.children.length > 0) {
            this.getList(item.children, name);
          }
        });
      }
    },
    getParentList(data, upMenuId) {
      data.map(item => {
        if (item.menuId == upMenuId) {
          this.arr.unshift(item.menuName);
        }
        if (item.children && item.children.length > 0) {
          this.getParentList(item.children, upMenuId);
        }
      });
    }
  },
  watch: {
    $route(val) {
      this.arr = [];
      this.getBreadcrumb(val.path);
    }
  }
};
</script>

<style lang="stylus" scoped>
.app-breadcrumb.el-breadcrumb {
  display: inline-block;
  font-size: 14px;
  line-height: 50px;
  margin-left: 8px;

  .no-redirect {
    color: #97a8be;
    cursor: text;
  }
}
</style>
