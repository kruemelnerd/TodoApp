<template>
  <div class="service">
    <h1>{{ message }}</h1>
    <h2>Dies ist ein kleiner Test</h2>

    <p><TodoInput></TodoInput></p>

    <button @click="showAllTodos()">Show all Todos</button>

    <h4>Alle Todos:</h4>
    <ul>
      Test
      <li v-for="item in response" v-bind:key="item.id">
        {{ item.description }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
import TodoInput from './TodoInput'

export default {
  name: 'service',
  components: {TodoInput},
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
