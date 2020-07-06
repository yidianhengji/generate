<template>
  <div class="fixed-header" :style="{ left: headerLeft }">
    <div class="header-nav-flex">
      <div class="navbar">
        <div class="hamburger-container" @click="toggleSideBar">
          <span>
            <i class="el-icon-s-fold"></i>
          </span>
        </div>
        <breadcrumb />
      </div>
      <div class="right-nav-bar">
        <el-dropdown class="username-container">
          <div class="username-text">
            <img class="userImg" src="../../../assets/userImg.png" />
            <span>系统管理员</span>
            <i class="el-icon-arrow-down el-icon--right"></i>
          </div>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <div class="center">修改密码</div>
            </el-dropdown-item>
            <el-dropdown-item @click.native="signOut">
              <div class="center">退出平台</div>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
import Breadcrumb from "@/components/Breadcrumb/index.vue";
export default {
  components: {
    Breadcrumb
  },
  props: {
    sidebar: {
      type: Object
    }
  },
  computed: {
    headerLeft() {
      return this.sidebar.opened ? "62px" : "220px";
    }
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch("app/toggleSideBar");
    },
    signOut() {
      this.$confirm("是否退出该系统?", "温馨提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        document.dispatchEvent(new Event("logout"));
      });
    }
  }
};
</script>

<style lang="stylus" scoped>
.fixed-header {
  position: fixed;
  top: 0;
  right: 0;
  left: 220px;
  z-index: 9;
  -webkit-transition: left 0.28s;
  transition: left 0.28s;

  .header-nav-flex {
    position: relative;
    height: 50px;
    background: #344058;

    .navbar {
      height: 100%;
      overflow: hidden;
      position: relative;
      -webkit-box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
      box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);

      .hamburger-container {
        line-height: 46px;
        height: 100%;
        float: left;
        cursor: pointer;
        -webkit-transition: background 0.3s;
        transition: background 0.3s;
        -webkit-tap-highlight-color: transparent;
        padding: 0px 15px;
        font-size: 16px;
        color: #ffffff;

        &:hover {
          background: rgba(0, 0, 0, 0.025);
        }

        span {
          display: inline-block;
          background: #409eff;
          height: 30px;
          line-height: 30px;
          width: 30px;
          text-align: center;
        }
      }

      .breadcrumb-container {
        float: left;
        display: inline-block;
        font-size: 14px;
        line-height: 50px;
        margin-left: 8px;
      }
    }

    .right-nav-bar {
      position: absolute;
      right: 0px;
      top: 0px;
      height: 100%;

      .username-container {
        height: 100%;
        padding: 0 10px;

        .username-text {
          display: flex;
          justify-content: center;
          align-items: center;
          height: 100%;
          color: #fff;
          outline: none;

          .userImg {
            width: 26px;
            height: 26px;
            margin-right: 5px;
            border-radius: 50%;
          }
        }
      }
    }
  }
}
</style>
