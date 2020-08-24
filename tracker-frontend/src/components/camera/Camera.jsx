import React, { Fragment, useState } from "react";
import Video from "./Video";
import { Root, Preview, Footer, GlobalStyle } from "./cameraStyles";
import DataService from '../../UserServices';

function Camera() {
    const [isCameraOpen, setIsCameraOpen] = useState(false);
    const [cardImage, setCardImage] = useState();
  
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
      <Fragment>
        <Root>
          {isCameraOpen && (
            <Video
              onCapture={blob => sendImage(blob)}
              onClear={() => setCardImage(undefined)}
            />
          )}
  
          {cardImage && (
            <div>
              <h2>Preview</h2>
              <Preview src={cardImage && URL.createObjectURL(cardImage)} />
            </div>
          )}
  
          <Footer>
            <button onClick={() => setIsCameraOpen(true)}>Open Camera</button>
            <button
              onClick={() => {
                setIsCameraOpen(false);
                setCardImage(undefined);
              }}
            >
              Close Camera
            </button>
          </Footer>
        </Root>
        <GlobalStyle />
      </Fragment>
    );
}

export default Camera;