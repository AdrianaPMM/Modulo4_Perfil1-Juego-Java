/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;

public class Principal1 extends javax.swing.JFrame {

    Comic comic = new Comic();
    MapaNiveles mapaNiveles = new MapaNiveles();
    Tutorial tutorial = new Tutorial();
    
    Nivel1_Bosque nvl1 = new Nivel1_Bosque();
    Nivel2_Helado nvl2 = new Nivel2_Helado();
    Nivel3_Fuego nvl3 = new Nivel3_Fuego();
    Nivel4_Arena nvl4 = new Nivel4_Arena();
    Nivel5_Nubes nvl5 = new Nivel5_Nubes();
    Nivel6_Galaxia nvl6 = new Nivel6_Galaxia();
    
    private CardLayout cardLayout;
    public Principal1() {
        
        final int originalTileSize = 10;
        final int scale = 5;
        
        final int tileSize = originalTileSize * scale;
        final int maxScreenCol = 26;
        final int maxScreenRow = 13;
        
        final int screenWidth = tileSize * maxScreenCol;
        final int screenHeight = tileSize * maxScreenRow;
        
        //this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        
        this.pack();
        this.requestFocusInWindow();
        
        initComponents();
        //Ponemos cardLayout
        cardLayout = new CardLayout();
        pnlPrincipal.setLayout(cardLayout);
        //Agregamos toooodas los Jpanels al pnlPrincipal
        pnlPrincipal.add(comic, "comic");
        pnlPrincipal.add(tutorial, "tutorial");
        pnlPrincipal.add(mapaNiveles, "mapaNiveles");
        
        pnlPrincipal.add(nvl1, "nvl1");
        pnlPrincipal.add(nvl2, "nvl2");
        pnlPrincipal.add(nvl3, "nvl3");
        pnlPrincipal.add(nvl4, "nvl4");
        pnlPrincipal.add(nvl5, "nvl5");
        pnlPrincipal.add(nvl6, "nvl6");
   
        LeerProgreso();

    }
    
    public void LeerProgreso()
    {
////         try{
////            
////            String query = "Select * From tbProgreso";    
////            PreparedStatement readCorreo = ConexionSQL.getConnection().prepareStatement(query);
////            
////            ResultSet rs = readCorreo.executeQuery();
////            
////            if (rs.next()) {
////                //System.out.println("Hay registros en la tabla");
////                //Si hay algo, es porque ha jugado minimo el tutorial,
////                //Por eso, va directamente al mapa, mostramos, mapa
////                cardLayout.show(pnlPrincipal, "mapaNiveles");
//
////            } else {
//                //System.out.println("No hay registros en la tabla");
//                //Si no hay nada, es que,no ha jugado nada
//                //por eso, iria al comic, y, desde el comic, al tutorial
//                //o sea, el tutorial solo aparece, si es que se vio el comic primero
//                //porque pues, primer udo velda
                cardLayout.show(pnlPrincipal, "comic");
                getBtndeComic(); //Se consigue el btn que esta en el panel de Comic
//                //Y despues, del tutorial, al mapa de nieveles
//
//                
//            }  
//        }catch(Exception e){
//            System.out.println("ERROR en el query: " + e.toString());
//        }
    }
    
    public void getBtndeComic()
    {
        JButton btnSiguiente1 = comic.getBtnSiguiente();
        //aqui digo que, despues de "terminar de leer el comic"
        //osea cuando le de a "siguiente"
        //Muestre la pantalla del tutorial
         btnSiguiente1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlPrincipal, "tutorial");
                tutorial.startGameThread();
                tutorial.requestFocusInWindow();
                 getBtndeTutorial();
            }
        });
    }

    public void getBtndeTutorial()
    {
         //JButton btnSiguiente2 = tutorial.getBtnSiguiente();
          //Mostramos mapa de niveles (cuando se le de clic al btn de Siguiente 2)
          /*btnSiguiente2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlPrincipal, "mapaNiveles");
                
                //y ahora, conseguimos tooodos los btns de los niveles
                getBtnsdeMapaNiveles();
    
            }
        });*/
    }
    
    public void getBtnsdeMapaNiveles()
    {
        JButton btnNvl1 = mapaNiveles.getBtnNvl1();
        JButton btnNvl2 = mapaNiveles.getBtnNvl2();
        JButton btnNvl3 = mapaNiveles.getBtnNvl3();
        JButton btnNvl4 = mapaNiveles.getBtnNvl4();
        JButton btnNvl5 = mapaNiveles.getBtnNvl5();
        JButton btnNvl6 = mapaNiveles.getBtnNvl6();
        
        //y, por ultimo, agregamos el evento "clic" a cada uno
        //osea, le ponemos lo que va a hacer, cuando al boton que 
        //conseguimos antes se le de clic
        
         btnNvl1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlPrincipal, "nvl1");
                   //cuando se le de al btn Del nivel 1, muestre,
                   //el panel del nivel 1, y asi sucesivamente
            }
        });
         
          btnNvl2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlPrincipal, "nvl2");
            }
        });
          
           btnNvl3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlPrincipal, "nvl3");
            }
        });
           
             btnNvl4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnlPrincipal, "nvl4");
            }
        });
             
         btnNvl5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(pnlPrincipal, "nvl5");
        }
        });
         
         btnNvl6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(pnlPrincipal, "nvl6");
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

        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Koa's Adventure");
        setPreferredSize(new java.awt.Dimension(1296, 624));

        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1300, 650));
        pnlPrincipal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
