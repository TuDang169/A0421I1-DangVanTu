package b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.fruit;
import b07_abstractclass_interface.thuc_hanh.b01_animal_interfaceedible.edible.Edible;

public class Orange implements Edible {
    @Override
    public String howToEat(){
        return "Orange could be juiced";
    }
}
