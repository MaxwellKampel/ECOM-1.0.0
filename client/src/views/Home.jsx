import React from 'react'
import EcomNav from '../components/EcomNav'
import axios from 'axios'
import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { Card } from 'reactstrap'
import ProductService from '../services/ProductService'

const Home = (props) => {

    const productService = new ProductService();

    const [test, setTest] = useState();

    useEffect(() => {
        productService.allProduct()
            .then((res) => {
                setTest(res)
                console.log(test)
            })
            .catch(err => console.log(err))
    }, [])



    return (
        <>
            <EcomNav />
            <div>
                <h1>Home</h1>
            </div>
        </>
    )
}

export default Home