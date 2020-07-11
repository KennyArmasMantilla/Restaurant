/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import Interfaces.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author GUILLERMO
 */
public class mesa {
    
    String idmesa;
    String Ubicacion;
    String CantComensales;
    Conexion conectar=new Conexion();
    Connection con=conectar.getConnection() ;

    public mesa(String idmesa) {
       
        this.idmesa= idmesa;
    }
    
   
  
    public mesa(){};
    

    public String getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(String idmesa) {
        this.idmesa = idmesa;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getCantComensales() {
        return CantComensales;
    }

    public void setCantComensales(String CantComensales) {
        this.CantComensales = CantComensales;
    }
    
     public void cargarmesa(JComboBox box){
     try {
            DefaultComboBoxModel value;
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select idMesa from mesa");
             value =new DefaultComboBoxModel();
             box.setModel(value);
             while(rs.next()){
              value.addElement(new mesa(rs.getString(1)));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
         }
     
 
    
    }
     
     
     
     
public String toString(){
return this.idmesa;
}

    
}
