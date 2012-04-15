package game;

import java.awt.*;
import javax.swing.*;

class ImagePanel extends JPanel {
  Image bgimage = null;

  ImagePanel(String url) {
    MediaTracker mt = new MediaTracker(this);
    bgimage = Toolkit.getDefaultToolkit().getImage(url);
    mt.addImage(bgimage, 0);
    try {
      mt.waitForAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int imgwidth = bgimage.getWidth(null);
    int imgheight = bgimage.getHeight(null);
    g.drawImage(bgimage, 1, 1, imgwidth, imgheight, null);
  }
}