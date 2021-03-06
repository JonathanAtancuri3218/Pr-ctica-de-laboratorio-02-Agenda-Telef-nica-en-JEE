/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servlets;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author Atancuri
*/
@WebServlet(name = "MyAgenda", urlPatterns = {"/my-agenda"})
public class MyAgenda extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sesion = request.getParameter("logout");
        String telefono = request.getParameter("mi-telefono");

        if (sesion != null) {
            if (sesion.equals("true")) {
                //System.out.println("Sesion cerrada de id " + request.getSession().getAttribute("sesionID"));
                request.getSession().invalidate();
                response.sendRedirect("/Ejemplo-Agenda");

            }
        } else {
            ServletContext aplicacion = request.getServletContext();
            UsuarioDAO userDao = DAOFactory.getDAOFactory().getUserDAO();
            Usuario user = userDao.findById(String.valueOf(request.getSession().getAttribute("userID")));
            if (telefono != null) {
                aplicacion.setAttribute("search", "true");
                //request.setAttribute("search", "true");
                TelefonoDAO phoneDao = DAOFactory.getDAOFactory().getPhoneDAO();
                user.setTelefonos(phoneDao.findByNumber(telefono,user.getCedula()));
            }else{
                aplicacion.setAttribute("search", "false");
            }
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/views/jsp/my-agenda.jsp").forward(request, response);
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/views/jsp/my-agenda.jsp");
            //dispatcher.forward(request, response);

            //System.out.println("Nombre: "+user.getNombre() + " Apellido: "+user.getApellido());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
