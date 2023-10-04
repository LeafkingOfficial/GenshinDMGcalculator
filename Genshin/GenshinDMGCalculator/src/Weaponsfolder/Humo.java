package Weaponsfolder;

import impl.Weapon;

public class Humo extends Weapon{

    public Humo(){
        super(
        0.0f, 
        0, 
        0, 
        0, 
        0, 
        0.662f, 
        0, 
        608
        );
    }

    @Override
    public void skill_2(){
        //半血以下提升攻击力
        character.atk_bonusSPC += (character.BasicHP + character.hp_bonusSPC) * 0.018f;
    }
    @Override
    public void skill_1(){
        character.hp_bonusSPC += character.BasicHP*0.2;
    }
    
}
