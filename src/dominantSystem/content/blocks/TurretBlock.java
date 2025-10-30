package dominantSystem.content.blocks;

import arc.graphics.Color;
import dominantSystem.content.bullets.AccelBulletType;
import dominantSystem.content.dsSounds;
import dominantSystem.util.func.dsInterp;
import dominantSystem.util.graphic.dsPal;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;
import dominantSystem.content.dsItems;

import static mindustry.type.ItemStack.with;

public class TurretBlock {
    public static Block
            needle, effulgence, combo, vector, payloadTurret;
    public static void load() {

        needle = new PowerTurret("needle"){{
            requirements(Category.turret, with(dsItems.lead, 30, dsItems.copper, 20, dsItems.silicon, 15));

            size = 1;
            squareSprite = true;
            scaledHealth = 250;
            range = 130f;
            reload = 45f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 1f;
            shake = 1f;
            shootEffect = Fx.sparkShoot;
            shootSound = dsSounds.needleShoot;
            shootY = 2;
            shoot = new ShootAlternate(3);
            shoot.shots = 3;
            shoot.shotDelay = 8;

            shootType = new AccelBulletType(6, 12){{
                collidesGround = true;
                collidesAir = true;
                ammoMultiplier = 1f;

                width = 6;
                height = 9;

                trailLength = 12;
                trailWidth = 1.5f;
                frontColor = backColor = trailColor = Pal.techBlue;

                homingDelay = 6;
                homingPower = 0.225f;

                buildingDamageMultiplier = 0.5f;

                velocityBegin = 0.25f;
                velocityIncrease = 6f;
                accelInterp = dsInterp.inOut;
                accelerateBegin = 0f;
                accelerateEnd = 0.775f;
                drag = -0.01f;
            }};

            ammoUseEffect = Fx.none;
            consumePower(110f/60);
            coolant = consumeCoolant(0.3f);
            recoils = 2;
            drawer = new DrawTurret(){{
                    parts.add(new RegionPart("-barrel-l"){{
                        progress = PartProgress.recoil;
                        recoilIndex = 0;
                        moveY = -2f;
                    }},
                            new RegionPart("-barrel-r"){{
                                progress = PartProgress.recoil;
                                recoilIndex = 1;
                                moveY = -2f;
                }});
            }};
        }};

        effulgence = new ItemTurret("effulgence"){{
            requirements(Category.turret, with(dsItems.graphite, 90, dsItems.thirium, 80, dsItems.silicon, 70, dsItems.plastanium, 45));

            size = 3;
            squareSprite = true;
            scaledHealth = 250;
            range = 200f;
            reload = 10f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 1f;
            shake = 1f;
            shootEffect = Fx.shootBig;
            shootSound = Sounds.shootBig;
            shoot = new ShootAlternate(10f);
            recoils = 2;

            ammoUseEffect = Fx.casing3;
            ammo(
                    dsItems.beryllium, new BasicBulletType(3f, 32){{
                        width = 7f;
                        height = 9f;
                        lifetime = 70f;

                        ammoMultiplier = 4;
                        buildingDamageMultiplier = 0.3f;
                        reloadMultiplier = 1.0f;
                        rangeChange = 0f;
                        pierceCap = 2;
                        pierceBuilding = true;
                        pierceArmor = true;

                        trailLength = 4;
                        trailWidth = 2f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = Pal.berylShot;
                        frontColor = Pal.berylShot;
                    }},
                    dsItems.thirium, new BasicBulletType(4f, 40){{
                        width = 8f;
                        height = 10f;
                        lifetime = 52f;

                        ammoMultiplier = 4;
                        buildingDamageMultiplier = 0.8f;
                        reloadMultiplier = 1.2f;
                        rangeChange = 1.5f*8;
                        pierceCap = 2;
                        pierceBuilding = true;
                        pierceArmor = true;

                        trailLength = 6;
                        trailWidth = 1.5f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = Pal.tungstenShot;
                        frontColor = Pal.tungstenShot;
                    }},
                    dsItems.etheronium, new BasicBulletType(3.5f, 48){{
                        width = 8f;
                        height = 10f;
                        lifetime = 60f;

                        ammoMultiplier = 6;
                        buildingDamageMultiplier = 1f;
                        reloadMultiplier = 1.0f;
                        rangeChange = 4.5f*8;
                        pierceCap = 2;
                        pierceBuilding = true;
                        pierceArmor = true;

                        trailLength = 6;
                        trailWidth = 1.5f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = dsPal.thiriumAmmoBack;
                        frontColor = dsPal.thiriumAmmoFront;
                    }}
            );
            limitRange();
            coolant = consumeCoolant(0.3f);
            drawer = new DrawTurret(){{
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        moveY = -2f;
                    }});
                }
            }};
        }};

        combo = new ItemTurret("combo"){{
            requirements(Category.turret, with(dsItems.thirium, 110, dsItems.etheronium, 90, dsItems.tungsten, 90, dsItems.thorium, 70));

            size = 3;
            rotateSpeed = 4;
            scaledHealth = 250;
            range = 210f;
            reload = 60/6.6f;
            outlineColor = Pal.darkOutline;
            consumeAmmoOnce = true;
            ammoEjectBack = 3f;
            recoil = 0.5f;
            shake = 1;
            shootY = 10;
            shootEffect = Fx.shootSmall;
            shootSound = Sounds.shootAlt;
            shoot = new ShootAlternate(){{spread = 12f/4; barrels = 3;}};

            ammoUseEffect = Fx.casing1;
            ammo(
                    dsItems.thirium, new BasicBulletType(5f, 78f){{
                        width = 7f;
                        height = 10f;
                        lifetime = 43f;

                        ammoMultiplier = 1;
                        buildingDamageMultiplier = 0.5f;
                        reloadMultiplier = 1.0f;
                        rangeChange = 0f*8;
                        pierceCap = 1;
                        pierceBuilding = true;
                        pierceArmor = false;

                        homingPower = 0.25f;
                        homingDelay = 6f;

                        trailLength = 6;
                        trailWidth = 1.8f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = dsPal.thiriumAmmoBack;
                        frontColor = dsPal.thiriumAmmoFront;
                    }},
                    dsItems.tungsten, new BasicBulletType(3.75f, 150f){{
                        width = 9f;
                        height = 10f;
                        lifetime = 62f;

                        ammoMultiplier = 2;
                        buildingDamageMultiplier = 1.0f;
                        reloadMultiplier = 0.75f;
                        rangeChange = 4f*8;
                        pierceCap = 3;
                        pierceBuilding = true;
                        pierceArmor = false;

                        homingPower = 0.25f;
                        homingDelay = 10f;

                        trailLength = 5;
                        trailWidth = 1.4f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = Pal.tungstenShot;
                        frontColor = Pal.tungstenShot;
                    }}
            );
            limitRange();
            coolant = consumeCoolant(0.3f);
            coolantMultiplier = 3;
            recoils = 3;
            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-barrel-l"){{
                              progress = PartProgress.recoil;
                              recoilIndex = 0;
                              moveY = -3f;
                          }},
                        new RegionPart("-barrel-m"){{
                            progress = PartProgress.recoil;
                            recoilIndex = 1;
                            moveY = -3f;
                        }},
                        new RegionPart("-barrel-r"){{
                            progress = PartProgress.recoil;
                            recoilIndex = 2;

                            moveY = -3f;
                        }}
                );
            }};
        }};

        vector = new ItemTurret("vector"){{
            requirements(Category.turret, with(dsItems.mycondium, 170, dsItems.thirium, 210, dsItems.etheronium, 260, dsItems.plastanium, 210));

            size = 5;
            squareSprite = true;
            scaledHealth = 280;
            range = 42f * 8;
            reload = 18f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 1f;
            shake = 1f;
            shootEffect = Fx.shootBig2;
            shootSound = dsSounds.autoCannon;
            shoot = new ShootAlternate(16f);
            shootY += 4;

            ammoUseEffect = Fx.casing4;
            ammo(
                    dsItems.thorium, new BasicBulletType(6f, 170){{
                        hitSound = despawnSound = dsSounds.autoCannonHit;
                        width = 14f;
                        height = 18f;

                        ammoMultiplier = 1;
                        buildingDamageMultiplier = 0.3f;
                        reloadMultiplier = 1.0f;
                        rangeChange = 0f;
                        pierceCap = 2;
                        pierceBuilding = true;
                        pierceArmor = true;

                        trailLength = 12;
                        trailWidth = 4f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = Pal.berylShot;
                        frontColor = Pal.berylShot;

                        fragBullets = 8;
                        fragRandomSpread = 30;
                        fragSpread = 20;
                        fragBullet = new BasicBulletType(5f, 35){{
                            width = 8f;
                            height = 12f;
                            hitSize = 6f;
                            lifetime = 18f;

                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            hitColor = backColor = trailColor = Pal.berylShot;
                            frontColor = Color.white;
                            trailWidth = 2.1f;
                            trailLength = 5;
                        }};

                    }}
            );
            limitRange();
            coolant = consumeCoolant(1.5f);
            coolantMultiplier = 0.5f;
            drawer = new DrawTurret();
        }};
        /*
        payloadTurret = new PayloadTurret("payload-turret"){{
            requirements(Category.turret, with(dsItems.copper, 1000, dsItems.titanium, 750, dsItems.silicon, 450, dsItems.plastanium, 330));

            health = 2700;
            size = 5;
            recoil = 8f;
            range = 300f;
            shake = 2f;
            shootSound = Sounds.shootBig;
            shootEffect = dsFx.PayloadShoot;
            smokeEffect = Fx.shootBigSmoke2;
            safeRange = 140f;
            reload = 30f;
            rotateSpeed = 1.8f;
            maxPaySize = 3.5f;
            payloadOffset = 7f;
            shootY = 8f;
            consumePower(3.75f);
            drawer = new DrawTurret("reinforced-"){{
                    parts.add(new RegionPart("-barrel"){{
                        progress = DrawPart.PartProgress.recoil;
                        moveY = -3f;
                }});
            }};
        }};
        */
    }}