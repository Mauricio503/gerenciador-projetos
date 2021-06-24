import React, { Component } from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Login from "./pages/Login";
import Projeto from "./pages/TodoList";
import ProtectedRoute from "./services/protectRoute";
import { Provider } from 'react-redux';
import { store } from './redux';

export default class Rotas extends Component {
  constructor(props) {
    super(props);
    this.state = { };
  }
  render() {
    var token = localStorage.getItem("token_erp");
    
    return (
      <BrowserRouter>      
          <Switch>
            <Route
              exact
              path="/"
              component={token == null || token.length < 10 ? Login : null}
            />
            <Route
              path="/projeto"
              component={
                <Provider store={ store }>
                <div className="container">
                    <Projeto/>
                </div>
            </Provider>
                }
            />
           
          </Switch>
      </BrowserRouter>
    );
  }
}
