/**
* Author: 		Panayiotis Leontiou
* Written: 		19/11/2016
* Last updated: 13/8/2020
*
* Compilation: 	javac -cp ./stdlib.jar Entity.java
* Execution: 	java -cp .:.stdlib.jar Entity
*
* I klasi Entity orizei to antikeimeno Entity, antikeimena tou opiou einai o georgos, o likos,
* i katsika kai to laxano. Kathe Entity apartizetai apo tin taftotita tis (pedio entity) pou
* den allazei meta tin proti anathesi tis apo ton constructor kai ti thesi tis (pedio position)
* i opia mporei na allaksei, meso tis methodou anaforas putPos().
* 
*/

public class Entity {

	private Types.EType entity;        //  Tipos tis ontotitas
	private Types.Position position;   //  Thesi tis ontotitas

	public Entity(Types.EType e, Types.Position p) {  //  Dimiourgei ena Entity me tipo e
		entity = e;                                   //  kai thesi p.
		position = p;
	}

	public Types.Position getPos() {  //  I methodos epistrefei tin thesi tou Entity.
		return position;
	}

	public void putPos(Types.Position p) {  //  I methodos allazei tin thesi tou Entity se p.
		position = p;
	}

	public String toSpos() {  //  Metatrepei tin thesi tou Entity se lektiki morfi kai 
		String s = "";        //  to epistrefei. An to Entity vrisketai East epistrefei
		switch (position) {   //  "East", eno an vrisketai West epistrefei "West".
		case East:
			s = "East";
			break;
		case West:
			s = "West";
			break;
		}
		return s;
	}

	public String toSent() {  //  Metatrepei ton tipo tou Entity se lektiki morfi(String)
		String s = "";        //  kai to epistrefei.
		switch (entity) {
		case Farmer:
			s = "Farmer";
			break;
		case Goat:
			s = "Goat";
			break;
		case Cabbage:
			s = "Cabbage";
			break;
		case Wolf:
			s = "Wolf";
			break;
		}
		return s;
	}

	public String toString() {     //  Metatrepei se lektiki morfi ton tipo tis ontotitas 
		String s = "The " + toSent() + " is on the " + toSpos()  //  kai tin thesi tis se
				+ " bank of the river";                          //  sxesi me ton potamo.
		return s;                                                //  kai epistrefei to s.
	}                                                            //  s = olokliri protasi

	public boolean isFarmer() {             //  Elegxei an to Entity einai o georgos, an 
		if (entity == Types.EType.Farmer){  //  nai epistrefei true, allios false.
			return true;
		}
		return false;
		
	}

	public boolean isWolf() {               //  Elegxei an to Entity einai o likos, an 
		if (entity == Types.EType.Wolf){    //  nai epistrefei true, allios false.
			return true;
		}
		return false;
	}

	public boolean isGoat() {              //  Elegxei an to Entity einai i katsika, an 
		if (entity == Types.EType.Goat){   //  nai epistrefei true, allios false.
			return true;
		}
		return false;
	}

	public boolean isCabbage() {              //  Elegxei an to Entity einai to laxano, 
		if (entity == Types.EType.Cabbage){   //  an nai epistrefei true, allios false.
			return true;
		}
		return false;
	}

	public boolean isWest() {                   //  Elegxei an to Entity vriskete stin 
		if (position == Types.Position.West){   //  ditiki oxthi tou potamou, an nai 
			return true;                        //  epistrefei true, allios false.
		}
		return false;
	}

	public boolean isEast() {                   //  Elegxei an to Entity vriskete stin 
		if (position == Types.Position.East){   //  anatoliki oxthi tou potamou, an nai 
			return true;                        //  epistrefei true, allios false.
		}
		return false;
	}

	public static void main(String[] args) {  //  I main elegxei kata poso litourgoun sosta
		                                      //  oi methodoi tis klasis Entity.
		Entity[] testEntities = new Entity[4];
		testEntities[0] = new Entity(Types.EType.Farmer, Types.Position.East);
		testEntities[1] = new Entity(Types.EType.Wolf, Types.Position.East);
		testEntities[2] = new Entity(Types.EType.Goat, Types.Position.East);
		testEntities[3] = new Entity(Types.EType.Cabbage, Types.Position.East);
		if (testEntities[1].isFarmer()){
			System.out.println("Something is wrong!");
		}
		else {
			System.out.println("This isn't Farmer. This is okay");
		}
		if (testEntities[0].isFarmer()){
			System.out.println("This is okay");
		}
		else{
			System.out.println("Something is wrong!");
		}
		if (testEntities[1].isEast()){
			testEntities[1].putPos(Types.Position.West);
		}
		System.out.println(testEntities[1].toSpos());
		for (int i=0; i<4; i++){
			System.out.println(testEntities[i].toString());
		}
		if (testEntities[3].isGoat()){
			System.out.println("This is cabbage not goat, something is wrong...");
		}
		else{
			System.out.println("This isn't goat!");
		}
		System.out.println("The goat is: " + testEntities[2].toSpos());
		testEntities[2].putPos(Types.Position.West);
		System.out.println("The goat is now: " + testEntities[2].toSpos());
		System.out.println("The goat is west? : " + testEntities[2].isWest());
		System.out.println("Entity 0 is the goat: " + testEntities[0].isGoat());
		System.out.println("Entity 1 is the goat: " + testEntities[1].isGoat());
		System.out.println("Entity 2 is the wolf: " + testEntities[2].isWolf());
		System.out.println("Entity 3 is the cabbage: " + testEntities[3].isCabbage());
		System.out.println("Position of cabbage: " + testEntities[3].getPos());
		for (int i=0; i<4; i++){
			System.out.println(testEntities[i].toString());
		}
	}

}
