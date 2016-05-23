package calculator.datatypes.vector;
 
import java.util.Iterator;
import java.util.Vector;
import calculator.AbstractValue;
 
public class VectorValue extends AbstractValue {
    private final Vector<Double> vector;
     
    public VectorValue(Vector<Double> vector) {
        super();
        this.vector = vector;
    }
     
    public String toString() {
        if(this.vector.isEmpty())
            return "Empty";
        else
            return this.vector.toString();
    }
     
    public Vector<Double> data() {
        return this.vector;
    }
     
    public AbstractValue add(AbstractValue operand) {
        Vector<Double> newVector = new Vector<Double>();
        Iterator<Double> iter1 = this.vector.iterator();
        Iterator<Double> iter2 = ((VectorValue) operand).data().iterator();
         
        while(iter1.hasNext() && iter2.hasNext()) {
            newVector.addElement(iter1.next()+iter2.next());
        }
        return new VectorValue(newVector);
    }
     
    public AbstractValue sub(AbstractValue operand) {
        Vector<Double> newVector = new Vector<Double>();
        Iterator<Double> iter1 = this.vector.iterator();
        Iterator<Double> iter2 = ((VectorValue) operand).data().iterator();
         
        while(iter1.hasNext() && iter2.hasNext()) {
            newVector.addElement(iter1.next()-iter2.next());
        }
        return new VectorValue(newVector);
    }
     
    public AbstractValue mul(AbstractValue operand) {
        return null;
    }
     
    public AbstractValue div(AbstractValue operand) {
        return null;
    }
}
