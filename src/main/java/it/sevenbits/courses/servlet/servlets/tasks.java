package it.sevenbits.courses.servlet.servlets;

import it.sevenbits.courses.servlet.Task;
import it.sevenbits.courses.servlet.servlets.TasksRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class tasks extends HttpServlet {
    private TasksRepository repository = TasksRepository.getInstance();

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            for (int i = 0; i < repository.getSize(); i++) {
                response.getWriter().write(String.format("{ \"id\":%d,\"name\":\"%S\"}\n",
                        repository.getTask(i).getID(), repository.getTask(i).getName()));
                response.setStatus(200);
            }
        } catch (IOException e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Task newTask = new Task(request.getParameter("key"));
            repository.addTask(newTask);
            response.setStatus(201);
            response.getWriter().write(String.format("{ \"id\":%d,\"name\":\"%S\"}", newTask.getID(), newTask.getName()));
        } catch (IOException e) {

        }
    }
}
