import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Animal> listOfAnimals = animalPension() ;//create a list of animal
        printAnimals(listOfAnimals);

    }

    //this function print the animal with their features
    private static void printAnimals(List<Animal> animalsList) {

        for (Animal animal: animalsList) {
            System.out.println(animal);
            animal.eat();
            animal.sleep();

            if(animal instanceof Reptiles) {//if it's a reptile ,add crawl feature
                Reptiles reptiles = (Reptiles) animal;
                reptiles.crawl();
            }

            if(animal instanceof Birds) {////if it's a birds ,add fly feature
                Birds birds = (Birds) animal;
                birds.fly();
            }
        }
    }

    //this function add animals with their details
    private static List<Animal> animalPension() {

        List<Animal> listOfAnimals = new ArrayList<>();

        Animal cat = new Cat("Mizi" , 2, Color.WHITE, new Owner("Shir", "0555555555"));
        Animal dog = new Dog("Emy",5,Color.BROWN, new Owner("Lidor", "0566666666"));
        Animal snake = new Snake("Kaa",3,Color.GREEN,"not");
        Animal duck = new Duck("Avigail",4,Color.ORANGE);

        //check clone
        Cat siamCat = (Cat) cat.clone();
        siamCat.setName(new String("Bell"));
        siamCat.setColor(Color.GOLD);
        siamCat.setAge(9);
        siamCat.setOwner(new Owner("Talia", "03-5626999"));

        Dog huskyDog=(Dog) dog.clone();
        huskyDog.setName(new String("Snorka"));
        huskyDog.setColor(Color.GREY);
        huskyDog.setAge(4);
        huskyDog.setOwner(new Owner("Tomy", "03-5620000"));

        //check equals
        Cat cat1 = (Cat) cat.clone();

        if(cat1.equals(cat))
            System.out.println("this cats are equals\n");

        if(huskyDog.equals(dog))
            System.out.println("this dogs are equals\n");


        listOfAnimals.add(cat);
        listOfAnimals.add(dog);
        listOfAnimals.add(snake);
        listOfAnimals.add(duck);
        listOfAnimals.add(siamCat);
        listOfAnimals.add(huskyDog);
        listOfAnimals.add(cat1);


        return listOfAnimals;

    }
}
