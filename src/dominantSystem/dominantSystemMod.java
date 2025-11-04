package dominantSystem;

import arc.util.*;
import dominantSystem.content.blocks.InnerBlock;
import dominantSystem.content.register.PowerRecipe;
import dominantSystem.content.register.ProductionRecipe;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import dominantSystem.content.blocks.*;
import dominantSystem.content.*;
import dominantSystem.content.register.CraftingRecipe;

import static mindustry.Vars.*;


public class dominantSystemMod extends Mod {
    public static final boolean DEBUGGING_SPRITE = false;
    public static final String MOD_RELEASES = "";
    public static final String MOD_REPO = "";
    public static final String MOD_GITHUB_URL = "";
    public static final String MOD_NAME = "dominant-system";
    public static final String SERVER = "";
    public static boolean DEBUGGING = false;
    public static Mods.LoadedMod MOD;

    //Мод работает на android?!?
    public dominantSystemMod(){

    }
    @Override
    public void loadContent() {
        MOD = mods.getMod(getClass());

        dsSounds.load();
        dsBullets.load();
        dsStatusEffects.load();

        ModuleBlock.load();
        dsItems.load();
        dsLiquids.load();

        InnerBlock.load();

        CraftingBlock.load();
        ProductionBlock.load();
        PowerBlock.load();
        TurretBlock.load();
        PayloadBlock.load();

        //dsContent.overrideLoad();

        dsContent.defenseLoad();
        EnvironmentBlock.load();

        dsUnitTypes.load();
        UnitBlock.load();

        ProductionRecipe.load();
        CraftingRecipe.load();
        PowerRecipe.load();

        dsPlanets.load();

        Log.info("DominantSystem Loaded Complete: " + MOD.meta.version + " | Cost Time: " + (Time.elapsed() / Time.toSeconds) + " sec.");
    }
}
