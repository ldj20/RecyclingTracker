import React, { useState } from 'react';
import AuthenticatedNavbar from './components/authenticated/AuthenticatedNavbar';
import AccountHome from './components/authenticated/AccountHome';

function AuthenticatedApp() {
    return (
      <div>
        <AuthenticatedNavbar/>

        <Route path="/" exact={true} component={AccountHome} />
        <Route path="/details" component={} />
        <Route path="/logout" component={} />
      </div>
    );
}
  
export default AuthenticatedApp;