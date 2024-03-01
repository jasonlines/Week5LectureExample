package GameCollectionExample;

// our very simple Exception subclass - we don't need any additional functionality here, just ways to construct it. If
// we don't give any constructors then there will be an implicit default constructor, but since we wanted to have one
// where a message can be passed in, we need to provide that constructor plus an explicit default constructor (because
// remember that we only have an implicit default constructor if NO constructors are given, but it will disappear once
// we make any constructors, so must explicitly have the default constructor implemented like below if we have multiple
// constructors)
public class InvalidNumberOfPlayersException extends Exception{

    public InvalidNumberOfPlayersException(){
        super();
    }

    public InvalidNumberOfPlayersException(String message){
        super(message);
    }
}
