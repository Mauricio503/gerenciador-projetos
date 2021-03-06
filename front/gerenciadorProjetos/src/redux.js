import { combineReducers, createStore } from 'redux'
import api from "./services/api";

const INITIAL_STATE = {
    tasks: []
}

const todoReducer = (state = INITIAL_STATE, action) => {
    const { payload, type } = action
    const { tasks } = state
    switch (type) {
        case 'TODO_ADD':
            api.post("/api/lista", {}).then(resposta => {
                console.log(resposta.data);    
            });
            return { ...state, tasks: [ ...tasks, payload ] }
        case 'TODO_REMOVE':
            return { ...state, tasks: tasks.filter(task => task !== payload) }
        default:
            return state
    }
}

const reducers = combineReducers({
    todoReducer
})

const store = createStore(reducers)

const actions = {
    add: task => ({
        payload: task,
        type: 'TODO_ADD'
    }),
    remove: task => ({
        payload: task,
        type: 'TODO_REMOVE'
    })
}

export { actions, store }