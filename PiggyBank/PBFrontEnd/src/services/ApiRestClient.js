class ApiRestClient {
	
	insertCoin(value){
		return fetch(`http://localhost:9090/v1/coin/${value}`, {method: 'POST'})
	}
	
	getNumberOfCoins(){
		return fetch(`http://localhost:9090/v1/coin/`, {method: 'GET'})
	}
	
	getNumberOfCoinsByDenomination(value){
		return fetch(`http://localhost:9090/v1/coin/${value}`, {method: 'GET'})
	}
}

export default new ApiRestClient();