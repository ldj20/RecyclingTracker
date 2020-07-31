import React, { useState } from 'react';
import { Route, useHistory } from 'react-router-dom';
import Navbar from './components/Navbar';
import DataService from './UserServices';

function App() {
  const [content, setContent] = useState();

  function testService() {
  DataService.get()
    .then(response => {
      console.log(response);
      setContent(response);
    })
  }
  return (
    <div>
      <Navbar/>

      <button onClick={testService}>Test</button>
      <p>{content}</p>
    </div>
  );
}

export default App;
