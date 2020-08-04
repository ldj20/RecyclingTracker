import React, { useState } from 'react';
import DataService from './UserServices';

import AuthenticatedApp from './AuthenticatedApp';
import UnauthenticatedApp from './UnauthenticatedApp';
//const AuthenticatedApp = React.lazy(() => import('./AuthenticatedApp'))
//const UnauthenticatedApp = React.lazy(() => import('./UnauthenticatedApp'))

function App() {
  //const user = useUser()
  return (
    <div>
      {false ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </div>
  );
}

export default App;