 import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

 public class Adminvindu extends JPanel {
 private static final long serialVersionUID = 1L;
 
	
public Adminvindu()
   {
     super(new GridLayout(1, 1));
     

     JTabbedPane tabbedPane = new JTabbedPane();
     Kulturhus k = new Kulturhus("Testhuset","Dette kulturhuset er laget som en test");

     
     
     
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	//////////////////////ALT UNDER KUN FOR TESTING////////////////////////
	/*Lokale l = new Kino("Testkino","Dette er en kinosal opprettet for å teste","Testefilm");
	Lokale l1 = new Konferanse("Testkonferansesal","Dette er en test","Testearrangement",2);
	Lokale l2 = new Konferanse("Testkonferansesal2","Dette er en test2","Testearrangement2",50);
	Lokale l3 = new Cafe("Testkonferansesal2","Dette er en test2",50);
	Kontaktperson kontakt = new Kontaktperson("Partyfiksern Geir","hallis@hollis.no","99999999");
	//Arrangement a = new Arrangement("Testarrangement",kontakt,"17-05-2015 20:30");
	//Arrangement kinoA = new Arrangement("Kinoarrangement",kontakt,"17-05-2015 20:30");
	Billett b = new Billett("fornavn","etternavn","epost","tlf");
	Billett b2 = new Billett("fornavn","etternavn","epost","tlf");
	Billett b3 = new Billett("fornavn","etternavn","epost","tlf");
	k.leggTilLokale(l);
	k.leggTilLokale(l1);
	k.leggTilLokale(l2);
	k.leggTilLokale(l3);
	//l.leggTilArrangement(kinoA);
	k.leggTilKontaktperson(kontakt);
	*/
    Lokalvindu lk = new Lokalvindu(k);
    Arrangementvindu av = new Arrangementvindu(k);
     

	/////////////////////////ALT OVER KUN FOR TESTING /////////////////////////	
	//////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	     


     tabbedPane.addTab("Administrer lokaler", null, lk, "Does nothing");
     tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

     tabbedPane.addTab("Administrer arrangementer", null, av,
             "Does twice as much nothing");
     tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

     JComponent panel3 = makeTextPanel("Panel #3");
     tabbedPane.addTab("Tab 3", null, panel3, "Still does nothing");
     tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

     JComponent panel4 = makeTextPanel(
             "Panel #4 (has a preferred size of 410 x 50).");
     panel4.setPreferredSize(new Dimension(820, 500));
     tabbedPane.addTab("Tab 4", null, panel4, "Does nothing at all");
     tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

     tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

     //Add the tabbed pane to this panel.
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
      JFrame frame = new JFrame("TabbedPaneDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Adminvindu(), BorderLayout.CENTER);
 
      //Display the window.
      frame.pack();
      frame.setVisible(true);
    }
 }
