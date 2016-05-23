package calculator.datatypes.complex;
 
import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
 
public class ComplexValueParser implements AbstractValueParser {
     
    public AbstractValue parse(String value) 
            throws ParseValueException {
        try {
        	String value1 = value.substring(1,value.length()-1);
            String values[] = value1.split(",");
            double[] mas = new double[2];
            mas[0] = Double.parseDouble(values[0]);
            mas[1] = Double.parseDouble(values[1]);
                return new ComplexValue(mas);
    
            //else
              //  return new ComplexValue(Double.parseDouble(values[1]), Double.parseDouble(values[2]));
    } catch(NumberFormatException exeption) {
          throw new ParseValueException();
        }}
     
    public String getDatatypeName() {
        return "комплексные числа";
    }}