package dominantSystem.expand.block.power;

import arc.util.Time;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;


public class RegenPowerNode extends PowerNode {
    /** Health recovery percentage per second */
    public float healing = -0.01f;
    public RegenPowerNode(String name) {
        super(name);
        update = true;
        health = 160;
        if(healing < 0) {healing *= -1;}
    }
    @Override
    public void setStats(){
        super.setStats();
        if(healing != 0 ){
            stats.add(Stat.healing, health * healing, StatUnit.seconds);
            stats.add(Stat.damage, health * (healing * 2), StatUnit.seconds);}
    }


    public class RegenPowerNodeBuild extends PowerNodeBuild {
        float timer = 0;
        @Override
        public void updateTile() {
            timer += Time.delta;
            if (timer >= 60) {
                timer = 0;
                if(power.graph.getPowerBalance() > 0) {
                    if (this.health < this.maxHealth - healing) {
                        this.health += this.maxHealth * healing;
                    } else {
                        this.health = this.maxHealth;
                    }
                }
                else {this.health -= this.maxHealth * healing;}
            }
            if(this.health <=0){kill();}
        }

    }
}
