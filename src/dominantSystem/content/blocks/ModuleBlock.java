package dominantSystem.content.blocks;

import arc.struct.Seq;
import mindustry.world.Block;
import dominantSystem.expand.block.payloads.ModulePayload;

public class ModuleBlock {
    public static Block
            //for presses
            mechanicalGel, pneumaticGel,
            //for smelters
            thermoGel, volcanicGel,

            //For assembling units
            //armor
            lightArmor, reinforcedArmor, heavyArmor,
            //core
            nuclearFuelCell, plasmaFuelCell,
            //ammo
            defaultAmmo;

    public static Seq<ModulePayload> modules = new Seq<>();

    public static void load() {
        mechanicalGel = new ModulePayload("mechanical-gel"){{
        }};
        pneumaticGel = new ModulePayload("pneumatic-gel"){{
        }};

        thermoGel = new ModulePayload("thermo-gel"){{
            temperature = 1.5f;
        }};
        volcanicGel = new ModulePayload("volcanic-gel"){{
            temperature = 2f;
        }};

        //For assembling units
        //armor
        lightArmor = new ModulePayload("light-armor"){{
            size = 2;
            armorMult = 1.5f;
        }};
        reinforcedArmor = new ModulePayload("reinforced-armor"){{
            size = 2;
            armorMult = 3f;
        }};
        heavyArmor = new ModulePayload("heavy-armor"){{
            size = 2;
            armorMult = 8f;
        }};
        //core
        plasmaFuelCell = new ModulePayload("plasma-fuel-cell"){{
            size = 2;
            speedMult = 1.2f;
        }};
        nuclearFuelCell = new ModulePayload("nuclear-fuel-cell"){{
            size = 2;
            speedMult = 6;
        }};

        defaultAmmo = new ModulePayload("default-ammo"){{
            damage = 200f;
        }};
    }
}
