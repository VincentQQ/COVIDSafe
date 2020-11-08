import React from 'react';
import { HashRouter as Router, withRouter } from 'react-router-dom';
import './doctor.scss';
import { Table, Button, Input, Modal, Select, message, Checkbox } from 'antd';
const { Option } = Select;
const success = (msg) => {
  message.success(msg);
};
// function
class Doctor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      dataSource: [],
      columns: [
        {
          title: 'Name',
          dataIndex: 'name',
          key: 'name',
        },
        {
          title: 'Gender',
          dataIndex: 'gender',
          key: 'gender',
        },
        {
          title: 'Age',
          dataIndex: 'age',
          key: 'age',
        },
        {
          title: 'Phone',
          dataIndex: 'phone',
          key: 'phone',
        },
        {
          title: 'Address',
          dataIndex: 'address',
          key: 'address',
        },
        {
          title: 'Status',
          dataIndex: 'status',
          key: 'status',
          render: (t, r) => {
            if (r.status == 1) {
              return (
                  <p>COVID Positive</p>
              )
            } else if (r.type == 2) {
              return (
                  <p>Quarantining</p>
              )
            } else {
              return (
                  <p>COVID Negative</p>
              )
            }
          }
        },
        {
          title: 'Setting',
          key: "setting",
          render: (t, r) => {
            return (
                <Button type="link" onClick={this.showModal.bind(this, r)}>Detail</Button>
            )
          }
        }
      ],
      patientId: "",
      doctorId: "",
      name: "",
      selects: "",
      visible: false,
      form: {
        conditionId: '',
        patientId: '',
        status: '',
        temperature: 'temperature',
        vomit: true,
        cold: true,
        dizzy: true,
        nauseous: true,
        hardToBreath: true,
        other: ''
      },
      datas:{}
    };
    this.getData = this.getData.bind(this)
    this.handleAddPatient = this.handleAddPatient.bind(this)
    this.handleDeletePatient = this.handleDeletePatient.bind(this)
    this.changeone = this.changeone.bind(this)
    this.changetwo = this.changetwo.bind(this)
    this.handleChange = this.handleChange.bind(this)
  }
  componentDidMount() {
    this.getData()
  }
  handleChange(value) {
    this.setState({
      selects: value
    })
    // console.log(`selected ${value}`);
  }
  getData() {
    React.$api.post('/doctor/checkPatient?doctorId=' + window.localStorage.getItem('id')).then(data => {
      console.log(data);
      this.setState({
        dataSource: data
      })
    })
  }
  handleAddPatient() {
    React.$api.post(`/doctor/addPatient?patientId=${this.state.patientId}&doctorId=${this.state.doctorId}`).then(data => {
      success('Add Successed!')
      this.getData()
      this.setState({
        patientId: "",
        doctorId: ""
      })
    })
  }
  handleDeletePatient() {
    React.$api.post(`/doctor/deletePatient?patientId=${this.state.patientId}&doctorId=${this.state.doctorId}`).then(data => {
      success('Delete Successed!')
      this.getData()
    })
  }
  changeone(e) {
    this.setState({
      patientId: e.target.value
    })
  }
  changetwo(e) {
    this.setState({
      doctorId: e.target.value
    })
  }
  showModal = (p) => {
    React.$api.post('/doctor/checkDetail?patientId=' + p.patientId).then(data => {
      // data = {
      //   'yy': {
      //     conditionId: 24,
      //     patientId: 666,
      //     status: 0,
      //     temperature: 36,
      //     vomit: true,
      //     cold: true,
      //     dizzy: true,
      //     nauseous: true,
      //     hardToBreath: true,
      //     other: 1
      //   }
      // }
      let _s = data[p.name]
      console.log(_s);
      this.setState({
        visible: true,
        form: _s,
        name: p.name,
        datas: data
      });
    })
  };

  handleOk = () => {
    let _d = this.state.datas
    _d[this.state.name] = this.state.form
    console.log(_d);
    React.$api.post('/doctor/editDetail', this.state.form).then(() => {
      success('Edit Successed!')
      this.setState({
        visible: false
      });
    })
  };

  handleCancel = () => {
    this.setState({
      visible: false,
    });
  };
  onChangeName(e){
    this.setState({
      name: e.target.value
    })
  }
  onChangeStatus(value) {
    let _S = this.state.form
    _S.status = value
    this.setState({
      form: _S
    })
  }
  onChangeOther(e) {
    let _S = this.state.form
    _S.other = e.target.value
    this.setState({
      form: _S
    })
  }
  onChangeTemperature(e) {
    let _S = this.state.form
    _S.temperature = e.target.value
    this.setState({
      form: _S
    })
  }
  onChangeVomit(e) {
    let _S = this.state.form
    _S.vomit = e.target.checked
    this.setState({
      form: _S
    })
  }

  onChangeCold(e) {
    let _S = this.state.form
    _S.cold = e.target.checked
    this.setState({
      form: _S
    })
  }
  onChangeDizzy(e) {
    let _S = this.state.form
    _S.dizzy = e.target.checked
    this.setState({
      form: _S
    })
  }
  onChangeNauseous(e) {
    let _S = this.state.form
    _S.nauseous = e.target.checked
    this.setState({
      form: _S
    })
  }
  onChangeHardToBreath(e) {
    let _S = this.state.form
    _S.hardToBreath = e.target.checked
    this.setState({
      form: _S
    })
  }
  render() {
    return (
        <div className="doctor">
          <Input onChange={this.changeone} placeholder="PatientId *" value={this.state.patientId} />
          <Input onChange={this.changetwo} placeholder="DoctorId *" value={this.state.doctorId} />
          <Button onClick={this.handleAddPatient}>Add</Button>
          <Button onClick={this.handleDeletePatient}>Delete</Button>
          <Table columns={this.state.columns} bordered dataSource={this.state.dataSource} />
          <Modal
              title="Detail Modal"
              visible={this.state.visible}
              onOk={this.handleOk}
              onCancel={this.handleCancel}
          >
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Name:</span>
              <Input onChange={this.onChangeName.bind(this)} style={{ width: 180 }} value={this.state.name} />
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Status:</span>
              <Select value={String(this.state.form.status)} onChange={this.onChangeStatus.bind(this)} style={{ width: 180 }}>
                <Option value="1">COVID positive</Option>
                <Option value="2">Quarantining</Option>
                <Option value="0">COVID negative</Option>
              </Select>
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Temperature:</span>
              <Input style={{ width: 180 }} onChange={this.onChangeTemperature.bind(this)} value={this.state.form.temperature} />
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Other:</span>
              <Input style={{ width: 180 }} onChange={this.onChangeOther.bind(this)} value={this.state.form.other} />
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Vomit:</span>
              <Checkbox checked={this.state.form.vomit} onChange={this.onChangeVomit.bind(this)}></Checkbox>
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Cold:</span>
              <Checkbox checked={this.state.form.cold} onChange={this.onChangeCold.bind(this)}></Checkbox>
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Dizzy:</span>
              <Checkbox checked={this.state.form.dizzy} onChange={this.onChangeDizzy.bind(this)}></Checkbox>
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>Nauseous:</span>
              <Checkbox checked={this.state.form.nauseous} onChange={this.onChangeNauseous.bind(this)}></Checkbox>
            </div>
            <div style={{ marginBottom: 16 }}>
              <span style={{ width: 110, display: 'inline-block', textAlign: 'right', paddingRight: 15 }}>HardToBreath:</span>
              <Checkbox checked={this.state.form.hardToBreath} onChange={this.onChangeHardToBreath.bind(this)}></Checkbox>
            </div>
          </Modal>
        </div>
    );
  }
}

export default withRouter(Doctor);