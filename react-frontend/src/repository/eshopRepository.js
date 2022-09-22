import axios from '../custom-axios/axios'
import axios2 from '../custom-axios/axios2'

const EShopService = {
    fetchBanks: () => {
        return axios.get("/getAll")
    },

    addUserToBank(selectBank, name, surname, location, type) {

        return axios.post("/user", {
            "bankIdString": selectBank,
            "name": name,
            "surname": surname,
            "location": location,
            "type": type
        })
    },

    fetchATMs: () => {
        return axios2.get("/getAll")
    },

    fetchUsers: (id) => {
        return axios.get(`/getBankUsers/${id}`)
    }
}
export default EShopService;
