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
@WebServlet(name = "EliminarCategory", urlPatterns = {"/EliminarCategory"})
public class EliminarCategory extends HttpServlet {
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarCategory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarCategory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    response.setContentType("application/json;charset=UTF-8");
        response.setHeader("cache-control","no-store");
        
        PrintWriter p = response.getWriter();
        String r = request.getParameter("categoryid");
        int id = (r==null || r.equals(""))?0:Integer.parseInt(r);
        if(id==0){
            Message m = new Message();
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("No se encontro category");
            m.setDetail("El parametro enviado es incorrecto");
           // p.print(m);
            
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            p.print(gson.toJson(m));
        } else {
        
            p.print(ejb.deleteCategory(id));
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
