import React, { useState } from 'react';
import DataService from '../../UserServices';
import { Link } from 'react-router-dom';

//todo: figure out why validations aren't working, make recycling goal limited to numbers

function SignUp(props) {

    const initialFormState= {
        fName: "",
        lName: "",
        email: "",
        password: "",
        goal: ""
    };
    
    const [form, setForm] = useState({initialFormState});
    
    const [submitted, setSubmitted] = useState(false);

    const handleChange = event => {
        const { name, value } = event.target;
        setForm({ ...form, [name]: value });
    };

    const saveData = event => {
        DataService.create(form)
            .then(response => {
                setSubmitted(true);
                console.log(response);
            })
            .catch(e => {
                console.log(e);
            });
        event.preventDefault();
    };

    return (
        <div>
          {submitted ? (
            <header className="notification">
              <h4>You signed up successfully!</h4>
              <Link to ="/login" className="btn btn-info">
                Login
              </Link>
            </header>
          ) : (
            <div className="page-form">
            
                <header>
                    <h2>Sign Up</h2>
                </header>

                <div className="form-group preauth-select-style">
                    <label htmlFor="fName">First Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="fName"
                        required
                        value={form.fName}
                        onChange={handleChange}
                        name="fName"
                    />
                </div>
        
                <div className="form-group preauth-select-style">
                    <label htmlFor="lName">Last Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="lName"
                        required
                        value={form.lName}
                        onChange={handleChange}
                        name="lName"
                    />
                </div>

                <div className="form-group preauth-select-style">
                    <label htmlFor="email">Email</label>
                    <input
                        type="text"
                        className="form-control"
                        id="email"
                        required
                        value={form.email}
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
                        value={form.password}
                        onChange={handleChange}
                        name="password"
                    />
                </div>

                <div className="form-group preauth-select-style">
                    <label htmlFor="goal">Daily Recycling Goal</label>
                    <input
                        type="text"
                        className="form-control"
                        id="state"
                        required
                        value={form.goal}
                        onChange={handleChange}
                        name="goal"
                    />
                </div>
        
                <button type="submit" className="btn btn-info form-control preauth-button-style" onClick={saveData}>
                    Submit
                </button>
                    
            </div>
            )}
        </div>
    );
};

export default SignUp;