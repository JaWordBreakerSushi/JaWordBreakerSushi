package game;

import java.awt.*;
import java.io.*;

import javax.swing.*;

public class ImagePanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;

  Image bgimage = null;
  String _url;
  int _width;
  int _height;

  public ImagePanel(String url) {
	  _url = url;
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
    _width = bgimage.getWidth(null);
    _height = bgimage.getHeight(null);
    g.drawImage(bgimage, 1, 1, _width, _height, null);
  }

  
  /*Getters and Setters*/
	public String get_url() {
		return _url;
	}
	
	public void set_url(String url) {
		_url = url;
	}
	
	public int get_width() {
		return _width;
	}
	
	public void set_width(int width) {
		_width = width;
	}
	
	public int get_height() {
		return _height;
	}
	
	public void set_height(int height) {
		_height = height;
	}
}