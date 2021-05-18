/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
*
* @author Atancuri
*/
public interface UsuarioDAO extends GenericDAO<Usuario, String> {
    public abstract Usuario findUser(String correo, String pass);
    public abstract List<Usuario> findByIdOrMail(String context);
}
