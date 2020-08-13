/**
* Author: 		Panayiotis Leontiou
* Written: 		19/11/2016
* Last updated: 13/8/2020
*
* Compilation: 	javac -cp ./stdlib.jar Types.java
* Execution: 	java -cp .:./stdlib.jar Types
*
* Orizei diaforous aparithmitous tipous pou einai aparetitoi gia tin ektelesi tou programmatos
* Farmer.java
* 
*/

public class Types {  //  Oi vasikoi tipoi pou xriazontai gia tin lisi tou provlimatos.

	public enum Position {  //  Thesi se sxesi me ton potamo.
		East, West
	}

	public enum EType {  //  Tipoi ontotitas.
		Farmer, Goat, Cabbage, Wolf
	}

	public enum MType {  //  Tipoi metakinisis.
		FAlone, WithGoat, WithCabbage, WithWolf, None
	}

	public static Position opposite(Position p) {  //  Allazei tin thesi mias ontotitas
		if (p == Position.East)                    //  se sxesi me ton potamo stin alli
			return Position.West;                  //  thesi.
		else
			return Position.East;
	}

}
