import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);

    this.state = {
      ename: '',
      complaint: ''
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const referenceNumber = Math.floor(Math.random() * 1000);

    const message =
      'Thanks ' +
      this.state.ename +
      '\nYour Complaint was Submitted.\nTransaction ID is: ' +
      referenceNumber;

    alert(message);
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'red' }}>
          Register your complaints here!!!
        </h1>

        <form onSubmit={this.handleSubmit}>
          <label>Name: </label>

          <input
            type="text"
            name="ename"
            value={this.state.ename}
            onChange={this.handleChange}
          />

          <br />

          <label>Complaint: </label>

          <textarea
            name="complaint"
            value={this.state.complaint}
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

export default ComplaintRegister;