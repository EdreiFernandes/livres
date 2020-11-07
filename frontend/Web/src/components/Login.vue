<template>
  <div>
    <div class="d-table position-absolute w-100 h-100">
      <div class="d-table-cell align-middle">
        <div class="d-flex justify-content-center">
          <div class="card text-center" style="width: 30rem">
            <div class="card-header"><h3>Fazer Login</h3></div>

            <div class="card-body">
              <input
                type="text"
                name="username"
                id="username"
                class="form-control mb-3"
                placeholder="Usuário"
                v-model="username"
              />

              <input
                type="password"
                name="senha"
                id="senha"
                class="form-control"
                placeholder="Senha"
                v-model="senha"
              />
            </div>

            <div class="card-footer text-muted">
              <button
                type="button"
                name="login"
                id="login"
                class="btn btn-primary"
                @click="logar()"
              >
                Logar
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      senha: "",
    };
  },
  methods: {
    logar() {
      this.$emit("FazerLogin", true);
    },
  },
};
</script>

<style></style>
