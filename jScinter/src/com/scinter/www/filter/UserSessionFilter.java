package com.scinter.www.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.scinter.www.model.User;

/**
 * 登录Session过滤
 * 
 */
public class UserSessionFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("UserInfo");
		
		// 不拦截的url白名单数组
		String[] notFilter = new String[] { "/admin","/admin/","/admin/index.jsp","/admin/index","/admin/loginout","/admin/getKaptchaImage","/admin/showKaptchaImageOrNot","/admin/getKaptchaCode"};
		
		// 请求的url
		String url = request.getRequestURI();
		//logger.info(url);
		if(url.equals(request.getContextPath()+"/admin")){
			response.sendRedirect(request.getContextPath()+"/admin/");
			//request.getRequestDispatcher("/admin/").forward(request, response);
			return;
		}
		// 检测session是否登录 已经登录的直接跳转到系统管理界面
		if (null != user) {
			if(url.equals("/scinter/admin/") || url.equals("/scinter/admin/index.jsp") || url.equals("/scinter/admin/index")){						
				request.getRequestDispatcher("/admin/scinter_index.jsp").forward(request, response);
			}
		}
		// 后台管理登录拦截
		if (url.indexOf("admin") != -1) {
			boolean doFilter = check(request,notFilter, url);
			if (doFilter) {
				if (null == user) {
					// 如果session中不存在登录者实体，则弹出框提示重新登录
					// 设置request和response的字符集，防止乱码
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html;charset=UTF-8");
            		response.setCharacterEncoding("UTF-8");
            		response.setHeader("Cache-Control", "no-cache");
					PrintWriter out = response.getWriter();
					String loginPage = request.getContextPath() + "/admin/index.jsp";
					StringBuilder builder = new StringBuilder();
					builder.append("<script type=\"text/javascript\">");
					builder.append("alert('提示信息：您的登录信息已经失效，请重新登录！');");
					builder.append("window.top.location.href='");
					builder.append(loginPage);
					builder.append("';");
					builder.append("</script>");
					out.print(builder.toString());
				} else {
					filterChain.doFilter(request, response);
				}
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * @param notFilter
	 *            不拦截的url
	 * @param url
	 *            ：请求的url
	 * @return false：不拦截 true：拦截
	 */
	public boolean check(HttpServletRequest request,String[] notFilter, String url) {
		// url以css和js结尾的不进行拦截
		if (url.endsWith(".css") || url.endsWith(".js")) {
			return false;
		}
		// 含有notFilter中的任何一个则不进行拦截
		for (String s : notFilter) {
			if (url.equals(request.getContextPath()+s)) {
				return false;
			}
		}
		return true;
	}

}
