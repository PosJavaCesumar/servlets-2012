package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ListaServlet", urlPatterns = "/Lista")
public class ListaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> resultado = (List<String>) req.getAttribute("resultado");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        for (String nome : resultado) {
            pw.println(String.format("<p>%s</p>", nome));
        }
        pw.println("</body></html>");
        pw.close();
    }
    
}