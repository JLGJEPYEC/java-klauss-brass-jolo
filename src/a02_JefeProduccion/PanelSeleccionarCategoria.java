/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a02_JefeProduccion;

import static a02_JefeProduccion.PrincipalJefeProduccion.panelPrincipal;
import b_metodos_conexion.extraccion_tablas;
import b_modelos.categorias_prod;
import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PanelSeleccionarCategoria extends javax.swing.JPanel {
     extraccion_tablas et = new extraccion_tablas();
     private ArrayList<categorias_prod> lista_cp = new ArrayList<categorias_prod>();
    public String getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(String idProduccion) {
        this.idProduccion = idProduccion;
    }
    private String idProduccion;
    /**
     * Creates new form PanelSeleccionarCategoria
     */
    public PanelSeleccionarCategoria() {
        initComponents();
        lista_cp=et.categorias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("Seleccionar Categoria");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Categoria", "Nombre Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jButton2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       extraccion_tablas et = new extraccion_tablas();
       //este metodo extrae el id de la fila seleccionada en la tabla mostrada aqui
       String filaSeleccionada = et.FilaSeleccionadaID(jTable1.getSelectedRow(),"idCategoria","categoria");
       //se modifica el texto estatico para no desaparecer el objeto creado
       PanelPreparar.textoCatSeleccionada =filaSeleccionada;
       /*principal jefe produccion actualmente tiene abierto dentro del panel principal
       al jpanel invocado desde los botones del lado
       OSEA, EL PRINCIPAL
       esto evita que al panelprincipal se le agregue un objeto nuevo
       deshaciendo todos los cambios efectuados
       */
       PrincipalJefeProduccion.pn.setSize(500,500);
       PrincipalJefeProduccion.pn.setLocation(10,10);     
        panelPrincipal.removeAll();
        //aqui se evidencia que se quiere volver a mostar el jpanel ya abierto anteriormente
        panelPrincipal.add(PrincipalJefeProduccion.pn,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        int n= lista_cp.size();
        String [][] arreglo = new String [n][5];
        for (int i = 0; i < n; i++) {
            arreglo[i][0]=String.valueOf(lista_cp.get(i).getId_categoria());
            arreglo[i][1]=lista_cp.get(i).getNombre_cat();
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            arreglo,
            new String [] {
        "ID Categoria", "Nombre Categoria"
    }
        ));
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
