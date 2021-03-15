BJSS Testframework

## Introduction
This repository contains UI tests for the BJSS

# Getting Started
TODO: Guide users through getting your code up and running on their own system. In this section you can talk about:
1.	Installation process
2.	Software dependencies
3.	Latest releases
4.	API references

## Build and Test
TODO: Description
This is a Cucumber BDD Test Framework in Java

## UI Tests
The following section shall cover the requirements and steps involved for running the tests within this repository.

### Requirements
You must have the following installed on your machine:
- [IntelliJ](https://www.jetbrains.com/idea/)
- [Java 8 or later](https://www.java.com/en/download/)

### Steps
1. Navigate to the same directory as this README
`cd <path-to-readme-directory>`.

2. To run from the command line, use this mvn command

`mvn verify`.

3. To run the tests using IntelliJ, use CukesRunner.class
4. To see the test report go to

target>cucumber-html-reports

5. To see the captured images for failing tests

`mvn verify`.
the images are under
target>cucumber-html-reports>embeddings