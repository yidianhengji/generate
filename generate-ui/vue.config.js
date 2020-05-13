const path = require("path");

function resolve(dir) {
  return path.join(__dirname, dir);
}

module.exports = {
  // 如果你不需要生产环境的 source map，可以将其设置为 false 以加速生产环境构建。
  productionSourceMap: false,
  publicPath: "./",
  // Server配置
  devServer: {
    port: 3002,
    proxy: {
      "^/api": {
        target: "http://localhost:9999/",
        changeOrigin: true
      }
    },
    before: app => {}
  },
  configureWebpack: {
    // provide the app's title in webpack's name field, so that
    // it can be accessed in index.html to inject the correct title.
    name: "vue Element Admin",
    resolve: {
      alias: {
        "@": resolve("src")
      }
    }
  }
};
