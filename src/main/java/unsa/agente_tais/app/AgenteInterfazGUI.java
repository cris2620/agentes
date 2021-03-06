/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsa.agente_tais.app;

import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Christian
 */
public class AgenteInterfazGUI extends javax.swing.JFrame {

    private GuiAgent sender;
    private int edad;
    private int grado;
    
    public final int MSJ_ENVIAR = 0;
    
    public AgenteInterfazGUI(GuiAgent sender, int edad, int grado) {
        initComponents();
        this.sender = sender;
        this.edad = edad;
        this.grado = grado;
        ImageIcon ii = new ImageIcon("src/imgs/pinguino1.gif");
        lbl_agent.setIcon(ii);
        ii.setImageObserver(lbl_agent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbl_agent = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbtn_rpt2 = new javax.swing.JRadioButton();
        rbtn_rpt3 = new javax.swing.JRadioButton();
        rbtn_rpt1 = new javax.swing.JRadioButton();
        rbtn_rpt4 = new javax.swing.JRadioButton();
        btn_MarRes1 = new javax.swing.JButton();
        btn_MarRes2 = new javax.swing.JButton();
        btn_MarRes3 = new javax.swing.JButton();
        btn_MarRes4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agente Pedagogico");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cuestionario #");

        jScrollPane1.setEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Si un perro llamado Boby esta amarrado a una cuerda que esta atada a una \nestaca en medio de un parque, la cuerda mide 100m, ¿Boby podra alcanzar \nun hueso a 200m de el?");
        jScrollPane1.setViewportView(jTextArea1);

        lbl_agent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rbtn_rpt2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtn_rpt2.setText("No podra Alcanzar el hueso");

        rbtn_rpt3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtn_rpt3.setText("No se puede espesificar");

        rbtn_rpt1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtn_rpt1.setText("Podra Alcanzar el hueso");

        rbtn_rpt4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtn_rpt4.setText("Ninguna de las Anteriores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rbtn_rpt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rbtn_rpt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rbtn_rpt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rbtn_rpt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rbtn_rpt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtn_rpt2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtn_rpt3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtn_rpt4))
        );

        btn_MarRes1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_MarRes1.setText("Ayuda");
        btn_MarRes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MarRes1ActionPerformed(evt);
            }
        });

        btn_MarRes2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_MarRes2.setText("Ver Respuesta");
        btn_MarRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MarRes2ActionPerformed(evt);
            }
        });

        btn_MarRes3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_MarRes3.setText("Ver Grafico!");
        btn_MarRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MarRes3ActionPerformed(evt);
            }
        });

        btn_MarRes4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_MarRes4.setText("Marcar Respuesta");
        btn_MarRes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MarRes4ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Tiempo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("00 00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_MarRes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_MarRes4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_MarRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_MarRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(lbl_agent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_agent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_MarRes1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(btn_MarRes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_MarRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_MarRes4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_MarRes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MarRes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MarRes1ActionPerformed

    private void btn_MarRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MarRes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MarRes2ActionPerformed

    private void btn_MarRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MarRes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MarRes3ActionPerformed

    private void btn_MarRes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MarRes4ActionPerformed
        GuiEvent ge = new GuiEvent(this, MSJ_ENVIAR);
        ge.addParameter("Yanahuara");
        sender.postGuiEvent(ge);
    }//GEN-LAST:event_btn_MarRes4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MarRes1;
    private javax.swing.JButton btn_MarRes2;
    private javax.swing.JButton btn_MarRes3;
    private javax.swing.JButton btn_MarRes4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbl_agent;
    private javax.swing.JRadioButton rbtn_rpt1;
    private javax.swing.JRadioButton rbtn_rpt2;
    private javax.swing.JRadioButton rbtn_rpt3;
    private javax.swing.JRadioButton rbtn_rpt4;
    // End of variables declaration//GEN-END:variables
}
