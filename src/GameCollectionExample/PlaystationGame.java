package GameCollectionExample;

public class PlaystationGame extends Game{

    public PlaystationGame(String gameName, String devName, int numPlayers, String ageRating) throws InvalidNumberOfPlayersException{
        super(gameName, devName, numPlayers, ageRating);
    }


    // we can override the toString to reuse what we already have in the super class, but also add a part to show
    // this is a PlaystationGame specifically
    public String toString(){
        // super.toString calls the toString method in the super class, i.e. Game.
        // Therefore, this should return "PlayStation Game: " + the result of super.toString appended
        return "Playstation game: " + super.toString();
    }

    public static void main(String[] args) {
        try {
            Game psGame = new PlaystationGame("God of War", "Sony", 1, "PEGI 18");
            System.out.println("Attempt 1 at making a game: " + psGame);
        } catch (InvalidNumberOfPlayersException e) {
            System.out.println("This will not trigger since 1 is a valid number of players, but...");
        } catch (IllegalArgumentException e) {
            System.out.println("This will trigger as the String we pass in must match a value for AgeRating exactly");
            System.out.println("\tThe exception's toString was: " + e);
            System.out.println("(but at least we caught the exception instead of it just breaking)");
        }

        System.out.println(); // whitespace to format the output more nicely

        // try the above again, but this time, include the underscore
        try {
            Game psGame = new PlaystationGame("God of War", "Sony", 1, "PEGI_18");
            System.out.println("Attempt 2 at making a game: " + psGame);
            System.out.println("(This printed fine as it was successful on attempt #2)");
        } catch (InvalidNumberOfPlayersException e) {
            System.out.println("This will not trigger since 1 is a valid number of players, but...");
        } catch (IllegalArgumentException e) {
            System.out.println("This will not trigger as PEGI_18 matches one of our enum's values");
            // note that we could have made the constructor replace spaces with underscores if we wanted to - it is up
            // to us to determine how we wish to implement the class, but for now, we will just expect exact values
        }
    }



}
