package Clasesitas;

import sets.setGet;
import sets.setGet2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario_Extra
 */
@WebServlet(name = "Cositas", urlPatterns = {"/Cositas"})
public class Cositas extends HttpServlet {

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
                setGet cosita = new setGet();
                cosita.setNum1(Integer.parseInt(request.getParameter("num1")));
                cosita.setNum2(Integer.parseInt(request.getParameter("num2")));
                
                String sumita = request.getParameter("suma")==null?"":request.getParameter("suma");
                String restita = request.getParameter("resta")==null?"":request.getParameter("resta");
                String division = request.getParameter("divi")==null?"":request.getParameter("divi");
                String multiplo = request.getParameter("multi")==null?"":request.getParameter("multi");
                String [] todos = {sumita, restita, division, multiplo};
                int elegido = 0;
                for(int i = 0; i < todos.length; i++){
                    if(!todos[i].equals("")){
                        elegido = i;
                    }
                }
                switch(elegido){
                    case 0:
                        cosita.setResultado(cosita.getNum1()+cosita.getNum2());
                        response.sendRedirect("sacaResul.jsp?resultado="+cosita.getResultado());
                        break;
                    case 1:
                        cosita.setResultado(cosita.getNum1()-cosita.getNum2());
                        response.sendRedirect("sacaResul.jsp?resultado="+cosita.getResultado());
                        break;
                    case 2:
                        if(cosita.getNum2() == 0){
                            cosita.setResultado(000000);
                            response.sendRedirect("sacaResul.jsp?resultado="+cosita.getResultado());
                        }
                        else{
                            cosita.setResultado(cosita.getNum1()/cosita.getNum2());
                            response.sendRedirect("sacaResul.jsp?resultado="+cosita.getResultado());
                        }
                        break;
                    case 3:
                        cosita.setResultado(cosita.getNum1()*cosita.getNum2());
                        response.sendRedirect("sacaResul.jsp?resultado="+cosita.getResultado());
                    default:
                        System.out.println("Error");
                        break;
                }
            }
        }
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
