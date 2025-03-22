package task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet(name = "MyServlet", urlPatterns = {"/book", "/load-book"})

public class MyServlet extends HttpServlet {
    private static final String uploadDir = "books";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String servletPath = req.getServletPath();
        if ("/load-book".equals(servletPath)) {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Upload a Book</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Upload a Book</h1>");
            out.println("<form action=\"" + req.getContextPath() + "/load-book\" method=\"POST\" enctype=\"multipart/form-data\">");
            out.println("<label for=\"file\">Choose a book file:</label>");
            out.println("<input type=\"file\" name=\"file\" id=\"file\" required>");
            out.println("<button type=\"submit\">Upload</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } else if ("/book".equals(servletPath)) {
            String bookName = req.getParameter("bookName");
            if (bookName == null || bookName.isEmpty()) {
                resp.getWriter().println("Error. No book name specified");
                return;
            }
            String uploadPath = getServletContext().getRealPath("") + File.separator + uploadDir;
            File file = new File(uploadPath, bookName);
            if (!file.exists()) {
                resp.getWriter().println("Error. File does not exist");
                return;
            }
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
            try (FileInputStream fis = new FileInputStream(file);
                 OutputStream os = resp.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        if ("/load-book".equals(servletPath)) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + uploadDir;
            File uploadDirFile = new File(uploadPath);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdir();
            }
            Part filePart = req.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            if (fileName == null || fileName.isEmpty()) {
                resp.getWriter().write("Error. Invalid file name");
                return;
            }
            filePart.write(uploadPath + File.separator + fileName);
            resp.getWriter().write("File \"" + fileName + "\" was successfully uploaded!");
        } else {
            resp.getWriter().write("POST not supported for this URL");
        }
    }
}
