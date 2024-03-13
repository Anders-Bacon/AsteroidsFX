package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;
    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }


    @Override
    public void stop(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)){
            world.removeEntity(asteroid);
        }
    }

    public Entity createAsteroid(GameData gameData){
        asteroid = new Asteroid();

        //Random squared Asteroids
        Random random = new Random();
        //random sized squares
        int size = random.nextInt(5)+ random.nextInt(5);
        asteroid.setPolygonCoordinates(size, -size, -size, size, size);
        //Automatically set to 0,0 and can rotate a random(360) degrees
        asteroid.setX(0);
        asteroid.setY(0);
        asteroid.setRotation(random.nextInt(360));
        return asteroid;
    }
    
}

