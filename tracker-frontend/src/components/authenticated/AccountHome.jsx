import React, { useState } from 'react';
import DataService from '../../UserServices';
import CameraComp from '../camera/CameraComp';

function AccountHome() {

    return (
        <div>
            <h2>Welcome!</h2>
            <CameraComp />
        </div>
    )
}

export default AccountHome;