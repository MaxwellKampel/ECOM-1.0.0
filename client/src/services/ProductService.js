import axios from "axios";

const axiosInstance = axios.create({
        baseURL: 'http://localhost:8080/api',
        timeout: 10000,
        headers: {
                'Content-Type': 'application/json'
        }
})

class ProductService {
    createProduct(data) {
            return axiosInstance.post('/products', data)
    }

    allProduct() {
            return axiosInstance.get('/products')
    }

    oneProduct(id){
        return axiosInstance.get(`/products/${id}`)
    }

    updateProduct(data){
        return axiosInstance.put(`/products/${data.id}`, data)
    }

    deleteProduct(id){
        return axiosInstance.delete(`/products/${id}`)
    }

}

export default ProductService;