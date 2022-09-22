import React from "react"
import {Link} from "react-router-dom";
import UserTerm from "../UserTerm/user";

class bankView extends React.Component{
    constructor(props) {
        super(props);
    }

    render()
    {
        const users = this.getUsers();
        return (
            <div>
                <div>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>User name</th>
                            <th scope={"col"}>User details</th>
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
                    <Link className={"btn btn-success"} to={"/banks/createaccount"}>Create account for user in bank</Link>
                </div>
            </div>
        )
    }

    componentDidMount() {
        console.log("HELLLLLLOOO")

        console.log(this.props.term)
        console.log("HEEE")

        this.props.onSelect(this.props.term)
    }


    getUsers = () => {
        return this.props.users.map((term) => {
            return(
                <UserTerm user={term} />
            )
        })
    }

}
export default bankView;