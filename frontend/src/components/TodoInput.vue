/* eslint-disable */

<template>
<div class="form-group">
  <p>
    <label for="descriptionInput">New Todo:</label>
    <input id="descriptionInput" v-model.lazy="todo.description" type="text" class="form-control" placeholder="Description" aria-label="Description" aria-describedby="basic-addon1" @keydown.enter="submitTodo" @focus="clearFieldsForNewTodo">
  </p>
  <p>
    <button class="btn btn-primary" @click.prevent="submitTodo">Submit new Todo</button>
  </p>
  <div v-show="success" class="alert alert-success" role="alert">
    Yeah, a new Todo was created :)
  </div>
  <div v-if="errors.length" class="alert alert-danger" role="alert">
    <h4>Oh no, an error</h4>
    <p class="mb-0" v-for="error in errors" v-bind:key="error.toSource">{{ error }}</p>
  </div>

</div>
</template>

<script>
import axios from 'axios'

export default {
  data: function () {
    return {
      todo: {
        title: '',
        description: ''
      },
      success: false,
      errors: []
    }
  },
  methods: {
    clearFieldsForNewTodo () {
      this.todo.description = ''
      this.success = false
      this.errors = []
    },
    submitTodo () {
      axios.post('todo123', {
        title: this.todo.title,
        description: this.todo.description
      })
        .then(response => {
          this.success = true
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>

<style scoped>

</style>
