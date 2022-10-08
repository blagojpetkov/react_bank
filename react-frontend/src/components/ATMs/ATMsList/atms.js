import React from "react"
import ATMTerm from "../ATMTerm/atm"

class ATMs extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {


        const atms = this.getATMs();
        return (
            <div>
                <br/>
                <br/>
                <h3 className={"text-center"}>All ATMs:</h3>
                <ul style={{listStyle: "none"}}>
                {atms}
                </ul>
            </div>
        );
    }


    getATMs = () => {
        return this.props.atms.map((term) => {
            return(
                <ATMTerm selectATM={this.props.selectATM} term = {term}/>
            )
        })
    }
}


export default ATMs