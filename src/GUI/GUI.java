/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on Apr 18, 2012, 3:41:56 PM
 */
package GUI;

/**
 *
 * @author atte
 */
public class GUI extends javax.swing.JFrame {

    /** Creates new form GUI */
    public GUI() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jakopakka = new javax.swing.JLayeredPane();
        jakopakka3 = new javax.swing.JLabel();
        jakopakka2 = new javax.swing.JLabel();
        jakopakka1 = new javax.swing.JLabel();
        jakopakka0 = new javax.swing.JLabel();
        Maalipakat = new javax.swing.JLayeredPane();
        Slotti1 = new javax.swing.JLayeredPane();
        Slotti2 = new javax.swing.JLayeredPane();
        Slotti3 = new javax.swing.JLayeredPane();
        Slotti4 = new javax.swing.JLayeredPane();
        Slotti5 = new javax.swing.JLayeredPane();
        Slotti6 = new javax.swing.JLayeredPane();
        Slotti7 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jakopakka3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/c10.png"))); // NOI18N
        jakopakka3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jakopakka3.setName("jakopakka 3"); // NOI18N
        jakopakka3.setBounds(130, 0, 71, 96);
        Jakopakka.add(jakopakka3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jakopakka2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/c10.png"))); // NOI18N
        jakopakka2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jakopakka2.setName("jakopakka 2"); // NOI18N
        jakopakka2.setBounds(110, 0, 71, 96);
        Jakopakka.add(jakopakka2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jakopakka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/c10.png"))); // NOI18N
        jakopakka1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jakopakka1.setName("jakopakka 1"); // NOI18N
        jakopakka1.setBounds(90, 0, 71, 96);
        Jakopakka.add(jakopakka1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jakopakka0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/c10.png"))); // NOI18N
        jakopakka0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jakopakka0.setName("jakopakka 0"); // NOI18N
        jakopakka0.setBounds(0, 0, 71, 96);
        Jakopakka.add(jakopakka0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jakopakka, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(Maalipakat, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Slotti1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Slotti2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Slotti3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Slotti4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Slotti5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Slotti6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Slotti7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jakopakka, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Maalipakat, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Slotti3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slotti2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slotti4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slotti5, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slotti6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slotti7, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(204, Short.MAX_VALUE))
                    .addComponent(Slotti1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void testiMetodi(){
        
    }
    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Jakopakka;
    private javax.swing.JLayeredPane Maalipakat;
    private javax.swing.JLayeredPane Slotti1;
    private javax.swing.JLayeredPane Slotti2;
    private javax.swing.JLayeredPane Slotti3;
    private javax.swing.JLayeredPane Slotti4;
    private javax.swing.JLayeredPane Slotti5;
    private javax.swing.JLayeredPane Slotti6;
    private javax.swing.JLayeredPane Slotti7;
    private javax.swing.JLabel jakopakka0;
    private javax.swing.JLabel jakopakka1;
    private javax.swing.JLabel jakopakka2;
    private javax.swing.JLabel jakopakka3;
    // End of variables declaration//GEN-END:variables
}
