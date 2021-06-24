import React, { Component } from "react";
import {
  Button,
  Segment,
  Divider,
} from "semantic-ui-react";
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { actions } from '../redux';

class Login extends Component {

 state = {
     login:'',
     senha:''
    }


  render() {
    return (
                <form className="login-form" onSubmit={ this.handleSubmit }>
                  <Segment raised>
                        <input className="login-field" onChange={ this.handleChange } 
                            type="text" value={ this.state.login } name="login"/>
                      <input className="login-field" onChange={ this.handleChange } 
                            type="password" value={ this.state.senha } name="senha"/>
                    
                    <Button fluid primary type="submit" size="large">
                      Login
                    </Button>

                  

                    <Divider/>
                  </Segment>
                </form>
         
      
    );
  }
  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
   }
  handleSubmit = event => {
    const { login } = this.props
    event.preventDefault()
    login(this.state)
    }
}

const mapStateToProps = state => ({
    tasks: state.todoReducer.tasks
})

const mapDispatchToProps = dispatch => ({
    add: bindActionCreators(actions.add, dispatch),
    remove: bindActionCreators(actions.remove, dispatch),
    login: bindActionCreators(actions.login, dispatch)
})

export default connect(mapStateToProps, mapDispatchToProps)(Login)