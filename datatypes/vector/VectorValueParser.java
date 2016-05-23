package calculator.datatypes.vector;
 
import java.util.Vector;
import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
 
public class VectorValueParser implements AbstractValueParser {
     
    public AbstractValue parse(String value)
            throws ParseValueException {
        try {
            String values[] = value.split(",");
            Vector<Double> vector = new Vector<Double>();
            for(String el : values) {
                if(el != " ")
                    vector.addElement(Double.parseDouble(el));
            }
            return new VectorValue(vector);
        } catch (NumberFormatException excrption) {
            throw new ParseValueException();
        }
    }
     
    public String getDatatypeName() {
        return "вектора";
    }
} 
