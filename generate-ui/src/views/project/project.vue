<template>
  <div class="app-wrapper">
    <ul class="project-list">
      <li class="active">
        <h4>+</h4>
        <p>创建新项目</p>
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
      <li>
        <img
          src="http://172.18.1.67:8080/profile/upload/2020/06/02/38a43b013b0c72956159e229d0aa9be0.jpg"
          alt
        />
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Project"
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

      &:nth-child(6n+6) {
        margin-right: 0px;
      }

      img {
        width: 100%;
        height: 100%;
      }
    }
  }
}
</style>