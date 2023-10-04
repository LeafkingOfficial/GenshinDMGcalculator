package impl;

public class Weapon {
    public float HPbonus;
    public float ATKbonus;
    public float DEFbonus;
    public float EngRecbonus;
    public float CRIT_Ratebonus;
    public float CRIT_DMGbonus;
    public float EMbonus;
    public float BasicATK;
    public Characters character;

    public Weapon(float HPbonus, float ATKbonus, float DEFbonus, float EngRecbonus, 
    float CRIT_Ratebonus, float CRIT_DMGbonus, float EMbonus, float BasicATK){
        this.HPbonus = HPbonus;
        this.ATKbonus = ATKbonus;
        this.DEFbonus = DEFbonus;
        this.EngRecbonus = EngRecbonus;
        this.CRIT_DMGbonus = CRIT_DMGbonus;
        this.CRIT_Ratebonus = CRIT_Ratebonus;
        this.EMbonus = EMbonus;
        this.BasicATK = BasicATK;
    }
    public void skill_1(){};
    public void skill_2(){};

}
