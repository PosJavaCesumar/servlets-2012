package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName= "RequisicaoFilter", urlPatterns = "/*")
public class RequisicaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(String.format("Antes - URI: %s", req.getRequestURI()));
        chain.doFilter(request, response);
        System.out.println(String.format("Depois - URI: %s", req.getRequestURI()));
    }

    @Override
    public void destroy() {
    }
    
}
