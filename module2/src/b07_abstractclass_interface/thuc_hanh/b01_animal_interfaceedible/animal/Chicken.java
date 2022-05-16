package b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.animal;

import b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound(){
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}

