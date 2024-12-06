package dominio.exception;

public class AgeException extends  Throwable{
    public AgeException() {
        super("Proibido o cadastro de menores");
    }
}
