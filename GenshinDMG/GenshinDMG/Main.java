package GenshinDMG;

import java.awt.Frame;
import java.io.IOException;

import GenshinDMG.Charactersfolder.Hutao;
import GenshinDMG.UI.UIFrame;
import GenshinDMG.Weaponsfolder.Humo;

public class Main {
    static Artifacts art1;
    public static void main(String[] args) throws IOException{
        System.out.println("Creat a new artifact");
        ArtifactManager manager = new ArtifactManager();


        Artifacts[] arts = {manager.arts[1],manager.arts[2],manager.arts[3],manager.arts[4],manager.arts[5]};

        //创建护摩之杖
        Weapon humo = new Humo();

        //创建胡桃
        Characters hutao;

        //初始化胡桃
        hutao = new Hutao(arts, humo);

        //将护摩与胡桃绑定
        humo.character = hutao;

        //叠加护摩被动
        ((Humo) hutao.wep).skill_half();

        //输出面板
        hutao.TestOutput();

        System.out.println("开e后面板: ");
        //((Hutao) hutao).Skill_e();
        
        hutao.TestOutput();

        Artifacts a =  manager.flower.get(0);
        System.out.println(a.artID);

        new UIFrame().init(hutao);
        
    }
}
