# Mow IT Now
This source implements Xebia technical assignment. It's built with Java 8 and Maven, tested with JUnit 4.12.

The production code is seperated into 3 modules

**Domain Model**
* Mower : engine that mows the field
* Field : defined with X and Y coordinates
* Orientation : either of NORTH, EAST, SOUTH or WEST
* Position : composed of Y and Y coordinates & Orientation 
* Instruction : either "turn right", "turn left" or "moove"
* Task : composed of a Mower and list of Instructions 
* Task Status : either CREATED, IN_PROGRESS or COMPLETED

**Data Model**
* Mapper : map constant data to model
* Task Repository : load data from entry file

**Api**
* Mower Agent : controls the execution of an instruction by a mower
* Task Agent :  controls the execution of the whole set of instructions, sort of Main Class


Tests code is in ./src/test/java. Tests data in ./src/test/resources. 

