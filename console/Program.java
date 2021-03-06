
package calculator.console;
 
import java.util.Scanner;
 
import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.real.RealValueParser;
import calculator.datatypes.fraction.FractionValueParser;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.vector.VectorValueParser;
 
public class Program {
 
    private final Scanner scanner;
 
    private final Calculator calc;
 
    private AbstractValueParser[] valueParsers;
 
    public Program() {
        scanner = new Scanner(System.in);
        valueParsers = new AbstractValueParser[] { new IntegerValueParser(),
                new RealValueParser(), new FractionValueParser(), new ComplexValueParser(), 
                new VectorValueParser() };
        AbstractValueParser parser = inputValueParser();
        System.out.println("�������� � ����� '" + parser.getDatatypeName()
                + "'");
        calc = new Calculator(parser);
    }
 
    private AbstractValueParser inputValueParser() {
        showChoises();
        int choise = scanner.nextInt();
        if (choise >= 1 && choise <= valueParsers.length)
            return valueParsers[choise - 1];
        else {
            System.out.println("�������� �����!");
            return inputValueParser();
        }
    }
 
    private void showChoises() {
        System.out.println("��� ����� ������� ��� ������. ��������� ��������:");
        for (int i = 0; i < valueParsers.length; i++)
            System.out.println("  " + (i + 1) + ". "
                    + valueParsers[i].getDatatypeName());
    }
 
    public static void main(String args[]) {
        try {
            Program instance = new Program();
            instance.run(args);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
 
    private void run(String[] args) {
        while (true) {
            String arg1 = scanner.next();
            if (arg1.equals("exit"))
                break;
            String op = scanner.next();
            String arg2 = scanner.next();
            try {
                System.out.println(" = " + calc.calculate(arg1, op, arg2));
 
            } catch (Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        }
    }
 
}