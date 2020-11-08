import React from 'react';
import { withRouter } from 'react-router-dom';
import './patient.scss';
import {Form, Input, Button, Select, Checkbox, message} from 'antd';

const success = () => {
  message.success('Checkin Successed');
};

class Patient extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
    this.onFinish = this.onFinish.bind(this)
    this.onFinishFailed = this.onFinishFailed.bind(this)
  }
  onFinish(values){
    // React.$api.post(`/patient/checkin?cold=${values.code ? true : false}&dizzy=${values.dizzy ? true : false}&hardToBreath=${values.hardToBreath ? true : false}&nauseous=${values.nauseous ? true : false}&other=${values.other}&patientId=${Number(window.localStorage.getItem('id'))}&status=${Number(values.status)}&temperature=${Number(values.temperature)}&vomit=${values.vomit ? true : false}`,{}
    // ,{
    React.$api.post(`/patient/checkin`,{
      cold:values.code ? true : false,
      dizzy:values.dizzy ? true : false,
      hardToBreath:values.hardtobreath ? true : false,
      nauseous:values.nauseous ? true : false,
      other:values.other,
      patientId:Number(window.localStorage.getItem('id')),
      status:Number(values.status),
      temperature:Number(values.temperature),
      vomit:values.vomit ? true : false
    }
    ).then(data => {
      console.log(data);
      success();
    })
    console.log('Success:', values);
  }
  onFinishFailed(errorInfo){
    // this.props.history.push('/login')
    console.log('Failed:', errorInfo);
  }
  render() {
    return (
      <div className="patient">
        <div className="main">
          {/* <div className="title">Sign Up Form</div> */}
          <Form
            name="basic"
            initialValues={{
              remember: true,
            }}
            // size="large"
            // layout="vertical"
            onFinish={this.onFinish}
            onFinishFailed={this.onFinishFailed}
          >
            <Form.Item
              label="Cold"
              name="code"
              valuePropName="checked"
              // rules={[
              //   {
              //     required: true,
              //     message: 'Please input code!',
              //   },
              // ]}
            >
              <Checkbox></Checkbox>
              {/* <Input placeholder="Code *" /> */}
            </Form.Item>

            <Form.Item
              label="Dizzy"
              name="dizzy"
              valuePropName="checked"
              // rules={[
              //   {
              //     required: true,
              //     message: 'Please input dizzy!',
              //   },
              // ]}
            >
              <Checkbox></Checkbox>
              {/* <Input placeholder="Dizzy *" /> */}
            </Form.Item>
            
            <Form.Item
              label="HardToBreath"
              name="hardtobreath"
              valuePropName="checked"
              // rules={[
              //   {
              //     required: true,
              //     message: 'Please input hardtobreath!',
              //   },
              // ]}
            >
              <Checkbox></Checkbox>
              {/* <Input placeholder="HardToBreath *" /> */}
            </Form.Item>

            <Form.Item
              label="Nauseous"
              name="nauseous"
              valuePropName="checked"
              // rules={[
              //   {
              //     required: true,
              //     message: 'Please input nauseous!',
              //   },
              // ]}
            >
              <Checkbox></Checkbox>
              {/* <Input placeholder="Nauseous *" /> */}
            </Form.Item>

            <Form.Item
              label="Vomit"
              name="vomit"
              valuePropName="checked"
              // rules={[
              //   {
              //     required: true,
              //     message: 'Please input vomit!',
              //   },
              // ]}
            >
              <Checkbox></Checkbox>
              {/* <Input placeholder="Vomit *" /> */}
            </Form.Item>

            <Form.Item
              label="Temperature"
              name="temperature"
              rules={[
                {
                  required: true,
                  message: 'Please input temperature!',
                },
              ]}
            >
              <Input placeholder="Temperature *" />
            </Form.Item>

            <Form.Item
            label="Status"
            name="status"
            rules={[
              {
                required: true,
                message: 'Please input status!',
              },
            ]}
            >
              <Select placeholder="Status *">
                <Select.Option value="0">COVID negative</Select.Option>
                <Select.Option value="1">COVID positive</Select.Option>
                <Select.Option value="2">Quarantining</Select.Option>
              </Select>
            </Form.Item>

            <Form.Item
              label="Other"
              name="other"
            >
              <Input placeholder="Other" />
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
              <Button type="primary" htmlType="submit">
                Checkin
              </Button>
            </Form.Item>
          </Form>
          {/* <div className="bot-bottom">
            Already a membership? log in
          </div> */}
        </div>
      </div>
    );
  }
}

export default withRouter(Patient);