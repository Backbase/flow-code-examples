# Interaction Example 1: Basic Interaction Configuration 
The following example explains the basics of the interaction configuration used by the Interaction Engine within the Flow Platform.

## Getting Started
The following list defines the technologies and libraries I used to implement the sample code:
* Maven 3.6+
* Java 11
* An IDE of your choice:
    * Spring Tool Suite, Eclipse, IntelliJ IDEA Community Edition

## Prerequisites
* Access to Backbase Repository (https://repo.backbase.com)
* Create a local developer environment. See [Backbase Community](https://community.backbase.com/documentation/flow/latest/create_developer_environment)

## Interaction Configuration
TO BE COMPLETED.

## Running the Example

### 1. Create a local developer environment
The Flow Application requires the Backbase local environment to run. A detailed explanation on how to setup the local 
environment can be found on [Backbase Community](https://community.backbase.com/documentation/flow/latest/create_developer_environment).

As a minimum start the following:
* MySQL Database
* Platform: Registry, Auth & Token Converter
* The Edge service

### 2. Create the database
You can use DBeaver (SQL Software) to connect to the MySQL database to create a database called `interaction-example1`.

### 3. Start the Flow Application

In a new terminal window, go to `flow-code-examples/interaction-examples/interaction-example1/` and execute the following command:
```bash
$ mvn spring-boot:run -Dspring-boot.run.profiles=eureka, local-mysql
```

Validate that the Flow Application is up and running by opening the IPS Eureka registry in your browser using: http://localhost:8080/registry/

In a new terminal window, go to `flow-code-examples/interaction-examples/interaction-example1/` and execute the following command:

```bash
$ bash run_interaction.sh
```

The script executes a curl command that starts the interaction engine.
