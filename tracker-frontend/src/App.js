import React, { useState } from 'react';
import { Route, useHistory } from 'react-router-dom';
import DataService from './UserServices';

const AuthenticatedApp = React.lazy(() => import('./AuthenticatedApp'))
const UnauthenticatedApp = React.lazy(() => import('./UnauthenticatedApp'))

function App() {
  const user = useUser()
  return (
    <div>
      {user ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </div>
  );
}

export default App;