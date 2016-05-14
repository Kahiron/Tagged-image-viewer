package taggedimageviewer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ImageID {
    ArrayList<String> tags;
    String fileName;
    
    
    ImageID(String filePath){
        fileName = filePath;
        System.out.println(fileName);
        
        String tagString = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length() - 5).toLowerCase();
        tags = new ArrayList<>();
        
        while (!tagString.equals("") && !tagString.equals(" ")){
            int nextBreak = tagString.indexOf(" ");
            if (nextBreak == -1){
                tags.add(tagString);
                break;
            }
            if (nextBreak == 0)
                break;
            tags.add(tagString.substring(0, nextBreak - 1));
            tagString = tagString.substring(nextBreak + 1, tagString.length() -1);
        }
    }

    public ArrayList<String> getTags() {
        return tags;
    }
    
    public BufferedImage getImage() throws IOException{
        return ImageIO.read(new File(fileName));
    }
    
}
