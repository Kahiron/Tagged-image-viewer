package taggedimageviewer;

import java.io.IOException;
import java.net.MalformedURLException;

public class TaggedImageViewer {
    static WindowFrame frame;
    static WindowComponent view;
    static ImageMaster im;
    public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
        im = new ImageMaster();
        view = new WindowComponent(im);
        frame = new WindowFrame(view);
        
        while(true){
            Thread.sleep(30);
            if (frame.hasFocus()){
                if (frame.resized()){
                    frame.updateSize();
                    view.update();
                }
                view.draw();
            }
        }
    }
}