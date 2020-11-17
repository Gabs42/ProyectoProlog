/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author Gabriel
 */
public class Tablero extends javax.swing.JFrame {
    private ArrayList<Carta> manoA; 
    private ArrayList<Carta> manoB; 
    private ArrayList<Carta>  palletesA = new ArrayList<Carta>();
    private ArrayList<Carta>  palletesB = new ArrayList<Carta>();
    private int selectedIndex = -1;
    private Carta selectedCard = new Carta("","");
    private int cardWidth = 120;
    private int cardHeight = 160;

    public Tablero( ArrayList<Carta> manoAn, ArrayList<Carta> manoBn,Carta palleteAn,Carta palleteBn) {
        this.manoA = manoAn;
        this.manoB = manoBn;
        this.palletesA.add(palleteAn);
        this.palletesB.add(palleteBn);
        initComponents();
        int counter = 1;
        while(counter!=8){
            String source = "ImagenesProyecto/" +manoA.get(counter-1).getColor()+manoA.get(counter-1).getNumero()+".png";
            ImageIcon icon = new ImageIcon(source);
            Image image = icon.getImage();
            image  = image.getScaledInstance(cardWidth,cardHeight,java.awt.Image.SCALE_SMOOTH);
            icon  = new ImageIcon(image);
            manoA.get(counter-1).setIcon(icon);
            counter++;
            
        }
        counter = 1;
        while(counter!=8){
            String source = "ImagenesProyecto/" +manoB.get(counter-1).getColor()+manoB.get(counter-1).getNumero()+".png";
            ImageIcon icon = new ImageIcon(source);
            Image image = icon.getImage();
            image  = image.getScaledInstance(cardWidth,cardHeight,java.awt.Image.SCALE_SMOOTH);
            icon  = new ImageIcon(image);
            manoB.get(counter-1).setIcon(icon);
            counter++;
            
        }
        String source = "ImagenesProyecto/" +this.palletesA.get(0).getColor()+this.palletesA.get(0).getNumero()+".png";
        ImageIcon icon = new ImageIcon(source);
        Image image = icon.getImage();
        image  = image.getScaledInstance(cardWidth,cardHeight,java.awt.Image.SCALE_SMOOTH);
        icon  = new ImageIcon(image);
        this.palleteA.setIcon(icon);
        this.palleteA.setText("");
        String sourceB = "ImagenesProyecto/" +this.palletesB.get(0).getColor()+this.palletesB.get(0).getNumero()+".png";
        ImageIcon iconB = new ImageIcon(sourceB);
        Image imageB = iconB.getImage();
        imageB  = imageB.getScaledInstance(cardWidth,cardHeight,java.awt.Image.SCALE_SMOOTH);
        iconB  = new ImageIcon(imageB);
        this.palleteB.setIcon(iconB);
        this.palleteB.setText("");
        
        String sourceStart = "ImagenesProyecto/" +"Start7"+ ".png";
        ImageIcon iconStart = new ImageIcon(sourceStart);
        Image imageStart = iconStart.getImage();
        imageStart  = imageStart.getScaledInstance(cardWidth,cardHeight,java.awt.Image.SCALE_SMOOTH);
        iconStart  = new ImageIcon(imageStart);
        this.start.setIcon(iconStart);
        this.start.setText("");
        
        this.carta1.setIcon(manoA.get(0).getIcon());
        this.carta1.setText("");
        this.carta2.setIcon(manoA.get(1).getIcon());
        this.carta2.setText("");
        this.carta3.setText("");
        this.carta3.setIcon(manoA.get(2).getIcon());
        this.carta4.setText("");
        this.carta4.setIcon(manoA.get(3).getIcon());
        this.carta5.setText("");
        this.carta5.setIcon(manoA.get(4).getIcon());
        this.carta6.setText("");
        this.carta6.setIcon(manoA.get(5).getIcon());
        this.carta7.setText("");
        this.carta7.setIcon(manoA.get(6).getIcon());
        
        this.carta8.setIcon(manoB.get(0).getIcon());
        this.carta8.setText("");
        this.carta9.setIcon(manoB.get(1).getIcon());
        this.carta9.setText("");
        this.carta10.setText("");
        this.carta10.setIcon(manoB.get(2).getIcon());
        this.carta11.setText("");
        this.carta11.setIcon(manoB.get(3).getIcon());
        this.carta12.setText("");
        this.carta12.setIcon(manoB.get(4).getIcon());
        this.carta13.setText("");
        this.carta13.setIcon(manoB.get(5).getIcon());
        this.carta14.setText("");
        this.carta14.setIcon(manoB.get(6).getIcon());
        
        
        this.carta1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(0);
                selectedIndex = 0;
            }
        });
        this.carta2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(1);
                selectedIndex = 1;
            }
        });
        this.carta3.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(2);
                selectedIndex = 2;
            }
        });
        this.carta4.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(3);
                selectedIndex = 3;
            }
        });
        this.carta5.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(4);
                selectedIndex = 4;
            }
        });
        this.carta6.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(5);
                selectedIndex = 5;
            }
        });
        this.carta7.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedCard = manoA.get(6);
                selectedIndex = 6;
            }
        });
        
        
        this.canvasButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!selectedCard.getColor().equals("")){
                    start.setIcon(selectedCard.getIcon());
                    selectedCard = new Carta("","");
                    switch(selectedIndex){
                        case 0:
                            System.out.println("Test");
                            carta1.setVisible(false);
                            break;
                        case 1:
                            carta2.setVisible(false);
                            break;
                        case 2:
                            carta3.setVisible(false);
                            break;
                        case 3:
                            carta4.setVisible(false);
                            break;
                        case 4:
                            carta5.setVisible(false);
                            break;
                        case 5:
                            carta6.setVisible(false);
                            break;
                        case 6:
                            carta7.setVisible(false);
                            break;
                         
                    }
                }
                
            }
        });
        this.palleteButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!selectedCard.getColor().equals("")){
                    palletesA.add(selectedCard);
                    palleteA.setIcon(selectedCard.getIcon());
                    selectedCard = new Carta("","");
                    switch(selectedIndex){
                        case 0:
                            carta1.setVisible(false);
                            break;
                        case 1:
                            carta2.setVisible(false);
                            break;
                        case 2:
                            carta3.setVisible(false);
                            break;
                        case 3:
                            carta4.setVisible(false);
                            break;
                        case 4:
                            carta5.setVisible(false);
                            break;
                        case 5:
                            carta6.setVisible(false);
                            break;
                        case 6:
                            carta7.setVisible(false);
                            break;
                         
                    }
                }
                
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta1 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JLabel();
        carta6 = new javax.swing.JLabel();
        carta7 = new javax.swing.JLabel();
        carta8 = new javax.swing.JLabel();
        carta9 = new javax.swing.JLabel();
        carta10 = new javax.swing.JLabel();
        carta11 = new javax.swing.JLabel();
        carta12 = new javax.swing.JLabel();
        carta13 = new javax.swing.JLabel();
        carta14 = new javax.swing.JLabel();
        palleteA = new javax.swing.JLabel();
        palleteB = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        canvasButton = new javax.swing.JButton();
        palleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carta1.setText("Carta1");

        carta2.setText("Carta1");

        carta3.setText("Carta1");

        carta4.setText("Carta1");

        carta5.setText("Carta1");

        carta6.setText("Carta1");

        carta7.setText("Carta1");

        carta8.setText("Carta1");

        carta9.setText("Carta1");

        carta10.setText("Carta1");

        carta11.setText("Carta1");

        carta12.setText("Carta1");

        carta13.setText("Carta1");

        carta14.setText("Carta1");

        palleteA.setText("palleteA");

        palleteB.setText("palleteB");

        start.setText("Start");

        canvasButton.setText("Jugar Carta Seleccionada al canvas");

        palleteButton.setText("Jugar Carta Seleccionada al pallete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(carta8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carta9)
                            .addComponent(palleteA))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(palleteB)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carta10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carta11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(start, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(carta12)
                                .addGap(18, 18, 18)
                                .addComponent(carta13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carta14))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(canvasButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(palleteButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(carta1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta3)
                            .addGap(14, 14, 14)
                            .addComponent(carta4)
                            .addGap(18, 18, 18)
                            .addComponent(carta5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(carta6)
                            .addGap(18, 18, 18)
                            .addComponent(carta7))))
                .addContainerGap(515, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carta14)
                    .addComponent(carta8)
                    .addComponent(carta9)
                    .addComponent(carta10)
                    .addComponent(carta11)
                    .addComponent(carta12)
                    .addComponent(carta13))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start)
                    .addComponent(palleteB)
                    .addComponent(palleteA))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carta1)
                    .addComponent(carta2)
                    .addComponent(carta3)
                    .addComponent(carta4)
                    .addComponent(carta5)
                    .addComponent(carta6)
                    .addComponent(carta7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(canvasButton)
                    .addComponent(palleteButton))
                .addContainerGap(477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canvasButton;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta10;
    private javax.swing.JLabel carta11;
    private javax.swing.JLabel carta12;
    private javax.swing.JLabel carta13;
    private javax.swing.JLabel carta14;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.JLabel carta6;
    private javax.swing.JLabel carta7;
    private javax.swing.JLabel carta8;
    private javax.swing.JLabel carta9;
    private javax.swing.JLabel palleteA;
    private javax.swing.JLabel palleteB;
    private javax.swing.JButton palleteButton;
    private javax.swing.JLabel start;
    // End of variables declaration//GEN-END:variables
}
