import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);

    this.state = {
      amount: '',
      currency: ''
    };
  }

  handleSubmit = (event) => {
    event.preventDefault();

    const euro = this.state.amount / 80;

    alert(
      'Converting to Euro Amount is ' + euro
    );
  };

  render() {
    return (
      <div>
        <h1 style={{ color: 'green' }}>
          Currency Convertor!!!
        </h1>

        <form onSubmit={this.handleSubmit}>
          <label>Amount: </label>

          <input
            type="number"
            value={this.state.amount}
            onChange={(event) =>
              this.setState({
                amount: event.target.value
              })
            }
          />

          <br />

          <label>Currency: </label>

          <input
            type="text"
            value={this.state.currency}
            onChange={(event) =>
              this.setState({
                currency: event.target.value
              })
            }
          />

          <br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;