package model.exceptions;

// Expection obrigada a gente a tratar as excessões (RuntimeException para não precisar usar throws nas funções)
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	// construtor recebendo um string msg como argumento e passando para superclasse
	public DomainException(String msg) {
		super(msg);
	}

	 
}
