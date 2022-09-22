import React from "react"
import {Link} from "react-router-dom";

const atmTerm = (props) => {
    return(
        <tr>
            <td>{props.term.location}</td>
        </tr>
    )
}
export default atmTerm;