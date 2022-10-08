import "./UserView.css"
import userPic from "../../../user_picture.png"
import {Link, useNavigate} from "react-router-dom";
import React from "react";

const UserView = (props) => {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        password: "",
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const password = formData.password;
        props.createAccount(props.bank, props.term.id.id, password)
        history(`/banks/${props.bank}/user/${props.term.id?.id}`)
    }

    return(
        <div id="body">
            <div id="container">
                <div id="left">
                    <h1>{props.term.name}</h1>
                    <h3>{props.term.surname}</h3>
                    <br/>
                    {props.term.accountNumbers?.length > 0 &&
                        <h3>Your account numbers:</h3>
                    }
                    <ul>
                    <h4>{props.term.accountNumbers?.map((x)=> {
                        return(
                            <li>
                                {x}
                            </li>
                        )
                        }
                    )
                    }</h4>
                    </ul>
                </div>
                <div id="right">
                    <img id="avatar" src={userPic} height="300" width="300"/>
                </div>
            </div>
            <div id="middle"><p>{props.term.location}</p>
                {props.term.accountNumbers?.length !==5 &&
                <div>
                    <form onSubmit={onFormSubmit}>
                        <input required name={"password"} className={"form-control"} style={{width: '35%'}} onChange={handleChange} placeholder="Enter a password for the account" />
                        <button className={"btn btn-success"} style={{width: '35%'}}>Create new account for user in bank</button>
                    </form>
                </div>

                    // <Link onClick={() => props.createAccount(props.bank, props.term.id.id)} className={"btn btn-success"} to={`/banks/${props.bank}/user/${props.term.id?.id}`}>Create account for user in bank</Link>

                }
            </div>


        </div>


    )
}

export default UserView;