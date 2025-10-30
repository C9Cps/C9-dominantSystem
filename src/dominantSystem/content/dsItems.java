package dominantSystem.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.type.Item;

public class dsItems {

    //Modded Item
    public static Item
            thirium, etheronium, fiberglass, mycondium;

    //Vanilla Item, for namespace use
    public static Item
            scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
            phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
            beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst;


    public static void load() {
        thirium = new Item("thirium", Color.valueOf("A4B8FA")) {{
            cost = 1.25f;
        }};
        etheronium = new Item("etheronium", Color.valueOf("768A9A")) {{
            cost = 1.5f;
        }};
        fiberglass = new Item("fiberglass", Color.valueOf("C8DBA7")) {{
            cost = 1.75f;
        }};
        mycondium = new Item("mycondium", Color.valueOf("F7E97E")) {{
            cost = 2.25f;
        }};

        scrap = Items.scrap;
        copper = Items.copper;
        lead = Items.lead;
        graphite = Items.graphite;
        coal = Items.coal;
        titanium = Items.titanium;
        thorium = Items.thorium;
        silicon = Items.silicon;
        plastanium = Items.plastanium;
        phaseFabric = Items.phaseFabric;
        surgeAlloy = Items.surgeAlloy;
        sporePod = Items.sporePod;
        sand = Items.sand;
        blastCompound = Items.blastCompound;
        pyratite = Items.pyratite;
        metaglass = Items.metaglass;
        beryllium = Items.beryllium;
        tungsten = Items.tungsten;
        oxide = Items.oxide;
        carbide = Items.carbide;
        fissileMatter = Items.fissileMatter;
        dormantCyst = Items.dormantCyst;

        Items.serpuloItems.add(Items.tungsten, Items.carbide);
        Items.erekirItems.add(Items.titanium);
        Items.erekirOnlyItems.clear();
    }
}










