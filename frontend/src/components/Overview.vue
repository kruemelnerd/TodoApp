<template>
  <div class="overview">
    <h1>ToDo App</h1>
    <h2>Just another learning app</h2>

    <p>
      <TodoInput v-on:create-new-todo="createNewTodo"></TodoInput>
    </p>

    <b-list-group>
      <b-list-group-item href="#" v-for="item in reverseItems" v-bind:key="item.id" v-bind:class="{'itemDone': item.done}" @click="handleChange(item)">
        <div class="d-flex w-100">
          <b-form-checkbox v-model="item.done" class="mr-n2" >
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
    /* eslint-disable */
    import axios from 'axios'
    import TodoInput from './TodoInput'
    import authHeader from '../services/auth-header'

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
  computed: {
    reverseItems () {
      return this.response.slice().reverse()
    }
  },
  methods: {
    handleChange (e) {
      let axiosConfig = {
        headers: {
          'Content-Type': 'application/json;charset=UTF-8'
        }
      }
      axios.put('toogleTodo', e.id, { headers: authHeader()  })
        .then(response => {
          e.done = response.data.done
        })
        .catch(e => {
          this.erros.push(e)
        })
    },
    showAllTodos () {
      axios.get('todo', { headers: authHeader() })
        .then(response => {
          this.response = response.data
          console.log(response.data)
        })
        .catch(e => {
          this.erros.push(e)
        })
    },
    createNewTodo (todo) {
      this.response.push(todo)
    }
  },
  created () {
    this.showAllTodos()
  }

}
</script>

<style>
  .todoItemDescription{
    padding-left: 5px;
  }
  .itemDone{
    text-decoration: line-through !important;
  }
</style>
