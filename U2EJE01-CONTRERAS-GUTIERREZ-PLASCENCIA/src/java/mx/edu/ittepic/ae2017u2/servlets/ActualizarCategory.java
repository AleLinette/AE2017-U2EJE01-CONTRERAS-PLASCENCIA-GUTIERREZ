/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ae2017u2.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.TransactionRequiredException;
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
@WebServlet(name = "ActualizarCategory", urlPatterns = {"/ActualizarCategory"})
public class ActualizarCategory extends HttpServlet {
    @EJB
    private EJBOperaciones ejb;
     Message m = new Message();

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
            out.println("<title>Servlet ActualizarCategory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarCategory at " + request.getContextPath() + "</h1>");
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
        PrintWriter pw = response.getWriter();
            int id = 0;
        String categoryname = "";
        try{
            id = Integer.parseInt(request.getParameter("id"));
            categoryname = request.getParameter("categoryname");
        }catch(NumberFormatException e1){
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("Ups the was an error =(");
            m.setDetail(e1.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        if(categoryname.isEmpty()){
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("error");
            m.setDetail("error parametros");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }else{
            try{
                m.setDetail(ejb.updateCategory(id, categoryname).toString());
                m.setCode(HttpServletResponse.SC_OK);
                m.setMessage("Muy bien");
            }catch(IllegalArgumentException e1){
                m.setCode(HttpServletResponse.SC_MOVED_TEMPORARILY);
                m.setMessage("Error");
                m.setDetail(e1.getMessage());
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            }catch(TransactionRequiredException e2){
                m.setCode(HttpServletResponse.SC_MOVED_TEMPORARILY);
                m.setMessage("Error");
                m.setDetail(e2.getMessage());
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            }
        }

        pw.print(new Gson().toJson(m));

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
