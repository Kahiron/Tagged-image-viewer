package taggedimageviewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Integer.max;
import java.util.ArrayList;

public class WindowComponent extends Component{
    Graphics g;
    ImageMaster im;
    int index = 0;
    
    
    BufferedImage window;
    int sideLoad = 10;
    ArrayList<BufferedImage> loaded;
    
    public WindowComponent(ImageMaster im) throws IOException {
        this.im = im;
        loaded = new ArrayList<BufferedImage>();
        
        setSize(800, 600);
        setVisible(true);
        setBackground(new Color(0xff181818));
        load();
    }
    
    public void load() throws IOException{
        while(sideLoad < loaded.size())
            loaded.remove(loaded.size() - 1);
        while(sideLoad > loaded.size())
            loaded.add(null);
        for (int i = index; i < sideLoad; i++) {
            if (i < im.actual.size()) {
                loaded.set(i - index, im.actual.get(i).getImage()); 
            }
            else
                loaded.set(i - index, null);        //draw nothing
            
        }
        System.out.println("done loading");
    }
    
    public void draw(){
        getGraphics().drawImage(window, 0, 0, this);
    }
    
    public void update() throws IOException{
        window = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        g = window.getGraphics();
        g.setColor(new Color(0x181818));
        g.fillRect(0, 0, window.getWidth(), window.getHeight());
        BufferedImage main = loaded.get(0);
        int x = ( main.getWidth() * (getWidth()/3 - 20))/max(main.getHeight(), main.getWidth());
        int y = (main.getHeight() * (getWidth()/3 - 20))/max(main.getHeight(), main.getWidth());
        Image image = main.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        g.setColor(Color.black);
        g.fillRect(20, 20, getWidth()/3 - 20, getWidth()/3 - 20);
        if (loaded.get(index) != null){
            g.drawImage(image, 20 + (max(x,y)-x)/2 , 20 + (max(x,y)-y)/2, this);
        }
        //g.drawRect(20, 20, getWidth()/3 - 20, getWidth()/3 - 20);
    }
}