import { resgetUpdateDataTable } from "@/api";
import { IS_OK } from "@/api/path";

export const databaseUpdate = {
  data () {
    return {
      loadingUpdate: false
    }
  },
  methods: {
    async loadingUpdateBtn () {
      this.loadingUpdate = true;
      const res = await resgetUpdateDataTable({ projectId: localStorage.getItem("projectId") });
      if (res.data.code === IS_OK) {
        setTimeout(() => {
          this.$message({
            type: "success",
            message: "更新成功"
          });
          this.loadingUpdate = false
        }, 500);
      } else {
        this.loadingUpdate = false
      }
    }
  }
}