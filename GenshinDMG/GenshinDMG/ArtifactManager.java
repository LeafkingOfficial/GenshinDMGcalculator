package GenshinDMG;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ArtifactManager {

    public int[] seletedArt  = {0,0,0,0,0};
    private String place;
    private String suit;
    private float ATK_bp;
    private float ATK_bn;
    private float HP_bp;
    private float HP_bn;
    private float DEF_bp;
    private float DEF_bn;
    private float EM;
    private float Rec;
    private float CR_R;
    private float CR_D;
    private float ELE_bonus;
    private int artID;
    public Artifacts[] arts;
    protected int MAXIMUM_ARTIFACTS = 50;

    public LinkedList<Artifacts> flower = new LinkedList<Artifacts>();
    public LinkedList<Artifacts> plumes = new LinkedList<Artifacts>();
    public LinkedList<Artifacts> sands = new LinkedList<Artifacts>();
    public LinkedList<Artifacts> goblet = new LinkedList<Artifacts>();
    public LinkedList<Artifacts> circlet = new LinkedList<Artifacts>();
    
    public LinkedList<Artifacts>[] ArtifactsListSet;

    public ArtifactManager() throws IOException{
        arts = new Artifacts[MAXIMUM_ARTIFACTS];
        readInfo();
        classification();
        ArtifactsListSet = new LinkedList[5];
        ArtifactsListSet[0] = flower;
        ArtifactsListSet[1] = plumes;  
        ArtifactsListSet[2] = sands;  
        ArtifactsListSet[3] = goblet;  
        ArtifactsListSet[4] = circlet;  
    }
    
    public void outputCurrentArt(){
        System.out.println("当前选择的圣遗物:");
        for(int i = 0; i<5; i++){
            System.out.print(seletedArt[i] + "|");
        }
    }
    //用于读取圣遗物数据，储存在art[]中，
    private void readInfo() throws IOException{
        File file = new File("Artifacts.txt");
        Scanner scanner = new Scanner(new FileReader(file));
        
        //读取所有文件中的圣遗物
        while(scanner.hasNextLine()){
            scanner.next();
            artID = scanner.nextInt();
            scanner.next();
            place = scanner.next();
            scanner.next();
            suit = scanner.next();
            scanner.next();
            ATK_bp = scanner.nextFloat();
            scanner.next();
            ATK_bn = scanner.nextFloat();
            scanner.next();
            HP_bp = scanner.nextFloat();
            scanner.next();
            HP_bn = scanner.nextFloat();
            scanner.next();
            DEF_bp = scanner.nextFloat();
            scanner.next();
            DEF_bn = scanner.nextFloat();
            scanner.next();
            EM = scanner.nextFloat();
            scanner.next();
            Rec = scanner.nextFloat();
            scanner.next();
            CR_R = scanner.nextFloat();
            scanner.next();
            CR_D = scanner.nextFloat();
            scanner.next();
            ELE_bonus = scanner.nextFloat();
            scanner.nextLine();
            arts[artID] = new Artifacts(place, suit, ATK_bp, ATK_bn, HP_bp, HP_bn, DEF_bp, DEF_bn, EM, Rec, CR_R, CR_D, ELE_bonus, artID);
        }
        scanner.close();
    }

    public void SaveInfo(Artifacts art) throws IOException{
        File file = new File("ArtifactsSAVE.txt");
        FileWriter wrt = new FileWriter(file,true);

        wrt.write("artID " + art.artID);
        wrt.write("\nplace " + art.place);
        wrt.write("\nsuit" + art.suit);
        wrt.write("\nATK_bonus_percentage " + art.ATK_bp);
        wrt.write("\nATK_bonus_number " + art.ATK_bn);
        wrt.write("\nHP_bonus_percentage " + art.HP_bp);
        wrt.write("\nHP_bonus_number " + HP_bn);
        wrt.write("\nDefence_bonus_percentage "+ art.DEF_bp);
        wrt.write("\nDefence_bonus_number " + art.DEF_bn);
        wrt.write("\nElement_Mastary " + art.EM);
        wrt.write("\nEnergy_Recharge " + art.Rec);
        wrt.write("\nCRIT_Rate " + art.CR_R);
        wrt.write("\nCRIT_damage " + art.CR_D);
        wrt.write("\nELE_bonus " + art.ELE_bonus);
        wrt.write("\n");
        wrt.write("\n");
        wrt.flush();
        wrt.close();
    }

    private void classification(){
        int i = 0;
        while(arts[i] != null){
            switch (arts[i].place){
                case "flower": 
                    flower.add(arts[i]);
                    break;
                case "plume":
                    plumes.add(arts[i]);
                    break;
                case "sands":
                    sands.add(arts[i]);
                    break;
                case "goblet":
                    goblet.add(arts[i]);
                    break;
                case "circlet":
                    circlet.add(arts[i]);
                    break;
            }
            i++;
        }
    }

    public Artifacts[] getCurrentArts(){
        Artifacts currentArts[] = new Artifacts[5];
        //i代表的是位置
        for(int i = 0; i<5; i++){
            currentArts[i] = ArtifactsListSet[i].get(seletedArt[i]);
        }
        return currentArts;
    }
}
