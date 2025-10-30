package dominantSystem;

import mindustry.Vars;
import mindustry.gen.Unit;
import dominantSystem.util.annotation.HeadlessDisabled;

@HeadlessDisabled
public class dsInputListener {
    public Unit currentUnit;

    public dsInputListener() {
    }

    public static void registerModBinding() {
    }

    public void update() {
        if (Vars.player != null) updatePlayerStatus();
    }

    protected void updatePlayerStatus() {
        currentUnit = Vars.player.unit();
    }
}
