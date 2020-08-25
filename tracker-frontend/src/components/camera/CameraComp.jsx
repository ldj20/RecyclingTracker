import React from 'react';
import Camera from 'react-html5-camera-photo';
import 'react-html5-camera-photo/build/css/index.css';
import DataService from '../../UserServices';
 
function CameraComp (props) {
  /*function getBase64Image(imgElem) {
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
    }*/
  
  function handleTakePhoto (dataUri) {
    console.log('takePhoto');
    console.log(dataUri)
  }

  function sendImage(img) {
    console.log(img);
    DataService.getLabels(/*getBase64Image('../../../public/cat.jpeg')*/img)
        .then(response => {
            console.log(response);
        })
        .catch(e => {
            console.log(e);
        })
  }
 
  return (
    <Camera
      onTakePhoto = { (dataUri) => { sendImage(dataUri); } }
    />
  );
}
 
export default CameraComp;