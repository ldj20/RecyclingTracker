import React, { useState } from 'react'
import PageSpinner from '../components/PageSpinner';
import DataService from '../UserServices';

const AuthContext = React.createContext()

function AuthProvider() {
    const [userData, setUserData] = useState();
    const [displayData, setDisplayData] = useState();

    if (localStorage.getItem('rTrackerToken')) {
        DataService.getById(/* id */)
            .then(response => {
                console.log(response);
                setUserData(response);
            })
            .catch(e => {
                console.log(e);
            })
        DataService.getDisplay(/* id */)
            .then(response => {
                console.log(response);
                setDisplayData(response);
            })
            .catch(e => {
                console.log(e);
            })
    }

    if (userData == null || displayData == null) {
        return <PageSpinner />
    }

    return (
        <AuthContext.Provider value = {{userData, displayData}} />
    )

}

const useAuth = () => React.useContext(AuthContext);

export {AuthProvider, useAuth};