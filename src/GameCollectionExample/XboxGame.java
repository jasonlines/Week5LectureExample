package GameCollectionExample;

public class XboxGame extends Game{

    // we won't add anything specific to this class but note that it is a subclass of Game, not PlaystationGame
    public XboxGame(String gameName, String devName, int numPlayers, String ageRating) throws InvalidNumberOfPlayersException{
        super(gameName, devName, numPlayers, ageRating);
    }

    // we will also override the toString like we did in Playstatoin Game, but this time will say it is an Xbox game
    public String toString(){
        // super.toString calls the toString method in the super class, i.e. Game.
        // Therefore, this should return "Xbox Game: " + the result of super.toString appended
        return "Xbox game: " + super.toString();
    }

    // simple test harness - note that we have explicitly said this method can throw the following type of checked
    // exception, so we do not need to put the code that could throw it in a try-catch. That's fine in some places
    // (and sensbile if you want to catch the exception elsewhere) but remember that it is generally bad practice to
    // have a main method declare in its header that it throws an exception as that is your last place to handle it - so
    // the code below is basically just saying it may throw one of these exceptions, and if it does, then... it breaks.
    // (so don't do this yourself in a main method, but it's good to see the difference when compared to the main in
    // PlaystationGame)
    public static void main(String[] args) throws InvalidNumberOfPlayersException{
        XboxGame xg = new XboxGame("Halo Infinite", "Microsoft", 4, "PEGI_16");
        System.out.println(xg);

        // the above should be fine but remember - since we just declared that the main could throw an
        // InvalidNumberOfPlayersException, if that happened when calling the constructor, since it is not within a
        // try-catch then there is nothing we could do to recover from the exception happening and our code would crash.
        //
        // As an exercise, I suggest modifying the header to remove the "throws InvalidNumberOfPlayersException" part
        // from the main method's header and then putting the call to the constructor in a try-catch (which is better
        // practice as our code can then recover if the constructor did throw that kind of exception)

    }
}
