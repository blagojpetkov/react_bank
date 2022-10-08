import React from "react";
import BankTerm from "../BankTerm/bank";
import {Link} from "react-router-dom";

class UserTerm extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
                    <tr>
                        <td>{this.props.user.name}</td>
                        <td>{this.props.user.surname}</td>

                        <td><Link className={"btn btn-success"} to={`/banks/${this.props.bank}/user/${this.props.user.id.id}`} onClick={() => this.props.selectUser(this.props.bank, this.props.user.id.id)} >Profile</Link></td>

                    </tr>
        );
    }
}


export default UserTerm