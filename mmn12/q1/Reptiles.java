public abstract class Reptiles extends Animal{

    //constructor
    public Reptiles(String name, int age, Color color) {
        super(name, age, color);
    }

    public abstract void eat();

    public void sleep(){
        System.out.println("Good night, the reptiles animal is going to sleep.");
    }

    public void crawl(){
        System.out.println("reptiles animal know to crawl.\n");
    }

    public String toString(){
        return("reptiles animal: name -"+super.getName()+", age -"+super.getAge()+" color- "+super.getColor());
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Object clone() {
        return super.clone();
    }

}
