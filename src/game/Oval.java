package game;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

class Oval implements Icon {
  private int width, height;
  public Oval(int wid, int ht) {
    width = wid;
    height = ht;
  }
  public void paintIcon(Component container, Graphics g,
      int p, int q) {
    g.drawOval(p, q, width - 1, height - 1);
  }
  public int getIconWidth() {
    return width;
  }
  public int getIconHeight() {
    return height;
  }
}