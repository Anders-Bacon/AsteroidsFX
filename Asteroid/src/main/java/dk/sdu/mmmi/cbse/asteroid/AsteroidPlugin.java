package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AsteroidPlugin implements IGamePluginService {

    Random random = new Random();

    private Entity asteroid;
    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                asteroid = createAsteroid(gameData);
                world.addEntity(asteroid);
            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(timerTask, 5000, 1000);

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
        int size = random.nextInt(20) + random.nextInt(20);
        asteroid.setPolygonCoordinates(size, size, size, -size, -size, -size, -size, size);
        //Automatically set to 0,0 and can rotate a random(360) degrees
        asteroid.setX(random.nextInt());
        asteroid.setY(random.nextInt());
        asteroid.setRotation(random.nextInt(360));
        asteroid.setRadius(size - 20);
        return asteroid;
    }
    
}

