package dominio.exception;

public class NameFormatException extends Throwable{
    public NameFormatException() {
        super("Numero de caracteres inválido, deve possuir 10 ou mais.");
    }
}
