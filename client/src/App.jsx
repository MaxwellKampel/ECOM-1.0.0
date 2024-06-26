import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Routes, Route, Link } from 'react-router-dom';
import { Card, CardBody, CardTitle, CardSubtitle, CardText, Button } from 'reactstrap';
import Home from './views/Home';
import Products from './views/Products';
import LoginReg from './views/LoginReg';




function App() {


  return (
    <>
    <Routes>
    <Route path='/' element={<Home />} />
    <Route path='/products' element={<Products />} />
    <Route path='/login' element={<LoginReg />} />


    </Routes>



    </>
  )
}

export default App
