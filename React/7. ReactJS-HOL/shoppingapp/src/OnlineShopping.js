import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);

    this.items = [
      new Cart('Laptop', 50000),
      new Cart('Mobile', 20000),
      new Cart('Headphones', 2000),
      new Cart('Keyboard', 1500),
      new Cart('Mouse', 800)
    ];
  }

  render() {
    return (
      <div>
        <h1>Items Ordered:</h1>

        {this.items.map((item, index) => (
          <div key={index}>
            <h3>
              {item.Itemname} : {item.Price}
            </h3>
          </div>
        ))}
      </div>
    );
  }
}

export default OnlineShopping;