import React, { useState } from 'react';
import { Route, useHistory } from 'react-router-dom';

import AuthenticatedNavbar from './components/authenticated/AuthenticatedNavbar';
import AccountHome from './components/authenticated/AccountHome';

function AuthenticatedApp() {
    return (
      <div>
        <AuthenticatedNavbar/>

        <Route path="/" exact={true} component={AccountHome} />
        <Route path="/details" component={AccountHome} />
        <Route path="/logout" component={AccountHome} />
      </div>
    );
}
  
export default AuthenticatedApp;