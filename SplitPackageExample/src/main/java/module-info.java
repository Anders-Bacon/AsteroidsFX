import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;

module SplitPackageExample {
    requires Common;
    exports dk.sdu.mmmi.cbse.playersystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;

}