package dominantSystem.expand.game;

import mindustry.io.SaveVersion;

public class dsWorldData {
    public static short CURRENT_VER = 1;

    public WorldData worldData = new WorldData();
    public TeamPayloadData teamPayloadData = new TeamPayloadData();

    public dsWorldData() {
        SaveVersion.addCustomChunk("ds-world-data", worldData);
        SaveVersion.addCustomChunk("ds-team-payload-data", teamPayloadData);
    }
}
