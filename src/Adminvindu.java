 import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.Date;

 public class Adminvindu extends JPanel implements Serializable {
 private static final long serialVersionUID = -6455247982999758395L;
 Kulturhus k;
 Personregister pr;
 Lokalvindu lokalV;
 Arrangementvindu arrangementV;
 Kontaktvindu kontaktV;
 
	
public Adminvindu( Kulturhus hus,Personregister reg)
   {
     super(new GridLayout(1, 1));

    JTabbedPane tabbedPane = new JTabbedPane();
    
    k = hus;
	pr = reg;
	lokalV = new Lokalvindu(k);
	arrangementV = new Arrangementvindu(k,pr);
	kontaktV = new Kontaktvindu(pr);
	

    tabbedPane.addTab("Administrer lokaler", null, lokalV, "Her kan du fikse alt som har med lokaler å gjøre");
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    tabbedPane.addTab("Administrer arrangementer", null, arrangementV,
             "Erre her det er party!?");
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

    tabbedPane.addTab("Administrer kontaktpersoner", null, kontaktV, "Partyfikserne må lagres");
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

    JComponent panel4 = makeTextPanel("Her vil billett-greier havne");
    tabbedPane.addTab("Billettregister", null, panel4, "Kommer snart");
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

    tabbedPane.setPreferredSize(new Dimension(900, 600));
    add(tabbedPane);
   }
	
   protected JComponent makeTextPanel(String text)
   {
     JPanel panel = new JPanel(false);
     JLabel filler = new JLabel(text);
     filler.setHorizontalAlignment(JLabel.CENTER);
     panel.setLayout(new GridLayout(1, 1));
     panel.add(filler);
     return panel;
   }
    /**
     * Create the GUI and show it.
     */
    public void createAndShowGUI()
    {
      //Create and set up the window.
      JFrame frame = new JFrame("Kulturhuset " + k.get_Navn());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Adminvindu(k,pr), BorderLayout.CENTER);
      
      frame.addWindowListener(new WindowAdapter()
      {
          public void windowClosing(WindowEvent e)
          {
        	  pr.lagrePersonregister();
        	  k.lagreLokaler();
          }
      });
 
      //Display the window.
      frame.pack();
      frame.setVisible(true);
    }
 }
