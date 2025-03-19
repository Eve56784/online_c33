package HW_24_Task_Two;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AgeValidator", urlPatterns = "/validate")
public class AgeValidator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ageParam = req.getParameter("age");
        resp.setContentType("text/plain");
        if(ageParam!=null){
            try{
                int age = Integer.parseInt(ageParam);
                if(age>=18 && age<120)
                    resp.getWriter().println("You're an adult.");
                else if (age<=18 && age>=0)
                    resp.getWriter().println("You're a minor.");
                else
                    resp.getWriter().println("Invalid age parameter.");
            }
            catch (Exception e){
                resp.getWriter().println(e.getMessage());
            }
        }
    }
}

//Для проверки после запуска http://localhost:8080/Servlets_war/validate?age=18