package dominantSystem.content;

import arc.graphics.*;
import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.*;
import mindustry.world.meta.*;

public class dsPlanets{
    public static Planet
            thalassa;
    public static void load(){
        thalassa = new Planet("thalassa", Planets.sun, 1f, 2){{
            generator = new PlanetGenerator() {};
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("636363").a(0.75f), 2, 0.42f, 1f, 0.43f),
                new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("C6BCBA").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
            );
            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    //metal
                    Color.valueOf("585B68"),
                    Color.valueOf("3F4049"),
                    Color.valueOf("1E1F28"),

                    //runiy
                    Color.valueOf("DB9644"),
                    Color.valueOf("BA6B2C")
            );
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("636363");
            atmosphereColor = Color.valueOf("8A73C6");
            defaultEnv = Env.scorching | Env.terrestrial;
            startSector = 12;
            sectorSeed = 12;
            tidalLock = true;
            orbitSpacing = 4.2f;
            totalRadius += 4f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = Blocks.coreShard;
            iconColor = Color.valueOf("ff9266");
            enemyBuildSpeedMultiplier = 0.4f;
            allowLaunchToNumbered = false;
            updateLighting = false;

            defaultAttributes.set(Attribute.heat, 0.8f);

            ruleSetter = r -> {
                r.waveTeam = Team.malis;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.loadout = ItemStack.list(dsItems.titanium, 1000, dsItems.tungsten, 1000, dsItems.silicon, 1000, dsItems.thirium, 1000);
            };
            unlockedOnLand.add(Blocks.coreShard);
        }};
    }
}
