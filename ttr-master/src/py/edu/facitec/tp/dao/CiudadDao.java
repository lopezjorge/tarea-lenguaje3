/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.dao;



import java.sql.Array;
import java.util.Vector;

import py.edu.facitec.tp.model.Ciudad;

/**
 *
 * @author brother
 */
public interface CiudadDao {
    void agregarCiudad(Ciudad ciudad);
    Vector<Ciudad>agregaCiudad();//este es el que se impleta con el combobox

    public boolean alterarCiudad(Ciudad ciudad);
    Ciudad buscarCiudadPorCodigo(int codigo);

    void eliminarCiudad(int codigo);
}
