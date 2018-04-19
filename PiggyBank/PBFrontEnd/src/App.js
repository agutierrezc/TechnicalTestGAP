import React, { Component } from 'react';
import logo from './logo.svg';
import CoinDenomination from './components/CoinDenomination';
import PiggyBank from './components/PiggyBank';
import ApiRestClient from './services/ApiRestClient';
import './App.css';

class App extends Component {
	constructor(){
		super();
		this.state={reloadPiggyBank:true};
		this.coinsDenomination = ["50", "100", "200", "500", "1000"];
		this.getNumberOfCoins = this.getNumberOfCoins.bind(this);
	}
	
	getNumberOfCoins(){
		this.setState({reloadPiggyBank:true})
	}
	
	
	
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Welcome to your Piggy Bank</h1>
        </header>
		<section>
			<div>{this.coinsDenomination.map((x,index) => <CoinDenomination value={x} key={index} getNumberOfCoins={this.getNumberOfCoins}/>)}</div>
			<div><PiggyBank reload={this.state.reloadPiggyBank}/></div>
			
		</section>
      </div>
    );
  }
  
}

export default App;
