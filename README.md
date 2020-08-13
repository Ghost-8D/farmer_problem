# farmer_problem
This project uses Object Oriented Programming (OOP) to solve the farmer problem. The solution is displayed graphically and in a text-based format.

### Farmer problem:
A farmer want to cross the river with a wolf, a sheep and a lettuce. There is a boat which has room only for two entities, but only the farmer can control the boat which means that he will have to travel from side to side and transfer each entity on the other side of the river. The problem is that if the farmer leaves the wolf with the sheep, the wolf is going to eat the sheep. Similarly if the sheep is left with the lettuce (without the presence of the farmer), the sheep will eat the lettuce. The goal is to find the minimum number of trips that the farmer has to perform in order to transfer all entities safely on the other side of the river, as well as the order in which they must be performed. It is possible that the farmer will have to transfer some of the entities back and forth mutliple times in order to satisfy the above conditions.

> Note: The situation where the farmer goes alone to the other side so that the sheep will eat the lettuce and the wolf will eat the sheep (so that the farmer will only have to move the wolf on the other side of the river) is not considered an option or a correct solution. All entities must cross the river safely.

### Requirements:
- javac >= 11.0.2

### Usage:

Compile the java program using the following commands in a terminal (MacOS/Linux) or in command line (Windows):
```bash
cd farmer_problem
javac -cp ./stdlib.jar Types.java Entity.java Farmer.java Stack.java State.java
```

Execute the program using the following command in a terminal (MacOS/Linux) or in command line (Windows):
```bash
java -cp .:./stdlib.jar Farmer
```

### Can you find the solution?
Try to think of the solution before executing the program and then run the program to watch your imagination come to life!

### Screenshots from execution:
![](https://github.com/Ghost-8D/farmer_problem/blob/master/farmer_problem/Farmer0.png)
![](https://github.com/Ghost-8D/farmer_problem/blob/master/farmer_problem/Farmer3.png)
![](https://github.com/Ghost-8D/farmer_problem/blob/master/farmer_problem/Farmer7.png)
