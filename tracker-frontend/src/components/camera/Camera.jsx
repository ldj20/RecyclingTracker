import React, { Fragment, useState } from "react";
import Video from "./Video";
import { Root, Preview, Footer, GlobalStyle } from "./cameraStyles";

function Camera() {
    const [isCameraOpen, setIsCameraOpen] = useState(false);
    const [cardImage, setCardImage] = useState();
  
    return (
      <Fragment>
        <Root>
          {isCameraOpen && (
            <Video
              onCapture={blob => setCardImage(blob)}
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