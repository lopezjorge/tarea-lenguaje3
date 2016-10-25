/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.tp.model.Cliente;
import py.edu.facitec.tp.util.ConexionManager;

/**
 *
 * @author brother
 */
public class ClienteDaoImp implements ClienteDao {

    @Override
    public void guardar(Cliente cliente) {
        String sql = "insert into clientes(nombres, apellidos, direccion,"
                + " ciudad_codigo, celular, credito, estado) values ('"+cliente.getNombres()+"', '"+cliente.getApellidos()+"', '"+cliente.getDireccion()+"',"
                + " '"+cliente.getCiudad_codigo()+"','"+cliente.getCelular()+"', "+cliente.getCredito()+", "+cliente.isEstado()+") ";
        //conectar
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        
        
    }

    @Override
    public  boolean modificar(Cliente cliente) {
       String sql = "UPDATE public.clientes "
                + "SET nombres='"+cliente.getNombres()+"', apellidos='"+cliente.getApellidos()+"', direccion='"+cliente.getDireccion()+"', "
                + "celular='"+cliente.getCelular()+"', ciudad_codigo= "+cliente.getCiudad_codigo()+", credito="+cliente.getCredito()+", "
                + "estado="+cliente.isEstado()+" "
                + "WHERE codigo="+cliente.getCodigo()+";";
            
                boolean resultado = false;
       
       ConexionManager.conectar();
       


       
        try {
            resultado = ConexionManager.stm.execute(sql);
            System.out.println("Ejecutando el SQL"+sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error tu puto dao no funciona "+ ex);
        }
        System.out.println("estado de salida de resultado " + resultado);
        
        ConexionManager.desconectar();
        
        return resultado;
        
    }

    @Override
    public Cliente buscarClientePorCodigo(int codigo) {
        String sql = "select nombres, apellidos, direccion,ciudad_codigo, celular, credito, estado from clientes where codigo = "+codigo+"";
    
        ConexionManager.conectar();
        
        Cliente cliente = null;
        ResultSet rs;
         
        try {
            rs = ConexionManager.stm.executeQuery(sql);
            
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCiudad_codigo(rs.getInt("ciudad_codigo"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCredito(rs.getDouble("credito"));
                cliente.setEstado(rs.getBoolean("estado"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL"+ex);
        }
        
        ConexionManager.desconectar();
        
        return cliente;
        
    }

    @Override
    public List<Cliente> buscarClientePorParametros(String filtro) {
         
        String sql = "SELECT codigo, nombres, apellidos, direccion, credito "
                + "FROM public.clientes "
                + "WHERE (nombres LIKE '%"+filtro+"%') "
                + "or (apellidos LIKE '%"+filtro+"%') "
                + "or (direccion LIKE '%"+filtro+"%');";
        List<Cliente> lista = new ArrayList<>();
        System.out.println("hemos seleccionado:" +sql);
        
        ConexionManager.conectar();
        
        Cliente cliente = null;
        
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCredito(rs.getDouble("credito"));
                
                lista.add(cliente);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        return lista;
    }
    
}
