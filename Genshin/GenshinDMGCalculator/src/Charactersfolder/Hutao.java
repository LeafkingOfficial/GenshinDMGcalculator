package Charactersfolder;

import impl.Artifacts;
import impl.Characters;
import impl.Weapon;

public class Hutao extends Characters{

    //胡桃的基础面板
    public static float BasicATK = 107;
    public static float BasicHP = 15552;
    public static float BasicCRIT_Rate = 0.05f;
    public static float BasicCRIT_DMG = 0.884f;

    //初始化胡桃的时候绑定圣遗物
    public Hutao(Artifacts arts[], Weapon wep){
        //在初始化的时候已经计算好了基础面板
        super("Hutao", arts, wep, BasicATK, BasicHP, BasicCRIT_Rate, BasicCRIT_DMG);
        super.skilldmgQ = 7.06f;

        
    }

    @Override
    public void Skill_1(){
        atk_bonusSPC += (super.BasicHP + super.hp_bonusSPC) * 0.0715;
        //胡桃的E技能13级基于生命提升攻击力
    }

    @Override
    public void Skill_2(){
        ele_bonus += 0.33;
    }

}
