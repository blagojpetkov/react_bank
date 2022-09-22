import React from "react"
import ReactPaginate from "react-paginate";
import {Link} from "react-router-dom";
import BankTerm from "../BankTerm/bank"

class Banks extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {
        const banks = this.getBanks();
        return (
            <div>
                <div>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Bank name</th>
                            <th scope={"col"}>Bank details</th>
                        </tr>
                        </thead>
                        <tbody>
                        {banks}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }


    getBanks = () => {
        return this.props.banks.map((term) => {
            return(
                <BankTerm onSelect={this.props.onSelect} term = {term}/>
            )
        })
    }
}


export default Banks