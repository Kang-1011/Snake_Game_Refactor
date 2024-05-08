package snakegame.model;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import snakegame.model.object.Snake;
import snakegame.model.object.Unit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class GameManagerTest {
    //test the instantiation of class with private constructor
    @Test
    public void testGameManager() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<GameManager> constructor = GameManager.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        GameManager gameManager = constructor.newInstance();

        assertNotNull(gameManager);

        constructor.setAccessible(false);
    }
}
