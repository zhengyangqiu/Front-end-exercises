// import logo from './logo.svg';
import './App.css';
import Hello from './components/Hello';

function App() {
  return (
    //store component
    // <h1 className="bold">Hello world!</h1>
    //return Hello component, uppercase ensure it is not HTML element
    <>
      <Hello />
      <Hello />
    
    </>
    
    




    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
  );
}

export default App;
