import React from 'react'
import spinner from './spinner.gif'

function PageSpinner() {
    return (
        <div>
        <img
          src={spinner}
          style={{ width: '340px', margin: 'auto', display: 'block' }}
          alt="Loading..."
        />
      </div>
    );
  }

export default PageSpinner;