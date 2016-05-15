package taggedimageviewer;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowFrame extends Frame implements KeyListener, WindowListener, MouseListener, MouseMotionListener{
    WindowComponent view;
    Graphics g;
    int lastWidth, lastHeight;
    
    public WindowFrame(WindowComponent view) throws IOException{
        this.view = view;
        setSize(800, 600);
        addWindowListener(this);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        add(this.view);
        setBackground(new Color(0xff181818));
        setVisible(true);
        view.update();
        view.draw();
        updateSize();
    }
    
    public boolean resized(){
        return lastWidth != getWidth() || lastHeight != getHeight();
    }
    
    public void updateSize(){
        lastWidth = getWidth();
        lastHeight = getHeight();
        view.updateSize();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyChar()){
            default :   System.out.println("Unsupported key.");        
        }
    }

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void windowOpened(WindowEvent e){
    }

    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowIconified(WindowEvent e){
        System.out.println("window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e){}

    @Override
    public void windowActivated(WindowEvent e){
        System.out.println("activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e){}

    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("mouse clicked");
        try {
            view.update();
        } catch (IOException ex){
            Logger.getLogger(WindowFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.draw();
    }

    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e){
        System.out.println("dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e){}
}
