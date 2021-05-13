import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
    public TwoServlet() {
        System.out.println("TwoServlet类被创建实例对象");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet doGet is run..");
        System.out.println("TowServlet负责第二步");
        response.sendRedirect("http://www.baidu.com");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
