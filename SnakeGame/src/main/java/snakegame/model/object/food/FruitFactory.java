package snakegame.model.object.food;

/**
 * Factory class defining a method to return the fruit instance
 */
public class FruitFactory {
    /**
     * Returns the fruit instance of type
     * @param type string representation of the fruit class
     * @return the fruit instance of type
     */
    public Fruit createFruit(String type){
        switch(type){
            case "lime":
                return new Lime();
            case "banana":
                return new Banana();
            case "apple":
                return new Apple();
        }
        return null;
    }
}


