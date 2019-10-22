<template>
  <div class="service">
    <h1>{{ message }}</h1>
    <h2>Dies ist ein kleiner Test</h2>

    <button @click="showAllTodos()">Show all Todos</button>

    <h4>Alle Todos: {{ response }}</h4>
  </div>
</template>

<script>import axios from 'axios'
export default {
  name: 'service',
  data () {
    return {
      message: 'Some Message from the backend',
      response: [],
      erros: []
    }
  },

  methods: {
    showAllTodos () {
      axios.get('todo')
        .then(response => {
          this.response = response.data
          console.log(response.data)
        })
        .catch(e => {
          this.erros.push(e)
        })
    }
  }
}
</script>
