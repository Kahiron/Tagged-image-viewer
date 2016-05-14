package taggedimageviewer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ImageMaster {
    String directory;
    
    ArrayList<ImageID> content;
    ArrayList<ImageID> actual;
    
    ImageMaster() throws MalformedURLException, IOException{
        directory = "D:\\Övrigt\\Favourites";
        content = new ArrayList<>();
        File dir;
        dir = new File(directory);
        //int counter = 0;
        File files[] = dir.listFiles();
        //int loadProgress = 0;
        for(File entry : files){
            //counter++;
            content.add(new ImageID(directory + "/" + entry.getName()));
            //loadProgress = counter / files.length * 100;
        }
    actual = content;
    }
}
