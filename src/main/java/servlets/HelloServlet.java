package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    private String identidade;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        identidade = config.getInitParameter("identidade");
        if (identidade == null) {
            throw new ServletException("'identidade' é obrigatório!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pessoa = req.getParameter("pessoa");
        Enumeration<String> headerNames = req.getHeaderNames();
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println(String.format("<h1>Hello %s, eu sou %s</h1>", 
                pessoa, identidade));
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            pw.println(String.format("<p>%s = %s</p>",
                    headerName, headerValue));
        }
        pw.println("</body></html>");
    }
    
}