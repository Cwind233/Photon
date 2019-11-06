package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EnCodingFilter
 * @author HZC
 */
@WebFilter(filterName="/EncodingFilter",urlPatterns="/*")
public class EnCodingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //先转换
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //设置请求编码为UTF-8
        req.setCharacterEncoding("UTF-8");
        //这一行要在中间 
        chain.doFilter(req, resp);
        //设置响应编码为UTF-8
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
    }

}
