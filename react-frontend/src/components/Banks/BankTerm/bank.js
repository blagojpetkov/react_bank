import React from "react"
import {Link} from "react-router-dom";

const bankTerm = (props) => {
    return(
        <tr>
            <td>{props.term.name}</td>
            <td><Link className={"btn btn-success"} to={`/banks/view/${props.term.id.id}`} onClick={() => props.onSelect(props.term.id.id)}>Details</Link></td>
        </tr>
    )
}
export default bankTerm;