package calculator;


public class Calculator {
	private final AbstractValueParser valueParser;
	//private final - "������ ��������"

	public Calculator(AbstractValueParser valueParser) {
		this.valueParser = valueParser;
	}

	public String calculate(String arg1, String operation, String arg2)
			throws DivisionByZeroException,
			//�������� throw ������������ ��� ����������� ���������� ���������.
			ParseValueException, OperationNotSupportedException {
		AbstractValue left = valueParser.parse(arg1);
		AbstractValue right = valueParser.parse(arg2);
		return calculate(left, operation, right).toString();
	}

	private AbstractValue calculate(AbstractValue left, String operation,
			AbstractValue right) throws DivisionByZeroException, OperationNotSupportedException 
			//�������� throw ������������ ��� ����������� ���������� ���������.
	{
		if (operation.equals("+"))
			return left.add(right);
		if (operation.equals("-"))
			return left.sub(right);
		if (operation.equals("/"))
			return left.div(right);
		if (operation.equals("*"))
			return left.mul(right);
		throw new OperationNotSupportedException(operation);
	}
}
