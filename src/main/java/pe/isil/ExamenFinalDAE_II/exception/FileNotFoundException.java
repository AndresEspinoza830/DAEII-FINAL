package pe.isil.ExamenFinalDAE_II.exception;

public class FileNotFoundException extends RuntimeException{

    public FileNotFoundException(String message){
        super(message);
    }

    public FileNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
