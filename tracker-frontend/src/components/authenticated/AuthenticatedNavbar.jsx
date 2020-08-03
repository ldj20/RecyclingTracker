import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function AuthenticatedNavbar() {
    const [collapsed, setCollapsed] = useState(true);
    
    const classOne = collapsed ?  'collapse navbar-collapse' : 'collapse navbar-collapse show';
    const classTwo = collapsed ? 'navbar-toggler collapsed' : 'navbar-toggler';   

    function toggleNavbar() {
        setCollapsed(!collapsed);
    }

    return (
        <div>
          <nav className="navbar navbar-expand-lg navbar-light" style={{backgroundColor: "#34eba2"}}>
            <Link to="/" className="navbar-brand">Recycling Tracker</Link>
            <button id="example" onClick={toggleNavbar} className={`${classTwo}`} type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarResponsive" aria-expanded={collapsed} aria-label="Toggle navigation">
                <span className="navbar-toggler-icon" />
            </button>

            <div className={`${classOne}`} id="navbarSupportedContent">

                <ul className="navbar-nav ml-auto">  
                  <li className="nav-item">
                    <Link to="/details" className="nav-link">Account Details</Link>
                  </li>
                  <li className="nav-item">
                    <Link to="/logout" className="nav-link">Logout</Link>
                  </li>
                </ul>
              
            </div>
          </nav>
        </div>
    );
}

export default AuthenticatedNavbar;