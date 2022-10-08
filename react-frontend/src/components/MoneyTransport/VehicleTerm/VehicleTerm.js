import React from "react"
import {Link} from "react-router-dom";

const VehicleTerm = (props) => {
    return(
        <tr>
            <td>{props.term.location}</td>
        </tr>
    )
}
export default VehicleTerm;