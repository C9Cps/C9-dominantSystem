package dominantSystem.content;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import dominantSystem.content.bullets.AccelBulletType;
import dominantSystem.expand.ability.BoostAbility;
import dominantSystem.util.func.dsInterp;
import dominantSystem.util.graphic.dsPal;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.gen.LegsUnit;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Weapon;
import dominantSystem.expand.units.unitType.dsUnitType;
import mindustry.world.meta.BlockFlag;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static mindustry.entities.part.DrawPart.PartProgress.warmup;

public class dsUnitTypes{
    public static dsUnitType
    //Legs
    madness, chaos, anarchy, anger, rage, catastrophe,
    //Air
    spear, retribution, demolisher, executioner,
            none;

    public static void load(){
        var sp = 1/7.5f;
        //Legs
        madness = new dsUnitType("madness"){{
            constructor = LegsUnit::create;

            health = 800;
            armor = 3f;
            speed = sp * 7f;
            drag = 0.1f;

            immunities.addAll(dsStatusEffects.toxicI);

            hitSize = 0.9f*8;
            rotateSpeed = 4.5f;
            legStraightness = 0.3f;
            stepShake = 0f;

            legCount = 6;
            legLength = 12f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 3;
            rippleScale = 0.2f;

            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit + 0.1f;
            targetGround = true;
            targetAir = true;

            weapons.add(new Weapon("dominant-system-madness-weapon"){{
                top = false;
                layerOffset = -0.01f;
                reload = 60/8f*2;
                cooldownTime = 42f;
                x = 19/4f;
                y = 2/4f;
                shootSound = Sounds.blaster;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 16){{
                    width = 9f;
                    height = 10f;
                    lifetime = 160f/3;

                    trailSinMag = 2;
                    trailLength = 5;
                    trailWidth = 1.4f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = dsPal.toxic;
                    frontColor = Color.white.cpy();

                    status = StatusEffects.sapped;
                    statusDuration = 1.5f * 60;
                }};
            }});
        }};
        chaos = new dsUnitType("chaos"){{
            constructor = LegsUnit::create;

            health = 1800;
            armor = 5;
            speed = sp * 5.4f;
            drag = 0.6f;

            immunities.addAll(dsStatusEffects.toxicI);

            hitSize = 1.8f*8;
            rotateSpeed = 3f;
            legStraightness = 0.3f;
            stepShake = 0f;

            legCount = 4;
            legLength = 16f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 3;
            rippleScale = 0.2f;

            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit + 0.1f;
            targetGround = true;
            targetAir = true;

            weapons.add(new Weapon("dominant-system-chaos-flamethrower"){{
                top = true;
                layerOffset = -0.01f;
                reload = 60/9f;
                x = 30/4f;
                y = 15/4f;
                shootX = -4/4f;
                shootY = 26/4f;
                shootSound = Sounds.flame;
                recoil = 2f;
                ejectEffect = Fx.none;
                bullet = new BulletType(4f, 27.5f){{
                    ammoMultiplier = 6f;
                    hitSize = 7f;
                    lifetime = 16f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    statusDuration = 4f * 60;
                    shootEffect = dsFx.shootSmallToxicFlame;
                    hitEffect = dsFx.hitToxicFlameSmall;
                    despawnEffect = dsFx.none;
                    keepVelocity = false;
                    hittable = false;

                    hitColor = dsPal.toxic;

                    status = dsStatusEffects.toxicI;
                    statusDuration = 3f * 60;
                }};
            }});
        }};
        anarchy = new dsUnitType("anarchy"){{
            constructor = LegsUnit::create;

            health = 4800;
            armor = 8;
            speed = sp * 4f;
            drag = 0.6f;

            immunities.addAll(dsStatusEffects.toxicI, dsStatusEffects.toxicII);

            hitSize = 2.8f*8;
            rotateSpeed = 2.75f;
            legStraightness = 0.3f;
            stepShake = 0.125f;

            legCount = 6;
            legLength = 3.5f*8;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -6f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 2;
            rippleScale = 0.2f;

            legSplashDamage = 16f;

            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit + 0.1f;
            weapons.add(
                new Weapon("dominant-system-anarchy-gun"){{
                mirror = true;
                top = true;
                layerOffset = -0.01f;
                reload = 60/3f;
                x = 40/4f;
                y = -14/4f;
                shootY = 31/4f;
                shootSound = Sounds.malignShoot;
                recoil = 2f;
                recoilTime = 24;
                shootCone = 35;


                bullet = new ArtilleryBulletType(3f, 10){{
                    splashDamage = 78;
                    splashDamageRadius = 4.8f * 8;

                    targetGround = true;
                    targetAir = false;
                    width = 8;
                    height =  12;
                    lifetime = 28f*8/3;

                    trailLength = 27;
                    trailWidth = this.width/3;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = dsPal.toxic;
                    frontColor = Color.white.cpy();

                    status = dsStatusEffects.toxicII;
                    statusDuration = 1.5f * 60;

                    hitEffect = shootEffect = new MultiEffect(dsFx.hitToxicBulletBig, dsFx.shareDamage);
                    despawnEffect = dsFx.hitToxicBulletBig;

                    hitSound = Sounds.plasmaboom;
                    despawnSound = Sounds.plasmaboom;
                }};
            }},

                new Weapon("dominant-system-antiAir-gun"){{
                autoTarget = true;
                controllable = false;

                targetGround = false;
                targetAir = true;

                top = true;
                layerOffset = 0.2f;
                reload = 60/3.6f/2;
                x = 28/4f;
                y = -28/4f;
                shootY = 16/4f;
                shootSound = dsSounds.minigun;
                inaccuracy = 1;
                recoil = 0f;

                rotate = true;
                rotateSpeed = 360/60f;

                bullet = new FlakBulletType(5f, 10){{
                    splashDamage = 28.5f;
                    splashDamageRadius = 1.8f*8;

                    width = 4f;
                    height =  6f;
                    lifetime = 22f*8/5f;

                    trailLength = 2*8;
                    trailWidth = this.width/3f;

                    hitColor = backColor = trailColor = dsPal.toxic;
                    frontColor = Color.white.cpy();

                    hitEffect = despawnEffect = dsFx.hitToxicBulletBig;
                    hitSound = despawnSound = Sounds.plasmaboom;
                    smokeEffect = Fx.none;

                    status = dsStatusEffects.toxicI;
                    statusDuration = 1.5f * 60;
                }};
                    parts.add(new RegionPart("-barrel") {{
                        outline = true;
                        outlineColor = Pal.darkOutline;
                        top = false;
                        y = 8f/4;
                        moveY = -8f/4;
                        heatLayerOffset = 0;
                        heatLightOpacity = 0.8f;
                        progress = PartProgress.recoil;
                    }});
            }});
        }};
        anger = new dsUnitType("anger"){{
            constructor = LegsUnit::create;

            health = 12000;
            armor = 11;
            speed = sp * 5.2f;
            drag = 0.8f;

            immunities.addAll(dsStatusEffects.toxicI, dsStatusEffects.toxicII, dsStatusEffects.toxicIII);

            hitSize = 2.8f*8;
            rotateSpeed = 2.75f;
            legStraightness = 0.3f;
            stepShake = 0.25f;

            legCount = 6;
            legLength = 4.5f*8;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -10f;
            legBaseOffset = 8f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 2;
            rippleScale = 0.2f;

            legSplashDamage = 40f;

            legMoveSpace = 0.7f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit + 0.1f;
            canHeal = false;
            abilities.add(new EnergyFieldAbility(0,999*999,0){{
                maxTargets = -1;
                color = dsPal.toxic;
                curStroke = 7;
                y = 8f/4;
                display = false;
                displayHeal = false;
            }});
            weapons.add(
                    new Weapon(){{
                        mirror = false;
                        reload = 210;
                        shoot.firstShotDelay = 60;
                        recoil = 0;
                        x = 0/4f;
                        y = -10/4f;
                        shootCone = 35f;
                        shootSound = dsSounds.plasmaStrong;
                        chargeSound = Sounds.lasercharge2;


                        bullet = new BasicBulletType(){{
                            shrinkX = shrinkY = 0f;
                            damage = 260;
                            speed = 4;
                            lifetime = 60f;
                            width = height = 15f;
                            sprite = "large-orb-back";

                            homingPower = 0.1f;
                            pierce = true;
                            pierceCap = 3;

                            shootStatus = StatusEffects.unmoving;
                            shootStatusDuration = 60;
                            chargeEffect = new ParticleEffect(){{
                                region = "circle-shadow";
                                lifetime = 45;
                                cone = 360;
                                particles = 36;
                                sizeFrom = 0;
                                sizeTo = 2;
                                length = 25; baseLength = -29;
                                colorFrom = Color.white;
                                colorTo = dsPal.toxic;
                            }};

                            hitColor = backColor = trailColor = dsPal.toxic;
                            trailLength = 20;

                            despawnSound = hitSound = Sounds.dullExplosion;

                            bulletInterval = 4f;
                            intervalRandomSpread = 20f;
                            intervalBullets = 2;
                            intervalAngle = 180f;
                            intervalSpread = 300f;
                            intervalBullet = fragBullet = new BasicBulletType(2f, 42){{
                                width = 9f;
                                hitSize = 5f;
                                height = 15f;
                                pierceCap = 3;
                                lifetime = 28f;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = dsPal.toxic;
                                frontColor = Color.white;
                                trailWidth = 2.1f;
                                trailLength = 5;
                                hitEffect = despawnEffect = new WaveEffect(){{
                                    colorFrom = colorTo = dsPal.toxic;
                                    sizeTo = 4f;
                                    strokeFrom = 4f;
                                    lifetime = 10f;
                                }};
                            }};

                            fragBullet.damage = 36;
                            fragBullets = 12;
                            fragVelocityMin = 0.6f;
                            fragVelocityMax = 1.35f;
                            fragLifeMin = 0.5f;
                            }};
                    }});
        }};
        rage = new dsUnitType("rage"){{
            constructor = LegsUnit::create;

            health = 28000;
            armor = 16;
            speed = sp * 6.6f;
            drag = 0.8f;

            immunities.addAll(dsStatusEffects.toxicI, dsStatusEffects.toxicII, dsStatusEffects.toxicIII);

            hitSize = 4.5f*8;
            rotateSpeed = 2.1f;
            legStraightness = 0.3f;
            stepShake = 0.25f;

            legCount = 4;
            legLength = 5f*8;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -12f;
            legBaseOffset = 15f;
            legMaxLength = 1.f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 2;
            rippleScale = 0.2f;

            legSplashDamage = 120f;
            legSplashRange = 2.25f * 8;

            legMoveSpace = 0.7f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit + 0.1f;
            weapons.add(
                    new Weapon("dominant-system-rage-gun"){{
                        mirror = true;
                        top = true;
                        layerOffset = 0.01f;
                        reload = 50f;
                        x = 64/4f;
                        y = -25/4f;
                        shootY = 31/4f;
                        shootSound = dsSounds.minigun;
                        recoil = 3f;
                        recoilTime = 21f;
                        shootCone = 10f;

                        rotate = true;
                        rotateSpeed = 160f/60;

                        shoot = new ShootAlternate(){{spread = 4; barrels = 3;}};
                        shoot.shots = 3;
                        shoot.shotDelay = 10;

                        bullet = new AccelBulletType(6f, 98){{
                            splashDamage = 22;
                            splashDamageRadius = 18;
                            splashDamagePierce = true;

                            homingDelay = 6;
                            homingPower = 0.225f;

                            targetGround = true;
                            targetAir = true;
                            width = 8;
                            height =  12;
                            lifetime = 70;

                            trailLength = 20;
                            trailWidth = this.width/3f;

                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            hitColor = backColor = trailColor = dsPal.toxic;
                            frontColor = Color.white.cpy();

                            status = dsStatusEffects.toxicIII;
                            statusDuration = 3f * 60;

                            hitEffect = shootEffect = new MultiEffect(dsFx.hitToxicBulletBig, dsFx.shareDamage);
                            despawnEffect = dsFx.hitToxicBulletBig;

                            hitSound = Sounds.plasmaboom;
                            despawnSound = Sounds.plasmaboom;

                            velocityBegin = 0.25f;
                            velocityIncrease = 6f;
                            accelInterp = dsInterp.inOut;
                            accelerateBegin = 0f;
                            accelerateEnd = 0.775f;
                            drag = -0.01f;
                        }};
                        recoils = 3;
                        parts.add(
                            new RegionPart("-barrel-l"){{
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
                    }},
                    new Weapon("dominant-system-rage-head"){{
                mirror = false;
                reload = 1.8f * 60;
                x = 0;
                y = 0;
                shootY = -1/4f;
                recoil = 0f;
                shootSound = dsSounds.newRailgun;

                shootWarmupSpeed = 0.05f;
                minWarmup = 0.9f;

                bullet = new RailBulletType(){{
                    shootEffect = dsFx.instToxicShoot;
                    hitEffect = despawnEffect = dsFx.instToxicHit;
                    pierceEffect = dsFx.ToxicRailHit;
                    smokeEffect = Fx.smokeCloud;
                    pointEffect = dsFx.instToxicTrail;
                    pointEffectSpace = 20f;

                    damage = 850;
                    pierce = true;
                    pierceCap = 4;
                    buildingDamageMultiplier = 0.2f;
                    pierceDamageFactor = 1.5f;
                    length = 30.5f*8;
                    hitShake = 6f;
                    ammoMultiplier = 1f;
                }};
                parts.add(
                        new RegionPart("-side"){{
                                    progress = warmup;
                                    mirror = true;
                                    moveRot = -20f;
                                }}
                        );
            }});
        }};
        catastrophe = new dsUnitType("catastrophe"){{
            constructor = LegsUnit::create;

            health = 84000;
            armor = 31;
            speed = sp * 3.2f;
            drag = 0.3f;

            immunities.addAll(dsStatusEffects.toxicI, dsStatusEffects.toxicII, dsStatusEffects.toxicIII);

            hitSize = 7.5f*8;
            rotateSpeed = 0.4f;
            legStraightness = 0.8f;
            baseLegStraightness = -0.1f;
            stepShake = 0.8f;

            legCount = 4;
            legGroupSize = 2;
            legLength = 9f*8;
            lockLegBase = true;
            legContinuousMove = true;
            legStraightLength = 2;

            legExtension = -1.25f*8;
            legBaseOffset = 3f*8;
            legMaxLength = 1.1f;
            legMinLength = 0.4f;
            legLengthScl = 0.92f;
            legForwardScl = 1.2f;
            rippleScale = 2.2f;

            legSplashDamage = 280f;
            legSplashRange = 1.8f * 8;

            legMoveSpace = 0.9f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.9f;
            groundLayer = Layer.legUnit + 0.1f;
            weapons.add(
                    new Weapon("dominant-system-catastrophe-front"){{
                        layerOffset = -0.01f;
                        mirror = false;
                        reload = 290f;
                        shoot.firstShotDelay = 120;
                        recoil = 0f;
                        x = 0;
                        y = 2;
                        shootY = -16;
                        shootCone = 5f;
                        shootSound = dsSounds.BigMachShoot;
                        chargeSound = dsSounds.BigMachCharge;


                        bullet = new BasicBulletType(9, 1475){{
                            splashDamage = 200;
                            splashDamagePierce = true;
                            splashDamageRadius = 3.6f * 8;

                            shrinkX = shrinkY = 0f;
                            lifetime = 58f * 8/9;
                            width = height = 28f;
                            sprite = "large-orb-back";

                            pierce = true;
                            pierceBuilding = false;
                            pierceCap = 2;
                            pierceDamageFactor = 1.5f;

                            shootStatus = StatusEffects.unmoving;
                            shootStatusDuration = 120;
                            chargeEffect = new ParticleEffect(){{
                                region = "circle-shadow";
                                lifetime = 120;
                                cone = 360;
                                spin = 180;
                                particles = 36;
                                sizeFrom = 0;
                                sizeTo = 5;
                                length = 60; baseLength = -70;
                                colorFrom = Color.white;
                                colorTo = dsPal.toxic;
                            }};

                            hitColor = backColor = trailColor = dsPal.toxic;
                            trailLength = 20;

                            despawnSound = hitSound = Sounds.largeExplosion;

                            bulletInterval = 5f;
                            intervalRandomSpread = 20f;
                            intervalBullets = 2;
                            intervalAngle = 180f;
                            intervalSpread = 300f;
                            intervalBullet = fragBullet = new BasicBulletType(7f, 190){{
                                width = 14f;
                                hitSize = 6f;
                                height = 18f;
                                pierceCap = 3;
                                lifetime = 28f;
                                homingPower = 0.1f;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = dsPal.toxic;
                                frontColor = Color.white;
                                trailWidth = 2.1f;
                                trailLength = 5;
                                hitEffect = despawnEffect = new WaveEffect(){{
                                    colorFrom = colorTo = dsPal.toxic;
                                    sizeTo = 4f;
                                    strokeFrom = 4f;
                                    lifetime = 10f;
                                }};
                            }};

                            fragBullet.damage = 110;
                            fragBullet.homingPower = 0;
                            fragBullets = 9;
                            fragVelocityMin = 0.55f;
                            fragVelocityMax = 1.2f;
                            fragLifeMin = 0.5f;
                        }};
                    }},
            new Weapon("dominant-system-catastrophe-gun"){{
                mirror = true;
                top = true;
                layerOffset = 0.01f;
                reload = 50f;
                x = 34;
                y = -18;
                shootY = 31/4f;
                shootSound = dsSounds.autoCannon;
                recoil = 1.5f;
                shootCone = 15f;

                rotate = true;
                rotateSpeed = 120f/60;

                shoot = new ShootAlternate(){{spread = 10; barrels = 2;}};
                shoot.shots = 4;
                shoot.shotDelay = 7;

                bullet = new AccelBulletType(7f, 120f){{
                    splashDamage = 78.5f;
                    splashDamageRadius = 2.2f * 8;
                    splashDamagePierce = true;

                    homingDelay = 6;
                    homingPower = 0.225f;

                    targetGround = true;
                    targetAir = true;
                    width = 8;
                    height =  12;
                    lifetime = 120;

                    trailLength = 20;
                    trailWidth = this.width/3f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = dsPal.toxic;
                    frontColor = Color.white.cpy();

                    status = dsStatusEffects.toxicIII;
                    statusDuration = 3f * 60;

                    hitEffect = shootEffect = new MultiEffect(dsFx.hitToxicBulletBig, dsFx.shareDamage);
                    despawnEffect = dsFx.hitToxicBulletBig;

                    hitSound = despawnSound = dsSounds.autoCannonHit;

                    velocityBegin = 0.25f;
                    velocityIncrease = 6f;
                    accelInterp = dsInterp.inOut;
                    accelerateBegin = 0f;
                    accelerateEnd = 0.775f;
                    drag = -0.01f;
                }};
                recoils = 2;
                parts.add(
                        new RegionPart("-barrel-l"){{
                            progress = PartProgress.recoil;
                            recoilIndex = 0;
                            moveY = -3f;
                        }},
                        new RegionPart("-barrel-r"){{
                            progress = PartProgress.recoil;
                            recoilIndex = 1;
                            moveY = -3f;
                        }}
                );
            }},
            new Weapon("dominant-system-catastrophe-cannon"){{
                mirror = true;
                top = false;
                layerOffset = -0.01f;
                reload = 90;
                x = 33;
                y = 1;
                shootY = 31/4f;
                shootSound = Sounds.malignShoot;
                recoil = 1f;
                shootCone = 9f;
                shoot = new ShootHelix();
                shoot.shots = 2;
                rotate = false;

                bullet = new MissileBulletType(7f, 310f){{
                    splashDamage = 190f;
                    splashDamageRadius = 2.8f * 8;
                    splashDamagePierce = true;

                    weaveMag = 2;
                    weaveScale = 3;

                    targetGround = true;
                    targetAir = true;
                    width = 12;
                    height =  18;
                    lifetime = 50f/7f * 8;

                    trailLength = 18;
                    trailWidth = this.width/3f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = dsPal.toxic;
                    frontColor = Color.white.cpy();

                    status = dsStatusEffects.toxicIII;
                    statusDuration = 3f * 60;

                    hitEffect = shootEffect = new MultiEffect(dsFx.hitToxicBulletBig, dsFx.shareDamage);
                    despawnEffect = dsFx.hitToxicBulletBig;

                    hitSound = despawnSound = Sounds.explosion;
                }};
                parts.add(
                        new RegionPart("-barrel"){{
                            progress = PartProgress.recoil;
                            moveY = -4f;
                        }}
                );
            }});
        }};

        //Air
        spear = new dsUnitType("spear"){{
            constructor = UnitEntity::create;

            health = 600;
            armor = 2;
            speed = sp * 18.0f;
            drag = 0.04f;
            accel = 0.08f;

            flying = true;
            engineOffset = 5.75f;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.drill};
            hitSize = 9;
            itemCapacity = 10;

            weapons.add(new Weapon(){{
                mirror = false;
                y = 2f;
                x = 0f;
                reload = 60/1.25f;
                shoot.shots = 2;
                shootSound = Sounds.missile;
                bullet = new MissileBulletType(3f, 12, "missile"){{
                    lifetime = 11.5f / 3*8;
                    keepVelocity = false;
                    x = 0;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    homingPower = 0.1f;

                    weaveScale = 4f;
                    weaveMag = 2f;

                    splashDamageRadius = 2.2f * 8;
                    splashDamage = 13f;

                    width = 6f;
                    height = 8f;

                    backColor = frontColor = Color.valueOf("FFA665");
                    shootEffect = Fx.smeltsmoke;
                    smokeEffect = Fx.shootSmallSmoke;

                    trailColor = Pal.unitBack;
                    backColor = Pal.unitBack;
                    frontColor = Pal.unitFront;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                }};
            }});
        }};
        retribution = new dsUnitType("retribution"){{
            constructor = UnitEntity::create;

            health = 1400;
            armor = 4;
            speed = sp * 14.8f;
            drag = 0.02f;
            accel = 0.05f;

            flying = true;
            engineOffset = 9f;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.factory};
            hitSize = 15;
            itemCapacity = 0;
            engineSize = 0;
            setEnginesMirror(
                    new UnitEngine(3.5f, -6.5f, 2.5f, -90)
            );
            weapons.add(
                    new Weapon(){{
                mirror = false;
                y = 2f;
                x = 0f;
                reload = 60/2.2f;
                shootSound = Sounds.bolt;
                bullet = new RailBulletType(){{

                    length = 12f*8;
                    damage = 56f;
                    hitColor = Color.valueOf("FFA665");
                    hitEffect = endEffect = Fx.hitBulletColor;

                    pierceCap = 2;
                    pierceDamageFactor = 0.75f;
                    pierce = true;
                    pierceBuilding = true;

                    smokeEffect = Fx.colorSpark;

                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 1.5f, 5f, e.rotation);
                    });
                    shootEffect = new Effect(10, e -> {
                        color(e.color);
                        float w = 1.2f + 7 * e.fout();

                        Drawf.tri(e.x, e.y, w, 30f * e.fout(), e.rotation);
                        color(e.color);

                        for(int i : Mathf.signs){
                            Drawf.tri(e.x, e.y, w * 0.9f, 18f * e.fout(), e.rotation + i * 90f);
                        }

                        Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
                    });
                    lineEffect = new Effect(20f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 0.9f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 1.5f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
        }};
        demolisher = new dsUnitType("demolisher"){{
            constructor = UnitEntity::create;
            lowAltitude = true;

            health = 3750;
            armor = 7;
            speed = sp * 11f;
            rotateSpeed = 3;
            drag = 0.02f;
            accel = 0.04f;

            flying = true;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.storage};
            hitSize = 22;
            itemCapacity = 60;
            engineSize = 3.5f;
            engineOffset = 11;
            //abilities.add(new BoostAbility(false, 1.5f, 90.0f));

            weapons.add(
                    new Weapon("dominant-system-demolisher-gunner"){{
                        mirror = true;
                        top = true;
                        layerOffset = 0.1f;
                        y = -4f;
                        x = 8f;
                        rotate = true;
                        rotateSpeed = 2;

                        reload = 60/2.7f;
                        shootSound = Sounds.missile;
                        bullet = new MissileBulletType(4f, 72, "missile"){{
                            layer += 1;
                            lifetime = 24f / 4*8;
                            keepVelocity = false;
                            shrinkY = 0f;
                            drag = -0.003f;

                            homingRange = 60f;
                            homingPower = 0.1f;

                            weaveScale = 4f;
                            weaveMag = 2f;

                            splashDamageRadius = 3.5f * 8;
                            splashDamage = 28f;

                            width = 9f;
                            height = 12f;

                            backColor = frontColor = Color.valueOf("FFA665");
                            shootEffect = Fx.smeltsmoke;
                            smokeEffect = Fx.shootSmallSmoke;

                            trailColor = Pal.unitBack;
                            backColor = Pal.unitBack;
                            frontColor = Pal.unitFront;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                        }};
                    }});
        }};
        executioner = new dsUnitType("executioner"){{
            constructor = UnitEntity::create;
            lowAltitude = true;

            health = 7500;
            armor = 11;
            speed = sp * 7f;
            rotateSpeed = 2.2f;
            drag = 0.04f;
            accel = 0.04f;

            flying = true;
            targetFlags = new BlockFlag[]{BlockFlag.core, BlockFlag.shield};
            hitSize = 40;
            itemCapacity = 90;
            engineSize = 3.5f;
            engineOffset = 19;
            weapons.add(
                    new Weapon("dominant-system-executioner-mount"){{
                        mirror = false;
                        top = true;
                        layerOffset = 1f;
                        y = -8f;
                        x = 0f;
                        rotate = true;
                        rotateSpeed = 1.8f;

                        shoot = new ShootAlternate(4.5f){{barrels = 3;}};

                        reload = 60/3f;
                        shootSound = Sounds.missile;
                        bullet = new MissileBulletType(5f, 48,"missile"){{
                            layer += 1;
                            lifetime = 19.5f / 5*8;
                            keepVelocity = false;
                            shrinkY = 0f;
                            drag = -0.003f;

                            trailWidth = 2;
                            trailLength = 8;

                            homingRange = 60f;
                            homingPower = 0.1f;

                            weaveScale = 4f;
                            weaveMag = 2f;

                            splashDamageRadius = 1.5f * 8;
                            splashDamage = 24f;

                            width = 8f;
                            height = 9f;

                            backColor = frontColor = Color.valueOf("FFA665");
                            shootEffect = Fx.smeltsmoke;
                            smokeEffect = Fx.shootSmallSmoke;

                            backColor = trailColor = Pal.unitBack;
                            frontColor = Pal.unitFront;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                        }};
                    }},
                    new Weapon("dominant-system-executioner-gunner"){{
                        mirror = true;
                        top = true;
                        y = -6f;
                        x = 17f;
                        rotate = true;
                        rotateSpeed = 1.8f;

                        reload = 60/4f;
                        shootSound = Sounds.bang;
                        bullet = new BasicBulletType(5f, 25){{
                            lifetime = 24f / 4*8;

                            width = 9f;
                            height = 12f;

                            trailWidth = 2;
                            trailLength = 4;

                            backColor = frontColor = Color.valueOf("FFA665");
                            shootEffect = Fx.smeltsmoke;
                            smokeEffect = Fx.shootSmallSmoke;

                            trailColor = Pal.unitBack;
                            backColor = Pal.unitBack;
                            frontColor = Pal.unitFront;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                        }};
                    }});
        }};
    }
}