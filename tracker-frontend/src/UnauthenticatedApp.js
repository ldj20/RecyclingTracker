import React, { useState } from 'react';
import UnauthenticatedNavbar from './compoennts/UnauthenticatedNavbar';

import Home from './components/unauthenticated/Home';
import SignUp from './components/unauthenticated/SignUp';
import Login from './components/unauthenticated/Login';

import DataService from './UserServices';

function UnauthenticatedApp() {
    return (
      <div>
        <UnauthenticatedNavbar/>

        <Route path="/" exact={true} component={Home} />
        <Route path="/sign-up" component={SignUp} />
        <Route path="/login" component={Login} />
      </div>
    );
}
  
export default UnauthenticatedApp;