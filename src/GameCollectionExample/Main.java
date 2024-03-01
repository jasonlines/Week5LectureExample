package GameCollectionExample;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // To demonstrate polymorphism, we can have a single game colleciton, which we'll represent as a list with
        // ArrayList, that can store any of our Game subclasses. This works becase the colleciton is set up to store
        // Game references, and because inheritance is an IS-A relationship, it means that an XboxGame IS-A Game, and
        // a PlaystationGame object IS-A Game, and the same for SteamGame.

        Game test; // we'll show that this can store objects from any of our subclasses first
        PlaystationGame psGame = null;
        XboxGame xbGame = null;
        SteamGame stGame = null;

        try {
            // Let's make one of each:
            psGame = new PlaystationGame("God of War", "Sony", 1, "PEGI_18");
            xbGame = new XboxGame("Halo Infinite", "Microsoft", 4, "PEGI_16");
            stGame = new SteamGame("Counter-Strike 2", "Valve", 1, "PEGI_18");

            // to demonstrate simple polymorphism we can store any of those 3 objects above in the test variable:
            test = psGame; // this is fine
            test = xbGame; // this is fine
            test = stGame; // this is fine

            // the code above is a bit pointless, as we just keep overwriting what "test" is, but the code compiles
            // because the "static" type of test is Game. Since psGame, xbGame and stGame are all subclasses of Game,
            // and inheritance is an IS-A relationship, it means that an XboxGame is a Game too, a PlaystationGame is
            // also a Game as well, and so is a SteamGame.
            //
            // While polymorphism allows the code above, we're not doing anything useful with it. Where it becomes
            // useful is if we need to store an array/collection of Game objects - because of polymorphism, we do not
            // need to have separate lists for XboxGames, PlaystationGames and SteamGames - instead, we can just have
            // a single list/collection of Game objects that can store all of those subclasses. For example:

            ArrayList<Game> myGameList = new ArrayList<>(); // creating a new, empty ArrayList to store Games

            myGameList.add(psGame); // can add a PlaystationGame (because PlaystationGame objs ARE Game objs too)
            myGameList.add(xbGame); // can add a XboxGame (because XboxGame objs ARE Game objs too)
            myGameList.add(stGame); // can add a Steam (because Steam objs ARE Game objs too)

            // we could now iterate through all objects in the list to print them out. Because of polymorphism, while
            // their STATIC type is Game (it is an ArrayList of Game objects), the DYNAMIC type of each matches what it
            // specifically is (so the first is a PlaystationGame so will call the PlaystationGame toString, whereas the
            // second is an XboxGame, so it will call the XboxGame toString, etc.)
            System.out.println("Printing the toStrings from the ArrayList of Games:");
            System.out.println("=======================");;
            for(Game g: myGameList){ // for-each loop, read as "for Game g in myGameList{ // do something with each g"
                System.out.println(g); // the output will say "<platform>: <field values>"
            }
            System.out.println();

            // we can also use the instanceOf operator to do different things depending on the dynamic type of an obj
            // For example, if we loop through the Game objects again, this time we'll do different things depending on
            // which class the dynamic type is for each
            for(int i = 0; i < myGameList.size(); i++){ // iterating through the list again, this time using just a for
                Game game = myGameList.get(i); // have to use .get() with a standard for loop; can store all in a Game though

                System.out.println("The value of i is: " + i);

                // redundant but to show that each thing in the list IS-A Game, plus more below
                if(game instanceof Game){
                    System.out.println("All three are Game objects so this will print three times!");
                }

                //
                if(game instanceof XboxGame){  // i.e. if game is an XboxGame this will trigger
                    System.out.println("This will only print when i is 1");
                }else if(game instanceof SteamGame){ // else if it is a Steam game this will trigger
                    System.out.println("This will only print when i is 2");
                }else if(game instanceof PlaystationGame) { // else if it is a PlaystationGame then this will trigger
                    System.out.println("This will only print when i is 0");
                }else{
                    System.out.println("This would only print if we added a new subclass not handled above");
                }
                System.out.println();
            }


        }catch(Exception e){
            e.printStackTrace(); // good for debugging, not good for final code - instead, do something more helpful to
                                 // handle the exception
        }
    }
}
