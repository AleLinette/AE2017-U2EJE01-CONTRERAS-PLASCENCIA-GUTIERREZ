/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ae2017u2.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.ittepic.ae2017eje01ejbs.EJBOperaciones;
import mx.edu.ittepic.u2eje01.utils.Message;

/**
 *
 * @author AleLinette
 */
@WebServlet(name = "ConsultaCategory", urlPatterns = {"/ConsultaCategory"})
public class ConsultaCategory extends HttpServlet {
    
    @EJB
    private EJBOperaciones ejb;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           PrintWriter p = response.getWriter();
            
            Message m = new Message();
            m.setCode(401);
            m.setMessage("Do not enter");
            m.setDetail("Not authorized method");
            
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            
            p.print(gson.toJson(m));
       
        }
    }

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
        processRequest(request, response);
        
        response.setContentType("application/json;charset=UTF-8");
        
        // obligar al cliente http que no guarde el resultado de este servlet en cache
        response.setHeader("Cache-Control", "no-store");
        
        // crear el objeto necesario para devolver la respuesta
        PrintWriter p = response.getWriter();
        
        int id = request.getParameter("id")==null?0:
                    Integer.parseInt(request.getParameter("id"));
        
        Message m = new Message();
        
        if(id == 0) {
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("No se encontró el rol");
            m.setDetail("El parámetro enviado es incorrecto");
            
            
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            p.print(gson.toJson(m));
             }
        
        // devuelvo la respuesta
        else p.print(ejb.getCategorybyId(id));
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
        processRequest(request, response);
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
