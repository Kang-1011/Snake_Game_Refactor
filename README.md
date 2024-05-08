# README

---
## Snake Game
A Snake Game in Java. Using JavaFX and FXML to display the game.

## Changes and Additional Features
The game now allows users pick from **8 background colors and 3 fruits**. There are new game modes like **obstacles**, **teleporters**, and **speed boosts** that trigger when the snake eats fruit. The game includes a **pause and resume** function, providing users the ability to pause and resume gameplay. 

## Maintenance Made
The game now uses the **Model View Controller (MVC)** design pattern, enhancing maintenance by reducing interdependence. The transition from Java Swing to JavaFX improved maintainability. JavaFX's FXML separates UI layout from application logic, and Scene Builder provides a visual layout tool for JavaFX, streamlining software development.

## Factory Method Design Pattern
The Factory method abstracts object creation, enabling flexible fruit selection without specifying their exact classes. In our game, the **Fruit Factory class** handles object creation, maintaining a single responsibility for this task.

## Singleton Method Design Pattern
The Singleton Method allows direct access to the object without instantiating it repeatedly, providing a widely used instance across the project. It is applied to the **Game Manager class** to ensure a single instance creation.

## Facade Method Design Pattern
The Façade method simplifies complex system functionalities, hiding the system’s intricacies and providing an interface to the client. In our game, it's used to display the **score and game over text**, provides a straightforward method to interact with these features.

## Mediator Pattern Design Pattern
The Mediator Pattern uses a mediator class to simplify communication between classes. In our game, when user picks a fruit, the **Game Manager** coordinates with the **Fruit Factory** to display that chosen fruit in the **Snake Game Controller**. This approach simplifies the system by allowing classes to interact primarily with the Mediator, enhancing understanding and maintainability.

## Strategy Method Design Pattern
The Strategy method enables a class's behavior to change dynamically during runtime by allowing an object to select from various algorithms and behaviors. In our game, this method allows users to choose **different game levels**. This approach enhances code flexibility and simplifies modifications, making it easier to adjust the game's behavior.

## Design Principles
The program follows the **“Program to an interface, not an implementation”** principle by using interfaces to define system behavior. It also aligns with the **Interface Segregation Principle** by allowing users to select game modes, background, and fruits without forcing dependencies on interfaces they do not use. Moreover, the system also adheres to the **Single Responsibility Principle** where each class in the program performs only one specific task. The program also follows **“Favor composition over inheritance”** principle by building relationships between classes rather than relying heavily on inheritance.

## Test Case
```
public class GameManagerTest {
    @Test
    public void testGameManager() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<GameManager> constructor = GameManager.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        GameManager gameManager = constructor.newInstance();

        assertNotNull(gameManager);

        constructor.setAccessible(false);
    }
}
```






