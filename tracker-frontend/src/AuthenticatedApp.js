import React, { useState } from 'react';
import { Route, useHistory } from 'react-router-dom';

import AuthenticatedNavbar from './components/authenticated/AuthenticatedNavbar';
import AccountHome from './components/authenticated/AccountHome';
import AccountDetails from './components/authenticated/AccountDetails';
import Logout from './components/authenticated/Logout';

function AuthenticatedApp() {
    return (
      <div>
        <AuthenticatedNavbar/>

        <Route path="/" exact={true} component={AccountHome} />
        <Route path="/details" component={AccountDetails} />
        <Route path="/logout" component={Logout} />
      </div>
    );
}
  
export default AuthenticatedApp;