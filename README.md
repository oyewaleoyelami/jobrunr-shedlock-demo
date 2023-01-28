## Description
The combination of [ShedLock](https://github.com/lukas-krecan/ShedLock) and [Jobrunr](https://github.com/jobrunr/jobrunr), represented with this sample implementation requires data persistence. 
 - PostgreSQL used as the database for both libraries.
 - Spring boot v2.7.2 and Java v17
 - use case : https://withoyewale.com/2023/01/28/combination-of-jobrunr-and-shedlock-for-scheduled-jobs-using-java-with-spring-boot/

## To run the demo
On a machine with a running docker setup and after checking out the code.

1. Navigate to the root directory of the application. 
2. Run `mvn clean install -DskipTests` to build the application and generate the corresponding jar file.
3. Run `docker-compose up --scale demo-service=2` to wire up the complete setup, start and run two instances of the application

## Result
As obtainable from the logs, `only one` of the two running instances initiated the scheduled job while the execution of the actual tasks was shared `both` instances.
To view the jobs via Jobrunr dashboard - `http://localhost:8082/dashboard/jobs`