import React from 'react';
import { withRouter } from 'react-router-dom';
import './appointment.scss';
import { Input, Table, Button, Modal, Form, Select, message } from 'antd';
const layout = {
  labelCol: { span: 6 },
  wrapperCol: { span: 18 },
};
const success = () => {
  message.success('Add Appointment Successed');
};
class Appointment extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      dataLsit: [],
      visible: false,
      columns: [
        {
          title: 'AppointmentID',
          dataIndex: 'appointmentId',
          key: 'appointmentId',
          render: text => <p>{text}</p>,
        },
        {
          title: 'PatientName',
          dataIndex: 'patientName',
          key: 'patientName',
        },
        {
          title: 'DoctorName',
          dataIndex: 'doctorName',
          key: 'doctorName',
        },
        {
          title: 'Type',
          key: 'type',
          render: (t, r) => {
            if (r.type == 0) {
              return (
                <p>Nucleic acid test</p>
              )
            } else if (r.type == 1) {
              return (
                <p>Treatment</p>
              )
            } else {
              return (
                <p>Advisory</p>
              )
            }
          }
        },
        {
          title: 'Date',
          key: 'date',
          dataIndex: 'date'
        },
        {
          title: 'Status',
          key: 'status',
          render: (t, r) => {
            if (r.status == 0) {
              return (
                <p>Waiting</p>
              )
            } else if (r.status == 1) {
              return (
                <p>Accepted</p>
              )
            } else {
              return (
                <p>Canceled</p>
              )
            }
          }
        },
        {
          title: 'Setting',
          key: 'setting',
          render: (t, r) => {
            if (r.status == 0 || r.status == 1) {
              return (
                <Button onClick={this.handleCancle.bind(this, r.appointmentId)}>Cancle</Button>
              )
            }
          }
        },
      ]
    };
    this.getData = this.getData.bind(this)
    this.showModal = this.showModal.bind(this)
    this.handleOk = this.handleOk.bind(this)
    // this.onReset = this.onReset.bind(this)
  }
  formRef = React.createRef();
  handleCancle(val) {
    console.log(val);
    React.$api.post('/patient/cancel?appointmentId=' + val, {
      // appointmentId: val
    }).then(data => {
      console.log(data);
      this.getData()
    })
  }
  componentDidMount() {
    this.getData()
  }
  showModal = () => {
    this.setState({
      visible: true,
    })
  }
  handleOk = e => {
    this.formRef.current.resetFields();
    this.setState({
      visible: false,
    });
  }
  getData() {
    React.$api.post('/patient/checkApp?patientId='+window.localStorage.getItem('id'), {
      // patientId: 100
    }).then(data => {
      console.log(data);
      let c = data.filter((item, index) => {
        item.key = index
        return item
      })
      console.log(c);
      this.setState({
        dataLsit: c
      })
    })
  }
  onFinishFailed(errorInfo) {
    console.log('Failed:', errorInfo);
  }
  onFinish(values) {
    console.log('Failed:', values);
    React.$api.post(`/patient/request?patientId=${values.paientid}&doctorId=${values.doctorid}&type=${values.type}&date=${values.date}`).then(data => {
      success()
      this.getData()
      this.handleOk()
    })
  }
  render() {
    return (
      <div className="appointment">
        <div className="appointment-header">
          <Button type="primary" onClick={this.showModal}>New Appointment</Button>
          {/* <Input size="large" placeholder="Search" /> */}
        </div>
        <Table columns={this.state.columns} dataSource={this.state.dataLsit} />
        <Modal
          title="Basic Modal"
          visible={this.state.visible}
          footer={null}
          // onOk={this.handleOk}
          onCancel={this.handleOk}
        >
          <Form
             {...layout}
             ref={this.formRef}
            name="basic"
            initialValues={{ remember: true }}
            onFinish={this.onFinish.bind(this)}
            onFinishFailed={this.onFinishFailed.bind(this)}
          >
            <Form.Item
              label="PatientId"
              name="paientid"
              rules={[{ required: true, message: 'Please input paientid!' }]}
            >
              <Input placeholder="PatientId *" />
            </Form.Item>

            <Form.Item
              label="DoctorId"
              name="doctorid"
              rules={[{ required: true, message: 'Please input doctorid!' }]}
            >
              <Input placeholder="DoctorId *" />
            </Form.Item>

            <Form.Item
            label="Type"
            name="type"
            rules={[
              {
                required: true,
                message: 'Please select type!',
              },
            ]}
            >
              <Select placeholder="Type *">
                <Select.Option value="0">Nucleic acid test</Select.Option>
                <Select.Option value="1">Treatment</Select.Option>
                <Select.Option value="2">Advisory</Select.Option>
              </Select>
            </Form.Item>

            <Form.Item
              label="Date"
              name="date"
              rules={[{ required: true, message: 'Please input date!' }]}
            >
              <Input placeholder="Date *" />
            </Form.Item>

            <Form.Item>
              <div className="appoform">
              <Button onClick={this.handleOk}>Cancel</Button>
              <Button type="primary" htmlType="submit">
                Submit
              </Button>
              </div>
            </Form.Item>
          </Form>
        </Modal>
        {/* Appointment */}
      </div>
    );
  }
}

export default withRouter(Appointment);