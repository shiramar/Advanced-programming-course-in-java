public abstract class Birds extends Animal{

    //constructor
    public Birds(String name, int age, Color color) {
        super(name, age, color);
    }

    public abstract void eat();

    public void sleep(){
        System.out.println("Good night, the birds animal is going to sleep.");
    }

    public abstract void fly();//only some of the birds fly

    public String toString(){
        return("birds animal: name -"+super.getName()+", age -"+super.getAge()+" color- "+super.getColor());
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Object clone() {
        return super.clone();
    }


}
