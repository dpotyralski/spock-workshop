package pl.dpotyralski.spockintroduction;

public class ExceptionProvider {

    public void operation(){
        System.out.println("Happy path!");
    }

    public void operationUnsupported(){
        throw new UnsupportedOperationException("Operation is not supported!");
    }

}
