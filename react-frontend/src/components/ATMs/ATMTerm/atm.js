import React from "react"
import {Link} from "react-router-dom";

const atmTerm = (props) => {
    return(
        <li><Link to={`/atms/${props.term.id.id}`} onClick={() => props.selectATM(props.term.id.id)} style={{margin: "10px auto", width: "100%", display: "block"}} className={"btn btn-secondary"}>{props.term.location}</Link></li>
    )
}
export default atmTerm;