public class Rational {

    private int denominator;
    private int numerator;

    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }

    //constructor
    public Rational(double numerator,double denominator) {

        //check if it's illegal number
        if ((double)(int)(numerator) - numerator != 0.0|| (double)(int)(denominator) - denominator != 0.0||(denominator<=0))
            throw new IllegalArgumentException(Integer.toString((int)numerator));

        else {
            this.numerator = (int) (numerator);
            this.denominator = (int) (denominator);
        }
    }

    //check if num1>num2
    public boolean greaterThan(Rational num2){
        return ((this.numerator * num2.getDenominator())> (this.denominator*num2.getNumerator())) ;
    }

    //check if num1=num2
    public boolean equals(Rational num2){
        return ((this.numerator * num2.getDenominator())==(this.denominator*num2.getNumerator())) ;
    }

    //check num1+num2
    public Rational plus(Rational num2){
        Rational tempNum = new Rational(this.numerator*num2.getDenominator()+this.denominator*num2.getNumerator(),this.denominator*num2.getDenominator());

        return tempNum;
    }

    //check num1-num2
    public Rational minus(Rational num2){
        Rational temp=new Rational(num2.numerator*-1,num2.denominator);
        return (this.plus(temp));
    }
    //check num1*num2
    public Rational multiply(Rational num2){
        Rational tempNum;
        return (tempNum= new Rational(this.numerator*num2.getNumerator(),this.denominator* num2.getDenominator()));
    }

    //check num1/num2
    public Rational divide(Rational num2){
        if(num2.getNumerator()==0)
            throw new ArithmeticException(Integer.toString((int)numerator));

        Rational tempNum= new Rational(num2.getDenominator(),num2.getNumerator());
        return(this.multiply(tempNum));
    }

    //reduce rational num
    public Rational reduce(){
        int gcd=gcd(this.numerator,this.denominator);
        return(new Rational(this.numerator/Math.abs(gcd),this.denominator/Math.abs(gcd)));
    }

    //it's auxiliary function to reduce
    private int gcd(int x, int y){
        if(y==0)
            return x;
        return gcd(y,x%y);
    }

    public String toString(){
        return  this.numerator + "/" + this.denominator;
    }
}
