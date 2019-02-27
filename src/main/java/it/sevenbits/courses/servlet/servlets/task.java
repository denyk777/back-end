package it.sevenbits.courses.servlet.servlets;

import it.sevenbits.courses.servlet.servlets.TasksRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class task extends HttpServlet {
    private TasksRepository repository = TasksRepository.getInstance();

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int requestID = Integer.parseInt(request.getParameter("taskId"));
            int ID = repository.getTask(requestID).getID();
            String name = repository.getTask(requestID).getName();
            response.getWriter().write(String.format("{ \"id\":%d,\"name\":\"%S\"}\n",ID, name));
            response.setStatus(200);
        } catch (NumberFormatException e) {
            response.setStatus(404);
        }
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int requestID = Integer.parseInt(request.getParameter("taskId"));
            int ID = repository.getTask(requestID).getID();
            repository.deleteByID(Integer.parseInt(request.getParameter("taskId")));
            response.getWriter().write(String.format("{ \"id\":%d}\n",ID));
            response.setStatus(200);
        } catch (NumberFormatException e) {
            response.setStatus(404);
        }

    }

}
