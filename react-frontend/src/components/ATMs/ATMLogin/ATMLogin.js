import {Link} from "react-router-dom";
import React from "react";
import "./ATMLogin.css"

const ATMLogin = (props) => {

    const [formData, updateFormData] = React.useState({
        accountNumber: "",
        password: "",
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmitLogin = (e) => {
        e.preventDefault();
        const accountNumber = formData.accountNumber;
        const password = formData.password;

        props.login(props.term.id.id, accountNumber, password);
    }

    const onFormSubmitWithdraw = (e) => {
        e.preventDefault();
        const accountNumber = formData.accountNumber;
        const password = formData.password;
        const amount = formData.amount;
        props.withdraw(props.term.id.id, accountNumber, password, amount);
    }
    const onFormSubmitDeposit = (e) => {
        e.preventDefault();
        const accountNumber = formData.accountNumber;
        const password = formData.password;
        const amount = formData.amount;
        props.deposit(props.term.id.id, accountNumber, password, amount);
    }


    return(
        <div>
            <br/>

            <div id={"main"} >
            {props.responseStatus === "Success" &&
            <h5 className={"success alert alert-success text-center"}>Successfully logged in</h5>
            }

            {props.responseStatus === "Money withdrawal is successful" &&
            <h4 className={"success alert alert-success text-center"}>Money withdrawal is successful</h4>
            }

            {props.responseStatus === "Money deposit is successful" &&
            <h4 className={"success alert alert-success text-center"}>Money deposit is successful</h4>
            }

            {props.responseStatus !== "" && props.responseStatus !== "Success" &&
                props.responseStatus !== "Money withdrawal is successful" &&
                props.responseStatus !== "Money deposit is successful" &&
            <h4 className={"redText alert alert-danger text-center"}>{props.responseStatus}</h4>
            }



            <h2 className={"text-center"}>ATM: {props.term.location}</h2>
            <br/>
            <h4 className={"text-center"}>Current ATM balance:</h4>
            <h4 id="balance" className={"text-center"}>{props.term.balance?.amount}$</h4>

            {props.responseStatus === "Success" &&
                <div className={"text-center"}>
                    <br/>
                <h3>Current account balance:</h3>
                <h3 id="balance">{props.selectedAccountBalance}</h3>
                </div>
            }

            {props.responseStatus !== "Success" &&
            <form onSubmit={onFormSubmitLogin}>
                <div className="container my-5" style={{
                    backgroundColor: '#0a4050',
                    width: '35%',
                    border: '2px solid gray',
                    borderRadius: '30px',
                    padding: '40px'
                }}>
                    <h3 className="text-light">Account Number</h3>
                    <input type="text"
                           className="form-control"
                           id="accountNumber"
                           name="accountNumber"
                           required
                           placeholder="Enter your account number"
                           onChange={handleChange}
                    />
                    <br/>
                    <h3 className="text-light">Password</h3>
                    <input type="text"
                           className="form-control"
                           id="password"
                           name="password"
                           required
                           placeholder="Enter your password"
                           onChange={handleChange}
                    />

                    <br/><br/>
                    <button id="submit" className="btn btn-danger" style={{width: '100%'}} type="submit">Login</button>
                    <br/>
                </div>
            </form>
            }

            </div>

            <div id={"right"}>
            {props.responseStatus === "Success" &&

            <div style={{width: "65%", margin: "auto"}}>
                <form style={{display: 'inline-block', margin: '10px'}} onSubmit={onFormSubmitWithdraw}>
                    <div className="container my-5" style={{
                        backgroundColor: '#0a4050',
                        width: '400px',
                        border: '2px solid gray',
                        borderRadius: '30px',
                        padding: '40px'
                    }}>
                        <h3 className="text-light">Withdraw money</h3>
                        <input type="text"
                               className="form-control"
                               id="amount"
                               name="amount"
                               required
                               placeholder="Enter amount to withdraw"
                               onChange={handleChange}
                        />
                        <br/>

                        <button id="submit" className="btn btn-danger" style={{width: '100%'}} type="submit">Withdraw</button>
                        <br/>
                    </div>
                </form>

                <form style={{display: 'inline-block', margin: '10px'}} onSubmit={onFormSubmitDeposit}>
                    <div className="container my-5" style={{
                        backgroundColor: '#0a4050',
                        width: '400px',
                        border: '2px solid gray',
                        borderRadius: '30px',
                        padding: '40px'
                    }}>
                        <h3 className="text-light">Deposit money</h3>
                        <input type="text"
                               className="form-control"
                               id="amount"
                               name="amount"
                               required
                               placeholder="Enter amount to deposit"
                               onChange={handleChange}
                        />
                        <br/>

                        <button id="submit" className="btn btn-danger" style={{width: '100%'}} type="submit">Deposit</button>
                        <br/>
                    </div>
                </form>

            </div>
            }

            </div>




        </div>
    )
}
export default ATMLogin;