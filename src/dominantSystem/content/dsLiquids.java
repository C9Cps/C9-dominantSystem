package dominantSystem.content;

import arc.graphics.Color;
import dominantSystem.util.graphic.dsPal;
import mindustry.content.Liquids;
import mindustry.type.Liquid;

public class dsLiquids {

    public static Liquid runiy;

    public static Liquid water, slag, oil, cryofluid, arkycite, gallium, neoplasm, ozone, hydrogen, nitrogen, cyanogen;

    public static void load() {
        runiy = new Liquid("runiy", Color.valueOf("#FF9568")){{
                heatCapacity = 0.75f;
                lightColor = dsPal.runiy;
                barColor = gasColor = lightColor;
            }

            @Override
            public void init() {
                super.init();
                coolant = true;
            }
        };

        water = Liquids.water;
        slag = Liquids.slag;
        oil = Liquids.oil;
        cryofluid = Liquids.cryofluid;
        arkycite = Liquids.arkycite;
        gallium = Liquids.gallium;
        neoplasm = Liquids.neoplasm;
        ozone = Liquids.ozone;
        hydrogen = Liquids.hydrogen;
        nitrogen = Liquids.nitrogen;
        cyanogen = Liquids.cyanogen;
    }
}
