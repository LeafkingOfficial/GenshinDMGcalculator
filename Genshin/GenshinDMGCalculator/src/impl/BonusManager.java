package impl;

public class BonusManager {
    public int SucroseEM = 0, KasuhaEM = 0, BannitATK = 0;
    public int Resistance = 0;

    //共鸣
    public String[] bonusListTeam = {"DoublePyro","DoubleHydro","DoubleGeo","DoubleAnemo","DoubleDendro","DoubleElectro","DoubleCryo"};
    public boolean[] bonusTeamTick = new boolean[10];

    //队友
    public String[] bonusTeamSkills = {"BannitC6_PyroDMG", "SucroseEM_50", "SucroseEM_Skill", "KasuhaSkill",
                                        "Dragon","MonaQ","SucroseC6","BannitQ","Dreams","Instructor","Oblige","Venerer",
                                        "Zhongli_E","Yelan_Q"};
    public boolean[] bonusTeamSkillTick = new boolean[20];

    //角色/武器技能
    public String[] charaSkills = {"Chara_e","CharaSkill","Weapon_Skill_1","Weapon_Skill_2"};
    public boolean[] charaSkillsTicks = new boolean[4];

    //食物增伤
    public String[] foods = {"Sakura","Oil","Adeptus"};
    public boolean[] foodsTicks = new boolean[5];

    //食物增伤
    public String[] artifact = {"80EM","18%ATK","15%ELE_Bonus","20%HP"};
    public boolean[] artifactTick = new boolean[5];

    public BonusManager(){
        //将所有buff初始化为false
        for(int i = 0; i<10; i++){
            bonusTeamTick[i] = false;
        }
    }
    //注意角色对象中的reset方法和本类中方法的冲突
    public void bonusAdder(Characters chara, String bonusName){
        switch(bonusName){
            case "DoublePyro":
                if(!bonusTeamTick[0]) {bonusTeamTick[0] = true; System.out.println("PyroBUFF ON");}
                else {bonusTeamTick[0] = false; System.out.println("PyroBUFF OFF");}
                break;
            case "DoubleHydro":
                if(!bonusTeamTick[1]) {bonusTeamTick[1] = true; System.out.println("HydroBUFF ON");}
                else {bonusTeamTick[1] = false; System.out.println("HydroBUFF OFF");}
                break;
            case "DoubleGeo":
                if(!bonusTeamTick[2]) {bonusTeamTick[2] = true; System.out.println("HydroBUFF ON");}
                else {bonusTeamTick[2] = false; System.out.println("HydroBUFF OFF");}
                break;
            case "BannitC6_PyroDMG":
                if(!bonusTeamSkillTick[0]) {bonusTeamSkillTick[0] = true; System.out.println("BannitC6_PyroDMG ON");}
                else {bonusTeamSkillTick[0] = false; System.out.println("BannitC6_PyroDMG OFF");}
                break;
            case "SucroseEM_50":
                if(!bonusTeamSkillTick[1]) {bonusTeamSkillTick[1] = true; System.out.println("SucroseEM_50 ON");}
                else {bonusTeamSkillTick[1] = false; System.out.println("SucroseEM_50 OFF");}
                break;
            case "SucroseEM_Skill":
                if(!bonusTeamSkillTick[2]) {bonusTeamSkillTick[2] = true; System.out.println("SucroseEM_Skill ON");}
                else {bonusTeamSkillTick[2] = false; System.out.println("SucroseEM_Skill OFF");}
                break;
            case "KasuhaSkill":
                if(!bonusTeamSkillTick[3]) {bonusTeamSkillTick[3] = true; System.out.println("KasuhaSkill ON");}
                else {bonusTeamSkillTick[3] = false; System.out.println("KasuhaSkill OFF");}
                break;
            case "Dragon":
                if(!bonusTeamSkillTick[4]) {bonusTeamSkillTick[4] = true; System.out.println("Dragon ON");}
                else {bonusTeamSkillTick[4] = false; System.out.println("Dragon OFF");}
                break;
            case "MonaQ":
                if(!bonusTeamSkillTick[5]) {bonusTeamSkillTick[5] = true; System.out.println("Dragon ON");}
                else {bonusTeamSkillTick[5] = false; System.out.println("Dragon OFF");}
                break;
            case "SucroseC6":
                if(!bonusTeamSkillTick[6]) {bonusTeamSkillTick[6] = true; System.out.println("SucroseC6 ON");}
                else {bonusTeamSkillTick[6] = false; System.out.println("SucroseC6 OFF");}
                break;
            case "BannitQ":
                if(!bonusTeamSkillTick[7]) {bonusTeamSkillTick[7] = true; System.out.println("BannitQ ON");}
                else {bonusTeamSkillTick[7] = false; System.out.println("BannitQ OFF");}
                break;
            case "Dreams":
                if(!bonusTeamSkillTick[8]) {bonusTeamSkillTick[8] = true; System.out.println("Dreams ON");}
                else {bonusTeamSkillTick[8] = false; System.out.println("Dreams OFF");}
                break;
            case "Instructor":
                if(!bonusTeamSkillTick[9]) {bonusTeamSkillTick[9] = true; System.out.println("Instructor ON");}
                else {bonusTeamSkillTick[9] = false; System.out.println("Instructor OFF");}
                break;
            case "Oblige":
                if(!bonusTeamSkillTick[10]) {bonusTeamSkillTick[10] = true; System.out.println("Oblige ON");}
                else {bonusTeamSkillTick[10] = false; System.out.println("Oblige OFF");}
                break;
            case "Venerer":
                if(!bonusTeamSkillTick[11]) {bonusTeamSkillTick[11] = true; System.out.println("Venerer ON");}
                else {bonusTeamSkillTick[11] = false; System.out.println("Venerer OFF");}
                break;
            case "Zhongli_E":
                if(!bonusTeamSkillTick[12]) {bonusTeamSkillTick[12] = true; System.out.println("Zhongli_e ON");}
                else {bonusTeamSkillTick[12] = false; System.out.println("Zhongli_e OFF");}
                break;
            case "Yelan_Q":
                if(!bonusTeamSkillTick[13]) {bonusTeamSkillTick[13] = true; System.out.println("Yelan_Q ON");}
                else {bonusTeamSkillTick[13] = false; System.out.println("Yelan_Q OFF");}
                break;
            case "Chara_e":
                if(!charaSkillsTicks[0]) {charaSkillsTicks[0] = true; System.out.println("Chara_e ON");}
                else {charaSkillsTicks[0] = false; System.out.println("Chara_e OFF");}
                break;
            case "CharaSkill":
                if(!charaSkillsTicks[1]) {charaSkillsTicks[1] = true; System.out.println("CharaSkill ON");}
                else {charaSkillsTicks[1] = false; System.out.println("CharaSkill OFF");}
                break;
            case "Weapon_Skill_1":
                if(!charaSkillsTicks[2]) {charaSkillsTicks[2] = true; System.out.println("Weapon_Skill ON");}
                else {charaSkillsTicks[2] = false; System.out.println("Weapon_Skill OFF");}
                break;
            case "Weapon_Skill_2":
                if(!charaSkillsTicks[3]) {charaSkillsTicks[3] = true; System.out.println("Weapon_Skill_2 ON");}
                else {charaSkillsTicks[3] = false; System.out.println("Weapon_Skill_2 OFF");}
                break;
            case "Sakura":
                if(!foodsTicks[0]) {foodsTicks[0] = true; System.out.println("Sakura ON");}
                else {foodsTicks[0] = false; System.out.println("Sakura OFF");}
                break;
            case "Oil":
                if(!foodsTicks[1]) {foodsTicks[1] = true; System.out.println("Oil ON");}
                else {foodsTicks[1] = false; System.out.println("Oil OFF");}
                break;
            case "Adeptus":
                if(!foodsTicks[2]) {foodsTicks[2] = true; System.out.println("Adeptus ON");}
                else {foodsTicks[2] = false; System.out.println("Adeptus OFF");}
                break;
            case "80EM":
                if(!artifactTick[0]) {artifactTick[0] = true; System.out.println("80EM ON");}
                else {artifactTick[0] = false; System.out.println("80EM OFF");}
                break;
            case "18%ATK":
                if(!artifactTick[1]) {artifactTick[1] = true; System.out.println("18%ATK ON");}
                else {artifactTick[1] = false; System.out.println("18%ATK OFF");}
                break;
            case "15%ELE_Bonus":
                if(!artifactTick[2]) {artifactTick[2] = true; System.out.println("15%ELE_Bonus ON");}
                else {artifactTick[2] = false; System.out.println("15%ELE_Bonus OFF");}
                break;
            case "20%HP":
                if(!artifactTick[3]) {artifactTick[3] = true; System.out.println("20%HP ON");}
                else {artifactTick[3] = false; System.out.println("20%HP OFF");}
                break;

        
            }
    }
    public void renewBonus(Characters chara){
        //共鸣加成
        if(bonusTeamTick[0]){
            System.out.println("已经添加双火");
            chara.atk_bonusSPC += (chara.BasicATK + chara.wep.BasicATK)*0.25;
        }
        if(bonusTeamTick[1]){
            System.out.println("已经添加双水");
            chara.hp_bonusSPC += chara.BasicHP*0.25;
        }
        if(bonusTeamTick[2]){
            System.out.println("已经添加双岩");
            chara.ele_bonus += 0.15f;
        }

        //队友天赋加成
        if(bonusTeamSkillTick[0]){
            System.out.println("班尼特六命效果添加");
            chara.ele_bonus += 0.15;
        }

        if(bonusTeamSkillTick[1]){
            System.out.println("砂糖天赋50精通添加");
            chara.ele_mastery += 50;
        }

        if(bonusTeamSkillTick[2]){
            System.out.println("砂糖天赋精通20%添加");
            chara.ele_mastery += SucroseEM*0.2;
        }

        if(bonusTeamSkillTick[3]){
            System.out.println("万叶精通0.04%元素伤害添加");
            chara.ele_bonus += KasuhaEM*0.0002;
        }

        if(bonusTeamSkillTick[4]){
            System.out.println("讨龙添加");
            chara.atk_bonusSPC += (chara.BasicATK+chara.wep.BasicATK)*0.48;
        }

        if(bonusTeamSkillTick[5]){
            System.out.println("莫娜大招");
            chara.ele_bonus += 0.58;
        }

        if(bonusTeamSkillTick[6]){
            System.out.println("砂糖六命增加元素伤害");
            chara.ele_bonus += 0.20;
        }

        if(bonusTeamSkillTick[7]){
            System.out.println("班尼特大招加伤");
            chara.atk_bonusSPC += BannitATK*1.32;
        }

        if(bonusTeamSkillTick[8]){
            System.out.println("千夜浮梦42精通");
            chara.ele_mastery += 42;
        }

        if(bonusTeamSkillTick[9]){
            System.out.println("教官120精通");
            chara.ele_mastery += 120;
        }

        if(bonusTeamSkillTick[10]){
            System.out.println("宗室20%攻击力");
            chara.atk_bonusSPC += (chara.BasicATK + chara.wep.BasicATK)*0.2;
        }

        if(bonusTeamSkillTick[11]){
            System.out.println("风套减抗");
            chara.Resistance_reduction += -0.4f;
        }

        if(bonusTeamSkillTick[12]){
            System.out.println("钟离减抗");
            chara.Resistance_reduction = -0.2f;
        }

        if(bonusTeamSkillTick[13]){
            System.out.println("夜兰增伤");
            chara.ele_bonus += 0.5;
        }

        if(charaSkillsTicks[2]){
            System.out.println("武器被动1开");
            chara.wep.skill_1();
        }

        if(foodsTicks[0]){
            System.out.println("绯樱饼加成");
            chara.hp_bonusSPC += chara.BasicHP*0.25;
        }

        if(foodsTicks[1]){
            System.out.println("精油");
            chara.ele_bonus += 0.25;
        }

        if(foodsTicks[2]){
            System.out.println("仙跳墙");
            chara.atk_bonusSPC += 372;
            chara.crit_rate += 0.12;
        }

        if(artifactTick[0]){
            System.out.println("80EM");
            chara.ele_mastery += 80;
        }

        if(artifactTick[1]){
            System.out.println("18%攻击力");
            chara.atk_bonusSPC += (chara.BasicATK + chara.wep.BasicATK)*0.18;
        }

        if(artifactTick[2]){
            System.out.println("15%元素伤害");
            chara.ele_bonus += 0.15;
        }

        if(artifactTick[3]){
            System.out.println("20%生命值");
            chara.hp_bonusSPC += chara.BasicHP*0.2;
        }

        if(charaSkillsTicks[1]){
            System.out.println("33火伤技能开");
            chara.Skill_2();
        }
        
        if(charaSkillsTicks[0]){
            //放到最后
            System.out.println("e技能开");
            chara.Skill_1();
        }

        if(charaSkillsTicks[3]){
            //放到最后
            System.out.println("武器被动2开");
            chara.wep.skill_2();
        }
        
    }
}
