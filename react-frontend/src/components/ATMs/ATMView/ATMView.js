// import {Link} from "react-router-dom";
// import React from "react";
// import "./ATMView.css"
//
// const ATMView = (props) => {
//
//     const [formData, updateFormData] = React.useState({
//         accountNumber: "",
//         password: "",
//         amount: "",
//     });
//
//     const handleChange = (e) => {
//         updateFormData({
//             ...formData,
//             [e.target.name]: e.target.value.trim()
//         })
//     }
//
//     const onFormSubmitWithdraw = (e) => {
//         e.preventDefault();
//         const accountNumber = formData.accountNumber;
//         const password = formData.password;
//         const amount = formData.amount;
//
//         props.withdraw(props.term.id.id, accountNumber, password, amount);
//     }
//
//
//     const onFormSubmitDeposit = (e) => {
//         e.preventDefault();
//         const accountNumber = formData.accountNumber;
//         const password = formData.password;
//         const amount = formData.amount;
//
//         props.deposit(props.term.id?.id, accountNumber, password, amount);
//     }
//
//
//     return(
//         <div>
//             <br/>
//
//
//             {props.responseStatus === "Success" &&
//             <h4 className={"success"}>Withdrawal is successful</h4>
//             }
//
//             {props.responseStatus !== "Success" &&
//             <h4 className={"redText"}>{props.responseStatus}</h4>
//             }
//
//
//             <br/>
//             <h1>ATM: {props.term.location}</h1>
//             <h3>Current ATM balance:</h3>
//             <h2 id="balance">{props.term.balance}</h2>
//
//
//             <form onSubmit={onFormSubmitWithdraw}>
//                 <h3>Please enter your account number</h3>
//                 <input type="text"
//                        className="form-control"
//                        id="accountNumber"
//                        name="accountNumber"
//                        required
//                        placeholder="Enter your account number"
//                        onChange={handleChange}
//                 />
//                 <br/>
//                 <h3>Enter your password</h3>
//                 <input type="text"
//                        className="form-control"
//                        id="password"
//                        name="password"
//                        required
//                        placeholder="Enter your password"
//                        onChange={handleChange}
//                 />
//                 <br/>
//                 <h3>Enter amount</h3>
//                 <input type="text"
//                        className="form-control"
//                        id="amount"
//                        name="amount"
//                        required
//                        placeholder="Enter amount"
//                        onChange={handleChange}
//                 />
//                 <br/>
//                 <button id="submit" type="submit" className="btn btn-primary">Submit</button>
//
//             </form>
//         </div>
//     )
// }
// export default ATMView;