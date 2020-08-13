
/**
* Author: 		Panayiotis Leontiou
* Written: 		19/11/2016
* Last updated: 13/8/2020
*
* Compilation: 	javac -cp ./stdlib.jar State.java
* Execution: 	java -cp .:./stdlib.jar State
*
* I klasi State orizei to antikeimeno State, i kathe periptosi tou opiou apoteleitai apo ta
* sigkekrimena tessera Entities.
* 
*/

// import jdk.nashorn.internal.codegen.types.Type;

public class State {

	private Entity[] state = new Entity[4]; // Pinakas me 4 ontotites (Entities)

	public State(Entity e1, Entity e2, Entity e3, Entity e4) {  //  Dimiourgei pinaka(state)  
	//  Constructor gia to State me orismata.    				//  me ta 4 Entities. 
 		state[0] = e1;                                          //  (diladi ton georgo, ton 
		state[1] = e2;                                          //  liko, tin katsika kai 
		state[2] = e3;                                          //  to laxano, ta opoia
		state[3] = e4;                                          //  vriskontai stin 
	}                                                           //  anatoliki(east) oxthi)

	public State() { //  Constructor gia to State xoris orismata.
	}

	public String toString() {  // Ennonei tis tesseris protaseis, gia ola ta
								// Entities, kai ta epistrefei me to String s.
		String s = "\n" + state[0] + "\n" + state[1] + "\n" + state[2] + "\n"  
				+ state[3] + "\n";  
		return s;
	}

	public boolean isFinal() {
		for (int i = 0; i < state.length; i++) {
			if (this.state[i].isFarmer() && this.state[i].isEast()) {  //  Elegxoume an o
																	   //  georgos, o likos, i
				return false;                                          //  katsika i to laxano
			}                                                          //  einai stin anatoliki
			if (this.state[i].isWolf() && this.state[i].isEast()) {    //  oxthi tis limnis.
																	   //  An esto kai enas 
				return false;                                          //  vriskete stin 
			}                                                          //  anatoliki plevra
			if (this.state[i].isGoat() && this.state[i].isEast()) {    //  tote epistrefei tin
																	   //  timi false afou i 												   
				return false;                                          //  katastasi den einai i 
			}                                                          //  teliki pou epithimoume
			if (this.state[i].isCabbage() && this.state[i].isEast()) { //  allios an oloi einai
				return false;                                          //  stin ditiki oxthi
			}                                                          //  i methodos epistrefei
		}                                                              //  tin timi true.
		return true; 
	}

	public boolean isPermitted() {  // Epistrefei true an einai epitrepti i
									// katastasi i false an
									// i katastasi den einai epitrepti.
		if (this.state[0].isEast()) {                               // -An o georgos vriskete 
			if (this.state[1].isWest() && this.state[2].isWest()) { //  stin anatoliki oxthi
																	//  exoume tis ekseis
				return false;                                       //  periptoseis: 1) An
			}                                                       //  o likos kai i katsika 
				                                                    //  einai stin ditiki oxthi 
			if (this.state[2].isWest() && this.state[3].isWest()) { //  tote i methodos
																	//  epistrefei false.
				return false;                                       //  2) An i katsika kai to 
			}                                                       //  laxano vriskontai stin 
				                                                    //  ditiki oxthi epistrefei 
		} else {                                                    //  tin timi false. 
			if (this.state[1].isEast() && this.state[2].isEast()) { // -Allios (diladi an o georgos 
																	//  vriskete stin ditiki oxthi
				return false;                                       //  tote exoume tis ekseis
			}                                                       //  periptoseis: 1) An o likos
				                                                    //  kai i katsika einai stin
			if (this.state[2].isEast() && this.state[3].isEast()) { //  anatoliki oxthi i methodos
				return false;                                       //  epistrefei false.
			}                                                       //  2) An i katsika kai to laxano
				                                                    //  vriskontai stin anatoliki oxthi
		}                                                           //  i methodos epistrefei false.
		return true;                                                // -An den isxiei kamia apo tis 
						                                            //  pio pano periptoseis tote i 
	}                                                               //  methodos epistrefei true.

	public boolean isSame(State s) {    //  I methodos epistrefei true an i ipo anafora katastasi
										//  perilamvanei tis idies ontotites(Entities) kai stis
										//  idies theseis me tin katastasi (s). Allios epistrefei
										//  tin timi false.
		for (int i = 0; i < 4; i++) {
			if (this.state[i].isFarmer() && !s.state[i].isFarmer()) {
				return false;   //  Elegxei an stin parousa katastasi i ontotites einai oi idies me tis 
								//  ontotites tis katastasis (s). An vrethei esto kai mia diafora
			}                   //  stis ontotites i stin thesi tous epistrefei tin timi false.
			if (this.state[i].isWolf() && !s.state[i].isWolf()) {
				return false;
			}
			if (this.state[i].isGoat() && !s.state[i].isGoat()) { 
				return false;
			}
			if (this.state[i].isCabbage() && !s.state[i].isCabbage()) {
				return false;
			}                                                                                                 
			if (this.state[i].isEast() && !s.state[i].isEast()) { 
				return false;
			} 
			if (this.state[i].isWest() && !s.state[i].isWest()) { 
				return false;
			}

		}
		return true;    //  An oles oi ontotites einai oi idies kai vriskontai stis idies theseis
						//  i methodos epistrefei true (pou simenei oti i katastasi (s) einai i
	}                   //  idia me tin ipo anafora katastasi).

	public State MoveTo(Types.MType move) { //  Dimiourgei kai epistrefei tin katastasi (newState) 
											//  stin opia odigi i efarmogi tis metaforas (move) stin 
											//  ipo anafora katastasi.
		Entity[] newEnt = new Entity[4];
		//  Dimiourgei ena neo pinaka me ta entities tis ipo anafora katastasis.
		for (int i = 0; i < 4; i++) {
			if (this.state[i].isFarmer()) {
				if (this.state[i].isEast()) {
					newEnt[i] = new Entity(Types.EType.Farmer, Types.Position.East);
				} else {
					newEnt[i] = new Entity(Types.EType.Farmer, Types.Position.West);
				}
			}
			if (this.state[i].isWolf()) {
				if (this.state[i].isEast()) {
					newEnt[i] = new Entity(Types.EType.Wolf, Types.Position.East);
				} else {
					newEnt[i] = new Entity(Types.EType.Wolf, Types.Position.West);
				}
			}
			if (this.state[i].isGoat()) {
				if (this.state[i].isEast()) {
					newEnt[i] = new Entity(Types.EType.Goat, Types.Position.East);
				} else {
					newEnt[i] = new Entity(Types.EType.Goat, Types.Position.West);
				}
			}
			if (this.state[i].isCabbage()) {
				if (this.state[i].isEast()) {
					newEnt[i] = new Entity(Types.EType.Cabbage, Types.Position.East);
				} else {
					newEnt[i] = new Entity(Types.EType.Cabbage, Types.Position.West);
				}
			}
		}
		switch (move) { //  Analoga me tin timi tis metaforas (move) ginontai ta akoloutha:
		case FAlone: {  //  An tha metakinithei mono o georgos tote allazei i
						//  thesi tou georgou(newEnt[0]) stin alli oxthi tou potamou.
			newEnt[0].putPos(Types.opposite(newEnt[0].getPos()));
			break;
		}
		case WithGoat: {  //  An tha metakinithei o georgos me tin katsika tote allazei i
				          //  thesi tou georgou (newEnt[0]) kai tis katsikas (newEnt[2])
			              //  stin alli oxthi tou potamou.
			newEnt[0].putPos(Types.opposite(newEnt[0].getPos()));  
			newEnt[2].putPos(Types.opposite(newEnt[2].getPos())); 
			break; 
		}
		case WithCabbage: { //  An tha metakinithei o georgos me to laxano tote allazei i
							//  thesi tou georgou (newEnt[0]) kai tou laxanou (newEnt[3])
		                    //  stin alli oxthi tou potamou.
			newEnt[0].putPos(Types.opposite(newEnt[0].getPos())); 
			newEnt[3].putPos(Types.opposite(newEnt[3].getPos())); 
			break; 
		}
		case WithWolf: { //  An tha metakinithei o georgos me to liko tote allazei i thesi
					     //  tou georgou (newEnt[0]) kai tou likou (newEnt[1]) stin alli
			             //  oxthi tou potamou.
			newEnt[0].putPos(Types.opposite(newEnt[0].getPos())); 
			newEnt[1].putPos(Types.opposite(newEnt[1].getPos())); 
			break; 
		}
		case None:  //  An den tha allaksei tipota tote i methodos epistrefei piso
					//  tin ipo anafora katastasi.
			State newState = new State(this.state[0], this.state[1], this.state[2], this.state[3]);
			return newState;
		}
		State newState = new State(newEnt[0], newEnt[1], newEnt[2], newEnt[3]);
		//  Dimiourgei mia nea katastasi(newState) me tis nees theseis ton ontotiton (newEnt[]).
		return newState;    //  I methodos epistrefei tin nea katastasi pou dimiourgithike.
	}

	public int getSuccs(State[] succs) { //  Dimiourgei ston pinaka succs tis epitrepomenes 
										 //  diadoxes katastaseis tis ipo anafora katastasis
										 //  kai epistrefei to plithos(counter) ton en logo
										 //  diadoxon katastaseon.
		int counter = 0; //  Einai to plithos ton diadoxon epitrepomenon katastaseon.
		if ((MoveTo(Types.MType.FAlone).isPermitted())) {  //  Elegxei an epitrepete na
														   //  metakinithei stin apenanti
			succs[counter] = MoveTo(Types.MType.FAlone);   //  oxthi monos tou o georgos, an
														   //  nai topothetei tin nea katastasi
			counter++;                                     //  ston pinaka succs kai afksanei
		}                                                  //  to counter.
		if (this.state[0].getPos().equals(this.state[2].getPos())) {
			if ((MoveTo(Types.MType.WithGoat).isPermitted())) { //  Elegxei an epitrepete na
																//  metakinithei stin apenanti
				succs[counter] = MoveTo(Types.MType.WithGoat);  //  oxthi o georgos me tin 
				counter++;                                      //  katsika, an nai topothetei 
			}                                                   //  tin nea katastasi ston pinaka 
		}                                                       //  succs kai afksanei to counter.
		if (this.state[0].getPos().equals(this.state[3].getPos())) {
			if ((MoveTo(Types.MType.WithCabbage)).isPermitted()) {  //  Elegxei an epitrepete na
																	//  metakinithei stin apenanti
				succs[counter] = MoveTo(Types.MType.WithCabbage); 	//  oxthi o georgos me to
				counter++;                                          //  laxano, an nai topothetei tin 
			}                                                       //  nea katastasi ston pinaka succs 
		}                                                           //  kai afksanei to counter.
		if (this.state[0].getPos().equals(this.state[1].getPos())) {
			if ((MoveTo(Types.MType.WithWolf)).isPermitted()) { //  Elegxei an epitrepete na 
			                                                    //  metakinithei stin apenanti
				succs[counter] = MoveTo(Types.MType.WithWolf);  //  stin apenanti oxthi o georgos
				counter++;                                      //  me to liko, an nai nai topothetei 
			}                                                   //  tin nea katastasi ston pinaka succs 
		}                                                       //  kai afksanei to counter.
		return counter; //  I methodos epistrefei to plithos ton epitrepomenon diadoxon katastaseon. 
	}

	public boolean validMoveTo(State s) {   //  I methodos elegxei kata poso einai dinaton i ipo 
											//  anafora katastasi na apotelei diadoxo katastasi tis 
											//  katastasis s.

		State nS = new State(this.state[0], this.state[1], this.state[2], this.state[3]);
		State[] arrS = new State[4];    //  Dimiourgei nea katastasi(nS) idia me tin parousa
		                                //  katastasi kai ena pinaka (arrS) me 4 katastaseis(State).
		for (int i = 0; i < s.getSuccs(arrS); i++) {   
			if (arrS[i].isSame(nS)) {   //  Ston pinaka topothetounte oi pithanes diadoxes 
				return true;            //  katastaseis tis katastasis s. An mia apo aftes
			}                           //  einai i idia me tin parousa katastasi(nS) tote
		}                               //  i methodos epistrefei true.
		return false;  //  Allios epistrefei false (Diladi oti i parousa katastasi(nS) den mporei
	}                  //  na einai diadoxos katastasi tis katastasis (s)).

	public void plot() {                                   //  I methodos plot emfanizei grafika
		for (int i = 0; i < 4; i++) {                      //  tin ipo anafora katastasi. 
			if (this.state[i].isFarmer()) {                //  Zografizei diladi tin thesi tou
				StdDraw.setPenColor(StdDraw.BLACK);        //  georgou (me ena mavro kiklo), tin 
				if (this.state[i].isWest()) {              //  thesi tou likou (me ena kafe kiklo) 
					StdDraw.filledCircle(12.5, 65.0, 2.5); //  tin thesi tis katsikas (me ena aspro
				} else {                                   //  kiklo) kai ti thesi tou laxanou (me
					StdDraw.filledCircle(87.5, 65.0, 2.5); //  ena prasino kiklo). An vriskonte
				}                                          //  stin anatoliki oxthi zografizei tous
			}                                              //  kiklous deksia apo to galazio 
                                                           //  tetragono (diladi ton potamo), eno
			if (this.state[i].isWolf()) {                  //  an vriskonte stin ditiki oxthi tou
				StdDraw.setPenColor(StdDraw.ORANGE);       //  potamou zografizei tous kiklous 
				if (this.state[i].isWest()) {              //  aristera apo to glazio tetragono
					StdDraw.filledCircle(12.5, 55.0, 2.5); //  (ton potamo).
				} else {
					StdDraw.filledCircle(87.5, 55.0, 2.5);
				}
			}

			if (this.state[i].isGoat()) {
				StdDraw.setPenColor(StdDraw.WHITE);
				if (this.state[i].isWest()) {
					StdDraw.filledCircle(12.5, 45.0, 2.5);
				} else {
					StdDraw.filledCircle(87.5, 45.0, 2.5);
				}
			}

			if (this.state[i].isCabbage()) {
				StdDraw.setPenColor(StdDraw.GREEN);
				if (this.state[i].isWest()) {
					StdDraw.filledCircle(12.5, 35.0, 2.5);
				} else {
					StdDraw.filledCircle(87.5, 35.0, 2.5);
				}
			}
		}

	}
	
	public void plot2(){
		for (int i = 0; i < 4; i++) {                      			//  Einai i idia me tin plot 
			if (this.state[i].isFarmer()) {                         //  alla anti kiklous emfanizei
				if (this.state[i].isWest()) {              	        //  eikones.
					StdDraw.picture(12.5, 67.0, "img/farmer.gif");
				} 
				else {                                   
					StdDraw.picture(87.5, 67.0, "img/farmer.gif");
				}                                          
			}                                              
                                                          
			if (this.state[i].isWolf()) {                  
				if (this.state[i].isWest()) {              
					StdDraw.picture(12.5, 55.0, "img/wolf.gif");
				} 
				else {	
					StdDraw.picture(87.5, 55.0, "img/wolf.gif");
				}
			}

			if (this.state[i].isGoat()) {
				if (this.state[i].isWest()) {
					StdDraw.picture(12.5, 44.0, "img/goat.gif");
				} 
				else {
					StdDraw.picture(87.5, 44.0, "img/goat.gif");
				}
			}

			if (this.state[i].isCabbage()) {
				if (this.state[i].isWest()) {
					StdDraw.picture(12.5, 33.0, "img/cabbage.gif");
				} 
				else {
					StdDraw.picture(87.5, 33.0, "img/cabbage.gif");
				}
			}
		}
	}
	
	public void plot(State s) {      //  I methodos plot() emfanizei grafika tin ipo anafora
	                                 //  katastasi me vasi tin prokatoxo katastasi (s). 
		                             //  Emfanizei tin kinisi apo to (s) stin parousa katastasi.
		
		State cS = new State(this.state[0], this.state[1], this.state[2], this.state[3]);
		s.plot2();
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(50.0,50.0, 28);
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledSquare(50.0, 50.0, 25.0);
		StdDraw.picture(50, 50, "img/river.gif");
		if (this.state[0].isEast()){
			StdDraw.picture(35.0, 35.0, "img/boat.gif");
		}
		else{
			StdDraw.picture(65.0, 35.0, "img/boat.gif");
		}
		
		int dx = 0;
		while (dx<=30){				
			if (this.state[0].isEast()){
				if (s.MoveTo(Types.MType.FAlone).isSame(cS)){
					StdDraw.picture(35.0+dx, 35.0, "img/boat.gif");
					StdDraw.picture(40.0+dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(12.5, 67.0, 6.5);
				}
				if (s.MoveTo(Types.MType.WithWolf).isSame(cS)){
					StdDraw.picture(35.0+dx, 35.0, "img/boat.gif");
					StdDraw.picture(40.0+dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(12.5, 67.0, 6.5);
					StdDraw.picture(32.0+dx, 41.0, "img/wolf.gif");
					StdDraw.filledSquare(12.5, 55.0, 5.5);
				}
				if (s.MoveTo(Types.MType.WithGoat).isSame(cS)){
					StdDraw.picture(35.0+dx, 35.0, "img/boat.gif");
					StdDraw.picture(40.0+dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(12.5, 67.0, 6.5);
					StdDraw.picture(30.0+dx, 41.0, "img/goat.gif");
					StdDraw.filledSquare(12.5, 44.0, 5.5);
				}
				if (s.MoveTo(Types.MType.WithCabbage).isSame(cS)){
					StdDraw.picture(35.0+dx, 35.0, "img/boat.gif");
					StdDraw.picture(40.0+dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(12.5, 67.0, 6.5);
					StdDraw.picture(30.0+dx, 39.0, "img/cabbage.gif");
					StdDraw.filledSquare(12.5, 32.0, 5.5);
				}
			}
			else{
				if (s.MoveTo(Types.MType.FAlone).isSame(cS)){
					StdDraw.picture(65.0-dx, 35.0, "img/boat.gif");
					StdDraw.picture(70.0-dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(87.5, 67.0, 6.5);
				}
				if (s.MoveTo(Types.MType.WithWolf).isSame(cS)){
					StdDraw.picture(65.0-dx, 35.0, "img/boat.gif");
					StdDraw.picture(70.0-dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(87.5, 67.0, 6.5);
					StdDraw.picture(61.0-dx, 41.0, "img/wolf.gif");
					StdDraw.filledSquare(87.5, 55.0, 5.5);
				}
				if (s.MoveTo(Types.MType.WithGoat).isSame(cS)){
					StdDraw.picture(65.0-dx, 35.0, "img/boat.gif");
					StdDraw.picture(70.0-dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(87.5, 67.0, 6.5);
					StdDraw.picture(60.0-dx, 41.0, "img/goat.gif");
					StdDraw.filledSquare(87.5, 44.0, 5.5);
				}
				if (s.MoveTo(Types.MType.WithCabbage).isSame(cS)){
					StdDraw.picture(65.0-dx, 35.0, "img/boat.gif");
					StdDraw.picture(70.0-dx, 42.0, "img/farmer.gif");
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(87.5, 67.0, 6.5);
					StdDraw.picture(60.0-dx, 39.0, "img/cabbage.gif");
					StdDraw.filledSquare(87.5, 32.0, 5.5);
				}
			}
			StdDraw.show(50);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledSquare(50.0,50.0, 28);
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledSquare(50.0, 50.0, 25.0);
			StdDraw.picture(50, 50, "img/river.gif");
			dx=dx+1;
		}		
		cS.plot2();
		if (this.state[0].isWest()){
			StdDraw.picture(35.0, 35.0, "img/boat.gif");
		}
		else{
			StdDraw.picture(65.0, 35.0, "img/boat.gif");
		}
		StdDraw.show(500);
		

	}

	public static void main(String[] args) {  //  I main aplos elegxei tis methodous tis klasis State
		                                      //  an leitourgoun sosta.
		Entity[] testEntities = new Entity[4];
		testEntities[0] = new Entity(Types.EType.Farmer, Types.Position.East);
		testEntities[1] = new Entity(Types.EType.Wolf, Types.Position.East);
		testEntities[2] = new Entity(Types.EType.Goat, Types.Position.East);
		testEntities[3] = new Entity(Types.EType.Cabbage, Types.Position.East);
		State testPlot = new State(testEntities[0], testEntities[1], testEntities[2], testEntities[3]);
		StdDraw.setXscale(0.0, 100.0);
		StdDraw.setYscale(0.0, 100.0);
		StdDraw.clear(StdDraw.GRAY);
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledSquare(50.0, 50.0, 25.0);
		//testPlot.plot();
		//StdDraw.show(1000);
		State[] testArr = new State[7];
		testArr[0] = testPlot.MoveTo(Types.MType.WithGoat);
		//StdDraw.clear(StdDraw.GRAY);
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledSquare(50.0, 50.0, 25.0);
		testArr[0].plot(testPlot);
		//StdDraw.clear(StdDraw.GRAY);
		testArr[1] = testArr[0].MoveTo(Types.MType.FAlone);
		testArr[1].plot(testArr[0]);
		StdDraw.clear(StdDraw.GRAY);
		testArr[2] = testArr[1].MoveTo(Types.MType.WithWolf);
		testArr[2].plot(testArr[1]);
		StdDraw.clear(StdDraw.GRAY);
		testArr[3] = testArr[2].MoveTo(Types.MType.WithGoat);
		testArr[3].plot(testArr[2]);
		StdDraw.clear(StdDraw.GRAY);
		testArr[4] = testArr[3].MoveTo(Types.MType.WithCabbage);
		testArr[4].plot(testArr[3]);
		StdDraw.clear(StdDraw.GRAY);
		testArr[5] = testArr[4].MoveTo(Types.MType.FAlone);
		testArr[5].plot(testArr[4]);
		StdDraw.clear(StdDraw.GRAY);
		testArr[6] = testArr[5].MoveTo(Types.MType.WithGoat);
		testArr[6].plot(testArr[5]);
		StdDraw.clear(StdDraw.GRAY);
		
		if (testArr[6].isFinal()) {
			StdOut.println("It is the final state " + testArr[6].toString());
		} else {
			StdOut.println("It is not the final state " + testArr[6].toString());
		}
		//testPlot.plot();
	}

}
