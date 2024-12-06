package dominio.exception;

public class EmailFormatException extends Throwable {
    public EmailFormatException() {
        super("Email sem o \"@\", adcione para prosseguir.");
    }
}
