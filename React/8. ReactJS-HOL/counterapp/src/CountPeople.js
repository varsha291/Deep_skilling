import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);

    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry() {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  UpdateExit() {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div>
        <button onClick={() => this.UpdateEntry()}>Login</button>
        {this.state.entrycount} People Entered!!!

        <button onClick={() => this.UpdateExit()}>Exit</button>
        {this.state.exitcount} People Left!!!
      </div>
    );
  }
}

export default CountPeople;