/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import java.awt.Label;

/**
 *
 * @author abc
 */
public class Nivel2_Helado extends javax.swing.JPanel {

    /**
     * Creates new form NivelHelado
     */
    MovimientoPersonaje movimientoPersonaje;
    Hilos hilos;
    String estPersonaje="ESTATICO";
    public Nivel2_Helado() {
        initComponents();
        movimientoPersonaje = new MovimientoPersonaje(this);
        this.addKeyListener(movimientoPersonaje);
        
        hilos = new Hilos(this);
        hilos.start();
    }
    
    public  void moverFondo(){
        jFondoHielo.setLocation(jFondoHielo.getX()-2,jFondoHielo.getY());
    }
    public  void moverPersonaje(){
        if (estPersonaje.equals("SALTANDO")) {
            jPersonaje.setLocation(jPersonaje.getX(),jPersonaje.getY()-2);
        }
        if (jPersonaje.getY()<150) {
            estPersonaje="ATERRIZANDO";
        }
        if (estPersonaje.equals("ATERRIZANDO")) {
            jPersonaje.setLocation(jPersonaje.getX(),jPersonaje.getY()+2);
        }
        if (jPersonaje.getY()==270) {
            estPersonaje="ESTATICO";
        }
    }
    public  void saltar(){
        estPersonaje="SALTANDO";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPersonaje = new javax.swing.JLabel();
        jFondoHielo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1300, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPersonaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos_img/Jugador.png"))); // NOI18N
        add(jPersonaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 120, 100));

        jFondoHielo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos_img/FondoNivelJuego.png"))); // NOI18N
        add(jFondoHielo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 660));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jFondoHielo;
    private javax.swing.JLabel jPersonaje;
    // End of variables declaration//GEN-END:variables
}
