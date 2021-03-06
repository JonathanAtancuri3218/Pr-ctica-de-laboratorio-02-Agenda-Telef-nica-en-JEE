/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.filter;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
*
* @author Atancuri
*/
@WebFilter(filterName = "HomeFilter", urlPatterns = {"/Ejemplo-Agenda"}, dispatcherTypes = {DispatcherType.REQUEST})
public class HomeFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public HomeFilter() {
    }    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        UsuarioDAO userDao = DAOFactory.getDAOFactory().getUserDAO();
        userDao.createTable();
        TelefonoDAO phoneDao = DAOFactory.getDAOFactory().getPhoneDAO();
        phoneDao.createTable();
        System.err.println("Filtro en homefilter");
        //chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //res.sendRedirect("/Practica-de-laboratorio-01");
        
        //req.setAttribute("userId", req.getSession().getAttribute("userID"));
        //RequestDispatcher dispatcher = req.getRequestDispatcher("/index.js");
        //dispatcher.forward(req, res);
        //RequestDispatcher despachador= request.getRequestDispatcher("/scopes.jsp");
        //despachador.forward(request, response);
        
    
        
    }

    
}
