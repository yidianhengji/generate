<template>
  <div class="app-wrapper">
    <ul class="project-list">
      <li class="active">
        <div>
          <h4>+</h4>
          <p>创建新项目</p>
        </div>
      </li>
      <li v-for="(item, index) in 5" :key="index" @click="handleClick">
        <div>项目1</div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Project",
  methods: {
    handleClick() {
      this.$router.push("/home");
    }
  }
};
</script>

<style scoped lang="stylus">
.app-wrapper {
  width: 100%;
  height: 100%;

  .project-list {
    padding: 80px 120px;
    list-style: none;
    display: flex;
    flex-wrap: wrap;

    li {
      flex: 0 0 calc(16.5% - 6px);
      margin-right: 10px;
      margin-bottom: 10px;
      height: 180px;
      display: flex;
      align-items: center;
      justify-content: center;
      border: 1px solid #eee;
      box-sizing: border-box;
      cursor: pointer;
      transition: 2s;

      &.active {
        background: #eee;

        > div {
          text-align: center;

          h4 {
            font-size: 60px;
          }
        }
      }

      &:hover {
        transform: scale(1.1);
      }

      &:nth-child(6n+6) {
        margin-right: 0px;
      }

      img {
        width: 100%;
        height: 100%;
        border: 1px solid #ccc;
        display: block;
      }
    }
  }
}
</style>