/**
* Author: 		Panayiotis Leontiou
* Written: 		19/11/2016
* Last updated: 13/8/2020
*
* Compilation: 	javac -cp ./stdlib.jar Stack.java
* Execution: 	java -cp .:./stdlib.jar Stack
*
* I klasi Stack orizei to antikeimeno Stack (stiva), ta stoixeia tou opoiou einai States.
* Exei dio vasikes leitourgies, tin push pou prosthetei ena neo stixeio sto pano meros tis
* stivas, nooumenou oti i stiva den einai pliris, kai tin pop, i opoia aferei to pano stixeio
* tis stivas, nooumenou oti i stiva den einai keni. I methodos toString parousiazei tin lisi
* tou provlimatos lektika.
* 
*/

public class Stack {

	private int Capacity;   //  Capacity = arithmos stoixeion stivas
	private State[] elems;  //  elems = pinakas me katastaseis (States)
	private int top;        //  top = to pano stixeio tis stivas

	public Stack(int capacity) {      //  I methodos dimiourgei mia stiva pou apoteleitai 
		Capacity = capacity;          //  apo ton arithmo ton stixeion tis, ton pinaka elems 
		elems = new State[Capacity];  //  me tis katastaseis (States) kai tin thesi tou top
		top = -1;                     //  diladi tou stixeiou pou vriskete pio pano apo 
	};                                //  ola ta ipolipa stixeia tis stivas.

	public boolean isEmpty() {     //  An i stiva einai adia epistrefei os ti thesi tou top
		return top == -1;          //  to -1.
	}

	public boolean isFull() {        //  An i stiva einai gemati tote epistrefei os ti thesi
		return top == Capacity - 1;  //  tou top tin teleftea thesi tis stivas.
	}

	public State getTop() {        //  Efoson i stiva den einai keni epistrefei tin katastasi
		if (!isEmpty())            //  pou vriskete pano stin korifi tis stivas.
			return elems[top];
		State dummy = new State();
		;
		return dummy;
	}

	public void push(State s) {  //  I methodos prosthetei, efoson i stiva den einai pliris, 
		if (!isFull()) {         //  mia katastasi (State) stin korifi tis stivas.
			top++;
			elems[top] = s;
		}
	}

	public State pop() {   //  I methodos aferei, efoson i stiva den einai keni, tin katastasi
		if (!isEmpty()) {  //  (State) pou vrisketai stin korifi tis stivas. 
			top--;
			return elems[top + 1];
		}
		State dummy = new State();
		return dummy;         //  Kai epistrefei piso tin katastasi pou aferese apo tin stiva.
	}

	public boolean contains(State s) {     //  I methodos pairnei mia katastasi kai efoson  
		if (!isEmpty())                    //  den einai keni, ellegxei an i katastasi afti 
			for (int i = 0; i <= top; i++) //  einai i idia me mia apo aftes pou vriskontai
				if (elems[i].isSame(s))    //  ston pinaka (elems). An einai i idia me mia
					return true;           //  apo aftes tote i methodos epistrefei true.
		return false;
	}

	public String toString() {
		String s = "";
		if (isEmpty())  //  An i stiva einai keni epistrefei katallilo minima.
			s = "\n\nThe stack is empty\n";
		else {          //  An den einai keni epistrefei se lektiki morfi ti lisi tou provlimatos
			s = "\n\nThe sequence of states for the solution is:\n";  //  vima vima tin kathe 
			for (int i = top; i >= 0; i--)                            //  metafora.
				s = s + "\n\n" + elems[i];
			s = s + "\n";
		}
		return s;
	}

	public static void main(String[] args) {  //  I main elegxei an leitourgoun sosta oi
		                                      //  methodoi tis klasis Stack.
		Entity e1 = new Entity(Types.EType.Farmer, Types.Position.East);  
		Entity e2 = new Entity(Types.EType.Wolf, Types.Position.East);    
		Entity e3 = new Entity(Types.EType.Goat, Types.Position.East);    
		Entity e4 = new Entity(Types.EType.Cabbage, Types.Position.East);
		Stack testS = new Stack(10);
		StdOut.println("testS is empty?: " + testS.isEmpty());
		for (int i=0; i<9; i++){
			 testS.push(new State(e1,e2,e3,e4));
		}
		StdOut.println("testS is empty now?: " + testS.isEmpty());
		StdOut.println("testS is full?: " + testS.isFull());
		testS.elems[9] = new State();
		testS.top++;
		StdOut.println("testS is full now?: " + testS.isFull());
		if (testS.contains(testS.elems[4])){
			StdOut.println("I elems[4] einai mesa sto testS");
		}
		else{
			StdOut.println("Something is wrong!");
		}
		testS.pop();
		if (testS.isFull()){
			StdOut.println("After pop, testS is full");
		}
		else{
			StdOut.println("After pop, testS is not full");
		}
		StdOut.println(testS.getTop().toString());
	}

}
