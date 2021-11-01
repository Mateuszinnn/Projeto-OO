package Exceptions;

public class DescricaoNaoInformadaException extends RuntimeException {
    public DescricaoNaoInformadaException() {
        super();
    }

    public DescricaoNaoInformadaException(String msg) {
        super(msg);
    }
}