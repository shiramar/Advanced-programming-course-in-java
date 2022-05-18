
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Boolean.TRUE;
import static java.sql.Types.NULL;

public class Main {

    static boolean valid=false;

    public static void main(String[] args) {


        int numerator1;
        int denominator1;
        int numerator2;
        int denominator2;

        //get user number
        System.out.println("Please enter the first numerator- ");
        numerator1=checkInt();

        System.out.println("Please enter the first denominator- ");
        denominator1 =checkInt();

        System.out.println("Please enter the second numerator- ");
        numerator2 =checkInt();
        System.out.println("Please enter the second denominator- ");
        denominator2 =checkInt();

        //create the rational number
        Rational num1 = new Rational(numerator1, denominator1);
        Rational num2 = new Rational(numerator2, denominator2);


        //check if the numbers are <,>,=
        if (num1.greaterThan(num2))
            System.out.println(num1.toString() + ">" + num2.toString());

        else if (num1.equals(num2))
            System.out.println(num1.toString() + "=" + num2.toString());

        else
            System.out.println(num1.toString() + "<" + num2.toString());

        //print the results of the functions
        System.out.println("divide: " + num1.toString() + "=" + num1.reduce().toString() + " " + num2.toString() + "=" + num2.reduce().toString());
        System.out.println("plus: " + num1.toString() + "+" + num2.toString() + "=" + num1.plus(num2).reduce().toString());
        System.out.println("minus: " + num1.toString() + "-" + num2.toString() + "=" + num1.minus(num2).reduce().toString());
        System.out.println("multiply: " + num1.toString() + "x" + num2.toString() + "=" + num1.multiply(num2).reduce().toString());
        System.out.println("divide: " + num1.toString() + "/" + num2.toString() + "=" + num1.divide(num2).reduce().toString());


    }

    //this function insists on receiving an int type from the user
    public static int checkInt() {
        Scanner scan = new Scanner(System.in);
        int num=NULL;
        while (!valid) {
             num=checkInt1();
        }
        valid=false;

        return num;
    }

    //check if it's int
    public static int checkInt1() {
        Scanner scan = new Scanner(System.in);
        int num=0;

        try {
            num = scan.nextInt();
            valid = true;
        } catch (InputMismatchException e) {
            System.out.println("Input error, try again");
            valid=false;
        }
        return num;
    }
}
