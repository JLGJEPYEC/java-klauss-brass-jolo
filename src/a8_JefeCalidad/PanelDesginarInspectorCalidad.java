/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
TERCER CASO DE USO IMPORTANTE DEL SISTEMA - 
PROCESO DE NEGOCIO: GESTION DE REQUERIMIENTOS DEL CLIENTE
*/
package a8_JefeCalidad;
import static a8_JefeCalidad.PrincipalJefeCalidad.panelPrincipal;
import b_modelos.criteriosDeCalidad;
import java.awt.BorderLayout;
/**
 *
 * @author juan-jolo
 */
public class PanelDesginarInspectorCalidad extends javax.swing.JPanel {
    public static String IDProduccionJC ="";
    public static String IDInspectorJC = "";
    /**
     * Creates new form PanelDesginarInspectorCalidad
     */
    public PanelDesginarInspectorCalidad() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextoIDP = new javax.swing.JTextField();
        TextoI = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        SeleccionarProduccionJC = new javax.swing.JButton();
        SeleccionarInspectorJC = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("Designar inspector de calidad");

        jLabel2.setText("ID Produccion");

        jLabel3.setText("Inspector");

        jButton1.setText("Desginar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SeleccionarProduccionJC.setText("Seleccionar produccion");
        SeleccionarProduccionJC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarProduccionJCActionPerformed(evt);
            }
        });

        SeleccionarInspectorJC.setText("Seleccionar inspector");
        SeleccionarInspectorJC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarInspectorJCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextoIDP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SeleccionarProduccionJC, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextoI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SeleccionarInspectorJC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextoIDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarProduccionJC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarInspectorJC))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarProduccionJCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarProduccionJCActionPerformed
       PanelSeleccionarProduccion pn = new PanelSeleccionarProduccion();
       pn.setSize(600,600);
       pn.setLocation(10,10);
       panelPrincipal.removeAll();
       panelPrincipal.add(pn,BorderLayout.CENTER);
       panelPrincipal.revalidate();
       panelPrincipal.repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarProduccionJCActionPerformed

    private void SeleccionarInspectorJCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarInspectorJCActionPerformed
       PanelSeleccionarInspectorJC pn = new PanelSeleccionarInspectorJC();
       pn.setSize(600,600);
       pn.setLocation(10,10);
       panelPrincipal.removeAll();
       panelPrincipal.add(pn,BorderLayout.CENTER);
       panelPrincipal.revalidate();
       panelPrincipal.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarInspectorJCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //acciones que ejecuta el boton tal cual
        
        int numInspector = Integer.parseInt(TextoI.getText());
        int numIDProduccion = Integer.parseInt(TextoIDP.getText());
        criteriosDeCalidad cc = new criteriosDeCalidad(numInspector,numIDProduccion);
        cc.modificarBBDD_IDI();
        //reestruccturacion del jpanel
       panelPrincipal.removeAll();
       panelPrincipal.revalidate();
       panelPrincipal.repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    //ANTES DE MOSTRARSE EL JPANEL, SE HARÁN AJUSTES
    //ESTE METODO SIRVE PARA ESO
    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        TextoI.setText(IDInspectorJC);
        TextoIDP.setText(IDProduccionJC);
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SeleccionarInspectorJC;
    private javax.swing.JButton SeleccionarProduccionJC;
    private javax.swing.JTextField TextoI;
    private javax.swing.JTextField TextoIDP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
