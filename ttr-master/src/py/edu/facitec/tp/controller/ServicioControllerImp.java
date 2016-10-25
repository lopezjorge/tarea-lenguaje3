/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.controller;

import py.edu.facitec.tp.dao.ServicioDao;
import py.edu.facitec.tp.dao.ServicioDaoImp;
import py.edu.facitec.tp.model.Servicio;

/**
 *
 * @author brother
 */
public class ServicioControllerImp implements ServicioController{
    ServicioDao servicioDao;

    public ServicioControllerImp() {
        servicioDao = new ServicioDaoImp();
    }
    
    @Override
    public void registrarServicio(Servicio servicio) {
        servicioDao.agregarServicio(servicio);
    }
    
}
