package servlets;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaServlet extends HttpServlet {
    
    private final List<String> NOMES = 
            ImmutableList.of("Anderson", "Adriano", "Alexandre", 
            "Edson", "Eduardo", "Edna", 
            "Iara", "Igor", "Ivan", 
            "Odivaldo", "Otavio", "Osmar", 
            "Ulisses", "Uender", "Ursula");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String busca = req.getParameter("busca");
        Builder<String> builder = ImmutableList.builder();
        for (String nome: NOMES) {
            if (nome.toUpperCase().startsWith(busca.toUpperCase())) {
                builder.add(nome);
            }
        }
        ImmutableList<String> resultado = builder.build();
        req.setAttribute("resultado", resultado);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Lista");
        dispatcher.forward(req, resp);
    }
    
}