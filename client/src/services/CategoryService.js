import axios from "axios";

const axiosInstance = axios.create({
        baseURL: 'http://localhost:8080/api',
        timeout: 10000,
        headers: {
                'Content-Type': 'application/json'
        }
})

class CategoryService {
    createCategory(data) {
            return axiosInstance.post('/categories', data)
    }

    allCategory() {
            return axiosInstance.get('/categories')
    }

    oneCategory(id){
        return axiosInstance.get(`/categories/${id}`)
    }

    updateCategory(data){
        return axiosInstance.put(`/categories/${data.id}`, data)
    }

    deleteCategory(id){
        return axiosInstance.delete(`/categories/${id}`)
    }

}

export default CategoryService;