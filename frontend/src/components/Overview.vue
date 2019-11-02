<template>
  <div class="overview">
    <h1>{{ message }}</h1>
    <h2>Dies ist ein kleiner Test</h2>

    <p><TodoInput></TodoInput></p>

    <button @click="showAllTodos()">Show all Todos</button>

    <h4>Alle Todos:</h4>

    <b-list-group>
      <b-list-group-item button v-for="item in response" v-bind:key="item.id">
        <div class="d-flex w-100">
          <b-form-checkbox class="mr-n2">
            <span class="sr-only">Checkbox for following text input</span>
          </b-form-checkbox>
          <div class="todoItemDescription">
            {{ item.description }}
          </div>
        </div>
      </b-list-group-item>
    </b-list-group>
  </div>
</template>

<script>
import axios from 'axios'
import TodoInput from './TodoInput'

export default {
  name: 'overview',
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

<style>
  .todoItemDescription{
    padding-left: 5px;
  }
</style>
