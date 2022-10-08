import React from "react"
import {useNavigate} from "react-router-dom";

const UserAdd = (props) => {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        surname: "",
        location: "",
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const surname = formData.surname;
        const location = formData.location;

        props.onAddUser(props.term, name, surname, location);
        history("/banks")
    }

    return(

        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter your name"
                               onChange={handleChange}
                        />
                    </div>
                    <br/>
                    <div className="form-group">
                        <label htmlFor="surname">Surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               placeholder="Enter your surname"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <br/>

                    <div className="form-group">
                        <label htmlFor="location">Location</label>
                        <input type="text"
                               className="form-control"
                               id="location"
                               name="location"
                               placeholder="Enter your location"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <br/>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default UserAdd