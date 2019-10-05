# Virtual-machines
#### Milestone 1  
Create a RESTful service using the following technologies:  
• SpringBoot Framework  
• Postgres Database

The service should support all CRUD (Create, Read, Update, Delete) operations.
We want to be able to perform those operations on a “Virtual Machine” entity, represented by the following fields:  
• Id – unique identifier for the resource  
• Name – a string showing the name of the machine to the user (non-unique)  
• CPU – total value in MHz  
• Memory – total value in MB  

#### Milestone 2  
Add the following resources to the Virtual Machine representation:  
• Disk  
• Network  
We can only attach one or more Disks or zero or more Networks to the Virtual Machine

The Disk is represented by:  
• Id  
• Name  
• Size – total value in GB  
The Network is represented by:  
• Id  
• Name  
• Data – out of scope, so just some field with something in it  

#### Milestone 3 - stretch goal  
Pack the Service in a runnable Docker container.  
Using docker-compose, start the Service and the DB containers as an application
  

#### Milestone 4 – beyond stretch goal  
UI – Should provide an interface for all CRUD operations  
Create a simple UI that has the following pages:  
• Machines list page – shows information about the machines in a table  
• Machine create page – shows a form for creating a machine – keep in mind that the machine can have more than one disk and zero or more networks  
• Machine edit page – shows editable information about a particular machine, its disk and network  
Pagination and validation are good to have.  
Note: There are no restrictions regarding the UI technology that can be used. The UI can be a separate process (plain old html, css, js; angular; react; etc.) or it can be hosted and served by the service (Spring MVC + thymeleaf). Bonus points if it’s a single page app.  

## To run the project:

- Run `mvn clean install`

- Run `docker-compose up`

- Try opening `localhost:8080/vm` in a browser


Remote debug port: `6006`

## TODOs

- Make controllers for `Disk` & `Network`
- Make the `attach` methods attach only already existing disks/networks
- Remove migration scrips and use Liquibase
- Make network/disk attaching endpoints reactive?
