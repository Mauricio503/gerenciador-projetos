import { combineReducers, createStore } from 'redux'
import api from "../../services/api";

const INITIAL_STATE = {
    tasks: []
}

const todoReducer = (state = INITIAL_STATE, action) => {
    const { type } = action
    const { login,senha } = state
    switch (type) {
        case 'TODO_ADD':
            console.log(login,senha);
            api.post("/api/login", {login,senha}).then(resposta => {
                console.log(resposta.data);    
            });
            return { ...state}
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