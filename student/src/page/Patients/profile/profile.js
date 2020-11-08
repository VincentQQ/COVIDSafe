import React from 'react';
import { HashRouter as Router, withRouter } from 'react-router-dom';
import './profile.scss';
import { Input, Button, message } from 'antd';
const success = () => {
  message.success('Edit Successed');
};
class Profile extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name:"",
      gender:"",
      password:"",
      phone: "",
      address:"",
      age:"",
      doctorId:"",
      status:"",
      patientId:"",
      email:""
    };
    this.handleSubmit = this.handleSubmit.bind(this)
    this.getData = this.getData.bind(this)
  }
  handleSubmit(){
    if(window.localStorage.getItem('flag') == '0'){
      React.$api.post(`/user/editPatient`, {
        name: this.state.name,
        gender: this.state.gender,
        password: this.state.password,
        phone: this.state.phone,
        address: this.state.address,
        age: this.state.age,
        patientId: this.state.patientId
      }).then(data => {
        success()
        console.log(data);
      })
    }else {
      console.log(this.state);
      React.$api.post(`/user/editDoctor`, {
        password: this.state.password,
        phone: this.state.phone,
        name: this.state.name,
        gender: this.state.gender,
        email: this.state.email,
        doctorId: this.state.doctorId
      }).then(data => {
        success()
        console.log(data);
      })
    }
    // console.log(this.state);
  }
  componentDidMount(){
    this.getData()
  }
  getData(){
    if(window.localStorage.getItem('flag') == '0'){
      React.$api.post('/user/searchPatient?patientId='+ window.localStorage.getItem('id')).then(data => {
        console.log(data);
        this.setState({
          name: data.name,
          gender: data.gender,
          password: data.password,
          phone: data.phone,
          address: data.address,
          age: data.age,
          doctorId: data.doctorId,
          status: data.status == '1' ? 'COVID positive' : data.status == '2' ? 'Quarantining ' : 'COVID negative',
          patientId: data.patientId,
        })
      })
    }else {
      React.$api.post('/user/searchDoctor?doctorId='+ window.localStorage.getItem('id')).then(data => {
        console.log(data);
        this.setState({
          name: data.name,
          gender: data.gender,
          email: data.email,
          password: data.password,
          phone: data.phone,
          doctorId: data.doctorId
        })
      })
    }
  }
  onChangeName(e){
    this.setState({
      name: e.target.value
    })
  }
  onChangeGender(e){
    this.setState({
      gender: e.target.value
    })
  }
  onChangePassword(e){
    this.setState({
      password: e.target.value
    })
  }
  onChangePhone(e){
    this.setState({
      phone: e.target.value
    })
  }
  onChangeEmail(e){
    this.setState({
      email: e.target.value
    })
  }
  onChangeAddress(e){
    this.setState({
      address: e.target.value
    })
  }
  onChangeAge(e){
    this.setState({
      age: e.target.value
    })
  }
  render() {
    const flag = window.localStorage.getItem('flag')
    return (
      <div className="profile">
        <img src="https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3238317745,514710292&fm=26&gp=0.jpg" alt=""/>
    <div className="profile-name">{this.state.name}</div>
        <div className="prifile-par" style={ flag == '0' ? {width:'750px'} : {width: '350px'}} >
        <div className="profile-input">
        <Input size="large" placeholder="Name" onChange={this.onChangeName.bind(this)} addonBefore="Name" value={this.state.name} />
        <Input size="large" placeholder="Gender" onChange={this.onChangeGender.bind(this)} addonBefore="Gender" value={this.state.gender} />
        <Input size="large" placeholder="Password" onChange={this.onChangePassword.bind(this)} addonBefore="Password" value={this.state.password} />
        <Input size="large" placeholder="Phone" onChange={this.onChangePhone.bind(this)} addonBefore="Phone" value={this.state.phone} />
        { flag == '1' && <Input size="large" onChange={this.onChangeEmail.bind(this)} placeholder="Email" addonBefore="Email" value={this.state.email} />}
        { flag == '0' && <Input size="large" onChange={this.onChangeAddress.bind(this)} placeholder="Address" addonBefore="Address" value={this.state.address} />}
        { flag == '0' && <Input size="large" onChange={this.onChangeAge.bind(this)} placeholder="Age" addonBefore="Age" value={this.state.age} />}
        </div>
        {/* <Divider type="vertical" /> */}
        { flag == '0' && <div className="profile-input dd">
        <Input size="large" placeholder=" " addonBefore="DoctorId" disabled value={this.state.doctorId} />
        <Input size="large" placeholder="Gender" addonBefore="PatientId" disabled value={this.state.patientId} />
        <Input size="large" placeholder="Status" addonBefore="Status" disabled value={this.state.status} />
        </div>}
        </div>
        <Button type="primary" onClick={this.handleSubmit}>Submit</Button>
      </div>
    );
  }
}

export default withRouter(Profile);