/**
* Author: 		Panayiotis Leontiou
* Written: 		19/11/2016
* Last updated: 13/8/2020
*
* Compilation: 	javac -cp ./stdlib.jar Farmer.java
* Execution: 	java -cp .:./stdlib.jar Farmer
*
* Enas georgos, mazi me ena liko, mia katsika kai ena laxano prepei na diasxisoun me asfaleia
* ena potami. Oloi tous vriskontai stin anatoliki oxthi tou potamou (East bank) kai epithimoun
* na to diasxisoun gia na ftasoun stin ditiki oxthi(West bank), me tous ekseis periorismous:
* -Mono o georgos mporei na kopilatisei ti varka.
* -An i katsika vrisketai stin idia oxthi me to laxano kai o georgos einai stin alli oxthi,
*  tha faei to laxano.
* -An o likos vrisketai stin idia oxthi me tin katsika kai o georgos einai stin alli oxthi,
*  tha faei tin katsika(afou prota tin afisei na faei to laxano an einai kai to laxano mazi tous) 
* 
* To klasi Farmer.java ipologizei tin lisi tou pio pano provlimatos kai tin parousiazei toso
* se lektiki oso kai se optiki morfi. (gia na leitourgisei xreiazete tis klaseis: Entity, State,
* Stack kai Types)
* 
*/

public class Farmer {

	public static void display(Stack solution) { //  I methodos parousiazei tin lisi optika.
		StdDraw.setXscale(0.0, 100.0);  //  Thetei tin klimaka tou kamva gia ton X aksona.
		StdDraw.setYscale(0.0, 100.0);  //  Thetei tin klimaka tou kamva gia ton Y aksona.
		int count = 0;                  //  Metraei ton arithmo ton pictures pou tha 
                                        //  apothikefsei.
		State previous = new State();//Edit for plot(s)//  Antiprosopevei tin prokatoxo katastasi.
		while (!solution.isEmpty()) {                 //  Enoso i stiva me tis liseis den einai
			StdDraw.clear(StdDraw.GRAY);              //  adia zografizei to grizo background,  
			StdDraw.setPenColor(StdDraw.CYAN);        //  to galazio tetragono potamo.   
			StdDraw.filledSquare(50.0, 50.0, 25.0);   //  Pernei to proto stixeio tis stivas
			StdDraw.picture(50, 50, "img/river.gif"); 
			State st = solution.getTop();             //  (solution) to anathetei sto state (st)
			solution.pop();                           //  kai to aferei apo tin stiva. Akolouthos
			if (count==0){                            //  zografizei tin katastasi (st).
				st.plot2();                           //  An to count einai miden tote simenei
			}                                         //  oti vriskontai stin arxiki katastasi
			else{                                     //  epomenos parousiazetai i arxiki 
				st.plot(previous); //Edit for plot(s) //  katastasi allios emfanizetai i kinisi
			}                                         //  ton entities apo tin proigoumeni 
			String file = "Farmer" + count + ".png";  //  katastasi stin parousa katastasi.
			StdDraw.save(file);                       //  Apothikevei tin eikona me to onoma 
			count++;                                  //  Farmer(count).jpg kai afksanei to  
			StdDraw.show(1000);                       //  arithmo ton eikonon kata ena.
			previous = st;  //Edit for plot(s)        //  Kathisterei tin epomeni eikona kata
		}                                             //  1 second gia na fenontai oi metavoles
	}                                                 //  ton theseon ton antikeimenon.

	public static void main(String[] args) {

		Entity e1 = new Entity(Types.EType.Farmer, Types.Position.East);  //  Dimiourgei tis
		Entity e2 = new Entity(Types.EType.Wolf, Types.Position.East);    //  ontotites Farmer, 
		Entity e3 = new Entity(Types.EType.Goat, Types.Position.East);    //  Wolf, Goat kai 
		Entity e4 = new Entity(Types.EType.Cabbage, Types.Position.East); //  Cabbage.
		State initial = new State(e1, e2, e3, e4);  //  Dimiourgei tin arxiki katastasi me tis 4 
		Stack stack = new Stack(100);               //  ontotites kai tin stiva (stack) me 
		stack.push(initial);                        //  xoritikotita 100 theseon. Topothetei tin
		                                            //  arxiki katastasi(initial) mesa stin stiva.
		while (!stack.isEmpty() && !stack.getTop().isFinal()) { 
		//  Enoso i stiva den einai adia kai i proti katastasi stin stiva den einai i teliki:
			
			State[] succs = new State[4];       //  Dimiourgei pinaka katastaseon me 4 theseis.            
			int N = stack.getTop().getSuccs(succs); //  Pernei ton arithmo ton diadoxon katastaseon
			boolean deadend = true;             //  deadend = vriskete se adieksodo.
			boolean found = false;              //  found = vrethike i lisi tou provlimatos.
			for (int i = 0; i < N; i++)
				if (succs[i].isFinal()) {  //  An i pithani diadoxi katastasi einai i teliki
					found = true;          //  tote to found ginete true kai to deadend false
					deadend = false;       //  gia na min aferethi to proto stixio tis stivas.
					stack.push(succs[i]);  //  Prosthetoume tin katastasi stin stiva (stack).
				}
			if (!found) {                             //  An den vrethike i lisi tote psaxnei ston 
				for (int i = 0; i < N; i++) {         //  pinaka (succs) me tis dinates diadoxes 
					if (!stack.contains(succs[i])) {  //  katastaseis an den periexei tin idia
						stack.push(succs[i]);         //  katastasi me prin tin vazei stin stiva.
						deadend = false;              //  Kai afou den eftase se adieksodo den tha
					}                                 //  aferesei katastasi apo tin stiva.
				}
			}
			if (deadend)      //  An ftasei se adieksodo tote aferei apo tin stiva tin teleftea 
				stack.pop();  //  katastasi.
		}
		Stack solution = new Stack(100);  //  Dimiourgeitai mia alli stiva 100 theseon opou
		solution.push(stack.getTop());    //  tha topothetisoume tis diadoxikes katastasis
		stack.pop();                      //  tis lisis tou provlimatos.
		while (!stack.isEmpty()) {              //  Enoso i stiva(stack) den einai keni: An i proti 
			if (stack.getTop().validMoveTo(solution.getTop()))  //  katastasi einai epitrepti me
				solution.push(stack.getTop()); //  vasi tin proigoumeni katastasi tis lisis, tin 
			stack.pop();                       //  prosthetoume stin stiva (solution) kai akolouthos
		}                                      //  aferoume tin katastasi apo tin stiva (stack).
		System.out.print(solution);  //  Ektiponoume tin lisi se lektiki alla kai se optiki morfi.
		display(solution);

	}

}
