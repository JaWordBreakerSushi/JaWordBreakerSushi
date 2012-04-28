package game;

import java.awt.event.*;


class GameKeyListener extends KeyAdapter implements KeyListener {
	    /** Handle the key typed event from the text field. */
	    public void gameKeyTyped(KeyEvent e) {
	      System.out.print("TYPED");
	      displayInfo(e, "KEY TYPED: ");
	    }
	
	    /** Handle the key pressed event from the text field. */
	    public void gameKeyPressed(KeyEvent e) {
	    	System.out.print("PRESSED");
	      displayInfo(e, "KEY PRESSED: ");
	    }
	
	    /** Handle the key released event from the text field. */
	    public void gameKeyReleased(KeyEvent e) {
	    	System.out.print("RELEASED");
	      displayInfo(e, "KEY RELEASED: ");
	    }
	
	    protected void displayInfo(KeyEvent e, String s) {
	      String keyString, modString, tmpString, actionString, locationString;
	
	      // You should only rely on the key char if the event
	      // is a key typed event.
	      int id = e.getID();
	      if (id == KeyEvent.KEY_TYPED) {
	        char c = e.getKeyChar();
	        keyString = "key character = '" + c + "'";
	      } else {
	        int keyCode = e.getKeyCode();
	        keyString = "key code = " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")";
	      }
	
	      int modifiers = e.getModifiersEx();
	      modString = "modifiers = " + modifiers;
	      tmpString = KeyEvent.getModifiersExText(modifiers);
	      if (tmpString.length() > 0) {
	        modString += " (" + tmpString + ")";
	      } else {
	        modString += " (no modifiers)";
	      }
	
	      actionString = "action key? ";
	      if (e.isActionKey()) {
	        actionString += "YES";
	      } else {
	        actionString += "NO";
	      }
	
	      locationString = "key location: ";
	      int location = e.getKeyLocation();
	      if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	        locationString += "standard";
	      } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	        locationString += "left";
	      } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	        locationString += "right";
	      } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	        locationString += "numpad";
	      } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	        locationString += "unknown";
	      }
	
	      System.out.println(keyString);
	      System.out.println(modString);
	      System.out.println(actionString);
	      System.out.println(locationString);
	    }
	
}



