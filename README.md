<h1 align="center">
  <br>
  
  <br>
  POC - Microservices
  <br>
</h1>

<h4 align="center">A demo project implementing the concept of microservices and service discovery using netflix-eureka discovery server</h4>


<p align="center">
    <a alt="Java">
        <img src="https://img.shields.io/static/v1?label=Java&message=v1.8&color=blue" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/static/v1?label=Spring%20Boot&message=2.2.0.RELEASE&color=brightgreen" />
    </a>
    <a alt="MySQL">
        <img src="https://img.shields.io/static/v1?label=MySQL&message=8.0.15&color=orange" />
    </a>
    <a alt="netflix-eureka">
        <img src="https://img.shields.io/static/v1?label=JWT&message=Hoxton.RC1&color=green" />
    </a>
</p>


## Concept ##
This is a Spring application which demonstrates the concept of microservices for highly scalable projects. Microservices breaks down the dependecies to smaller levels and are easier to build and maintain.

This is a sample application to show to-do list of a user, with:
1. seperate user-service application.
2. seperate tasks-service to store all the task
3. todo - service which talks to other services to collect all data and generate a view to display to the user

I have used spring-cloud-starter-netflix-eureka client and server (Version #Hoxton.RC1#) for implemention service discovery technology, instead of hardcoded call to other services. This is helpful if we have multiple instance of same service running (for scalability and loadbalancing) or if we are using the same code in multiple environments(in that case the server URL may change environment to environment). 

## Note ##
This is just a demonstration application and, as of now only has read funcationality.
