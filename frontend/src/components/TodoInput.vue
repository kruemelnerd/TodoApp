<template>
<div class="form-group">
  <p>
    <label for="titleInput">Title:</label>
    <input type="text" id="titleInput" v-model.lazy="todo.title"/>

    <label for="descriptionInput">Description:</label>
    <input id="descriptionInput" v-model.lazy="todo.description" type="text" class="form-control" placeholder="Description" aria-label="Description" aria-describedby="basic-addon1">
  </p>
  <p>
    <button class="btn btn-primary" @click.prevent="submitTodo">Submit new Todo</button>
  </p>
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
      errors: []
    }
  },
  methods: {
    submitTodo () {
      axios.post('todo', {
        title: this.todo.title,
        description: this.todo.description
      })
        .then(response => {})
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>

<style scoped>

</style>
