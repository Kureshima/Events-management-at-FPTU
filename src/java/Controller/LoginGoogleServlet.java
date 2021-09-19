package Controller;

import DAO.UserDAO;
import DTO.UserDTO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GoogleAPI.GoogleUtils;
import javax.servlet.http.HttpSession;

@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String SUCCESS = "index.jsp";
    private final String FAIL = "login.jsp";

    public LoginGoogleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code;
        String url = FAIL;
        try {
            code = request.getParameter("code");
            if (code == null || code.isEmpty()) {
                url = FAIL;
            } else {
                String accessToken = GoogleUtils.getToken(code);
                UserDTO user = GoogleUtils.getUserInfo(accessToken);
                UserDAO ud = new UserDAO();
                if(user.isVerified_email() == true) {
                    user = ud.loginUser(user);
                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("CURRENT_USER", user);
                        url = SUCCESS;
                    } else {                       
                        request.setAttribute("USER_LOGIN_ERROR", "Cannot login!");
                        url = FAIL;
                    }
                } else {
                    request.setAttribute("USER_INVALID", "Email is not valid!");
                    url = FAIL;
                }
            }
        } catch (Exception e) {
            request.setAttribute("SYSTEM_ERROR", e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
