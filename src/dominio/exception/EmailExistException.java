package dominio.exception;

public class EmailExistException extends  Throwable{
    public EmailExistException(){
        super("Email já existente no Bando de Dados.");
    }
}
