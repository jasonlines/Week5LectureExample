package GameCollectionExample;

// another simple example of extending the abstract Game class into a third subclass
public class SteamGame extends Game{

    // Just like with XboxGame, we won't add anything specific to this class besides what it inherits from Game (and we
    // can use the Game constructor here to set the fields and check the enum and numPlayers without duplicating the code)
    public SteamGame(String gameName, String devName, int numPlayers, String ageRating) throws InvalidNumberOfPlayersException{
        super(gameName, devName, numPlayers, ageRating);
    }

    // we will also override the toString like we did in Playstation Game, but this time will say it is a Steam game
    public String toString(){
        // super.toString calls the toString method in the super class, i.e. Game.
        // Therefore, this should return "Steam Game: " + the result of super.toString appended
        return "Steam game: " + super.toString();
    }

    public static void main(String[] args) {
        try {
            SteamGame steamGame = new SteamGame("Counter-Strike 2", "Valve", 1, "PEGI_18");
            System.out.println(steamGame);
        }catch (InvalidNumberOfPlayersException e){
            // we can use printStackTrace to print out the full trace of where the exception occurred (if it did)
            e.printStackTrace();
        }
    }
}
