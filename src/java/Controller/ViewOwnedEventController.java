/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EventDAO;
import DTO.EventDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WilliamTrung
 */
@WebServlet(name = "ViewOwnedEventController", urlPatterns = {"/ViewOwnedEventController"})
public class ViewOwnedEventController extends HttpServlet {
    private final String FAIL = "viewOwnEvent.jsp";
    private final String SUCCESS = "viewOwnEvent.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAIL;
        HttpSession session = request.getSession();
        try {
            String search = request.getParameter("search");
            int index = Integer.parseInt(request.getParameter("index"));
            int pageSize = 3;
            EventDAO dao = new EventDAO();
            List<EventDTO> list = dao.getListEventByPage(search, index, pageSize);
            if (list != null && !list.isEmpty()) {
                request.setAttribute("LIST_EVENT", list);
                request.setAttribute("EVENT_MESSAGE", "Page"+index);
                request.setAttribute("Search", search);
                url = SUCCESS;
            } else {
                session.setAttribute("EVENT_MESSAGE", "No event");
            }
        } catch (Exception e) {
            log("Error at ViewEventController: " + e.toString());
            session.setAttribute("ERROR_MESSAGE", "ERROR at ViewEventController!");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
