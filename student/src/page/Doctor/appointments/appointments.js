import React from 'react';
import { withRouter } from 'react-router-dom';
// import '../Patients/appointment/appointment.scss';
import { Table, Button, message } from 'antd';
const success = (msg) => {
  message.success(msg);
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
          key: 'appointmentId'
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
            if(r.status == 0){
              return (
                <div>
                  <Button onClick={this.handleConfirm.bind(this, r.appointmentId)}>Confirm</Button> 
                  <Button onClick={this.handleCancle.bind(this, r.appointmentId)}>Cancel</Button>
                </div>
              )
            }
          }
        },
      ]
    };
    this.getData = this.getData.bind(this)
    this.handleCancle = this.handleCancle.bind(this)
    this.handleConfirm = this.handleConfirm.bind(this)
  }
  componentDidMount() {
    this.getData()
  }
  handleCancle(val){
    React.$api.post('/doctor/cancel?appointmentId='+val).then(data => {
      console.log(data);
      success('Cancle Successed')
      this.getData()
    })
  }
  handleConfirm(val){
    React.$api.post('/doctor/confirm?appointmentId='+val).then(data => {
      console.log(data);
      success('Confirm Successed')
      this.getData()
    })
  }
  getData() {
    React.$api.post('/doctor/checkApp?doctorId='+window.localStorage.getItem('id'), {
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
  render() {
    return (
      <div className="appointment">
        <div className="appointment-header">
          <p>New Appointment</p>
          {/* <Input size="large" placeholder="Search" /> */}
        </div>
        <Table columns={this.state.columns} dataSource={this.state.dataLsit} />
      </div>
    );
  }
}

export default withRouter(Appointment);