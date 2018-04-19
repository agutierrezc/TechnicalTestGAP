Author: Andres Felipe Gutierrez Camacho
-----------------------------------------------------------------------------------

-----------------------------------------------------------------------------------
---------------------------- General Indications ----------------------------------
-----------------------------------------------------------------------------------

The project was developed using Eclipse Oxygen.3 Release (4.7.3), Java 8, Maven 3.3.9
and React 16.3. It is composed of a back-end made using Spring Boot 2.0.1.RELEASE 
and a front-end made with React v16.3.

	1. PBBackEnd: Back-end application with the Api Rest
	2. PBFrontEnd: Front-end application that consumes the Api Rest

Back-end application exposes three endpoints, first one to insert coins of specific 
denomination, second one to get the total of number of coins and third one to get the 
number of coins of specific denomination. Denominations allowed are "50", "100", "200", 
"500", "1000". Implementation does not persist the data, it save the data in memory 
which means that once server gets down data will disappear.

Front-end application is composed by a list of allowed denominations and an image of 
a pig. Clicking on a denomination, application will insert one coin of that 
denomination. Below each denominations is a counter with the number of coins of the 
especifict denomination. Above of pig image is another counter but it shows the total 
of coins inside the piggy Bank. Each time the page is refresh, application will get 
the information from the server also when a denomination is clicked, application 
refresh the data for that specific denomination and for the total of coins.

-----------------------------------------------------------------------------------
---------------------------- Technical Indications --------------------------------
-----------------------------------------------------------------------------------	

Preconditions: 
	* Java 8
	* Maven 3.3.9
	* npm 3.10.10
	* yarn 1.3.2
	
Because back-end application using Spring Boot it is not necessary to deploy it to 
server, it has an embed server inside generate jar. To generate the runnable jar you
have to go to "PBBackEnd" directory, open a command prompt and run "mvn package"
then go to "target" folder and run "java -jar PiggyBank.jar". Now the back-end 
should be running into the port 9090.

Technical specification of endpoints exposed:

	* http://localhost:9090/v1/coin/{{denomination}} 	POST	insert coin 
	* http://localhost:9090/v1/coin/{{denomination}} 	GET	get specific denomination
	* http://localhost:9090/v1/coin/ 			GET	get coin's total

In another command prompt go to "PBFrontEnd" folder and run "yarn install" or "npm install" 
then run "yarn start" or "npm start". Application will run on port 3000.
