import React from 'react';
import { withRouter } from 'react-router-dom';
import './register.scss';
import { Form, Input, Button, message } from 'antd';

const success = () => {
  message.success('Register Successed');
};

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
    this.onFinish = this.onFinish.bind(this)
    this.onFinishFailed = this.onFinishFailed.bind(this)
    this.ToLogin = this.ToLogin.bind(this)
  }
  onFinish(values){
    console.log('Success:', values);
    React.$api.post(`/user/register`, {
      'address':values.address,
      'age': values.age,
      'gender': values.gender,
      'name':values.name,
      'password': values.password,
      'patientId': values.patientId,
      'phone': values.phone
    }).then(data => {
      if(data.isSuccess){
        this.props.history.push('/login')
        success()
      }
      console.log(data);
    })
  }
  onFinishFailed(errorInfo){
    console.log('Failed:', errorInfo);
  }
  ToLogin(){
    this.props.history.push('/login')
  }
  render() {
    return (
      <div className="register">
        <div className="header"></div>
        <div className="main">
          <div className="title">Sign Up Form</div>
          <Form
            name="basic"
            initialValues={{
              remember: true,
            }}
            size="middle"
            layout="vertical"
            onFinish={this.onFinish}
            onFinishFailed={this.onFinishFailed}
          >
            <Form.Item
              label="PatientID"
              name="patientId"
              rules={[
                {
                  required: true,
                  message: 'Please input your patientId!',
                },
              ]}
            >
              <Input placeholder="PatientId *" />
            </Form.Item>

            <Form.Item
              label="Name"
              name="name"
              rules={[
                {
                  required: true,
                  message: 'Please input your name!',
                },
              ]}
            >
              <Input placeholder="Name *" />
            </Form.Item>
            
            <Form.Item
              label="Age"
              name="age"
              rules={[
                {
                  required: true,
                  message: 'Please input your age!',
                },
              ]}
            >
              <Input placeholder="Age *" />
            </Form.Item>

            <Form.Item
              label="Gender"
              name="gender"
              rules={[
                {
                  required: true,
                  message: 'Please input your gender!',
                },
              ]}
            >
              <Input placeholder="Gender *" />
            </Form.Item>

            <Form.Item
              label="Password"
              name="password"
              rules={[
                {
                  required: true,
                  message: 'Please input your password!',
                },
              ]}
            >
              <Input placeholder="Password *" />
            </Form.Item>

            <Form.Item
              label="Phone"
              name="phone"
              rules={[
                {
                  required: true,
                  message: 'Please input your phone!',
                },
              ]}
            >
              <Input placeholder="Phone *" />
            </Form.Item>

            <Form.Item
              label="Address"
              name="address"
              rules={[
                {
                  required: true,
                  message: 'Please input your address!',
                },
              ]}
            >
              <Input placeholder="Address *" />
            </Form.Item>

            {/* <Form.Item 
            name="role"
            rules={[
              {
                required: true,
                message: 'Please input your role!',
              },
            ]}
            >
              <Radio.Group>
                <Radio value="0">User</Radio>
                <Radio value="1">Doctor</Radio>
              </Radio.Group>
            </Form.Item> */}

            {/* <Divider type="vertical"/> */}
            <Form.Item>
              <Button type="primary" style={{margin: 'auto',display: 'block'}} htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Form>
          <Button type="link" onClick={this.ToLogin}>To Login</Button>
          <div className="bot-bottom">
            Already a membership? log in
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Register);