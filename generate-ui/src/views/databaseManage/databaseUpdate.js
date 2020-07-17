export const databaseUpdate = {
  data () {
    return {
      loadingUpdate: false
    }
  },
  methods: {
    loadingUpdateBtn () {
      this.loadingUpdate = true;
      alert()
    }
  }
}