package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

public class ComplexValue extends AbstractValue 
{
	private final double[] value;
	private final double Re;
	private final double Im;
	
	public ComplexValue(double[] mas) 
	{
		super();
		this.value = mas;
		Re = mas[0];
		Im = mas[1];
	}

	public String toString() {
		return "("+Double.toString(Re)+","+Double.toString(Im)+")";
	}
	//Получение действительной части
	public double getRe()
	{ 
	return Re; 
	} 
	public double getIm()
	{ 
	return Im; 
	} 
	//Показать исходное значение
	public double[] V()
	{
		return value;
	}

	public AbstractValue add(AbstractValue chis) {
		ComplexValue ch = (ComplexValue)chis;
		double[] res = new double[2];
		res[0] = Re + ch.getRe();
		res[1] = Im + ch.getIm();
		ComplexValue RES = new ComplexValue(res);
		return RES;
	}

	public AbstractValue sub(AbstractValue chis) {
		ComplexValue ch = (ComplexValue)chis;
		double[] res = new double[2];
		res[0] = Re - ch.getRe();
		res[1] = Im - ch.getIm();
		ComplexValue RES = new ComplexValue(res);
		return RES;
	}

	public AbstractValue mul(AbstractValue chis) 
	throws OperationNotSupportedException
	{
		ComplexValue ch = (ComplexValue)chis;
		double[] res = new double[2];
		res[0] = (Re * ch.getRe()) - (Im * ch.getIm());
		res[1] = (Re * ch.getIm()) + (Im * ch.getRe());
		ComplexValue RES = new ComplexValue(res);
		return RES;
	}

	public AbstractValue div(AbstractValue chis)
			throws DivisionByZeroException 
	{
		ComplexValue ch = (ComplexValue)chis;
		double[] res = new double[2];
		if (ch.getRe() == 0 & ch.getIm() == 0)
			throw new DivisionByZeroException();
		res[0] = ((Re * ch.getRe()) + (Im * ch.getIm()))/(Math.pow(ch.getRe(), 2) + Math.pow(ch.getIm(), 2));
		res[1] = ((Im * ch.getRe())-(Re * ch.getIm()))/(Math.pow(ch.getRe(), 2) + Math.pow(ch.getIm(), 2));
		ComplexValue RES = new ComplexValue(res);
		return RES;
	}

}