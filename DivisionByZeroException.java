package calculator;

@SuppressWarnings("serial")
public class DivisionByZeroException extends Exception 
//extends - ��� �������� �����, ��������������� ��� ���������� ���������� ������-�� ������������� ������. 
{
	public DivisionByZeroException() {
		super("������� �� ����");
	}
}
