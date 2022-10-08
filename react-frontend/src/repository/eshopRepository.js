import axios_bank from '../custom-axios/axios_bank'
import axios_atm from '../custom-axios/axios_atm'

const EShopService = {
    login: (atmId, accountNumber, password)=>{
        return axios_atm.get(`/login?ATMIdString=${atmId}&accountNumber=${accountNumber}&password=${password}`)
    },
    fetchBanks: () => {
        return axios_bank.get("/getAll")
    },

    addUserToBank(selectBank, name, surname, location, type) {

        return axios_bank.post("/user", {
            "bankIdString": selectBank,
            "name": name,
            "surname": surname,
            "location": location,
            "type": type
        })
    },

    createAccount(bankId, userId, password){
        return axios_bank.post(`/account?bankIdString=${bankId}&userIdString=${userId}&password=${password}`)
    },

    fetchUsers: (id) => {
        return axios_bank.get(`/getBankUsers/${id}`)
    },

    fetchUser: (bankId, userId) => {
        return axios_bank.get(`/${bankId}/${userId}`)
    },

    fetchATMs: () => {
        return axios_atm.get("/getAll")
    },

    fetchAccountBalance: (accountNumber) => {
        return axios_atm.get(`/balance?accountNumber=${accountNumber}`)
    },
    fetchATM: (id) => {
        return axios_atm.get(`/get/${id}`)
    },

    withdraw: (atmId, accountNumber, password, amount) => {
        return axios_atm.get(`/withdraw?ATMIdString=${atmId}&accountNumber=${accountNumber}&password=${password}&amount=${amount}`)
    },
    deposit: (atmId, accountNumber, password, amount) => {
        return axios_atm.get(`/deposit?ATMIdString=${atmId}&accountNumber=${accountNumber}&password=${password}&amount=${amount}`)
    },



}
export default EShopService;
