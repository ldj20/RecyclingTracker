import React, { useState } from 'react';
import { Route, useHistory } from 'react-router-dom';

import Navbar from './components/Navbar';
import Home from './components/Home';
import SignUp from './components/SignUp';
import Login from './components/Login';

import DataService from './UserServices';

function App() {
  return (
    <div>
      <Navbar/>

      <Route path="/" exact={true} component={Home} />
      <Route path="/sign-up" component={SignUp} />
      <Route path="/login" component={Login} />
    </div>
  );
}

export default App;
