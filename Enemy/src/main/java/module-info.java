import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.enemy.EnemyPlugin;

module Enemy {
    requires Common;
    requires CommonBullet;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with dk.sdu.mmmi.cbse.enemy.EnemyPlugin;
}