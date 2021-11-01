package Exceptions;

public class ValorNaoInformadoException extends RuntimeException {
    public ValorNaoInformadoException() {
        super();
    }

    public ValorNaoInformadoException(String msg) {
        super(msg);
    }
}
