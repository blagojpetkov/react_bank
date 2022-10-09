import React from "react"
import {useNavigate} from "react-router-dom";

const ATMAdd = (props) => {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        location: "",
        bankId: props.banks.map(x=>x.id.id)[0],
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();

        const location = formData.location;
        const bankId = formData.bankId;

        props.onAddATM(location, bankId);
        history("/atms")
    }

    return(

        <div className="row mt-5">
            <h2>Add a new ATM</h2>
            <div className="col-md-5">
                <br/>
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Location of ATM</label>
                        <input type="text"
                               className="form-control"
                               id="location"
                               name="location"
                               required
                               placeholder="Enter the location of the ATM"
                               onChange={handleChange}
                        />
                    </div>
                    <br/>
                    <div className="form-group">
                        <label htmlFor="name">Bank</label>
                        <select className={"form-control"} name={"bankId"} onChange={handleChange}>
                            {
                                props.banks?.map(x=>{
                                return(
                                    <option value={x.id.id}>{x.name}</option>
                                )
                            })}
                        </select>

                    </div>
                    <br/>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default ATMAdd