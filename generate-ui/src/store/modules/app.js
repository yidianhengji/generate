const state = {
  sidebar: {
    opened: false
  },
  logout: false
};

const mutations = {
  TOGGLE_SIDEBAR: state => {
    state.sidebar.opened = !state.sidebar.opened;
  },
  TOGGLE_LOGOUT: state => {
    state.logout = !state.logout;
  }
};

const actions = {
  toggleSideBar({ commit }) {
    commit("TOGGLE_SIDEBAR");
  },
  toggleLogout({ commit }) {
    commit("TOGGLE_LOGOUT");
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
