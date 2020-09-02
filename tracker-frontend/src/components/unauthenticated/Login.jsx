import React, { useState } from 'react';
import DataService from '../../UserServices';

function Login() {
    const [loginInfo, setLoginInfo] = useState({
        email: "",
        password: ""
    })
    
    const handleChange = event => {
        const { name, value } = event.target;
        setLoginInfo({ ...loginInfo, [name]: value });
    };

    return (
        <div className="page-form">
            <h2>Login</h2>
            
            <form>
                <div className="form-group preauth-select-style">
                        <label htmlFor="email">Email</label>
                        <input
                            type="email"
                            className="form-control"
                            id="email"
                            required
                            value={loginInfo.email}
                            onChange={handleChange}
                            name="email"
                        />
                    </div>
            
                    <div className="form-group preauth-select-style">
                        <label htmlFor="password">Password</label>
                        <input
                            type="password"
                            className="form-control"
                            id="password"
                            required
                            value={loginInfo.password}
                            onChange={handleChange}
                            name="password"
                        />
                    </div>
                    <button type="submit" className="btn btn-info form-control preauth-button-style">
                        Login
                    </button>
            </form>
        </div>
    )
}

export default Login;