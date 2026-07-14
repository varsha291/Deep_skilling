import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: '',
      email: '',
      password: ''
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    if (this.state.name.length < 5) {
      alert('Name should have atleast 5 characters');
      return;
    }

    if (
      !this.state.email.includes('@') ||
      !this.state.email.includes('.')
    ) {
      alert('Email should contain @ and .');
      return;
    }

    if (this.state.password.length < 8) {
      alert('Password should have atleast 8 characters');
      return;
    }

    alert('Registration Successful');
  };

  render() {
    return (
      <div>
        <h1>Register Here!!!</h1>

        <form onSubmit={this.handleSubmit}>
          <label>Name: </label>

          <input
            type="text"
            name="name"
            value={this.state.name}
            onChange={this.handleChange}
          />

          <br />

          <label>Email: </label>

          <input
            type="text"
            name="email"
            value={this.state.email}
            onChange={this.handleChange}
          />

          <br />

          <label>Password: </label>

          <input
            type="password"
            name="password"
            value={this.state.password}
            onChange={this.handleChange}
          />

          <br />

          <button type="submit">
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default Register;