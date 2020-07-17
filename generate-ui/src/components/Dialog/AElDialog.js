import AElDialog from "./AElDialog.vue"

const aeldialog = {
  install: function (Vue) {
    Vue.component('AElDialog', AElDialog)
  }
}

export default aeldialog;