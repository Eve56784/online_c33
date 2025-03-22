package task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServletList", urlPatterns = "/list-books")
public class MyServletList extends HttpServlet {
    private static final String UPLOAD_DIR = "books";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ru\">");
        out.println("<head><meta charset=\"UTF-8\"><title>Book List:</title></head>");
        out.println("<body><h1>Book List</h1>");

        if (!uploadDir.exists() || !uploadDir.isDirectory()) {
            out.println("<p>Dir was not found.</p>");
        } else {
            File[] files = uploadDir.listFiles();
            if (files == null || files.length == 0) {
                out.println("<p>File was not found</p>");
            } else {
                out.println("<ul>");
                for (File file : files) {
                    out.println("<li>" + file.getName() + "</li>");
                }
                out.println("</ul>");
            }
        }
        out.println("</body></html>");
    }
}
