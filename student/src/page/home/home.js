
import React from 'react';
import { HashRouter as Router, withRouter } from 'react-router-dom';
import './home.scss';
import MenuCom from './menu';
class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }
  render() {
    return (
      <div className="home">
        <Router>
          <MenuCom />
          <div className="home-header">
          </div>
          <div className="home-main">
            {this.props.children}
          </div>
        </Router>
      </div>
    );
  }
}

export default withRouter(Home);