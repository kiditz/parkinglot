# Parking Lot Problem
Hei all this problem found as my interview task for solving park ticketing issue with question:
```
I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is
given a number starting at 1 increasing with increasing distance from the entry point
in steps of one. I want to create an automated ticketing system that allows my
customers to use my parking lot without human intervention.
When a car enters my parking lot, I want to have a ticket issued to the driver. The
ticket issuing process includes us documenting the registration number (number
plate) and the colour of the car and allocating an available parking slot to the car
before actually handing over a ticket to the driver (we assume that our customers are
nice enough to always park in the slots allocated to them). The customer should be
allocated a parking slot which is nearest to the entry. At the exit the customer returns
the ticket with the time the car was parked in the lot, which then marks the slot they
were using as being available. Total parking charge should be calculated as per the
parking time. Charge applicable is $10 for first 2 hours and $10 for every additional
hour.
We interact with the system via a simple set of commands which produce a specific
output. Please take a look at the example below, which includes all the commandsyou need to support - they're self explanatory. The system should accept a filename
as a parameter at the command prompt and read the commands from that file.
```

# Run The application 
First you need to use jdk8 and maven to build this application, i assume you have it in your computer. so you can run this command without problem
```
mvn clean package
```
## And the output will be:
```maven

[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.3:report (report) @ parking-lot ---
[INFO] Loading execution data file /home/kiditz/workplace/interview-task/parking-lot/target/jacoco.exec
[INFO] Analyzed bundle 'parking-lot' with 3 classes
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ parking-lot ---
[INFO] Building jar: /home/kiditz/workplace/interview-task/parking-lot/target/parking-lot.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.249 s
[INFO] Finished at: 2020-07-07T16:19:40+07:00
[INFO] ------------------------------------------------------------------------
```
## Coverage test
this application include coverage test that can be found in folder ./target/site/jacoco/index.html after run package command
you can open the index.html in your browser to see the unit test report that i made for this application.
```
cd target/site/jacoco
google-chrome index.html
```
## Run Program
There is become three way to run the application
1. Run without arguments
```
java -jar target/parking-lot.jar
```
Then you can see the following instruction like this
```
Please enter 'exit' to close the program
Waiting for input
Availebla command is [create_parking_lot, park, status, leave]
```
Next, you need to write command by entering the text a.k.a
```
create_parking_lot 5
```
and see the output
```
Created parking lot with 5 slots
```

2. Run with input arguments
```
java -jar target/parking-lot.jar file_input.txt
```
Output will be 

```
Created parking lot with 6 slots
Allocated slot number: 1
Allocated slot number: 2
Allocated slot number: 3
Allocated slot number: 4
Allocated slot number: 5
Allocated slot number: 6
Registration number KA-01-HH-3141 with Slot Number 6 is free with Charge 30
Slot No. Registration No.
1		KA-01-HH-1234
2		KA-01-HH-9999
3		KA-01-BB-0001
4		KA-01-HH-7777
5		KA-01-HH-2701
Allocated slot number: 6
Sorry, parking lot is full
Registration number KA-01-HH-1234 with Slot Number 1 is free with Charge 30
Registration number KA-01-BB-0001 with Slot Number 3 is free with Charge 50
Registration number DL-12-AA-9999 not found
Allocated slot number: 1
Allocated slot number: 3
Sorry, parking lot is full
Slot No. Registration No.
1		KA-09-HH-0987
2		KA-01-HH-9999
3		CA-09-IO-1111
4		KA-01-HH-7777
5		KA-01-HH-2701
6		KA-01-P-333
```

3. Run with input and output arguments

```
java -jar target/parking-lot.jar file_input.txt output.txt
```
and you can view the output inside output.txt file
