/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 *
 * @author ra21504264
 */
public class IncluirAluno extends HttpServlet {

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
            
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String ra = request.getParameter("ra");
            
            out.println("Incluindo...<br/>");
            out.println("nome: " + nome + "<br/>");
            out.println("sobrenome: " + sobrenome + "<br/>");
            out.println("ra: " + ra + "<br/>");
            
            Aluno aluno = new Aluno();
            aluno.setRa(ra);
            aluno.setSobrenome(sobrenome);
            aluno.setNome(nome);
            
            //Criar a sessão
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            
            
            //Criar a transação
            Transaction t = sessao.beginTransaction();
            
            
            //Falar que quer salvar
            sessao.save(aluno);
            
            
            //Mandar salvar
            sessao.flush();
            
            
            //Commitar a transação
            t.commit();
            
            //Fechar a sessao
            sessao.close();
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
