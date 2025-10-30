package dominantSystem;

import arc.struct.ObjectMap;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import mindustry.game.Team;
import mindustry.gen.Building;
import dominantSystem.expand.block.commandable.CommandableBlock;
import dominantSystem.expand.block.special.RemoteCoreStorage;

public class dsGroups {
    public static final ObjectMap<Building, Building> bridgeLinks = new ObjectMap<>();
    public static final ObjectMap<Building, Seq<Building>> beaconBoostLinks = new ObjectMap<>();
    public static final ObjectSet<RemoteCoreStorage.RemoteCoreStorageBuild>[] placedRemoteCore = new ObjectSet[Team.all.length];
    public static final Seq<CommandableBlock.CommandableBlockBuild> commandableBuilds = new Seq<>();

    static {
        for (int i = 0; i < Team.all.length; i++) {
            dsGroups.placedRemoteCore[i] = new ObjectSet<>();
        }
    }
    public static void clear() {
        beaconBoostLinks.clear();
        bridgeLinks.clear();
        commandableBuilds.clear();
        RemoteCoreStorage.clear();
    }

    public static void worldReset() {}

    public static void update() {}

    public static void draw() {}
}
