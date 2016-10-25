/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.controller;

import java.util.Vector;
import py.edu.facitec.tp.dao.CiudadDao;
import py.edu.facitec.tp.dao.CiudadDaoImp;
import py.edu.facitec.tp.model.Ciudad;

/**
 *
 * @author brother
 */
public class CiudadControllerImp implements CiudadController {

    private CiudadDao ciudadDao;

    public CiudadControllerImp() {
        this.ciudadDao = new CiudadDaoImp();
    }
    
    @Override
    public void registrarCiudad(Ciudad ciudad) {
        ciudadDao.agregarCiudad(ciudad);
    }

    @Override
    public Vector<Ciudad> cargarCombo() {
        return ciudadDao.agregaCiudad();
    }

    @Override
    public boolean modificarCiudad(Ciudad ciudad) {
       return ciudadDao.alterarCiudad(ciudad);
    }

    @Override
    public Ciudad buscarCiudadPorCodigo(int codigo) {
        return ciudadDao.buscarCiudadPorCodigo(codigo);
    }

    @Override
    public void eliminarCiudad(int codigo) {
      ciudadDao.eliminarCiudad(codigo);
    }

    

 
   
    
}
