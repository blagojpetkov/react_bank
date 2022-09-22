import React from "react"
import {Link} from "react-router-dom";

const atmTerm = (props) => {
    return(
        <li><button style={{margin: "10px"}} className={"btn btn-secondary"}>{props.term.location}</button></li>
    )
}
export default atmTerm;