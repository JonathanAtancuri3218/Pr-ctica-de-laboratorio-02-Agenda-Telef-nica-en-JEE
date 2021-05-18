/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
*
* @author Atancuri
*/
public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
    public abstract List<Telefono> findByUserId(String cedula);
    public abstract List<Telefono> findByNumber(String correo,String cedula);
}
