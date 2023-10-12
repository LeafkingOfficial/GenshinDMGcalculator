package UI;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import impl.Characters;

import impl.ArtifactManager;
import impl.Artifacts;
import impl.BonusManager;
import impl.Calculator;
import impl.BonusManager;

import impl.ArtifactManager;

import java.awt.GridBagConstraints;;

public class UIFrame{

    class SwitchButton extends Button{
        public int ConnectArtPlace;
        public Panel connectPanel;
        public SwitchButton anotherButton;
        public SwitchButton(String ButtonName, int CAP, Panel CNP){
            super(ButtonName);
            this.ConnectArtPlace = CAP;
            this.connectPanel = CNP;
        }
    }
    
    class ImageCanvas extends Panel{
        private BufferedImage img;
        
        public ImageCanvas(){
            try {
                img = ImageIO.read(new File("pimon.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(img,0,-220,680,780, this);
        }
    }
    
    //储存当前对应角色
    public Characters chara;

    //新建frame
    private Frame fr = new Frame();

    private Panel condition = new Panel();

    //新建用于存放buff的panel
    private Panel buff = new Panel();

    //用于存放圣遗物的类型
    private Panel artifact = new Panel();

    //设置用于存放伤害的panel
    private Panel dmgPanel = new Panel();

    //设置布局
    private GridBagLayout gbl = new GridBagLayout();

    //设置全局信息panel
    private GridBagConstraints gbcALL = new GridBagConstraints();

    //设置容器Frame
    private GridBagConstraints gbc = new GridBagConstraints();

    //设置Panel容器
    private GridBagConstraints gbcp = new GridBagConstraints();

    //Bonus的容器格式设置
    private GridBagConstraints gbcb = new GridBagConstraints();

    //伤害的容器格式设置
    private GridBagConstraints gbcd = new GridBagConstraints();

    //设置圣遗物容器
    private GridBagConstraints gbca = new GridBagConstraints();

    private GridBagConstraints gbcartpack = new GridBagConstraints();

    private boolean ifOpen_art = false;

    private Panel frArt = new Panel();

    private ImageCanvas BonusPanel;

    private BonusManager bonusManager;

    private ArtifactManager manager;

    private TextField currentDmgField;

    private Color transp = new Color(255, 255, 255, 64);


    private void addMain(Component comp){
        gbl.setConstraints(comp, gbcALL);
        fr.add(comp);
    }
    private void addcomp(Component comp){
        gbl.setConstraints(comp, gbc);
        condition.add(comp);
    }
    private void addcomppanel(Component comp){
        gbl.setConstraints(comp, gbcp);
        buff.add(comp);
    }
    public void addarti(Component comp){
        gbl.setConstraints(comp, gbcartpack);
        artifact.add(comp);
    }
    public void addbon(Component comp){
        gbl.setConstraints(comp, gbcb);
        BonusPanel.add(comp);
    }
    public void adddmg(Component comp){
        gbl.setConstraints(comp, gbcd);
        dmgPanel.add(comp);
    }

    public void renewCharaCondition(ArtifactManager manager, BonusManager bmanager){
        gbcALL.fill = GridBagConstraints.BOTH;

        //先重置角色数值
        chara.reset();

        //更新角色的圣遗物
        chara.arts = manager.getCurrentArts();

        //更新圣遗物增益
        chara.ArtsCalculator(chara.BasicATK, chara.BasicHP, chara.wep);

        //更新其他buff增益
        bmanager.renewBonus(chara);


        fr.remove(condition);
        charaCondition(chara);

        gbcALL.gridx = 0;
        gbcALL.gridy = 0;
        gbcALL.gridheight = 1;
        addMain(condition);
        condition.validate();
        fr.validate();
    }

    public void charaCondition(Characters chara){

        //刷新condition
        condition = new Panel();
        condition.setLayout(gbl);

        //填充区域
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;

        //设置名字
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        TextField text = new TextField(chara.name);
        text.setEditable(false);
        text.setBackground(transp);
        addcomp(text);


        //设置一个用于存放buff的panel
        buff = new Panel();
        buff.setLayout(gbl);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 6;
        gbc.gridwidth = 1;
        addcomp(buff);

        //设置基础数据
        
        //设置生命值
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        TextField texthp = new TextField("生命值:" + (chara.BasicHP + chara.hp_bonusSPC));
        texthp.setEditable(false);
        addcomp(texthp);
        
        //设置攻击力
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        TextField textatk = new TextField("攻击力:" + (chara.BasicATK + chara.wep.BasicATK + chara.atk_bonusSPC));
        textatk.setEditable(false);
        addcomp(textatk);

        //设置元素精通
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        TextField textEM = new TextField("元素精通:" + ((int)chara.ele_mastery));
        textEM.setEditable(false);
        addcomp(textEM);

        //设置元素伤害加成
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        TextField textEINC = new TextField("元素伤害加成:" + (chara.ele_bonus*100) + "%");
        textEINC.setEditable(false);
        addcomp(textEINC);

        //设置暴击
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        TextField textCRIT_Rate = new TextField("暴击率:" + (chara.crit_rate)*100 + "%");
        textCRIT_Rate.setEditable(false);
        addcomp(textCRIT_Rate);

        //设置爆伤
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        TextField textCRIT_DMG = new TextField("暴击伤害:" + (chara.crit_dmg)*100 + "%");
        textCRIT_DMG.setEditable(false);
        addcomp(textCRIT_DMG);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 5;
        gbc.gridwidth = 1;
        TextArea Buffshow = new TextArea("当前获得增益效果");
        Buffshow.setEditable(false);
        addcomppanel(Buffshow);        
    }

    public void init(Characters chara) throws IOException{
        this.chara = chara;
        //设置布局
        fr.setLayout(gbl);


        manager = new ArtifactManager();
        //设置菜单栏
        menu(chara);

        

        //设置角色状态栏
        condition.setLayout(gbl);
        charaCondition(chara);
        gbcALL.gridx = 0;
        gbcALL.gridy = 0;
        gbcALL.gridheight = 1;

        addMain(condition);

        //设置buff栏
        gbcALL.gridx = 0;
        gbcALL.gridy = 1;
        gbcALL.gridheight = 1;
        BonusManager b = new BonusManager();
        bonusManager = b;
        Panel bonusPanel =  BonusUI(b);
        addMain(bonusPanel);
        fr.validate();
        
        fr.pack();
        fr.setVisible(true);

        //窗口关闭设置
        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };

        fr.addWindowListener(windowListener);

        //test

    }

    public void menu(Characters chara){
        MenuBar mb = new MenuBar();
        Menu m1 = new Menu("装备");
        Menu m2 = new Menu("增益");
        mb.add(m1);
        mb.add(m2);

        MenuItem mi1 = new MenuItem("圣遗物");
        MenuItem mi2 = new MenuItem("武器");
        m1.add(mi1);
        m1.add(mi2);
        m1.addSeparator();
        fr.setMenuBar(mb);
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(e);
                try {
                    if(!ifOpen_art){
                        frArt = ArtifactUI(chara);
                        gbcALL.gridx = 1;
                        gbcALL.gridy = 0;
                        gbcALL.gridheight = 3;
                        addMain(frArt);
                        fr.validate();
                        fr.pack();
                        ifOpen_art = true;
                    }else{
                        fr.remove(frArt);
                        fr.validate();
                        fr.pack();
                        ifOpen_art = false;
                    }

                } catch (IOException e1) {
                    System.out.println("NOT");
                    e1.printStackTrace();
                }
            }
        };

        mi1.addActionListener(listener);
        

    }

    private Panel CreateArtBlock(LinkedList<Artifacts> artsList, int index){
        Artifacts art = artsList.get(index);

        Panel ArtifactBlock = new Panel();
        ArtifactBlock.setLayout(gbl);
        gbca.fill = GridBagConstraints.BOTH;
        gbca.weightx = 1;
        gbca.weighty = 1;


        // gbca.gridx = 0;
        // gbca.gridy = 0;
        // gbca.gridwidth = 1;
        // gbca.gridheight = 1;
        // TextField head = new TextField("ID:" + Integer.toString(art.artID));
        // gbl.setConstraints(head,gbca);
        // head.setEditable(false);
        // ArtifactBlock.add(head);

        gbca.gridwidth = GridBagConstraints.REMAINDER;
        gbca.gridx = 1;
        gbca.gridy = 0;
        gbca.gridwidth = 1;
        gbca.gridheight = 1;
        TextField head1 = new TextField(art.place+"/" + art.suit + art.artID);
        head1.setFont(new Font("bold", 1, 12));
        
        gbl.setConstraints(head1,gbca);
        head1.setEditable(false);
        ArtifactBlock.add(head1);
        
        gbca.gridx = 0;
        gbca.gridy = 1;
        gbca.gridwidth = 2;

        

        //添加词条
        if(art.ATK_bn!=0){
            TextField t = new TextField("\n攻击力:" + art.ATK_bn); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.ATK_bp!=0){
            TextField t = new TextField("\n攻击力百分比:" + art.ATK_bp*100 + "%"); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.CR_D!=0){
            TextField t = new TextField("\n暴击伤害:" + art.CR_D*100 + "%"); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.CR_R!=0){
            TextField t = new TextField("\n暴击率:" + art.CR_R*100 + "%"); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.DEF_bn!=0){
            TextField t = new TextField("\n防御力:" + art.DEF_bn); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.DEF_bp!=0){
            TextField t = new TextField("\n防御力百分比:" + art.DEF_bp*100 + "%"); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.ELE_bonus!=0){
            TextField t = new TextField("\n元素伤害加成:" + art.ELE_bonus); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.EM!=0){
            TextField t = new TextField("\n元素精通:" + art.EM); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.HP_bn!=0){
            TextField t = new TextField( "\n生命值:" + art.HP_bn); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.HP_bp!=0){
            TextField t = new TextField( "\n生命值百分比:" + art.HP_bp*100 + "%"); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        if(art.Rec!=0){
            TextField t = new TextField( "\n充能效率:" + art.Rec*100 + "%"); 
            gbl.setConstraints(t,gbca);
            t.setEditable(false);
            ArtifactBlock.add(t);
            gbca.gridy++;
        }
        
        return ArtifactBlock;
    }

    public Panel ArtifactUI(Characters chara) throws IOException{
        this.chara = chara;
        artifact.setLayout(gbl);

        //这里是为了在打开界面时刷新一下角色属性
        renewCharaCondition(manager, bonusManager);

        gbcartpack.insets = new Insets(5, 5, 5, 5);

        //创建五个panel用于储存圣遗物数据
        Panel[] panelList = new Panel[5];
        for(int i = 0; i < 5; i++ ){
            panelList[i] = CreateArtBlock(manager.ArtifactsListSet[i], manager.seletedArt[i]);
        }

        gbcartpack.weightx = 0;
        gbcartpack.weighty = 0;
        gbcartpack.gridx = 0;
        gbcartpack.gridy = 0;
        gbcartpack.gridwidth = 2;
        gbcartpack.gridheight = 1;
        //gbcartpack.fill = GridBagConstraints.BOTH;
        //gbcartpack.gridwidth = GridBagConstraints.REMAINDER;

        SwitchButton[] bts = new SwitchButton[10];
        
        for(int i = 0; i<5; i++){

            //创建按钮
            bts[i*2] = new SwitchButton("previous", i, panelList[i]);
            bts[i*2+1] = new SwitchButton("next", i, panelList[i]);

            //绑定双生Button md这个bug de了我起码两三个小时气死我了
            bts[i*2].anotherButton = bts[i*2+1];
            bts[i*2+1].anotherButton = bts[i*2];


            //将圣遗物panel添加到圣遗物展示界面
            gbcartpack.gridwidth = 2;
            gbcartpack.gridx = 0;
            gbcartpack.fill = GridBagConstraints.BOTH;
            gbcartpack.gridy = i*2;
            addarti(panelList[i]);

            gbcartpack.fill = GridBagConstraints.HORIZONTAL;
            //添加按钮到圣遗物展示
            gbcartpack.gridwidth = 1;
            gbcartpack.gridy = i*2 + 1;
            addarti(bts[i*2]);
            gbcartpack.gridx = 1;
            addarti(bts[i*2+1]);
        }

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SwitchButton b = (SwitchButton)e.getSource();
                int placeInt = b.ConnectArtPlace;
                if(e.getActionCommand().equals("next")){

                    //如果某一部位的List中还有下一个圣遗物
                    if(manager.ArtifactsListSet[placeInt].size() > manager.seletedArt[placeInt]+1){
                        
                        //Manager选择下一个圣遗物
                        manager.seletedArt[placeInt]++;

                        //移除原来的Panel
                        artifact.remove(b.connectPanel);
                        

                        //创建新的圣遗物表格
                        Panel newPanel = CreateArtBlock(manager.ArtifactsListSet[placeInt],manager.seletedArt[placeInt]);
                        b.connectPanel = newPanel;
                        b.anotherButton.connectPanel = newPanel; //绑定双生button的下一个

                        //设置添加格式
                        gbcartpack.weightx = 0;
                        gbcartpack.weighty = 0;
                        gbcartpack.gridx = 0;
                        gbcartpack.gridy = placeInt*2;
                        gbcartpack.gridwidth = 2;
                        gbcartpack.gridheight = 1;


                        System.out.println("更新下一个圣遗物");
                        //添加新的panel
                        addarti(newPanel);

                        //按钮刷新---------------------------------------------------------------------

                        artifact.validate();
                        fr.validate();
                        renewCharaCondition(manager,bonusManager);
                    }
                }
                if(e.getActionCommand().equals("previous")){
                    
                    //如果某一部位的List中还有上一个圣遗物
                    if(manager.seletedArt[placeInt]>0){
                        
                        //Manager选择上一个圣遗物
                        manager.seletedArt[placeInt]--;

                        //移除原来的Panel
                        artifact.remove(b.connectPanel);
                        

                        //创建新的圣遗物表格
                        Panel newPanel = CreateArtBlock(manager.ArtifactsListSet[placeInt],manager.seletedArt[placeInt]);

                        b.connectPanel = newPanel;
                        b.anotherButton.connectPanel = newPanel; //绑定双生button的下一个

                        //设置添加格式
                        gbcartpack.weightx = 0;
                        gbcartpack.weighty = 0;
                        gbcartpack.gridx = 0;
                        gbcartpack.gridy = placeInt*2;
                        gbcartpack.gridwidth = 2;
                        gbcartpack.gridheight = 1;


                        System.out.println("更新上一个圣遗物");
                        //添加新的panel
                        addarti(newPanel);

                        //按钮刷新---------------------------------------------------------------------
                        artifact.validate();
                        fr.validate();
                        renewCharaCondition(manager,bonusManager);
                    }
            }
            //输出当前选择的圣遗物id
            manager.outputCurrentArt();
            }
        };

        //给所有的bts绑定事件监听
        for(int i = 0; i<10; i++){
            bts[i].addActionListener(listener);
        }

        return artifact;


        
    }

    public Panel BonusUI(BonusManager bmanager){
        BonusPanel = new ImageCanvas();
        BonusPanel.setLayout(gbl);
        BonusPanel.setBackground(transp);

        gbcb.fill = GridBagConstraints.HORIZONTAL;

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                System.out.println("Selected");

                Checkbox name = (Checkbox)(e.getItemSelectable());
                bmanager.bonusAdder(chara, name.getLabel());
            }
        };
        

        //设置共鸣效果
        Label lb1 = new Label("共鸣加成：");
        lb1.setFont(new Font("b", 2, 12));
        lb1.setBackground(null);
        addbon(lb1);
        for(int i = 0; i < bmanager.bonusListTeam.length; i++){
            gbcb.gridy = i+1;
            Checkbox cb = new Checkbox(bmanager.bonusListTeam[i]);
            cb.addItemListener(itemListener);
            cb.setBackground(null);
            addbon(cb);
        }
        
        //设置队友效果
        gbcb.gridx = 1;
        gbcb.gridy = 0;
        Label lb2 = new Label("队友加成");
        lb2.setFont(new Font("b", 2, 12));
        addbon(lb2);

        
        for(int i = 0; i < bmanager.bonusTeamSkills.length; i++){
            gbcb.gridy = i+1;
            Checkbox cb = new Checkbox(bmanager.bonusTeamSkills[i]);
            cb.addItemListener(itemListener);
            cb.setBackground(null);
            addbon(cb);
        }


        //设置角色天赋
        gbcb.gridx = 4;
        gbcb.gridy = 0;
        Label lb4 = new Label("角色/武器技能");
        lb4.setFont(new Font("b", 2, 12));
        addbon(lb4);
        for(int i = 0; i < bmanager.charaSkills.length; i++){
            gbcb.gridy = i+1;
            Checkbox cb = new Checkbox(bmanager.charaSkills[i]);
            cb.addItemListener(itemListener);
            cb.setBackground(null);
            addbon(cb);
        }

        //设置食物
        gbcb.gridx = 5;
        gbcb.gridy = 0;
        Label lb5 = new Label("食物");
        lb5.setFont(new Font("b", 2, 12));
        addbon(lb5);
        for(int i = 0; i < bmanager.foods.length; i++){
            gbcb.gridy = i+1;
            Checkbox cb = new Checkbox(bmanager.foods[i]);
            cb.addItemListener(itemListener);
            cb.setBackground(null);
            addbon(cb);
        }

        //设置圣遗物二件套效果
        gbcb.gridx = 6;
        gbcb.gridy = 0;
        Label lb6 = new Label("圣遗物二件套");
        lb6.setFont(new Font("b", 2, 12));
        addbon(lb6);
        for(int i = 0; i < bmanager.artifact.length; i++){
            gbcb.gridy = i+1;
            Checkbox cb = new Checkbox(bmanager.artifact[i]);
            cb.addItemListener(itemListener);
            cb.setBackground(null);
            addbon(cb);
        }

        gbcb.gridx = 2;
        gbcb.gridy = 0;
        //设置需要输入的队友参数
        Label lb3 = new Label("队友参数");
        lb3.setFont(new Font("b", 2, 12));
        addbon(lb3);
        Label[] lb = new Label[6];
        lb[0] = new Label("砂糖精通");
        lb[1] = new Label( "万叶精通");
        lb[2] = new Label("班尼特攻击力");
        lb[3] = new Label("反应系数");

        lb[4] = new Label("敌人等级");
        lb[5] = new Label("敌人抗性");


        TextField[] enterTexts = new TextField[6];
        enterTexts[0] = new TextField("917");
        enterTexts[1] = new TextField("974");
        enterTexts[2] = new TextField("799");
        enterTexts[3] = new TextField("1.5");
        enterTexts[4] = new TextField("90");
        enterTexts[5] = new TextField("0.1");


        for(int i = 0; i<3; i++){
            gbcb.gridy = i+1;
            gbcb.gridx = 2;
            addbon(lb[i]);
            gbcb.gridx = 3;
            addbon(enterTexts[i]);
        }

        //反应系数框、敌人等级、敌人抗性
        gbcb.gridy = 8;
        gbcb.gridx = 2;
        addbon(lb[3]);
        gbcb.gridx = 3;
        addbon(enterTexts[3]);

        gbcb.gridy = 9;
        gbcb.gridx = 2;
        addbon(lb[4]);
        gbcb.gridx = 3;
        addbon(enterTexts[4]);

        gbcb.gridy = 10;
        gbcb.gridx = 2;
        addbon(lb[5]);
        gbcb.gridx = 3;
        addbon(enterTexts[5]);


        //设置点击按钮更新出伤害
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String sucroseEM = enterTexts[0].getText();
                String KasuhaEM = enterTexts[1].getText();
                String BannitATK = enterTexts[2].getText();
                String reac = enterTexts[3].getText();
                String Level = enterTexts[4].getText();
                String Resis = enterTexts[5].getText();

                bmanager.SucroseEM =  Integer.parseInt(sucroseEM);
                bmanager.KasuhaEM = Integer.parseInt(KasuhaEM);
                bmanager.BannitATK = Integer.parseInt(BannitATK);
                float reaction = Float.parseFloat(reac);
                float Levelf = Float.parseFloat(Level);
                float Resisf = Float.parseFloat(Resis);

                renewCharaCondition(manager, bmanager);
                DmgUI(reaction, Levelf, Resisf);

            }
        };
        //设置更新按钮
        gbcb.gridx = 6;
        gbcb.gridy = 8;
        Button chectbutton = new Button("Check");
        chectbutton.addActionListener(listener);
        addbon(chectbutton);
        
        BonusPanel.setVisible(true);
        return BonusPanel;


    }

    public void  DmgUI(float reaction, float level, float Resis){
        if(dmgPanel != null) fr.remove(dmgPanel);

        dmgPanel = new Panel();
        dmgPanel.setLayout(gbl);

        Label lb1 = new Label("60级散兵伤害");
        Label lb2 = new Label("敌人受到伤害");
        lb2.setFont(new Font("L", 1, 12));
        
        //创建散兵的伤害
        float sbDMG = Calculator.DmgCalculate(chara, -1.4f, reaction, 0, 60);
        TextField t1 = new TextField(String.valueOf(sbDMG));

        //创建小怪的伤害
        System.out.println("....抗性为"+Resis);
        float xgDMG = Calculator.DmgCalculate(chara, Resis, reaction, 0, level);
        TextField t2 = new TextField(String.valueOf(xgDMG));
        t2.setFont(new Font("B", 1, 12));
        t2.setForeground(Color.red);



        gbcd.fill = GridBagConstraints.REMAINDER;
        gbcd.gridx = 0;
        gbcd.gridy = 0;
        adddmg(lb1);
        gbcd.gridx = 1;
        adddmg(t1);
        gbcd.gridx = 0;
        gbcd.gridy = 1;
        adddmg(lb2);
        gbcd.gridx = 1;
        adddmg(t2);

        gbcALL.gridx = 0;
        gbcALL.gridy = 2;
        addMain(dmgPanel);
        fr.validate();
        fr.pack();
    }
}
