import React from "react"
import VehicleTerm from "../VehicleTerm/VehicleTerm"
import {Link} from "react-router-dom";

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
                <Link style={{width: "100%", marginTop: "20px"}} className={"btn btn-success"} to={"/vehicleAdd"}>Add Money Transport Vehicle</Link>

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