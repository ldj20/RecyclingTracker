import React from 'react';
import Camera from 'react-html5-camera-photo';
import 'react-html5-camera-photo/build/css/index.css';
import DataService from '../../UserServices';
const fs = require('fs');
 
function CameraComp (props) {

  const text = fs.readFileSync("../../../public/recyclables.txt", "utf-8");
  var textByLine = text.split("\n")

  function sendImage(img) {
    DataService.getLabels(img)
        .then(response => {
            /*labels = response.data;
            textByLine.forEach(item => {
              if (item in labels && labels[`${item}`] > 0.65) {
                //update board and return success screen
              }
            })
        */})
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