
public class Cat extends Mamal {

    private Owner owner;

    //constructor
    public Cat(String name, int age, Color color, Owner owner) {
        super(name, age, color);
        this.owner=owner;
    }

    public void eat(){
        System.out.println("Cats eat meat and mouses");
    }

    //return owner details
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String toString() {
        return ("mammalian animal: CAT ,name- " + super.getName() + ", age-" + super.getAge() + "\n"
                + "color- " + super.getColor()+owner);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        else if (obj == null)
            return false;
        else if (obj instanceof Cat) {
            Cat other = (Cat) obj;
            if (super.equals(other) && getOwner().equals(other.getOwner()))
                return true;
        }
        return false;
    }

    public Object clone() {
        return super.clone();
    }


}
