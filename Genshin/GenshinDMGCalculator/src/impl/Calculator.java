package impl;
public class Calculator {

    public static float resisReduction;

    public static float DmgCalculate(Characters chara , float RES, float reac_coe, float addiRec_coe, float oppLevel){
        
        //攻击力乘区
        float ATK_coe = chara.BasicATK + chara.wep.BasicATK + chara.atk_bonusSPC;
        System.out.println("攻击力乘区 "+ ATK_coe);

        //技能倍率
        float SKILL_coe = chara.skilldmgQ;
        System.out.println("技能倍率 "+ SKILL_coe);

        //暴伤倍率
        float CRIT_coe = chara.crit_dmg + 1;
        System.out.println("暴伤倍率 "+ CRIT_coe);

        //增伤乘区
        float INC_coe = chara.ele_bonus + 1;
        System.out.println("增伤乘区 "+ INC_coe);

        //精通乘区 reac_coe 为增幅反应倍率 addi为反应额外增伤，如魔女套
        float ELE_coe = reac_coe *( 1 + (chara.ele_mastery * 2.78f)/(chara.ele_mastery + 1400) + addiRec_coe);
        System.out.println("精通乘区 "+ ELE_coe);

        //抗性区
        float RES_coe;
        RES = RES + chara.Resistance_reduction;
        if(RES>0.75) RES_coe = 1/(1+RES);
        else if(RES>=0 && RES <= 0.75) RES_coe = 1 - RES;
        else RES_coe = 1-RES/2;
        System.out.println("抗性区 "+ RES_coe);

        //防御区域直接默认90级角色了,减防角色没有抽，不搞了
        float DEF_coe = 190/(190 + oppLevel + 100 );
        System.out.println("防御区 "+ DEF_coe);

        float DMG = ATK_coe*SKILL_coe*CRIT_coe*INC_coe*ELE_coe*RES_coe*DEF_coe;
        
        return DMG;
    }
}
