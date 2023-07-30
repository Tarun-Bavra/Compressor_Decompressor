package AppFrame;
import Comp_Decomp.Decompressor;
import Comp_Decomp.Compressor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
JButton CompressButton;
JButton DecompressButton;
AppFrame()
{
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CompressButton = new JButton("Select File to Compress");
    CompressButton.setBounds(50,100 ,200,30);
    CompressButton.addActionListener(this);

    DecompressButton = new JButton("Select File to Decompress");
    DecompressButton.setBounds(850,100,200,30);
    DecompressButton.addActionListener(this);

    this.setVisible(true);
    this.setSize(1000,500);
    this.setLayout(null);
    this.setTitle("Compress or Decompress Your File");
    this.getContentPane().setBackground(Color.orange);
    this.add(CompressButton);
    this.add(DecompressButton);

}

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==CompressButton) {
            JFileChooser filechooser= new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }

        }
        if(e.getSource()==DecompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }

}


