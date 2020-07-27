package zyl.spring.web.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class SessionTimeOutInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HttpSession session = request.getSession();
    // 获取登录的session信息
    Object user = session.getAttribute("userinfor");
    if (user != null) {
      return true;
    } else {
      // 未登录自动跳转界面
      //            response.sendRedirect(request.getContextPath() + "/login.do");

      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(
          new ObjectMapper()
              .writeValueAsString(Result.builder().code("200").message("请先登录").build()));
      out.flush();
      return false;
    }
  }
}
