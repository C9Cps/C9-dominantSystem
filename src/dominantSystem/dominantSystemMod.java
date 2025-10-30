package dominantSystem;

import arc.Core;
import arc.util.*;
import dominantSystem.content.blocks.InnerBlock;
import dominantSystem.content.register.PowerRecipeRegister;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import dominantSystem.content.blocks.*;
import dominantSystem.content.*;
import dominantSystem.content.register.RecipeRegister;

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

    //Мод работает на android?
    public dominantSystemMod(){

    }
    @Override
    public void loadContent() {
        Time.mark();

        MOD = mods.getMod(getClass());
        MOD.meta.displayName = Core.bundle.get("mod.dominant-system.name");
        MOD.meta.version = Core.bundle.get("mod.dominant-system.version");
        MOD.meta.author = Core.bundle.get("mod.dominant-system.author");
        MOD.meta.description = Core.bundle.get("mod.dominant-system.description");
        MOD.meta.subtitle = Core.bundle.get("mod.dominant-system.subtitle");
        MOD.meta.repo = "C9Cps/C9-dominantSystem";
        dsSounds.load();
        dsBullets.load();
        dsStatusEffects.load();

        ModuleBlock.load();
        dsItems.load();
        dsLiquids.load();

        InnerBlock.load();

        CraftingBlock.load();
        PowerBlock.load();
        TurretBlock.load();
        PayloadBlock.load();

        //dsContent.overrideLoad();

        dsContent.defenseLoad();
        dsContent.productionLoad();
        dsContent.environmentsLoad();

        dsUnitTypes.load();
        UnitBlock.load();

        RecipeRegister.load();
        PowerRecipeRegister.load();
        dsPlanets.load();

        Log.info("DominantSystem Loaded Complete: " + MOD.meta.version + " | Cost Time: " + (Time.elapsed() / Time.toSeconds) + " sec.");
    }
}
