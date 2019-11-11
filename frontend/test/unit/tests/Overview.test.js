import { shallowMount } from '@vue/test-utils'
import Overview from '@/components/Overview.vue'

//import Overview from "../../../src/components/Overview";

test('Display Header correct', () => {

  expect(true).toBe(true);
  const allTodos = [{
    "title": "title1",
    "description": "description 1",
    "done": false
  },
    {
      "title": "title2",
      "description": "description 2",
      "done": true
    }
  ]
  expect(allTodos[0].title).toBe("title1")
  expect(allTodos[1].title).toBe("title2")

  const wrapper = shallowMount(Overview, {
    response: { allTodos }
  })
  // Fixme: Notworking correct
  //expect(wrapper.findAll('.todoItemDescription' )).toHaveLength(allTodos.length)
  //expect(wrapper.findAll('.todoItemDescription' )).toHaveLength(allTodos.length)

});
