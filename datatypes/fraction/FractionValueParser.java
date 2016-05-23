package calculator.datatypes.fraction;
 
import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.DivisionByZeroException;
 
public class FractionValueParser implements AbstractValueParser {
 
    public AbstractValue parse(String value)
            throws ParseValueException, DivisionByZeroException {
        try {
            String values[] = value.split("/");
            if(values.length != 2)
                throw new ParseValueException();
            return new FractionValue(Integer.parseInt(values[0]),
                    Integer.parseInt(values[1]));
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }
     
    public String getDatatypeName() {
        return "дроби";
    }
     
}
