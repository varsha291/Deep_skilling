import officeImage from './office.jpg';

function App() {
  const element = 'Office Space';

  const offices = [
    {
      Name: 'DBS',
      Rent: 50000,
      Address: 'Chennai'
    },
    {
      Name: 'WeWork',
      Rent: 70000,
      Address: 'Hyderabad'
    }
  ];

  return (
    <div>
      <h1>{element}, at Affordable Range</h1>

      <img
        src={officeImage}
        width="25%"
        height="25%"
        alt="Office Space"
      />

      {offices.map((item, index) => (
        <div key={index}>
          <h1>Name: {item.Name}</h1>

          <h3
            style={{
              color: item.Rent < 60000 ? 'red' : 'green'
            }}
          >
            Rent: Rs. {item.Rent}
          </h3>

          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;