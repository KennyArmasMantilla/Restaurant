
package Interfaces;
import restaurant.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class Usuario extends javax.swing.JFrame {

    Conexion conectar=new Conexion();
    Connection con=conectar.getConnection() ;
    
    public Usuario() {
        initComponents();
        setLocationRelativeTo(null);
        leer();
        limpiar();
        bloquear();
    }

    void limpiar()
    {
        nombre.setText("");
        ApePaterno.setText("");
        ApeMaterno.setText("");
        Telefono.setText("");
        DNI.setText("");
       
    }
    void mostrartabla(){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("telefono");
        Tabla.setModel(modelo);
        
        String sql="select * from cliente";
        
        String datos[]=new String[5];
        try 
        {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);

                modelo.addRow(datos);
            }          
            Tabla.setModel(modelo);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
    
    public void leer()
    {
        Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
        {
        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            if(Tabla.getSelectedRow()!=-1)
            {
                int fila=Tabla.getSelectedRow();       
                DNI.setText(Tabla.getValueAt(fila, 0).toString());
                nombre.setText(Tabla.getValueAt(fila, 1).toString());
                ApePaterno.setText(Tabla.getValueAt(fila,2).toString());
                ApeMaterno.setText(Tabla.getValueAt(fila,3).toString());
                Telefono.setText(Tabla.getValueAt(fila,4).toString());
                 desbloquear();
            }     
        }
        });
        
        
    }
     
    void bloquear()
    {
        nombre.setEnabled(false);
        ApePaterno.setEnabled(false);
        ApeMaterno.setEnabled(false);
        Telefono.setEnabled(false);
        DNI.setEnabled(false);        
    }
    
    void desbloquear()
    {
        nombre.setEnabled(true);
        ApePaterno.setEnabled(true);
        ApeMaterno.setEnabled(true);
        Telefono.setEnabled(true);
        DNI.setEnabled(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        ApePaterno = new javax.swing.JTextField();
        ApeMaterno = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        DNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Mostrar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        botonbuscar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Elimnar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jButton7.setText("Realizar Pedido");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 53, -1, -1));

        jLabel3.setText("Apellido Paterno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 89, -1, -1));

        jLabel4.setText("Apellido Materno");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 130, -1, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 121, -1));

        ApePaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApePaternoActionPerformed(evt);
            }
        });
        getContentPane().add(ApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 86, 121, -1));
        getContentPane().add(ApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 127, 121, -1));
        getContentPane().add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 168, 121, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stock_lock-open.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 164));

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 101, -1));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 101, -1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 520, 110));

        DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNIActionPerformed(evt);
            }
        });
        getContentPane().add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 199, 121, -1));

        jLabel1.setText("Telefono");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 171, -1, -1));

        jLabel10.setText("DNI");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 202, 80, -1));

        Mostrar.setText("Mostrar");
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 101, -1));

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 101, -1));

        Atras.setText("Atras");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 101, -1));
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 30));

        botonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.jpg"))); // NOI18N
        botonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 30, 30));

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 100, -1));

        Elimnar.setText("Eliminar");
        Elimnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElimnarActionPerformed(evt);
            }
        });
        getContentPane().add(Elimnar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 100, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/noooi2jas3i.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 610, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApePaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApePaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApePaternoActionPerformed

    private void DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DNIActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
     
               
    }//GEN-LAST:event_jButton7ActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        desbloquear();
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
     
        String nombreUsuario, ApellidoPA, ApellidoMa, TelefonoUsuario, Dni;
        
        
        nombreUsuario = nombre.getText();
        ApellidoPA = ApePaterno.getText();
        ApellidoMa = ApeMaterno.getText();
        TelefonoUsuario = Telefono.getText();
        Dni=DNI.getText();
        
        try {
            PreparedStatement pps=con.prepareStatement ("INSERT INTO cliente (idCliente,Nombre,ApePaterno,ApeMaterno,telefono) VALUES (?,?,?,?,?);");
            
            pps.setString(1,Dni);
            pps.setString(2,nombreUsuario);
            pps.setString(3,ApellidoPA);
            pps.setString(4,ApellidoMa);
            pps.setString(5,TelefonoUsuario);
            
                
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"DATOS INSERTADOS");
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"FALTA LLENAR DATOS");
        }
     bloquear();
    }//GEN-LAST:event_guardarActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
       
      mostrartabla();
      
    }//GEN-LAST:event_MostrarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
        bloquear();
    }//GEN-LAST:event_CancelarActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
       Principal nuevo=new Principal();
       nuevo.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_AtrasActionPerformed

    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
        try {

            String n1=buscar.getText();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM cliente where idCliente='"+n1+"';");
            ResultSet rs =ps.executeQuery();
            ResultSetMetaData rsm =rs.getMetaData();
            ArrayList<String[]> data= new ArrayList<>();
            while(rs.next()){
                String[] rows=new String[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i]=rs.getString(i+1);

                } data.add(rows);
            }

            DefaultTableModel dtm=(DefaultTableModel)this.Tabla.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_botonbuscarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
       try {
            
            String sql="UPDATE cliente SET idCliente=?,"
                    + "nombre=?,"
                    +"ApePaterno=?,"
                +"ApeMaterno=?,"
                +"telefono=?"
              
               +" WHERE IDCliente='"+DNI.getText()+"'";
           
                 PreparedStatement ppr=con.prepareStatement(sql);
                 ppr.setString(1,DNI.getText());
                  ppr.setString(2,nombre.getText());
                   ppr.setString(3,ApePaterno.getText());
                    ppr.setString(4,ApeMaterno.getText());
                     ppr.setString(5,Telefono.getText());
                       
                       int n=ppr.executeUpdate();
                       if(n>0){
                       
                       JOptionPane.showMessageDialog(null,"SEA ACTUALIZO LOS DATOS");
                       
                       }
                       
                       
                    } catch (SQLException ex) {
            Logger.getLogger(Camarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void ElimnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElimnarActionPerformed
        
        int fila=Tabla.getSelectedRow();
        String valor=Tabla.getValueAt(fila, 0).toString();
        if(fila>=0)
        {
            
            try {
                PreparedStatement ps=con.prepareStatement("DELETE from cliente WHERE idCliente='"+valor+"';");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DATO ELIMINADO");
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_ElimnarActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JTextField ApeMaterno;
    private javax.swing.JTextField ApePaterno;
    private javax.swing.JButton Atras;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField DNI;
    private javax.swing.JButton Elimnar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton botonbuscar;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo;
    // End of variables declaration//GEN-END:variables
}
