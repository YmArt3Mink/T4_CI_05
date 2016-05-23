package calculator;

@SuppressWarnings("serial")
public class OperationNotSupportedException extends Exception
//extends это ключевое слово, предназначенное для расширения реализации какого-то существующего класса. 
{

	public OperationNotSupportedException(String operation) {
		super("Операция " + operation + " не поддерживается");
		//Ключевое слово super можно использовать для вызова конструктора суперкласса и для обращения к члену суперкласса, скрытому членом подкласса.
	}

}
