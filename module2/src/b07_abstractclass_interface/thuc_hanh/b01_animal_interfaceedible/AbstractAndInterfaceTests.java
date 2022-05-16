package b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible;
import b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.animal.Animal;
import b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.animal.Chicken;
import b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.animal.Tiger;
import b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.edible.Edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

    }
}
