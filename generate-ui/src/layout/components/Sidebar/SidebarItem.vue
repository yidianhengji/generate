<template>
  <div>
    <el-submenu v-if="item.children" :index="item.id">
      <template slot="title">
        <i :class="item.icon"></i>
        <span v-show="!isNest">{{ item.name }}</span>
      </template>
      <sidebar-item v-for="child in item.children" :key="child.path" :item="child" :isNest="isNest"></sidebar-item>
    </el-submenu>
    <el-menu-item v-else :index="item.url" :key="item.id">
      <i :class="item.icon"></i>
      <span slot="title">{{ item.name }}</span>
    </el-menu-item>
  </div>
</template>

<script>
export default {
  name: "SidebarItem",
  props: {
    item: {
      type: Object,
      required: true
    },
    isNest: {
      type: Boolean,
      default: false
    }
  }
};
</script>

<style></style>
