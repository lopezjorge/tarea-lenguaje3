/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.tp.model.Servicio;
import py.edu.facitec.tp.util.ConexionManager;

/**
 *
 * @author brother
 */
public class ServicioDaoImp implements ServicioDao{

    @Override
    public void agregarServicio(Servicio servicio) {
        String sql = "insert into servicios (nombre, descripcion, valor_unitario, estado) "
                + "values ('"+servicio.getNombre()+"', '"+servicio.getDescripcion()+"', "
                + ""+servicio.getValor_unitario()+", "+servicio.isEstado()+")";
    //conectar
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //desconectar
        ConexionManager.desconectar();
    
    }
    
}
