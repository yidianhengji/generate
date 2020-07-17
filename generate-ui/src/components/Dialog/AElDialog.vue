<template>
  <transition name="dialog-fade">
    <div v-show="visible" class="wrapper" ref="wrapper" :key="key">
      <div role="dialog" class="AEchendmDialog" :id="id" ref="AEchendmDialog" :style="{ width }">
        <div class="AEchendmDialog__header" ref="header">
          <slot name="title">
            <span class="AEchendmDialog__title">{{ title }}</span>
          </slot>
          <button
            type="button"
            class="AEchendmDialog__headerbtn headerbtn__close"
            @click="handleClose"
          >
            <i class="AEchendmDialog__icon el-icon el-icon-close"></i>
          </button>
        </div>
        <div class="AEchendmDialog__body" ref="body">
          <div class="AEchendmDialog__content">
            <slot></slot>
          </div>
        </div>
        <div class="AEchendmDialog__footer" ref="footer" v-if="$slots.footer">
          <slot name="footer"></slot>
        </div>
      </div>
    </div>
  </transition>
</template>

<script type="text/jsx">
import { Random } from "../../util/commonUtils";
import Popup from "element-ui/src/utils/popup";

export default {
  name: "AElDialog",
  mixins: [Popup],
  props: {
    visible: Boolean,
    title: String,
    beforeCloseDestroy: Boolean,
    width: String,
    ShowCloseButton: {
      type: Boolean,
      default: false
    },
    beforeClose: Function,
    top: String
  },
  data() {
    return {
      key: 0,
      id: "dialog" + Random(),
      mouseDownX: 0,
      mouseDownY: 0,
      initX: 0,
      initY: 0,
      drag: false
    };
  },
  mounted() {
    if (this.visible) {
      this.init();
    }
    window.addEventListener("resize", this.setHeight);
    document.addEventListener("mousedown", this.commonMousedown);
    document.addEventListener("mousemove", this.commonMouseMove);
    document.addEventListener("mouseup", this.commonMouseUp);
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.setHeight);
    document.removeEventListener("mousedown", this.commonMousedown);
    document.removeEventListener("mousemove", this.commonMouseMove);
    document.removeEventListener("mouseup", this.commonMouseUp);
  },
  methods: {
    commonMousedown(e) {
      const flag = e.target.closest(`#${this.id} .AEchendmDialog__header`);
      if (flag) {
        const rootEle = e.target.closest(`#${this.id}`);
        this.initX = rootEle.offsetLeft;
        this.initY = rootEle.offsetTop;
        this.mouseDownX = e.pageX;
        this.mouseDownY = e.pageY;
        this.drag = true;
      }
    },
    commonMouseMove(e) {
      if (this.drag) {
        let left = parseInt(e.pageX) - parseInt(this.mouseDownX) + this.initX;
        let top = parseInt(e.pageY) - parseInt(this.mouseDownY) + this.initY;

        this.$refs.AEchendmDialog.style.left = `${left}px`;
        this.$refs.AEchendmDialog.style.top = `${top}px`;
      }
    },
    commonMouseUp() {
      this.drag = false;
      this.initX = this.$refs.AEchendmDialog.offsetLeft;
      this.initY = this.$refs.AEchendmDialog.offsetTop;
    },
    setHeight() {
      this.$nextTick(() => {
        const height = document.body.offsetHeight;
        const dialogHeight = height - 20; // 上下空20px
        const footer = this.$refs.footer;
        let maxHeight = "";
        this.$refs.AEchendmDialog.style.maxHeight = `${dialogHeight}px`;
        if (this.$slots.footer) {
          // 10为dialogBody的 padding值
          maxHeight = `${dialogHeight -
            this.$refs.header.offsetHeight -
            footer.offsetHeight -
            10}px`;
        } else {
          // 20为dialogBody的上下padding值
          maxHeight = `${dialogHeight - this.$refs.header.offsetHeight - 20}px`;
        }
        this.$refs.body.style.maxHeight = maxHeight;
        // this.$refs.body.querySelector('.AEchendmDialog__content').style.maxHeight = maxHeight;

        this.$refs.AEchendmDialog.style.left = `${(document.body.offsetWidth -
          this.$refs.AEchendmDialog.offsetWidth) /
          2}px`;
        if (this.top) {
          this.$refs.AEchendmDialog.style.top = this.top;
        } else {
          this.$refs.AEchendmDialog.style.top = `${(document.body.offsetHeight -
            this.$refs.AEchendmDialog.offsetHeight) /
            2}px`;
        }
      });
    },
    handleClose() {
      if (this.beforeClose) {
        this.beforeClose();
      } else {
        this.$emit("update:visible", false);
        this.$emit("close");
      }
    },
    init() {
      document.body.appendChild(this.$el);
      this.setHeight();
    }
  },
  watch: {
    visible(val) {
      if (val) {
        this.init();
      } else {
        if (this.beforeCloseDestroy) {
          this.$nextTick(() => {
            this.key++;
          });
        }
        window.removeEventListener("resize", this.setHeight);
      }
    }
  }
};
</script>

<style lang="stylus" scoped>
.wrapper {
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  overflow: hidden;
  margin: 0;
  z-index: 9;
}

.AEchendmDialog {
  position: absolute;
  border-radius: 2px;
  -webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 50%;
  background: #fff;

  .AEchendmDialog__header {
    padding: 10px 20px;
    border-bottom: 1px solid #eee;
    cursor: move;

    .AEchendmDialog__title {
      font-size: 15px;
      line-height: normal;
    }

    .AEchendmDialog__headerbtn {
      position: absolute;
      top: 15px;
      right: 20px;
      padding: 0;
      background: 0 0;
      border: none;
      outline: 0;
      cursor: pointer;
      font-size: 16px;

      &.headerbtn__fullscreen {
        right: 40px;
      }
    }
  }

  .AEchendmDialog__body {
    padding: 10px;
    overflow: auto;
  }

  .AEchendmDialog__footer {
    padding: 15px;
    border-top: 1px solid #eee;
    text-align: right;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }
}
</style>
