import "./App.css"
import React from "react"
import Header from "../Header/header"
import {BrowserRouter as Router, Navigate, Redirect, Route, Routes} from "react-router-dom";
import EShopService from "../../repository/eshopRepository";
import Banks from "../Banks/BanksList/banks";
import ATMs from "../ATMs/ATMsList/atms";
import BankView from "../Banks/BankView/bankview"
import UserAdd from "../Banks/UserAdd/UserAdd";
import eshopRepository from "../../repository/eshopRepository";

class App extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            banks: [],
            atms: [],
            selectedBank: "",
            selectedBankUsers: [],
        }
    }

    render() {
        return(
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/banks"} exact element={<Banks onSelect={this.selectBank} banks={this.state.banks} />}/>
                            <Route path={"/"}      exact element={<Banks onSelect={this.selectBank} banks={this.state.banks}/>}/>
                            <Route path={"/banks/view/:id"} exact element={
                                <BankView
                                    onSelect={this.selectBank}
                                    users={this.state.selectedBankUsers}
                                    term={this.state.selectedBank}
                                />
                            }
                            />
                            <Route path={"/banks/createuser"} exact element={<UserAdd term={this.state.selectedBank} onAddUser={this.addUser}/>}/>
                            <Route path={"/banks/createaccount"}/>

                            <Route path={"/atms"} exact element={<ATMs atms={this.state.atms} />}/>
                            <Route path="*" element={<Navigate to ="/banks" />}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        )
    }


    loadBanks = () => {
        EShopService.fetchBanks().then((data) => {
            this.setState({
                banks: data.data
            })
        })
    }

    loadATMs = () => {
        EShopService.fetchATMs().then((data) => {
            this.setState({
                atms: data.data
            })
        })
    }


    selectBank = (id) => {
            this.setState({
                selectedBank: id
            })

            EShopService.fetchUsers(id).then((data) => {
                this.setState({
                    selectedBankUsers: data.data
                })
            })
    }

    addUser = (selectedBank, name, surname, location) => {
        EShopService.addUserToBank(selectedBank, name, surname, location, "NORMAL_USER")


        // .then(()=>{
        //     this.loadBooks()
        // })
    }


    componentDidMount() {
        this.loadBanks()
        this.loadATMs()

    }
}

export default App