package exemple_1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OK extends Frame {
	
	/**
	 * Main
	 */
    public static void main(String[] argv) {
        OK app = new OK();
        app.setVisible(true);
    } 

    /**
     * Constructor
     */
    public OK() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exit();
            } 
          } );
        add(ok);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            } 
          } );
        pack();
    } 

    /**
     * Exit Application
     */
    void exit() {
        System.exit(0);
    } 
} 
