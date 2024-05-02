package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)){
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX * 0.2);
            asteroid.setY(asteroid.getY() + changeY * 0.2);

            if (asteroid.getX() < 0) {
                asteroid.setX(asteroid.getX() - gameData.getDisplayWidth());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(asteroid.getX() % gameData.getDisplayWidth());
            }

            if (asteroid.getY() < 0) {
                asteroid.setY(asteroid.getY() - gameData.getDisplayHeight());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(asteroid.getY() % gameData.getDisplayHeight());
            }
            if (asteroid.isDestroyed()){
                world.removeEntity(asteroid);
                if (asteroid.getRadius() > 6){
                    splitAsteroid(asteroid, world);
                }
                world.removeEntity(asteroid);
            }
        }


    }

    private void splitAsteroid(Entity asteroid, World w) {
        Entity asteroid1 = new Asteroid();
        Entity asteroid2 = new Asteroid();
        asteroid1.setPolygonCoordinates(5, 5, 5, -5, -5, -5, -5, 5);
        asteroid2.setPolygonCoordinates(5, 5, 5, -5, -5, -5, -5, 5);
        int spawnAngle = 45;
        double entity1X = asteroid.getX() + Math.cos(Math.toRadians(asteroid.getRotation()+ spawnAngle));
        double entity1Y = asteroid.getY() + Math.cos(Math.toRadians(asteroid.getRotation()+ spawnAngle));
        double entity2X = asteroid.getX() + Math.cos(Math.toRadians(asteroid.getRotation()- spawnAngle));
        double entity2Y = asteroid.getY() + Math.cos(Math.toRadians(asteroid.getRotation()- spawnAngle));
        asteroid1.setRotation(asteroid.getRotation()+ spawnAngle);
        asteroid2.setRotation(asteroid.getRotation()- spawnAngle);
        asteroid1.setX(entity1X +asteroid.getX());
        asteroid1.setY(entity1Y +asteroid.getY());
        asteroid2.setX(entity2X +asteroid.getX());
        asteroid2.setY(entity2Y +asteroid.getY());
        asteroid1.setRadius(5);
        asteroid2.setRadius(5);
        w.addEntity(asteroid1);
        w.addEntity(asteroid2);

    }


}
