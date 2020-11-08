
import React from 'react';
import { withRouter, Link } from 'react-router-dom';
import './menu.scss';
import { Button, Menu } from 'antd';
const { SubMenu } = Menu;
class MenuCom extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name:""
    };
    this.getData = this.getData.bind(this)
    this.toLogOut = this.toLogOut.bind(this)
  }
  componentDidMount(){
    this.getData()
  }
  getData(){
    if(window.localStorage.getItem('flag') == '0'){
      React.$api.post('/user/searchPatient?patientId='+ window.localStorage.getItem('id')).then(data => {
        console.log(data);
        this.setState({
          name: data.name
        })
      })
    }else {
      React.$api.post('/user/searchDoctor?doctorId='+ window.localStorage.getItem('id')).then(data => {
        console.log(data);
        this.setState({
          name: data.name
        })
      })
    }
  }
  toLogOut(){
    this.props.history.push('/login')
  }
  render() {
    const flag = window.localStorage.getItem('flag')
    return (
      <div className="menu" style={{ width: 200 }}>
        <div className="menu-title">
          <div className="title-img">
            <img src="https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3238317745,514710292&fm=26&gp=0.jpg" alt=""/>
            <div>
              <p>Welcome</p>
              <p>{this.state.name}</p>
            </div>
          </div>
          <p className="general">GENERAL</p>
        </div>
        <Menu
          defaultSelectedKeys={['1']}
          mode="inline"
          theme="dark"
        >
          { flag == '0' && <Menu.Item key="1"><Link to="/home">Checkin</Link></Menu.Item>}
          { flag == '0' && <Menu.Item key="2"><Link to="/home/appointment">Appointment</Link></Menu.Item>}
          <Menu.Item key="3"><Link to="/home/profile">Profile</Link></Menu.Item>
          { flag == '1' && <Menu.Item key="4"><Link to="/home/appointmonts">Appointments</Link></Menu.Item>}
          { flag == '1' && <Menu.Item key="5"><Link to="/home/doctor">Patients</Link></Menu.Item>}
        </Menu>
        <Button type="text" onClick={this.toLogOut}>Log Out</Button>
      </div>
    );
  }
}

export default withRouter(MenuCom);