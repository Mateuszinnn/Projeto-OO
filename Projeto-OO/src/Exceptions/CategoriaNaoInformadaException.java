package Exceptions;

public class CategoriaNaoInformadaException extends RuntimeException {
    public CategoriaNaoInformadaException() {
        super();
    }

    public CategoriaNaoInformadaException(String msg) {
        super(msg);
    }
}
