import './App.css';
import React, {useState} from 'react';

function App() {
  // useState creates piece of state called count which starts at 0
  const [count,setCount] = useState(0);

  // setCount is used to change the value of count
  const increase = () => setCount(count + 1);
  const decrease = () => setCount(count - 1);

  return (
    <div>
      <h1>Simple Counter</h1>
      {/* display the current value of count */}
      <p>Current Count: {count}</p>
      {/* calls increase and decrease functions on button click */}
      <button onClick={increase}>Increase</button>
      <button onClick={decrease}>Decrease</button>
    </div>
  );
}

export default App;
