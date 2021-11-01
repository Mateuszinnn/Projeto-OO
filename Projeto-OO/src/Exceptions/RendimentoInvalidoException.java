package Exceptions;

public class RendimentoInvalidoException extends RuntimeException{
	public RendimentoInvalidoException() {
        super();
    }

    public RendimentoInvalidoException(String msg) {
        super(msg);
    }
}
