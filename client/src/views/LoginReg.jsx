import React from 'react'
import EcomNav from '../components/EcomNav'

import axios from 'axios'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { Card } from 'reactstrap'
import UserService from '../services/UserService'

const LoginReg = (props) => {

    const userService = new UserService();

    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();

    const [adminLevel, setAdminLevel] = useState(0);


    const [errors, setErrors] = useState({});
    const redirect = useNavigate();

    const addNewUser = (e) => {
        e.preventDefault();
        // console.log("New User Created")

        const newUser = { firstName, lastName, email, password, adminLevel};

        console.log(newUser)

        userService.registerUser(newUser)
            .then(res => {  // success protocol
                console.log("New user created:", res.data)
                redirect("/")   // calls the useNavigate() function we created
            })
            .catch(err => {     // rejection protocol
                console.log("Problem adding new user - check server terminal", err);
                // setErrors(err.res.data.errors);    // calls to execute error messages when validation fails
            })
        }
        const loginUser = (e) => {
            e.preventDefault();
            console.log("User logged in")

            const loggedUser = { email, password };
            console.log(loggedUser)

            axios.post("http://localhost:8080/api/user/login", loggedUser)
                .then(res => {  // success protocol
                    console.log("user logged in:", res.data)
                    redirect("/")   // calls the useNavigate() function we created
                })
                .catch(err => {     // rejection protocol
                    console.log("Problem logging in user - check server terminal", err);
                    setErrors(err.response.data.errors);    // calls to execute error messages when validation fails
                })
        }




        return (
            <>

                <EcomNav />




                <Card>
                    <div>
                        <h1>Register</h1>
                    </div>
                    <hr />
                    <form onSubmit={addNewUser} >
                        <div className=''>
                            <div className="mb-3">
                                <label className="form-label" > First Name: </label>
                                <input value={firstName} onChange={(e) => setFirstName(e.target.value)} className="form-control" />
                                {errors.name && <p className='text-danger'>{errors.name.message} </p>}
                            </div>

                            <div className="mb-3">
                                <label className="form-label" > Last Name: </label>
                                <input value={lastName} onChange={(e) => setLastName(e.target.value)} className="form-control" />
                                {errors.name && <p className='text-danger'>{errors.name.message} </p>}
                            </div>

                            <div className="mb-3">
                                <label className="form-label" > Email: </label>
                                <input type='email' value={email} onChange={(e) => setEmail(e.target.value)} className="form-control" />
                                {errors.minutes && <p className='text-danger'>{errors.minutes.message} </p>}
                            </div>

                            <div className="mb-3">
                                <label className="form-label" > Password: </label>
                                <input type='password' value={password} onChange={(e) => setPassword(e.target.value)} className="form-control" />
                                {errors.minutes && <p className='text-danger'>{errors.minutes.message} </p>}
                            </div>
                            <button className="btn btn-primary  "> Create </button>
                        </div>
                    </form >
                </Card>

                <Card>
                    <div className="mt-5">
                        <div>
                            <h1>Login</h1>
                            <hr />
                        </div>
                        <form onSubmit={loginUser} >
                            <div className=''>
                                <div className="mb-3">
                                    <label className="form-label" > Email: </label>
                                    <input type='email' value={email} onChange={(e) => setEmail(e.target.value)} className="form-control" />
                                    {errors.minutes && <p className='text-danger'>{errors.minutes.message} </p>}
                                </div>

                                <div className="mb-3">
                                    <label className="form-label" > Password: </label>
                                    <input type='password' value={password} onChange={(e) => setPassword(e.target.value)} className="form-control" />
                                    {errors.minutes && <p className='text-danger'>{errors.minutes.message} </p>}
                                </div>
                                <button className="btn btn-success  "> Login </button>
                            </div>
                        </form >
                    </div>
                </Card>




            </>
        )
    }

    export default LoginReg