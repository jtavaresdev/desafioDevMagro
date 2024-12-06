package dominio.exception;

public class HeightFormatException extends Throwable{
    public HeightFormatException() {
        super("Erro na passagem do parametro, falta virgula. Ex: 1,83 m");
    }
}
