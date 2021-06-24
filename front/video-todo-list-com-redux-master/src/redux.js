import { combineReducers, createStore } from 'redux'
import api from "./services/api";

const INITIAL_STATE = {
    tasks: []
}

const todoReducer = (state = INITIAL_STATE, action) => {
    const { payload, type } = action;
    const { tasks } = state
    switch (type) {
        case 'TODO_ADD':
            api.post("/api/lista", {}).then(resposta => {
                console.log(resposta.data);    
            });
            return { ...state, tasks: [ ...tasks, payload ] }
        case 'TODO_REMOVE':
            return { ...state, tasks: tasks.filter(task => task !== payload) }
        case 'LOGIN':
            api.post("/api/login", {username:payload.login,senha:payload.senha}).then(resposta => {
                window.localStorage.setItem("token_gerenciadorProjeto",resposta.data.token);
                window.location.reload();
            });
            return { ...state }
        case 'PROJETOS':
                api.post("/api/projeto/lista", {token:window.localStorage.getItem("token_gerenciadorProjeto")}).then(resposta => {
                    console.log(resposta.data);
                });
                return { ...state }
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
    }),
    login: user => ({
        payload: user,
        type: 'LOGIN'
    })
}

export { actions, store }