<template>
  <div class="app-wrapper">
    <sidebar :sidebar="sidebar" />
    <div class="main-container" :style="{ marginLeft: mainMarginLeft }">
      <navbar :sidebar="sidebar" />
      <app-main />
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { AppMain, Sidebar, Navbar } from "./components";
export default {
  components: {
    AppMain,
    Sidebar,
    Navbar
  },
  computed: {
    ...mapGetters(["sidebar"]),
    mainMarginLeft() {
      return this.sidebar.opened ? "62px" : "220px";
    }
  }
};
</script>

<style scoped lang="stylus">
.app-wrapper {
  width: 100%;
  height: 100%;

  .main-container {
    height: 100%;
    -webkit-transition: margin-left 0.28s;
    transition: margin-left 0.28s;
    position: relative;
  }
}
</style>
