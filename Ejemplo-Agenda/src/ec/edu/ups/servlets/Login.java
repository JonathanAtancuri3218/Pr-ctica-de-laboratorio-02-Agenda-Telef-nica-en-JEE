/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servlets;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
*
* @author Atancuri
*/
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/html/form-login.html");
        dispatcher.forward(request, response);
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
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        
        UsuarioDAO userDao = DAOFactory.getDAOFactory().getUserDAO();
        Usuario user = userDao.findUser(mail, pass);
        if (user != null && user.getActivo() == 1) {
            System.out.println("usuario encontrado");
            HttpSession session = request.getSession(true);
            System.out.println("Sesion iniciada con id " + request.getSession().getId());
            session.setAttribute("sesionID", String.valueOf(session.getId()));
            session.setAttribute("userID", user.getCedula());
            //session.setAttribute(logincon, user);
            session.setAttribute("Inicio sesion como :", user);
            System.out.println("Inicio como : "+user);
    		//System.out.printf("El usuario INICIO sesion con exito como  %s%n", user);
            
            response.sendRedirect("my-agenda");
            
        }else{
            response.sendRedirect("login");
        }     
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
