<template>
  <section class="app-main">
    <transition name="fade-transform" mode="out-in">
      <router-view />
    </transition>
  </section>
</template>

<script>
export default {};
</script>

<style lang="stylus" scoped>
.app-main {
  height: calc(100% - 50px);
  width: 100%;
  position: relative;
  padding-top: 50px;
}
</style>
