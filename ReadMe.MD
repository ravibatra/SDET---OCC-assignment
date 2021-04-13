*************************************  ReadMe file********************************************
# Project Title

SDET Assignment by OCC

## Getting Started

Download the project from GitHub and download the project file in eclipse workspace
or the other way is to import the project from eclipse as a GitHub source.
Once it is available in the eclipse, there is no ther dependencies as all the dependencies are covered under pom.xml
json,csv and output file path is already provided in sach a way, it should automatically take care from source

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

If you have eclipse and able to download from GitHub, this project is ready to go

## Running the tests

Just open the SDET source file and run this project as a Java project. Other way is to creata a build and deploy and then run.

## Approach
1. Store csv data into has hashset (hashset will remove the duplicate values
2. Store the json data through parser into hashmap and later store into new hashset
3. Created new hashset for merge #1 and #2 hashsets.
4. Insert json hashset values into merged hashset - as of now there are unique set of records
5. Now take csv hashset and interate one by one records and insert into merged hashset
6. This way we have unique records into merged hashset
7. Now take this inot arralist and sort the array set while inseritng the records into new csv as output
8. take the salary into seperate variable
9. Sort the salary by descending order
10. got all the unique records into csv with sorted by salary (desc order)

### Break down into end to end tests
Assumption:
Definition of unique - If first anme, last name, age, address, salary - if any one field is different in csv or json or both then we treate that record as unique 

There are many scenarios covered as a part of this project. 
We covered happy path, edge cases,negative scenarios, and error handling

1. If we have unique cases in csv and some similar records in json file 
2. If we have unique cases in csv and unique cases in json file
3. If we have similar records in csv which is already in json
4. If within csv we have duplicate record and in json we have some records similar to csv
5. if we csv we have some records and in json file we have some duplicate records within json and some similar to csv file
6. If both files have thier own duplicate records and duplicate records across the files too

### coding style 
Created some classes and package
Main class - CSV_Json
Different methods - StoreCSVInHashSet, StoreJsonInHashMap, parseEmployeeObject, WriteResultToCSV
Employee Class and construnctor Employee
SortSalary class
source files (json, csv)
output file (csv)

## Versioning

Version 1.0

## Authors

*****Ravi Batra****

