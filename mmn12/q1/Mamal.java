
public abstract class Mamal extends Animal{

    //constructor
    public Mamal(String name, int age, Color color) {
        super(name, age, color);
    }

    public abstract void eat();

    public void sleep(){
        System.out.println("Good night, the mammalian animal is going to sleep.\n");
    }

    public String toString(){
        return("mammalian animal: name -"+super.getName()+", age -"+super.getAge()+" color- "+super.getColor());
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Object clone() {
        return super.clone();
    }

}
