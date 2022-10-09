import React from "react"
import {Link} from "react-router-dom";
import UserTerm from "../UserTerm/userTerm";

class bankView extends React.Component{
    constructor(props) {
        super(props);
    }

    render()
    {
        const users = this.getUsers();
        return (
            <div>
                <h4>Number of transactions: {this.props.banks.filter(x=>x.id.id===this.props.term).map(x=>x.transactionCount)}</h4>
                <div>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>
                            <th scope={"col"}>Profile</th>
                        </tr>
                        </thead>
                        <tbody>
                        {users}
                        </tbody>
                    </table>
                </div>
                <div>
                    <Link className={"btn btn-dark"} to={"/banks/createuser"}>Create user in bank</Link>
                    <br/><br/><br/>
                    {/*<Link className={"btn btn-success"} to={"/banks/createaccount"}>Create account for user in bank</Link>*/}
                </div>
            </div>
        )
    }



    getUsers = () => {
        return this.props.users.map((term) => {
            return(
                <UserTerm user={term} bank={this.props.term} selectUser={this.props.selectUser}/>
            )
        })
    }

}
export default bankView;