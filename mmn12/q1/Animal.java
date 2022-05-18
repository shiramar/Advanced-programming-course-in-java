public abstract class Animal implements Cloneable {

    private String name;
    private int age;
    private Color color;

    //constructor
    public Animal(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void eat();

    public abstract void sleep();

    public String toString(){
        return(" animal , name -"+name+" age -"+age+", color- "+color);
    }

    //check equals
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        else if (obj == null)
            return false;

        else if (obj instanceof Animal) {
            Animal other = (Animal) obj;
            if (this.getName().equals(other.getName()) && this.getAge() == other.getAge() && this.getColor().equals(other.getColor()))
                return true;
        }
        return false;
    }

    //duplicate
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
