import React from "react"
import VehicleTerm from "../VehicleTerm/VehicleTerm"

class VehicleList extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {


        const vehicles = this.getVehicles();
        return (
            <div>
                <div>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Vehicles</th>
                        </tr>
                        </thead>
                        <tbody>
                        {vehicles}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }


    getVehicles = () => {
        return this.props.vehicles.map((term) => {
            return(
                <VehicleTerm term = {term}/>
            )
        })
    }
}


export default VehicleList