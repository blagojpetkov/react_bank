import React from "react"
import {Link} from "react-router-dom";

const bankView = (props) => {
    return(
        <div>
        <Link className={"btn btn-dark"} to={"/banks/createuser"}>Create user in bank</Link>
        <Link className={"btn btn-success"} to={"/banks/createaccount"}>Create account for user in bank</Link>
        </div>
    )

}
export default bankView;