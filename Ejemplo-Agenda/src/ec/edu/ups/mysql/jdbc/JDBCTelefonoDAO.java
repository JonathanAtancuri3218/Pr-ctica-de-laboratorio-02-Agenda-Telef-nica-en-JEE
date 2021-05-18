/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Atancuri
*/
public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {
    
    @Override
    public void createTable() {
        conexionDos.update("CREATE TABLE IF NOT EXISTS telefono ("
                + "	tel_id INT NOT NULL AUTO_INCREMENT,"
                + "	tel_numero VARCHAR(20),"
                + "	tel_tipo  VARCHAR(50),"
                + "	tel_operadora VARCHAR(50),"
                + "	usu_cedula VARCHAR(10) NOT NULL,"
                + "	PRIMARY KEY (tel_id),"
                + "	FOREIGN KEY (usu_cedula) REFERENCES usuario(usu_cedula)"
                + ");");
    }
    
    @Override
    public boolean create(Telefono phone) {
        
        return conexionDos.update("INSERT INTO telefono (tel_numero, tel_tipo, tel_operadora, usu_cedula) "
                + "VALUES ('" + phone.getNumero() + "', '" + phone.getTipo() + "', '" + phone.getOperadora() + "', '" + phone.getUser().getCedula() + "');");        
    }
    
    @Override
    public Telefono findById(Integer id) {
        Telefono phone = null;
        ResultSet rs = conexionUno.query("Select * FROM telefono WHERE tel_id = " + id + ";");
        try {
            if (rs != null && rs.next()) {
                phone = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
                phone.setId(rs.getInt("tel_id"));
                phone.setUser(DAOFactory.getDAOFactory().getUserDAO().findById(rs.getString("usu_cedula")));
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
        }
        return phone;
    }
    
    @Override
    public boolean update(Telefono phone) {
        return conexionDos.update("UPDATE telefono SET "
                + "	tel_numero = '" + phone.getNumero() + "',"
                + "	tel_tipo = '" + phone.getTipo() + "',"
                + "	tel_operadora = '" + phone.getOperadora() + "'"
                + "WHERE tel_id = '" + phone.getId() + "' AND usu_cedula = '" + phone.getUser().getCedula() + "';");
    }
    
    @Override
    public boolean delete(Telefono phone) {
        return conexionDos.update("DELETE FROM telefono WHERE tel_id = '" + phone.getId() + "' AND usu_cedula = '" + phone.getUser().getCedula() + "';");
    }
    
    @Override
    public List<Telefono> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Telefono> findByUserId(String cedula) {
        List<Telefono> phones = new ArrayList<>();
        ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE usu_cedula = '" + cedula + "';");
        
        try {
            while (rs.next()) {
                Telefono phone = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
                phone.setId(rs.getInt("tel_id"));
                //phone.setUser(DAOFactory.getDAOFactory().getUserDAO().findById(cedula));
                //System.out.println("Telegono usuario: "+cedula);
                phones.add(phone);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
        }
        return phones;
    }

    @Override
    public List<Telefono> findByNumber(String correo,String cedula) {
        List<Telefono> phones = new ArrayList<>();
        //System.out.print("SELECT * FROM usuario, telefono WHERE telefono.usu_cedula=usuario.usu_cedula and usuario.usu_cedula="+ cedula);
        ResultSet rs = conexionDos.query("SELECT * FROM usuario, telefono WHERE telefono.usu_cedula=usuario.usu_cedula and usuario.usu_cedula="+ cedula);
        //System.out.println("---------- " +rs);
        try {
            while (rs.next()) {
            	
                Telefono phone = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
                System.out.println("-----____---- " +phone);
                phone.setId(rs.getInt("tel_id"));
                //phone.setUser(DAOFactory.getDAOFactory().getUserDAO().findById(cedula));
                //System.out.println("Telegono usuario: "+cedula);
                phones.add(phone);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
        }
        return phones;
    }
}
