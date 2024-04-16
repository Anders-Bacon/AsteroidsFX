import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.playersystem.Player;

module SplitPackageExample {
    requires Common;
    provides IGamePluginService with Player;

}