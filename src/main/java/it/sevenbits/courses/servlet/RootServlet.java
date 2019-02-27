package it.sevenbits.courses.servlet;

import it.sevenbits.courses.servlet.servlets.TasksRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RootServlet extends HttpServlet {
//    private TasksRepository repository = TasksRepository.getInstance();
//
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        int key = -1;
//        try {
//            key = Integer.parseInt(request.getParameter("key"));
//        } catch (NumberFormatException e) {
//            e.getMessage();
//        }
//        if (key >= 0) {
//            response.getWriter().write(repository.getTask(key) + "\n");
//        } else {
//            for (int i = 0; i < repository.getSize(); i++) {
//                response.getWriter().write(repository.getTask(i) + "\n");
//                response.setStatus(200);
//            }
//        }
    }
//
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String key = request.getParameter("key");
//        response.getWriter().write("Parameter key = " + key + "\n");
//        repository.addTask(key);
//
//        response.setContentType("application/x-www-form-urlencoded");
//        response.setCharacterEncoding("UTF-8");
//
//
//
//        /*for (int i = 0; i <= repository.getSize(); i++) {
//            response.getWriter().write(repository.getTask(i) + "\n");
//            response.setStatus(200);
//        }*/

    }
//
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
//        repository.deleteByID(Integer.parseInt(request.getParameter("key")));
    }
}
