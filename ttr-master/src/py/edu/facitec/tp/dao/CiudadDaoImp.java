/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.tp.model.Ciudad;
import py.edu.facitec.tp.util.ConexionManager;

/**
 *
 * @author brother
 */
public class CiudadDaoImp implements CiudadDao{

    @Override
    public void agregarCiudad(Ciudad ciudad) {
        String sql = "insert into ciudades (nombre, iso, estado) "
                + "values('"+ciudad.getNombre()+"', '"+ciudad.getIso()+"', "+ciudad.isEstado()+")";
    
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
    
    }
//carga la lista de ciudades
   

    @Override
    public Vector<Ciudad> agregaCiudad() {
        String sql = "select  codigo, nombre from ciudades";
        
        Vector<Ciudad> listaCiudad= new Vector<Ciudad>();
        
        Ciudad ciu = null;
        
        ConexionManager.conectar();
        
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("ejecuntando sql de combobox "+ sql);
            while (rs.next()) {
                ciu = new Ciudad();
                ciu.setCodigo(rs.getInt("codigo"));
                ciu.setNombre(rs.getString("nombre"));
                listaCiudad.add(ciu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
            
          ConexionManager.desconectar();
          
          return listaCiudad;
    }

    @Override
    public boolean alterarCiudad(Ciudad ciudad) {
        String sql = "update ciudades set nombre='"+ciudad.getNombre()+"', "
                + "iso='"+ciudad.getIso()+"', estado="+ciudad.isEstado()+" where codigo = "+ciudad.getCodigo()+"";
        
        boolean resultado = false;
        ConexionManager.conectar();
        
        try {
           resultado =  ConexionManager.stm.execute(sql);
            System.out.println("ejecutando"+sql);
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        return resultado;
                
    }

    @Override
    public Ciudad buscarCiudadPorCodigo(int codigo) {
         String sql = "select nombre, iso, estado from ciudades where codigo="+codigo+"";
         
         ConexionManager.conectar();
         
         Ciudad ciudad = null;
         
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("ejecutando query "+sql);
            if (rs.next()) {
                ciudad = new Ciudad();
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setIso(rs.getString("iso"));
                ciudad.setEstado(rs.getBoolean("estado"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return ciudad;
    }

    @Override
    public void eliminarCiudad(int codigo) {
        String sql = "DELETE from ciudades where codigo= "+codigo+";";
        
        System.out.print("SQL =" +sql);
        
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
            System.out.println("ejecutando "+ sql);
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error" +sql);
        }
        ConexionManager.desconectar();
        
    }


    
    
    
}
