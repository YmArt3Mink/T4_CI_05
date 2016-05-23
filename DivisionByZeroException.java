package calculator;

@SuppressWarnings("serial")
public class DivisionByZeroException extends Exception 
//extends - это ключевое слово, предназначенное для расширения реализации какого-то существующего класса. 
{
	public DivisionByZeroException() {
		super("Деление на ноль");
	}
}
