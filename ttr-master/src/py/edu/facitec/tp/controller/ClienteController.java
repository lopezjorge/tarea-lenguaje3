/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.controller;

import java.util.List;
import py.edu.facitec.tp.model.Cliente;

/**
 *
 * @author brother
 */
public interface ClienteController {
    
    void registrarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    Cliente buscarClientePorCodigo(int codigo);
    List<Cliente>busquedaPorParametros(String filtro);
    
}
