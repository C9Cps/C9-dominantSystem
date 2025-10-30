package dominantSystem.content;

import mindustry.type.StatusEffect;

public class dsStatusEffects {
    public static StatusEffect
            toxicI, toxicII, toxicIII;

    public static void load() {
        toxicI = new StatusEffect("toxicI"){{
            damageMultiplier = 0.9f;
            damage = 5/60f;
            effect = dsFx.toxicBurning;
            speedMultiplier = 0.75f;
            effectChance = 0.1f;
        }};
        toxicII = new StatusEffect("toxicII"){{
            damageMultiplier = 0.75f;
            damage = 20/60f;
            effect = dsFx.toxicBurning;
            speedMultiplier = 0.75f;
            effectChance = 0.1f;
        }};
        toxicIII = new StatusEffect("toxicIII"){{
            damageMultiplier = 0.75f;
            damage = 50/60f;
            effect = dsFx.toxicBurning;
            speedMultiplier = 0.75f;
            effectChance = 0.1f;
        }};
    }
}
