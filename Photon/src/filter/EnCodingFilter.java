package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EnCodingFilter
 * @author HZC
 */
@WebFilter(filterName="/EncodeFilter",urlPatterns="/*")
public class EnCodingFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    //设置请求编码为UTF-8
	    request.setCharacterEncoding("utf-8");
        //设置响应编码为UTF-8
        ((HttpServletResponse) response).setContentType("application/json;charset=utf-8");
        ((HttpServletResponse) response).setCharacterEncoding("utf-8");
        //这一行要在最下面
        chain.doFilter(request, response);
	}

    @Override
    public void destroy() {
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
    }

}
