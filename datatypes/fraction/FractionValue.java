package calculator.datatypes.fraction;
 
import calculator.AbstractValue;
import calculator.DivisionByZeroException;
 
public class FractionValue extends AbstractValue {
     
    private final int numerator;
    private final int denominator;
     
    private int gcd(int a, int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
     
    public FractionValue(int numerator, int denominator) 
            throws DivisionByZeroException {
        super();
        int d = gcd(numerator, denominator);
        this.numerator = numerator/d;           
        this.denominator = denominator/d;
         
        if(denominator == 0)
            throw new DivisionByZeroException();
    }
     
    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
     
    public FractionValue inverse() 
            throws DivisionByZeroException {
        return new FractionValue(this.denominator, this.numerator);
    }
     
    public AbstractValue add(AbstractValue operand) 
            throws DivisionByZeroException {
        FractionValue value = ((FractionValue) operand);
        int ad = this.numerator * value.denominator;
        int cb = this.denominator * value.numerator;
        int bd = this.denominator * value.denominator;
         
        return new FractionValue(ad + cb, bd);
    }
 
    public AbstractValue sub(AbstractValue operand) 
            throws DivisionByZeroException {
        FractionValue value = ((FractionValue) operand);
        int ad = this.numerator * value.denominator;
        int cb = this.denominator * value.numerator;
        int bd = this.denominator * value.denominator;
 
        return new FractionValue(ad - cb, bd);
    }
     
    public AbstractValue mul(AbstractValue operand) 
            throws DivisionByZeroException {
        FractionValue value = ((FractionValue) operand);
        int ac = this.numerator * value.numerator;
        int bd = this.denominator * value.denominator;
         
        return new FractionValue(ac, bd);
    }
 
    public AbstractValue div(AbstractValue operand)  
            throws DivisionByZeroException {
        return this.mul(((FractionValue) operand).inverse());
    }
}
