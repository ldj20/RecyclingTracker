import React, { useState } from 'react';
import DataService from '../UserServices';


function Home() {
    
    const [content, setContent] = useState();

    function testService() {
    DataService.get()
      .then(response => {
        console.log(response);
        setContent(response);
      })
    }

    return (
        <div>
            <h2>Home</h2>
            <button onClick={testService}>Test</button>
            <p>{content}</p>
        </div>
    )
}

export default Home;