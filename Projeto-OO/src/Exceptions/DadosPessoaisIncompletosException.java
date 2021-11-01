package Exceptions;

public class DadosPessoaisIncompletosException extends RuntimeException{
	public DadosPessoaisIncompletosException() {
        super();
    }

    public DadosPessoaisIncompletosException(String msg) {
        super(msg);
    }

}
