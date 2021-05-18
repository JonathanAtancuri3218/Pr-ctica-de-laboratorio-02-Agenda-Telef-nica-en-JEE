/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.JDBCTelefonoDAO;
import ec.edu.ups.mysql.jdbc.JDBCUsuarioDAO;

/**
*
* @author Atancuri
*/
public class JDBCDAOFactory extends DAOFactory{

    @Override
    public void createTables() {
        this.getUserDAO().createTable();
        this.getPhoneDAO().createTable();
    }

    @Override
    public UsuarioDAO getUserDAO() {
        return new JDBCUsuarioDAO();
    }

    @Override
    public TelefonoDAO getPhoneDAO() {
        return new JDBCTelefonoDAO();
    }
    
}
