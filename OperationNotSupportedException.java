package calculator;

@SuppressWarnings("serial")
public class OperationNotSupportedException extends Exception
//extends ��� �������� �����, ��������������� ��� ���������� ���������� ������-�� ������������� ������. 
{

	public OperationNotSupportedException(String operation) {
		super("�������� " + operation + " �� ��������������");
		//�������� ����� super ����� ������������ ��� ������ ������������ ����������� � ��� ��������� � ����� �����������, �������� ������ ���������.
	}

}
