package UI;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class ImageCanvas extends Frame{
    private BufferedImage img;
    
    public ImageCanvas() throws IOException{;
        img = ImageIO.read(new File("pimon.jpg"));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(img,0,0,200,200, this);
    }
}