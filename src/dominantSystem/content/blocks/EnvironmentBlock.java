package dominantSystem.content.blocks;

import dominantSystem.expand.block.env.*;

public class EnvironmentBlock {
    public static Floor4x12 metalFloorGroove, metalFloorGrooveDeep, metalFloorRidge, metalFloorRidgeHigh;
    public static Atlas_4_4_Floor armorAncient, armorAncientSub, armorQuantum;

    public static Atlas_4_12_Wall armorWall;
    public static TiledFloor metalFloorPlain, labFloorLight, labFloorDark;
    public static DataFloor lineMarkingFloor, lineMarkingFloorQuantum, lineMarkingFloorQuantumDark, lineMarkingFloorAncient, lineMarkingFloorAncientDark;

    public static void load() {

        metalFloorGroove = new Floor4x12("metal-floor-groove", true);

        armorWall = new Atlas_4_12_Wall("armor-wall");

        metalFloorGroove.baseFloor = metalFloorPlain;
        metalFloorGrooveDeep.baseFloor = metalFloorPlain;
        metalFloorRidge.baseFloor = metalFloorPlain;
        metalFloorRidgeHigh.baseFloor = metalFloorPlain;

        armorAncient.blendFloors.add(armorAncientSub);
        armorAncientSub.blendFloors.add(armorAncient);
    }
}
