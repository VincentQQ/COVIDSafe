// import logo from './logo.svg';
import './App.css';
import React from 'react';
import { HashRouter as Router, Route } from 'react-router-dom';
import Home from './page/home/home';
import Login from './page/login/login';
import Register from './page/register/register';
import Patient from './page/Patients/patient/patient';
import Appointment from './page/Patients/appointment/appointment';
import Profile from './page/Patients/profile/profile';
import Appointments from './page/Doctor/appointments/appointments';
import Doctors from './page/Doctor/doctor/doctor';
//import Dashboard from './page/Doctor/dashboard/dashboard';
// import Patient from './page/patient/patient';
// import Page from './page/page';
class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return ( 
        <div className="App" >
            <Router >
            <Route exact path="/" component = { Login } ></Route>
            <Route exact path="/login" component = { Login } ></Route>
            <Route exact path="/register" component = { Register } ></Route>
            <Route path="/home" render={ ()=>
                <Home>
                    <Route exact path="/home" component={Patient} />
                    <Route exact path="/home/appointment" component={Appointment} />
                    <Route exact path="/home/profile" component={Profile} />
                    <Route exact path="/home/appointments" component={Appointments} />
                    {/*<Route exact path="/home/dashboard" component={Dashboard} />*/}
                    <Route exact path="/home/doctor" component={Doctors} />
                </Home>
            }/>
            </Router>
        </div>
        );
    }
}

export default App;