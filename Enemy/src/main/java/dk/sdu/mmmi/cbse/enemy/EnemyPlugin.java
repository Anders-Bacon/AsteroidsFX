package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {
    private Entity enemy;
    public EnemyPlugin() {

    }
    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {

        Entity enemyShip = new Enemy();
        //Enemy:
        enemyShip.setPolygonCoordinates(-4,4,-3, 4, -3, 3, -2, 3, -2, 2, 1, 2, 1, 3, 2, 3, 2, 4, 3, 4, 3, 3, 2, 3, 2, 2, 3, 2, 3, 1, 4, 1, 4, 0, 5, 0, 5, -3, 4, -3, 4, -1, 3, -1, 3, -3, 2, -3, 2, -4, 0, -4, 0, -3, 2, -3, 2, -2, -3, -2, -3, -3, -1, -3, -1, -4, -3, -4, -3, -3, -4, -3, -4, -1, -5, -1, -5, -3, -6, -3, -6, 0, -5, 0, -5, 1, -4, 1, -4, 2, -3, 2, -3, 3, -4, 3, -4, 4);

        //Spaceship:

        //playerShip.setPolygonCoordinates(12, -1, 8, -1, 8, -3, 6, -3, 6, -5, -2, -5, -2, -7, 0, -7, 0, -9, -10, -9, -10, -5, -8, -5, -8, -3, -6, -3, -6, -1, -10, -1, -10, 1, -6, 1, -6, 3, -8, 3, -8, 5, -10, 5, -10, 9, 0, 9, 0, 7, -2, 7, -2, 5, 2, 5, 2, 1, 4, 1, 4, -1, 2, -1, 2, -3, 4, -3, 4, -1, 6, -1, 6, 1, 4, 1, 4, 3, 2, 3, 2, 5, 6, 5, 6, 3, 8, 3, 8, 1, 12, 1);
        enemyShip.setX(gameData.getDisplayHeight()/4);
        enemyShip.setY(gameData.getDisplayWidth()/4);
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }
}
