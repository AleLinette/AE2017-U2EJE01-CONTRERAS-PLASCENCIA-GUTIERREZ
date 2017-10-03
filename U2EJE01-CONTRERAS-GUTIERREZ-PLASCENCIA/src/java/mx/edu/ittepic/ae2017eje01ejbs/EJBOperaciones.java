/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ae2017eje01ejbs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import mx.edu.ittepic.u2eje01.utils.Message;
import mx.edu.ittepic.aeu02eje01.entities.Category;

/**
 *
 * @author AleLinette
 */
@Stateless
public class EJBOperaciones {
    
    @PersistenceContext
    private EntityManager em;
    
    //Consultar todos 
    public String getCategory(){
        //primera consulta:
        Query q;
        
        List<Category> listCategorys;
        
        //Consulta como tal:
        q = em.createNamedQuery("Category.findAll");
        
        //Con esto se ejecuta  el query:
        listCategorys = q.getResultList();
        
        //convertir a json:
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String result = gson.toJson(listCategorys);
        return result;
         
    }
    
    public String getCategorybyId (int id){
        String result ="";
        Query q;
        Category c;
        
         Message m = new Message();
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        q = em.createNamedQuery("Category.findByCategoryid").setParameter("categoryid", id);
        
        try {
            c = (Category)q.getSingleResult();
            m.setCode(HttpServletResponse.SC_OK);
            m.setMessage("La consulta se ejecuto correctamente");
            m.setDetail(gson.toJson(c));
            
            return gson.toJson(c);
        } catch(NoResultException e){
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("No se encontraron resultados");
            m.setDetail(e.toString());
        } catch(NonUniqueResultException e){
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("Existe más de un resultado");
            m.setDetail(e.toString());
        }
        return gson.toJson(m);
    }


    public String createCategory(String categoryname){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Message m = new Message();
        
        Category c = new Category();
        
        c.setCategoryname(categoryname);
        try {
            em.persist(c);
            m.setCode(HttpServletResponse.SC_OK);
            m.setMessage("El rol se creo correctamente con la clave " + c.getCategoryid());
            m.setDetail(gson.toJson(c));
        } catch (EntityExistsException e) {
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("No se pudo guardar el rol, intente nuevamente");
            m.setDetail(e.toString());
        }
        
        return gson.toJson(m);
    }
    
    public String deleteCategory(int categoryid){
        GsonBuilder builder= new GsonBuilder();
        Gson gson = builder.create();
        Message m = new Message();
        Category c;
        
        try {
            //Forma de hacer una consulta por la llave primaria y aplica a cualquier entidad.
            //Se pasan dos parametros
            c = em.find(Category.class, categoryid);
            em.remove(c);
            
            m.setCode(HttpServletResponse.SC_OK);
            m.setMessage("La categoria se eliminó correctamente");
            m.setDetail(gson.toJson(c));
            return gson.toJson(m);
        } catch(IllegalArgumentException e){
            m.setCode(HttpServletResponse.SC_BAD_REQUEST);
            m.setMessage("No se pudo eliminar, intente de nuevo");
            m.setDetail(e.toString());
      
        }
        return gson.toJson(m);
    }

    public Object updateCategory(int id, String categoryname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
}



