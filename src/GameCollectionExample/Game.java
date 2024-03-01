package GameCollectionExample;

// the class is abstract as we never want to be able to make just a "Game" - we want to extend this into subclasses
// for specific platforms such as PlaystationGame, XboxGame, SteamGame, etc., and then be able to make those directly.
// The purpose of this class however is that all of those subclasses will have the same basic functionality and fields,
// so instead of duplicating that code in three (or more) other classes, we can implement it here once and then reuse
// the implementation effort later by extending into subclasses
public abstract class Game{

    // 1. fields
    // 2. constructors
    // 3. accessors/mutators (+ toString)
    // 4. class-specific methods
    // 5. main method/test harness

    // NOTE: we didn't have time to do this in the lecture, but instead of using String to represent the ageRating,
    // since it can only take one of a small number of defined values, it makes more sense to use an enum
    public enum AgeRating{PEGI_3, PEGI_7, PEGI_12, PEGI_16, PEGI_18, UNRATED};

    // We can make the fields private as we don't need public access elsewhere - we could also make them protected,
    // but if we don't actually need to access them directly, they can stay private anyway
    private String gameName;
    private String devName;
    private int numPlayers;
    private AgeRating ageRating; // the type is our enum, AgeRating, instead of String now

    // first constructor that takes args for all 4 fields and check that the number of players is greater than 0. If it
    // isn't then an Exception is thrown - specifically, our own subclass of Exception called
    // InvalidNumberOfPlayersException
    //
    // Note that we can pass in a String for ageRating still and try to convert it to a valid value of our enum - if it
    // doesn't match though it will cause an (unchecked) Exception, so you need to remember to handle that somewhere or
    // risk having your code crash if an exception happens with no way to recover from it
    public Game(String gameName, String devName, int numPlayers, String ageRating) throws
            InvalidNumberOfPlayersException{

        // check the number of players here - throw the exception if it is less than 1
        if (numPlayers < 1) {
            throw new InvalidNumberOfPlayersException("Num players must be at least 1, but found " + numPlayers);
        }

        // The code below will try to get the enum value that matches the String we've passed in - this is a typical
        // use case to create objects with enum fields if reading data from file (i.e. read data in as a String then
        // try to convert into an enum using the .valueOf method)
        AgeRating toStore = AgeRating.valueOf(ageRating); // will throw IllegalArgumentException if ageRating String
                                                          // doesn't match one of the defined values

        // if no exception was thrown then we can set the fields like usual - code will not get here if an Exception
        // is thrown, however
        this.gameName = gameName;
        this.devName = devName;
        this.numPlayers = numPlayers;
        this.ageRating = toStore; // toStore was converted from an input String to an enum before being stored here
    }

    // second constructor that sets a default value for the age rating
    public Game(String gameName, String devName, int numPlayers) throws InvalidNumberOfPlayersException{
        this(gameName, devName, numPlayers, "UNRATED"); // note that this calls our constructor from above to avoid
                                                        // code duplication of the checks and setting the fields
    }

    // getters and setters

    // a getter for the ageRating field
    public AgeRating getAgeRating() {
        return ageRating;
    }

    // a standard setter/mutator method that expects the same type as the field - i.e. in this case, an AgeRating
    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    // we could also add a utility method so that a user can pass in a String and it will try to convert it to an
    // AgeRating if the String matches one of the specified values - remember this will thrown an unchecked
    // IllegalArgumentException if the passed in String does not match one of the defined values of the AgeRating enum
    //
    // This is an example of method overLOADing - since we now have another method called setAgeRating, but it is fine
    // since the argument type(s) do not match the previous method, e.g. setAgeRating(AgeRating) vs setAgeRating(String)
    public void setAgeRating(String ageRatingString) {
        this.ageRating = AgeRating.valueOf(ageRatingString);
    }

    // you could have other getters and setters too, but we'll leave it here

    // a class-specific method as an example


    // overridden toString to return something more sensible for this class
    public String toString(){
        return this.gameName+","+this.devName+","+this.numPlayers+","+this.ageRating;
    }

    // remember, since Game is abstract we cannot instantiate a Game object in a local test hardness to test it -
    // however, we can test all of the functionality above when we implement a subclass that extends this (since it will
    // inherit all of the behaviours from the Game base class)

}
