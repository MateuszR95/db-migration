package pl.mateusz.example.dbmigration;

public class MinimumAgeException extends RuntimeException{
    public MinimumAgeException(String message) {
        super(message);
    }
}
