package GenshinDMG;

public class BonusManager {
    public String[] bonusListTeam = {"DoublePyro","DoubleHydro","DoubleGeo","DoubleAnemo","DoubleDendro","DoubleElectro","DoubleCryo"};
    public boolean[] bonusTeamTick = new boolean[10];

    public String[] bonusTeamSkills = {"BannitC6_ProDMG", "SucroseEM_50", "SucroseEM_Skill", "KasuhaSkill"};
    public boolean[] bonusTeamSkillTick = new boolean[10];

    public BonusManager(){

    }
    //注意角色对象中的reset方法和本类中方法的冲突
    public void bonusAdder(Characters chara, String bonusName){
        switch(bonusName){
            case "DoublePyro":
                chara.atk_bonusSPC += chara.BasicATK*0.25;
            break;
        }
    }
}
