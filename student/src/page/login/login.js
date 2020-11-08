import React from 'react';
import { withRouter } from 'react-router-dom';
import './login.scss';
import { Form, Input, Button, Checkbox, Radio } from 'antd';

class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
    this.onFinish = this.onFinish.bind(this)
    this.onFinishFailed = this.onFinishFailed.bind(this)
    this.toRegister = this.toRegister.bind(this)
  }
  onFinish(values){
    console.log('Success:', values);
    React.$api.post(`/user/login?id=${values.name}&password=${values.password}&role=${values.role}`,{
    }).then( data => {
      if(data.isSuccess){
        window.localStorage.setItem('flag', values.role)
        window.localStorage.setItem('id', values.name)
        if(values.role == '0'){
          this.props.history.push('/home')
        }else {
          this.props.history.push('/home/profile')
        }
      }
      console.log(data)
    })
  }
  onFinishFailed(errorInfo){
    console.log(React.$api)
    console.log('Failed:', errorInfo);
  }
  toRegister(){
    this.props.history.push('/register')
  }
  render() {
    // Since ``this.handleClick` has been bound to the instance, we can use it to handle the click event!
    return (
      <div className="login">
        <div className="header"></div>
        <div className="main">
        <div className="title">Sign Up Form</div>
          <Form
            name="basic"
            initialValues={{
              remember: true,
            }}
            size="large"
            onFinish={this.onFinish}
            onFinishFailed={this.onFinishFailed}
          >
            <Form.Item
              name="name"
              rules={[
                {
                  required: true,
                  message: 'Please input your name!',
                },
              ]}
            >
              <Input placeholder="User Id  *" />
            </Form.Item>

            <Form.Item
              name="password"
              rules={[
                {
                  required: true,
                  message: 'Please input your password!',
                },
              ]}
            >
              <Input.Password placeholder="Password *" />
            </Form.Item>
            
            <Form.Item 
            name="role"
            rules={[
              {
                required: true,
                message: 'Please input your role!',
              },
            ]}
            >
              <Radio.Group>
                <Radio value="0">Patient</Radio>
                <Radio value="1">Doctor</Radio>
              </Radio.Group>
            </Form.Item>

            <Form.Item>
              <Button type="primary" style={{margin: 'auto',display: 'block'}} htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Form>
          <Button type="link" onClick={this.toRegister}>To Register</Button>
          <div className="bot-bottom">

          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Login);