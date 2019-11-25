<template>
<div class="form-group">
  <div class="row">
    <div class="col-xl-10">
     <input id="descriptionInput" v-model.lazy="todo.description" type="text" class="form-control" placeholder="Description" aria-label="Description" aria-describedby="basic-addon1" @keydown.enter="submitTodo" @focus="clearFieldsForNewTodo">
    </div>
    <div class="col-xl-2">
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
    /* eslint-disable */
    import axios from 'axios'
    import authHeader from '../services/auth-header'

    export default {
  data: function () {
    return {
      todo: {
        title: '',
        description: '',
        done: false
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
      const desc = this.todo.description.trim()
      if (desc && desc !== "") {
        axios.post('todo', {
            title: this.todo.title.trim(),
            description: desc,
            done: false
        },{ headers: authHeader() })
            .then(response => {
              this.showSuccess = true
              this.$emit('create-new-todo', response.data)
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
