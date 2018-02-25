# Web Crawler

Simple web Crawler api rest created in java + spring boot framework.
which given a url returns a json with the urls and link found

## API Methods :

/getShortLinks
InPut=webPage=http://myUrl.com
OutPut=Return a Json with the list of links of a specific page
Execution mode: 
http://localhost:8080/alejandroWebCrawler/api/getShortLinks?webPage=http://myUrl.com

/getAllLinks
InPut=webPage=http://myUrl.com
OutPut=Return a Json with the list of links and subLinks of a web page
Execution mode: 
http://localhost:8080/alejandroWebCrawler/api/getAllLinks?webPage=http://myUrl.com

## API OutPut :

The 'output' folder contains files examples of the generated output. (methods.json)

## Installation

  Name project :/alejandroWebCrawler

- Download the project contained in the  'project' folder
- Import into your favorite IDE the maven project.
- Get dependencies and Compile.
- Add the war project in a Tomcat server


## Technical Requirements: 
 - Java 1.8
 - Spring Boot Framework 1.5
 - Maven
 - Tomcat Server 8.5 
 - Eclipse 

## Pending

- Verification of input  url and handling of exceptions.
- Add  parameter of input  the Nº of Url to look for, static at the moment.
- Implement log4j
- Delete final variables and implement a property
- Implement Robot security
- Remove rest and implement GraphQL

## Reference
   netinstructions :
   [How to make a simple web crawler in java](http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/).