package GenshinDMG;
import java.io.IOException;;

//这就是用来存数据的
public class Artifacts {
    public String place;
    public String suit;
    public float ATK_bp;
    public float ATK_bn;
    public float HP_bp;
    public float HP_bn;
    public float DEF_bp;
    public float DEF_bn;
    public float EM;
    public float Rec;
    public float CR_R;
    public float CR_D;
    public float ELE_bonus;
    public int artID;

    public Artifacts( String place, String suit, float ATK_bp, float ATK_bn, float HP_bp, float HP_bn, float DEF_bp, 
    float DEF_bn, float EM, float Rec, float CR_R, float CR_D, float ELE_bonus, int artID) throws IOException{
        this.artID = artID;
        this.place = place;
        this.suit = suit;
        this.ATK_bn = ATK_bn;
        this.ATK_bp = ATK_bp;
        this.HP_bn = HP_bn;
        this.HP_bp = HP_bp;
        this.DEF_bn = DEF_bn;
        this.DEF_bp = DEF_bp;
        this.EM = EM;
        this.Rec = Rec;
        this.CR_R = CR_R;
        this.CR_D = CR_D;
        this.ELE_bonus = ELE_bonus;
        //SaveInfo();
        //readInfo();
    }


}
