package dominantSystem.expand.units.unitType;

import dominantSystem.content.dsItems;
import mindustry.type.ItemStack;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.unit.ErekirUnitType;

public class dsUnitType extends ErekirUnitType {
    public dsUnitType(String name) {
        super(name);
        ammoType = new ItemAmmoType(dsItems.thirium);
    }

    @Override
    public void init() {
        super.init();
        float maxWeaponRange = 0;
        for (Weapon weapon : weapons) {
            if (weapon.range() > maxWeaponRange) {
                maxWeaponRange = weapon.range();
            }
        }
        fogRadius = maxWeaponRange / 8 + 1;
    }
}
