package dominantSystem.expand.block.payloads;

import dominantSystem.content.dsStats;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Stat;
import dominantSystem.content.blocks.ModuleBlock;
import mindustry.world.meta.StatUnit;

public class ModulePayload extends Block {
    public ModulePayload(String name) {
        super(name);
        solid = true;
        destructible = true;
        rebuildable = false;

        placeablePlayer = false;
        size = 1;

        buildVisibility = BuildVisibility.shown;
    }
    public float healthMult;
    public float armorMult;
    public float speedMult;
    public float temperature;
    public float damage;

    @Override
    public void init() {
        super.init();
        ModuleBlock.modules.add(this);
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.remove(Stat.health);
        stats.remove(Stat.size);

        if (temperature > 0) {stats.addPercent(Stat.temperature, temperature);}
        if (damage > 0) {stats.add(Stat.damage, damage);}
        if (healthMult > 0) {stats.add(Stat.healthMultiplier, healthMult, StatUnit.multiplier);}
        if (speedMult > 0) {stats.add(Stat.speedMultiplier, speedMult, StatUnit.multiplier);}
        if (armorMult > 0) {stats.add(dsStats.armorMultiplier, armorMult, StatUnit.multiplier);}
    }
    @Override
    public boolean canBeBuilt() {
        return false;
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        return false;
    }
}
