<template>
  <div>
    <img id="background" class="position-absolute h-100 w-100" 
        style="z-index: -10; opacity: 50%; object-fit: cover" 
        src="@/assets/background.jpg">

    <div v-if="estaLogado">
      <com-side-bar></com-side-bar>
      <com-menu></com-menu>
      <div class="container pt-5 pt-80">
        <router-view></router-view>
      </div>
    </div>
    <div v-else>
      <app-login v-on:FazerLogin="permitirAcesso($event)" />
    </div>
  </div>
</template>

<script>
import ComSideBar from "./components/ComSideBar";
import ComMenu from "./components/ComMenu";
import Login from "@/components/Login.vue";

export default {
  components: {
    "com-side-bar": ComSideBar,
    "com-menu": ComMenu,
    "app-login": Login,
  },
  data() {
    return {
      estaLogado: false,
    };
  },
  methods: {
    permitirAcesso(_estaLogado) {
      this.estaLogado = _estaLogado;
    },
  },
};
</script>