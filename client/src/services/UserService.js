import axios from "axious";

const axiosInstance = axios.create({
        baseURL: 'http://localhost:8080/api',
        timeout: 10000,
        headers: {
                'Content-Type': 'application/json'
        }
})