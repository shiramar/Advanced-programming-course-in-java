
public class Snake extends Reptiles {

    private String venomouse;

    //constructor
    public Snake(String name, int age, Color color, String venomouse) {
        super(name, age, color);
    }

    public void eat(){
        System.out.println("Snake eat mouse");
    }

    public void crawl(){
        System.out.println("snakes know how to crawl fast.\n");
    }

    public void setVenomouse(String venomouse){
        this.venomouse=venomouse;
    }

    //function that return if snake venomouse or not
    public String getVenomouse(){
        return venomouse;
    }

    public String toString() {
        return ("Reptiles animal: SNAKE ,name- " + super.getName() + ", age-" + super.getAge() + "\n"
                + "color- " + super.getColor()+" this type is "+venomouse+" venomouse");
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        else if (obj == null)
            return false;

        else if (obj instanceof Snake) {
            Snake other = (Snake) obj;
            if (super.equals(other) && this.getVenomouse() == other.getVenomouse()) {
                return true;
            }
        }
        return false;
    }

    public Object clone() {
        return super.clone();
    }


}
