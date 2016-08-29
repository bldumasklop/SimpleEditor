//Simple Editor
//Brendan Dumas-Klop

package simple.editor;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.*;

/**
 *
 * @author Brendan
 */
public class SimpleEditor extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public SimpleEditor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userText = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSave = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuUndo = new javax.swing.JMenuItem();
        menuCut = new javax.swing.JMenuItem(new DefaultEditorKit.CutAction());
        menuCopy = new javax.swing.JMenuItem(new DefaultEditorKit.CopyAction());
        menuPaste = new javax.swing.JMenuItem(new DefaultEditorKit.PasteAction());
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userText.setColumns(20);
        userText.setRows(5);
        userText.getDocument().addUndoableEditListener(undoManager);
        jScrollPane1.setViewportView(userText);

        jMenu1.setText("File");

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setText("Save");
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuSave);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        menuUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuUndo.setText("Undo");
        menuUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUndoActionPerformed(evt);
            }
        });
        jMenu2.add(menuUndo);

        menuCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuCut.setText("Cut");
        menuCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCutActionPerformed(evt);
            }
        });
        jMenu2.add(menuCut);

        menuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuCopy.setText("Copy");
        jMenu2.add(menuCopy);

        menuPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menuPaste.setText("Paste");
        jMenu2.add(menuPaste);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Format");

        jMenuItem1.setText("Background");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Text Color");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    UndoManager undoManager = new UndoManager(); //Instantiating the UndoManager
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
        userText.setBackground(newColor);
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
        userText.setForeground(newColor);
    }                                          

    private void menuCutActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void menuUndoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try
        {
            undoManager.undo();
        }
        catch(Exception e)
        {
            
        }
    }                                        

    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    saveFile();        
        
         
    }                                        

    /**
     * @param args the command line arguments
     */
    
    public void saveFile()
    {
        JFileChooser save = new JFileChooser(); //preparing the file selector
        int option = save.showSaveDialog(this); //bringing up the save window
        File file = new File(save.getSelectedFile().getPath());
        try
        {
            String source = userText.getText(); //getting the user's text for
                                                //the file output
            char buffer[] = new char[source.length()];
            source.getChars(0,source.length(),buffer,0);
            FileWriter f1= new FileWriter(file+".txt"); //writing the file
            for(int i=0;i<buffer.length;i++)
            {
                f1.write(buffer[i]);
            }
        f1.close();

        }
        catch(Exception ae) //catching exceptions
        {
	
        }
    }
    public static void main(String args[]) 
    {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleEditor().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuCopy;
    private javax.swing.JMenuItem menuCut;
    private javax.swing.JMenuItem menuPaste;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JMenuItem menuUndo;
    private javax.swing.JTextArea userText;
    // End of variables declaration                   
}
