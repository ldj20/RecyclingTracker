import React, { useState } from 'react';
import DataService from '../../UserServices';
import Camera from '../camera/Camera';

function AccountHome() {
    
    const [exLabel, setExLabel] = useState();

    function getBase64Image(imgElem) {
        var canvas = document.createElement("canvas");
        canvas.width = imgElem.clientWidth;
        canvas.height = imgElem.clientHeight;
        var ctx = canvas.getContext("2d");
        ctx.drawImage(imgElem, 0, 0);
        var dataURL = canvas.toDataURL("image/png");
        return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
    }

    function sendImage(img) {
        DataService.getLabels(getBase64Image('../../../public/cat.jpeg'))
            .then(response => {
                console.log(response);
            })
            .catch(e => {
                console.log(e);
            })
    }

    return (
        <div>
            <h2>Welcome!</h2>
            <Camera />
            <button onClick={sendImage}/>
            <p>{exLabel}</p>
        </div>
    )
}

export default AccountHome;