package t08_generics_1.examples.result;

public class Main {

    public static void main(String[] args) {
        t08_generics_1.examples.result.Main app = new t08_generics_1.examples.result.Main();
        app.demo();
    }

    public  void demo() {

        System.out.println("\nGeneric Result class - used to return a 'Result' object from an operation (function)");
        // create (instantiate) a Result object that indicates that some operation was successful
        // and therefore contains the result value (This would be returned by the operation)
        Result<Integer> result = Result.ok(10);
        if (result.isOk())
            System.out.println("Successful operation, result = " + result.value() );

        // create (instantiate) a Result object that indicates that some operation has failed,
        // so the value in Result object will be null
        Result<Integer> errorResult = Result.fail("There was an error");
        if( errorResult.isOk() )
            System.out.println("Successful  operation,  result = " + errorResult.value());
        else
            System.out.println("Unsuccessful operation, result = " + errorResult.value());
    }
}

class Result<T> {
    private T _value;
    private String _error;

    private Result(T value, String error) {
        _value = value;
        _error = error;
    }

    public static <T> Result<T> ok(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> fail(String error) {
        return new Result<>(null, error);
    }

    public boolean isOk() {
        return _error == null;
    }

    public T value() {
        return _value;
    }

    public String error() {
        return _error;
    }
}

