package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {



    double speed = 1;
    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {

            if (enemy.getX() >= gameData.getDisplayWidth() ){
                enemy.setY(enemy.getY() + 10);
                enemy.setX(10);
            }

            enemy.setX(enemy.getX() + speed);
            System.out.println(enemy.getX());

        }




    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

}
