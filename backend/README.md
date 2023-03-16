<B><h1>Stock Application</h1></B><br>
Basic Stock application implemented with below feature:<br>
    &nbsp;&nbsp;1. List the company with basic details like company name, owner, website, turnover, initial stock price.<br>
    &nbsp;&nbsp;2. update the stock prices.<br>
    &nbsp;&nbsp;3. provide the all stock price with company brief details.<br>
    &nbsp;&nbsp;4. get the specific stock details information(High, Low, Average) in mention time frame with complete company details.<br>
    
The Complete Application developed in spring boot framerwork with mysql database. <br>

Application contains multiple microservices mention below.<br>
&nbsp;&nbsp;Authentication Service : This serivce will authenticate the admin credentials and return the jwt token.

&nbsp;&nbsp;Company Service : This Service will take care for Company related features(List new company,get specific company details,udpate company &nbsp;&nbsp;details, provide the company details to client).

&nbsp;&nbsp;Stock Service : This Service will take care for Stock related features(List new Stock,get specific Stock details,udpate Stock price,
&nbsp;&nbsp;&nbsp;&nbsp;provide the stack details to client).

&nbsp;&nbsp;Stock Aggregator : This Serice internally implemented the Aggregator pattern so whenever any get request come it will redirect here and it will &nbsp;&nbsp;interally fetch all the data from both(stock and company) and provide to client.

&nbsp;&nbsp;EureaServer : This service implemented service descovery Feature

&nbsp;&nbsp;Gatway : application starting point where admin token verify to use the admin related feature.
