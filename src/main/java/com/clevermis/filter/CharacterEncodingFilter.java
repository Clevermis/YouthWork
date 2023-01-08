package com.clevermis.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @program: YouthWork
 * @description: 字符编码过滤器
 * @author: Clevermis
 * @create: 2023-01-07 11:55
 * @since JDK 1.8
 **/
public class CharacterEncodingFilter implements Filter {

  /**
   * @methodname init  的功能描述 TODO:初始化过滤器
   * @Param: * @param filterConfig
   * @return: void
   * @throw: ServletException
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/7 11:58
   */
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  /**
   * @param servletResponse
   * @param filterChain
   * @methodname doFilter  的功能描述 TODO:设置字符编码
   * @Param: * @param servletRequest
   * @return: void
   * @throw: IOException, ServletException
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/7 11:58
   */
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding("utf-8");
    servletResponse.setCharacterEncoding("utf-8");
    servletResponse.setContentType("text/html;charset=UTF-8");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  /**
   * @methodname destroy  的功能描述 TODO:释放被 Filter 对象打开的资源
   * @Param: * @param
   * @return: void
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/7 11:58
   */
  public void destroy() {

  }
}

