
public class Duck extends Birds {

    //constructor
    public Duck(String name, int age, Color color) {
        super(name, age, color);
    }

    public void eat(){
        System.out.println("Ducks eat rice and mixed");
    }

    //return if this bird fly
    public void fly(){
        System.out.println("ducks know to fly.\n");
    }

    public String toString() {
        return ("Birds animal: DUCK ,name- " + super.getName() + ", age-" + super.getAge() + "\n"
                + "color- " + super.getColor());
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Object clone() {
        return super.clone();
    }
}
