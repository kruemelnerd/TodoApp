<template>
<div class="form-group">
  <div class="row">
    <div class="col-10">
     <input id="descriptionInput" v-model.lazy="todo.description" type="text" class="form-control" placeholder="Description" aria-label="Description" aria-describedby="basic-addon1" @keydown.enter="submitTodo" @focus="clearFieldsForNewTodo">
    </div>
    <div class="col-2">
      <button class="btn btn-primary" @click.prevent="submitTodo">Submit new Todo</button>
    </div>
  </div>
  <b-alert :show="showSuccess" variant="success" dismissible >Yeah, a new Todo was created :)</b-alert>
  <b-alert :show="showErrors" variant="danger" dismissible>
    <h4>Oh no, an error</h4>
    <p class="mb-0" v-for="error in errors" v-bind:key="error.toSource">{{ error }}</p>
  </b-alert>
</div>
</template>

<script>
import axios from 'axios'

export default {
  /* eslint-disable */
  data: function () {
    return {
      todo: {
        title: '',
        description: ''
      },
      showSuccess: false,
      showErrors: false,
      errors: []
    }
  },
  methods: {
    clearFieldsForNewTodo () {
      this.todo.description = ''
      this.showSuccess = false
      this.showErrors = false
      this.errors = []
    },
    submitTodo () {
      var desc = this.todo.description.trim()
      if (desc && desc !== "") {
        axios.post('todo', {
            title: this.todo.title.trim(),
            description: desc
        })
            .then(response => {
              this.showSuccess = true
            })
            .catch(e => {
                this.showErrors = true
                this.errors.push(e)
            })
      } else {
        this.showErrors = true
        this.errors.push('Please enter a Todo first.')
      }

    }
  }
}
</script>

<style scoped>

</style>
