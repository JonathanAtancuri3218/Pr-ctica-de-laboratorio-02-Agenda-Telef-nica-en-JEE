/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

/**
 *
 * @author Atancuri
 */
public abstract class DAOFactory {
    protected static DAOFactory factory = new JDBCDAOFactory();
    
    public static DAOFactory getDAOFactory(){return factory;}
    
    public abstract void createTables();
    
    public abstract UsuarioDAO getUserDAO();
    
    public abstract TelefonoDAO getPhoneDAO();
}
