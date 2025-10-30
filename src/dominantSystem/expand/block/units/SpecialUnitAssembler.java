package dominantSystem.expand.block.units;

import arc.Core;
import arc.graphics.Color;
import arc.util.Scaling;
import arc.util.Strings;
import mindustry.gen.Icon;
import mindustry.graphics.Pal;
import mindustry.type.LiquidStack;
import mindustry.ui.Styles;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatValues;


public class SpecialUnitAssembler extends UnitAssembler {
    public SpecialUnitAssembler(String name) {
        super(name);}

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.output, table -> {
            table.row();

            int tier = 0;
            for(var plan : plans){
                int ttier = tier;
                table.table(Styles.grayPanel, t -> {

                    if(plan.unit.isBanned()){
                        t.image(Icon.cancel).color(Pal.remove).size(40).pad(10);
                        return;
                    }

                    if(plan.unit.unlockedNow()){
                        t.image(plan.unit.uiIcon).scaling(Scaling.fit).size(40).pad(10f).left().with(i -> StatValues.withTooltip(i, plan.unit));
                        t.table(info -> {
                            info.defaults().left();
                            info.add(plan.unit.localizedName);
                            info.row();
                            info.add(Strings.autoFixed(plan.time / 60f, 1) + " " + Core.bundle.get("unit.seconds")).color(Color.lightGray);
                            if(ttier > 0){
                                info.row();
                                info.add(Stat.moduleTier.localized() + ": " + ttier).color(Color.lightGray);
                            }
                        }).left();

                        t.table(req -> {
                            req.add().grow(); //it refuses to go to the right unless I do this. please help.

                            req.table(solid -> {
                                int length = 0;
                                if(plan.itemReq != null){
                                    for(int i = 0; i < plan.itemReq.length; i++){
                                        if(length % 6 == 0){
                                            solid.row();
                                        }
                                        solid.add(StatValues.stack(plan.itemReq[i])).pad(5);
                                        length++;
                                    }
                                }

                                for(int i = 0; i < plan.requirements.size; i++){
                                    if(length % 6 == 0){
                                        solid.row();
                                    }
                                    solid.add(StatValues.stack(plan.requirements.get(i))).pad(5);
                                    length++;
                                }
                            }).right();

                            LiquidStack[] stacks = plan.liquidReq;
                            if(stacks != null){
                                for(int i = 0; i < plan.liquidReq.length; i++){
                                    req.row();

                                    req.add().grow(); //another one.

                                    req.add(StatValues.displayLiquid(stacks[i].liquid, stacks[i].amount * 60f, true)).right();
                                }
                            }
                        }).grow().pad(10f);
                    }else{
                        t.image(Icon.lock).color(Pal.darkerGray).size(40).pad(10);
                    }
                }).growX().pad(5);
                table.row();
                tier++;
            }
        });
    }

    public class SpecialUnitAssemblerBuild extends UnitAssemblerBuild {
    }
}
