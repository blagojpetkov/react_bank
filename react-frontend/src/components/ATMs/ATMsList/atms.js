import React from "react"
import ReactPaginate from "react-paginate";
import {Link} from "react-router-dom";
import ATMTerm from "../ATMTerm/atm"

class ATMs extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {


        const atms = this.getATMs();
        return (
            <div>
                <ul>
                {atms}
                </ul>
            </div>
        );
    }


    getATMs = () => {
        return this.props.atms.map((term) => {
            console.log(term)
            return(
                <ATMTerm term = {term}/>
            )
        })
    }
}


export default ATMs