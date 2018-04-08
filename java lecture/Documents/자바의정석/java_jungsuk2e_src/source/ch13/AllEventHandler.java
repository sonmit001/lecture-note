import java.awt.event.*;

class AllEventHandler
          implements ActionListener, ComponentListener, MouseMotionListener, 
           MouseListener, MouseWheelListener, KeyListener, TextListener, 
           FocusListener, ItemListener,  AdjustmentListener, WindowListener, 
           WindowFocusListener, WindowStateListener, ContainerListener 
{
	// ActionListener�� �޼���
	public void actionPerformed(ActionEvent ae) {}

	// ComponentListener�� �޼���
	public void componentMoved(ComponentEvent ae) {}
	public void componentHidden(ComponentEvent ae) {}
	public void componentResized(ComponentEvent ae) {}
	public void componentShown(ComponentEvent ae) {}

	// MouseMotionListener�� �޼���
	public void mouseDragged(MouseEvent me) {}
	public void mouseMoved(MouseEvent me) {}

	// MouseListener�� �޼���
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mouseClicked(MouseEvent me) {}

	// MouseWheelListener�� �޼���
	public void mouseWheelMoved(MouseWheelEvent e) {}
	
	// KeyListener�� �޼���
	public void keyPressed(KeyEvent ke) {}
	public void keyReleased(KeyEvent ke) {}
	public void keyTyped(KeyEvent ke) {}
	
	// TextListener�� �޼���
	public void textValueChanged(TextEvent te) {}
	
	// FocusListener�� �޼���
	public void focusGained(FocusEvent fe) {}
	public void focusLost(FocusEvent fe) {}
	
	// ItemListener�� �޼���
	public void itemStateChanged(ItemEvent ie) {}
	
	// AdjustmentListener�� �޼���
	public void adjustmentValueChanged(AdjustmentEvent ae) {}
	
	// WindowListener�� �޼���
	public void windowClosing(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowClosed(WindowEvent we) {}
	public void windowActivated(WindowEvent we) {}
	public void windowDeactivated(WindowEvent we) {}
	
	// WindowFocusListener�� �޼���
	public void windowGainedFocus(WindowEvent e) {}
	public void windowLostFocus(WindowEvent e) {}
	
	// WindowStateListener�� �޼���
	public void windowStateChanged(WindowEvent e) {}
	
	// ContainerListener�� �޼���
	public void componentAdded(ContainerEvent ce) {}
	public void componentRemoved(ContainerEvent ce) {}
} // End of EventHandler class