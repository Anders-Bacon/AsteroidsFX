package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.stream.Collectors.toList;

public class EnemyPlugin implements IGamePluginService {
    private Entity enemy;
    public EnemyPlugin() {

    }
    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
        enemy.setX(10);
        enemy.setY(10);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (Entity enemy : world.getEntities(Enemy.class)) {
                    for (BulletSPI bulletSPI : getBulletSPIs()) {
                        Entity bullet = bulletSPI.createBullet(enemy, gameData);
                        world.addEntity(bullet);
                    }
                }
            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    private Entity createEnemyShip(GameData gameData) {

        Entity enemyShip = new Enemy();
        //Enemy:
        enemyShip.setPolygonCoordinates(-8,8,-6, 8, -6, 6, -4, 6, -4, 4, 2, 4, 2, 6, 4, 6, 4, 8, 6, 8, 6, 6, 4, 6, 4, 4, 6, 4, 6, 2, 8, 2, 8, 0, 10, 0, 10, -6, 8, -6, 8, -2, 6, -2, 6, -6, 4, -6, 4, -8, 0, -8, 0, -6, 4, -6, 4, -4, -6, -4, -6, -6, -2, -6, -2, -8, -6, -8, -6, -6, -8, -6, -8, -2, -10, -2, -10, -6, -12, -6, -12, 0, -10, 0, -10, 2, -8, 2, -8, 4, -6, 4, -6, 6, -8, 6, -8, 8);

        //Spaceship:
        //playerShip.setPolygonCoordinates(12, -1, 8, -1, 8, -3, 6, -3, 6, -5, -2, -5, -2, -7, 0, -7, 0, -9, -10, -9, -10, -5, -8, -5, -8, -3, -6, -3, -6, -1, -10, -1, -10, 1, -6, 1, -6, 3, -8, 3, -8, 5, -10, 5, -10, 9, 0, 9, 0, 7, -2, 7, -2, 5, 2, 5, 2, 1, 4, 1, 4, -1, 2, -1, 2, -3, 4, -3, 4, -1, 6, -1, 6, 1, 4, 1, 4, 3, 2, 3, 2, 5, 6, 5, 6, 3, 8, 3, 8, 1, 12, 1);
        enemyShip.setX(10);
        enemyShip.setY(10);
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
