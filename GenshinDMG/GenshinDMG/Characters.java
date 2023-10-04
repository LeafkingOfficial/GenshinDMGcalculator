package GenshinDMG;
public class Characters {
    public String name;
    public float atk = 0;
    public float ele_mastery = 0;
    public float hp = 0;
    public float crit_rate = 0;
    public float crit_dmg = 0;
    public float ele_bonus = 0;
    public float def = 0;
    public float Eng_rec = 0;
    public Artifacts arts[];
    public Weapon wep;
    public float BasicATK;
    public float BasicHP;
    public float BasicCRIT_Rate;
    public float BasicCRIT_DMG;

    public float skilldmgQ;

    //储存总加成
    public float atk_bonusSPC = 0;
    public float hp_bonusSPC = 0;
    public float inc_bonusSPC = 0;

    public Characters(String name, Artifacts arts[], Weapon wep, float BasicATK, float BasicHP, float BasicCRIT_Rate, float BasicCRIT_DMG){
        this.name = name;
        this.arts = arts;
        this.wep = wep;
        this.BasicATK = BasicATK;
        this.BasicHP = BasicHP;
        this.BasicCRIT_Rate = BasicCRIT_Rate;
        this.BasicCRIT_DMG = BasicCRIT_DMG;
        //通过圣遗物和武器和角色白值初始化角色的初始面板
        ArtsCalculator(BasicATK, BasicHP, wep);
        System.out.println("基础攻击力：" + (BasicATK + wep.BasicATK));
        System.out.println("基础生命" + BasicHP);

    }
    
    private void reset(){
        atk = 0;
        ele_mastery = 0;
        hp = 0;
        crit_rate = 0;
        crit_dmg = 0;
        ele_bonus = 0;
        def = 0;
        Eng_rec = 0;
        atk_bonusSPC = 0;
        hp_bonusSPC = 0;
        inc_bonusSPC = 0;
    }
    //这里要输入角色的具体基础面板和武器
    public void ArtsCalculator(float BasicATK, float BasicHP, Weapon wep){


        //创建变量储存圣遗物总数据 后续可以做成返回输出展示
        float HPper = 0, HPnum = 0, ATK_bper = 0, ATK_bnum = 0, DEF_bnum = 0, DEF_bper = 0, EM = 0, REC = 0, CR = 0, CD = 0, ELE_bonus = 0;
        
        reset();

        //对圣遗物里每一个属性累加
        for(int i = 0; i<5; i++){
            HPper += arts[i].HP_bp;
            HPnum += arts[i].HP_bn;
            ATK_bper += arts[i].ATK_bp;
            ATK_bnum += arts[i].ATK_bn;
            DEF_bper += arts[i].DEF_bp;
            DEF_bnum += arts[i].DEF_bn;
            EM += arts[i].EM;
            CR += arts[i].CR_R;
            CD += arts[i].CR_D;
            REC += arts[i].Rec;
            ELE_bonus += arts[i].ELE_bonus;
        }

        //计算面板生命值 圣遗物生命百分比 + 小生命 + 武器提供生命
        hp_bonusSPC = BasicHP*HPper + HPnum + BasicHP*wep.HPbonus;

        //计算攻击力数值
        float netATK = BasicATK + wep.BasicATK;
        atk_bonusSPC += netATK*ATK_bper + ATK_bnum + netATK*wep.ATKbonus;

        //计算防御，先不算了防御不重要
        //......

        //计算元素精通
        ele_mastery += EM;

        //计算充能不重要不算了
        //......

        //计算暴击爆伤
        crit_rate += CR + wep.CRIT_Ratebonus + BasicCRIT_Rate;
        crit_dmg += CD + wep.CRIT_DMGbonus + BasicCRIT_DMG;

        //计算元素伤害加成
        ele_bonus += ELE_bonus;
    }

    public void TestOutput(){
        System.out.println("Name: " + name);
        System.out.println("atk: " +(BasicATK + wep.BasicATK + atk_bonusSPC));
        System.out.println("HP: " + (BasicHP + hp_bonusSPC) );
        System.out.println("element masteray: " + ele_mastery);
        System.out.println("CRIT_RATE: " + crit_rate);
        System.out.println("CRIT_DMG: " + crit_dmg);
        System.out.println("pyro bonus: " + ele_bonus);


    }
}
