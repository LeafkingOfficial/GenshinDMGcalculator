package GenshinDMG.Weaponsfolder;
import GenshinDMG.Characters;
import GenshinDMG.Weapon;

public class Humo extends Weapon{

    public Humo(){
        super(
        0.2f, 
        0, 
        0, 
        0, 
        0, 
        0.662f, 
        0, 
        608
        );
    }

    public void skill_full(){
        //半血以下提升攻击力
        character.atk_bonusSPC += (character.BasicHP + character.hp_bonusSPC) * 0.018f;
    }
    public void skill_half(){
        //半血以上提升攻击力
        character.atk_bonusSPC += (character.BasicHP + character.hp_bonusSPC) * 0.008f;
    }
    
}
