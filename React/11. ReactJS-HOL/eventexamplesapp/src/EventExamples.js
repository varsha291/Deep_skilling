import React, { Component } from 'react';

class EventExamples extends Component {
  constructor(props) {
    super(props);

    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState((prevState) => ({
      count: prevState.count + 1
    }));
  };

  sayHello = () => {
    alert('Hello Member');
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  decrement = () => {
    this.setState((prevState) => ({
      count: prevState.count - 1
    }));
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleClick = (event) => {
    alert('I was clicked');
  };

  render() {
    return (
      <div>
        <h3>{this.state.count}</h3>

        <button onClick={this.handleIncrement}>
          Increment
        </button>

        <br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br />

        <button onClick={() => this.sayWelcome('welcome')}>
          Say welcome
        </button>

        <br />

        <button onClick={this.handleClick}>
          Click on me
        </button>
      </div>
    );
  }
}

export default EventExamples;