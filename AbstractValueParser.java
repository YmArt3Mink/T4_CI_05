package calculator;

public interface AbstractValueParser {
	AbstractValue parse(String value) throws ParseValueException, DivisionByZeroException;
	String getDatatypeName();
}
//Оператор throw используется для возбуждения исключения «вручную».
