Stock Application
Basic Stock application implemented with below feature:
    1. List the company with basic details like company name, owner, website, turnover, initial stock price.
    2. update the stock prices.
    3. provide the all stock price with company brief details.
    4. get the specific stock details information(High, Low, Average) in mention time frame with complete company details.
    
The Complete Application developed in spring boot framerwork with mysql database. 
Application contains multiple microservices mention below.

Authentication Service : this serivce will authenticate the admin credentials and return the jwt token.

Company Service : this Service will take care for Company related features(list new company,get specific company details,udpate company details, provide the company details to client).

Stock Service : this Service will take care for Stock related features(list new Stock,get specific Stock details,udpate Stock price, provide the stack details to client).

Stock Aggregator : this Serice internally implemented the Aggregator pattern so whenever any get request come it will redirect here and it will interally fetch all the data from both(stock and company) and provide to client.

EureaServer : this service implemented service descovery 

gatway : application starting point where admin token verify to use the admin related feature.
