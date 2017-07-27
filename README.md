**Martian Robot**

**To run the app**
Clone this git repo. 
Make sure Java is installed on your environment.
From the MartianRobots folder, run: </br>
java -cp Martian-robot-1.0-SNAPSHOT.jar Main


**To run the test**
Make sure Maven is installed on your environment.
From the MartianRobots folder, run: </br>
mvn test


**Improvement to be made:**
1. Handle errors in user input (e.g. invalid input, missing parameters, random commands that are not supported, etc.)
2. Refactor the command logic in the Robot class and use Command pattern. This is so that if we need to support new types of command in the future (which is mentioned in the instruction), we can do it easily. 
3. Use proper index mechanism to handle orientation change. Currently it relies on the order in which Orientation enums are declared.
