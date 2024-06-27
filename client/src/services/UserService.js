import axios from "axios";

const axiosInstance = axios.create({
        baseURL: 'http://localhost:8080/api',
        timeout: 10000,
        headers: {
                'Content-Type': 'application/json'
        }
})

class UserService {
        registerUser(data) {
                return axiosInstance.post('/user/register', data)
        }

        loginUser(data) {
                return axiosInstance.post('user/login', data)
        }
}

export default UserService;
