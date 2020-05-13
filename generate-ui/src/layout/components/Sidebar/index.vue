<template>
  <div class="sidebar-container" :style="{ width: sidebarWidth }">
    <logo />
    <el-scrollbar
      wrap-class="scrollbar-wrapper"
      v-if="permissionRoutes && permissionRoutes.length > 0"
    >
      <el-menu
        :router="router"
        :mode="mode"
        :collapse="isCollapse"
        :default-active="$route.path"
        :unique-opened="uniqueOpened"
        :background-color="backgroundColor"
        :text-color="textColor"
        :active-text-color="activeTextColor"
        :collapse-transition="collapseTransition"
        style="border-right: none;"
      >
        <sidebar-item
          v-for="route in permissionRoutes"
          :key="route.id"
          :index="route.id"
          :item="route"
          :isNest="sidebar.opened"
        />
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import Logo from "./Logo";
import SidebarItem from "./SidebarItem";
export default {
  components: {
    Logo,
    SidebarItem
  },
  props: {
    sidebar: {
      type: Object
    }
  },
  data() {
    return {
      router: true,
      mode: "vertical",
      backgroundColor: "#344058",
      textColor: "#fff",
      activeTextColor: "#1e9fff",
      uniqueOpened: false,
      collapseTransition: false,
      permissionRoutes: [
        {
          id: "00",
          name: "首页",
          icon: "el-icon-document",
          url: "/home"
        },
        {
          id: "11",
          name: "系统管理",
          icon: "el-icon-document",
          url: "",
          children: [
            {
              id: "112",
              name: "人员管理",
              icon: "el-icon-document",
              url: "/personnel"
            },
            {
              id: "113",
              name: "字典管理",
              icon: "el-icon-document",
              url: "/dictionary"
            },
            {
              id: "114",
              name: "角色管理",
              icon: "el-icon-document",
              url: "/role"
            },
            {
              id: "115",
              name: "菜单管理",
              icon: "el-icon-document",
              url: "/menus"
            },
            {
              id: "116",
              name: "部门管理",
              icon: "el-icon-document",
              url: "/department"
            },
            {
              id: "117",
              name: "单位管理",
              icon: "el-icon-document",
              url: "/company"
            }
          ]
        },
        {
          id: "22",
          name: "公告管理",
          icon: "el-icon-document",
          url: "/notice"
        },
        {
          id: "33",
          name: "商品管理",
          icon: "el-icon-document",
          url: "/goods"
        }
      ]
    };
  },
  computed: {
    isCollapse() {
      return this.sidebar.opened;
    },
    sidebarWidth() {
      return this.sidebar.opened ? "62px" : "220px";
    }
  },
};
</script>

<style lang="stylus" scoped>
.sidebar-container {
  -webkit-transition: width 0.28s;
  transition: width 0.28s;
  background-color: #304156;
  height: 100%;
  position: fixed;
  font-size: 0;
  top: 0;
  bottom: 0;
  left: 0;
  z-index: 1001;
  overflow: hidden;

  > .el-scrollbar {
    height: calc(100% - 50px);
  }
}
</style>
