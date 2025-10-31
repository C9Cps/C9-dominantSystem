package dominantSystem.content.blocks;

import dominantSystem.expand.block.power.RegenPowerNode;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.draw.*;
import dominantSystem.content.dsItems;
import dominantSystem.content.dsLiquids;
import dominantSystem.expand.block.power.LightningReactor;
import dominantSystem.expand.block.production.factory.RecipeCrafter;

import static mindustry.type.ItemStack.with;

public class PowerBlock {
    public static Block
            effulgentPowerNode, effulgentPowerNodeLarge, thermoisotopeGenerator, effulgentReactor;
    public static void load() {
        effulgentPowerNode = new RegenPowerNode("effulgent-power-node") {{
            requirements(Category.power, with(dsItems.thirium, 8, dsItems.fiberglass, 5, dsItems.etheronium, 5));
            size = 1;
            laserRange = 12f;
            maxNodes = 16;
        }};
        /*
        effulgentPowerNodeLarge = new RegenPowerNode("effulgent-power-node-large") {{
            requirements(Category.power, with(dsItems.thirium, 20, dsItems.fiberglass, 10, dsItems.etheronium, 15));
            size = 2;
            laserRange = 26;
            maxNodes = 24;
        }};
         */
        thermoisotopeGenerator = new RecipeCrafter("thermoisotope-generator") {{
            requirements(Category.power, with(dsItems.thirium, 125, dsItems.fiberglass, 90, dsItems.etheronium, 70));
            squareSprite = false;

            size = 3;
            addLink(-2, 1, 1, -2, 2, 1, -1, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, -2, -1, 1, -2, -2, 1, -1, -2, 1, 2, -1, 1, 2, -2, 1, 1, -2, 1);

            powerProduction = 2700f/60;
            outputsPower = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawArcSmelt(){{x = 48f/4; y = 48f/4;}},
                    new DrawArcSmelt(){{x = -48f/4; y = 48f/4;}},
                    new DrawArcSmelt(){{x = 48f/4; y = -48f/4;}},
                    new DrawArcSmelt(){{x = -48f/4; y = -48f/4;}},
                    new DrawCrucibleFlame(){{flameRad = 1.25f; particleRad = 10;}},
                    new DrawDefault());
            rotate = rotateDraw = false;
        }};
        effulgentReactor = new LightningReactor("effulgent-reactor") {{
            requirements(Category.power, with(dsItems.thirium, 250, dsItems.fiberglass, 100, dsItems.etheronium, 190, dsItems.mycondium, 90, dsItems.phaseFabric, 80));
            squareSprite = false;

            size = 5;
            health = 4500;
            powerProduction = 49000f/60;
            itemDuration = 60/0.8f;
            ambientSound = Sounds.pulse;
            ambientSoundVolume = 0.1f;
            liquidCapacity = 80f;
            explodeEffect = Fx.explosion;

            intervalLighting = 20;
            lightingDamage = 80;
            lightingColor = dsLiquids.cyanogen.color;

            consumePower(7500/60f);
            consumeItems(with(dsItems.etheronium, 2, dsItems.surgeAlloy, 1));
            consumeLiquid(dsLiquids.cyanogen, 10f/60);
        }};
    }};