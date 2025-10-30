package dominantSystem.expand.block.power;

import arc.Events;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Nullable;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.consumers.ConsumeItemFilter;
import mindustry.world.consumers.ConsumeLiquidFilter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPlasma;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;


public class LightningReactor extends ImpactReactor {
    public float intervalLighting = 60;
    public float lightingDamage = 20;
    public Color lightingColor = Color.white;
    public Effect damageEffect = Fx.hitLaserBlast;
    public Sound damageSound = Sounds.spark;
    public float damageSoundVolume = 0.6f, damageSoundPitchRand = 0.1f;
    public float baseLightRadius = 65f;

    public @Nullable ConsumeItemFilter filterItem;
    public @Nullable ConsumeLiquidFilter filterLiquid;
    public @Nullable LiquidStack outputLiquid;

    public LightningReactor(String name) {
        super(name);
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPlasma(){{plasma1 = Color.valueOf("8DEEBB"); plasma2 = Color.valueOf("5EC1BF");}}, new DrawDefault());
    }

    @Override
    public void init(){
        filterItem = findConsumer(c -> c instanceof ConsumeItemFilter);
        filterLiquid = findConsumer(c -> c instanceof ConsumeLiquidFilter);

        if(outputLiquid != null){
            outputsLiquid = true;
            hasLiquids = true;
        }

        emitLight = true;
        lightRadius = baseLightRadius * size;
        super.init();
    }

    @Override
    public void setStats(){
        stats.timePeriod = itemDuration;
        super.setStats();
        stats.remove(Stat.productionTime);

        if(hasItems){
            stats.add(Stat.productionTime, itemDuration / 60f, StatUnit.seconds);
        }
        stats.add(Stat.lightningDamage, lightingDamage);
    }


    public class LightningReactorBuild extends ImpactReactorBuild {
        float timer = 0;
        float interval = intervalLighting;

        @Override
        public void updateTile() {
            if (efficiency >= 0.9999f && power.status >= 0.99f) {
                boolean prevOut = getPowerProduction() <= consPower.requestedPower(this);

                warmup = Mathf.lerpDelta(warmup, 1f, warmupSpeed * timeScale);
                if (Mathf.equal(warmup, 1f, 0.001f)) {
                    warmup = 1f;
                }

                if (!prevOut && (getPowerProduction() > consPower.requestedPower(this))) {
                    Events.fire(EventType.Trigger.impactPower);
                }

                if (timer(timerUse, itemDuration / timeScale)) {
                    consume();
                }
            } else {
                warmup = Mathf.lerpDelta(warmup, 0f, 0.01f);
            }

            totalProgress += warmup * Time.delta;

            productionEfficiency = Mathf.pow(warmup, 5f);
            int randDegress = Mathf.random(1,360);
            if (efficiency > 0.1) {
                timer += Time.delta * productionEfficiency;
                if (timer >= intervalLighting) {
                    if (health >= (maxHealth / 3) * 2) {
                        this.health -= lightingDamage * 2;
                        if (wasVisible) {
                            damageEffect.at(x, y, rotation = randDegress);
                            damageEffect.at(x, y, rotation = randDegress-Mathf.random(20,60));
                            damageSound.at(x, y, 1f + Mathf.range(damageSoundPitchRand), damageSoundVolume);

                        }
                    } else {
                        Lightning.create(Team.derelict, lightingColor, lightingDamage, this.x, this.y, 45, 10);
                        Lightning.create(Team.derelict, lightingColor, lightingDamage, this.x, this.y, -45, 10);
                        Lightning.create(Team.derelict, lightingColor, lightingDamage, this.x, this.y, 45 * 3, 10);
                        Lightning.create(Team.derelict, lightingColor, lightingDamage, this.x, this.y, 0, 10);
                        this.health += lightingDamage * 4;
                        if (wasVisible) {
                            damageEffect.at(x, y);
                            damageSound.at(x, y, 1f + Mathf.range(damageSoundPitchRand), damageSoundVolume);
                        }
                    }

                    if (timer > interval) {
                        timer = 0;
                    }
                }
            }
        }

    }
}
