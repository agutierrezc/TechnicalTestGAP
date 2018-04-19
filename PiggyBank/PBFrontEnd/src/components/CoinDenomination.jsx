import React, { Component } from 'react';
import ApiRestClient from '../services/ApiRestClient';

class CoinDenomination extends Component {
	constructor(){
		super();
		this.state = {count:0};
	}
	
	componentDidMount(){
		this.getCount();
	}
	
	coinClick(value){
		ApiRestClient.insertCoin(value).then(
			response => {if(response.status == 200){
				this.getCount();
				this.props.getNumberOfCoins();
			}});
	}
	
	getCount(){
		ApiRestClient.getNumberOfCoinsByDenomination(this.props.value)
		.then(response => response.json().then(value => this.setState({count:value})));
	}
	
  render() {
	  const {value} = this.props;
    return (
      <div className="CoinDenomination" onClick={() => this.coinClick(value)}>
		<h2>{value}</h2>
		<div><p>{this.state.count}</p></div>
      </div>
    );
  }
  
  
  
}

export default CoinDenomination;