import React, { Component } from 'react';
import PiggyBankImage from '../images/piggy-bank-image.png';
import ApiRestClient from '../services/ApiRestClient';

class PiggyBank extends Component {
	constructor(){
		super();
		this.state = {count:0};
	}
	
	componentDidMount(){
		this.getCount();
	}
	
	componentWillReceiveProps(){
		this.getCount();
	}
	
	getCount(){
		ApiRestClient.getNumberOfCoins(this.props.value)
		.then(response => response.json().then(value => this.setState({count:value})));
	}
	
  render() {
	  const {value,click} = this.props;
    return (
      <div className="PiggyBankComponent">
		<p id="count">{this.state.count}</p>
		<img src={PiggyBankImage}/>
      </div>
    );
  }
  
  
  
}

export default PiggyBank;