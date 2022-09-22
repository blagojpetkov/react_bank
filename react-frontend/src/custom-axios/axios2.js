import axios from "axios"

const instance = axios.create({
    baseURL : 'http://localhost:9093/api/atm/',
    headers : {
        'Access-Control-Allow-Origin' : '*'
    }
})

export default instance;