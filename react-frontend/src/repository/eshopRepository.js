import axios from '../custom-axios/axios'
import axios2 from '../custom-axios/axios2'

const EShopService = {
    fetchBanks: () => {
        return axios.get("/getAll")
    },

    fetchATMs: () => {
        return axios2.get("/getAll")
    },
    addUserToBank(selectBank, name, category, author, availableCopies) {
        console.log("vnatre vo service")
        console.log(selectBank)
        console.log("vnatre vo service")

        //return axios.get("/")
    }
}
export default EShopService;
