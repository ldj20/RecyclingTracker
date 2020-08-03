import React, { useEffect } from 'react';
import { useHistory } from 'react-router-dom';

function Logout() {

    const history = useHistory();

    useEffect(() => {
        /*localStorage.removeItem('rTrackerToken')
        history.push("/");*/
    })

    return <div />
}

export default Logout;