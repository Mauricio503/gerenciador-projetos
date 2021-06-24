import React, { Component } from 'react'

import { Provider } from 'react-redux'

import { store } from './redux'

import TodoList from './components/TodoList'

import './App.css';

import Login from "./components/Login";

class App extends Component {

    render() {
        var token = localStorage.getItem("token_gerenciadorProjeto");
        return (
            <Provider store={ store }>
                <div className="container">
                    {token == null || token.length < 10 ? <Login/> :  <TodoList/>}
                </div>
            </Provider>
        )
    }

}

export default App
