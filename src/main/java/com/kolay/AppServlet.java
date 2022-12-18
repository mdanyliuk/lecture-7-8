package com.kolay;

import com.kolay.model.User;
import com.kolay.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/")
public class AppServlet extends HttpServlet {

    UserService userService;

    public AppServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("".equals(username)) {
            req.setAttribute("message", "Username can't be empty!");
        } else if ("".equals(password)) {
            req.setAttribute("message", "Password can't be empty!");
        } else {
            Optional<User> user = userService.checkCredentials(username, password);
            if (user.isEmpty()) {
                req.setAttribute("message", "Wrong credentials!");
            } else {
                req.getSession().setAttribute("user", user.get());
                handleWelcome(req, resp);
                return;
            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/welcome" :
                handleWelcome(req, resp);
                break;
            case "/users" :
                handleUsers(req, resp);
                break;
            case "/logout" :
                handleLogout(req, resp);
                break;
            default:
                resp.sendError(404);
        }
    }

    private void handleWelcome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("name", user.getName());
        req.getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }

    private void handleUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userList", userService.findAllUsers());
        req.getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    private void handleLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
