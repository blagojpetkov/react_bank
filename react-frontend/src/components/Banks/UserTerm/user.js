import React from "react";
import BankTerm from "../BankTerm/bank";

class UserTerm extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
                    <tr>
                        <td>{this.props.user.name}</td>
                        <td><button className={"btn btn-success"}>Details</button></td>
                    </tr>
        );
    }
}


export default UserTerm