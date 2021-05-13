import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/**
 * 子类---》父类---》A接口
 * 此时子类也是A接口的实现类
 *
 * 抽象类的作用：降低接口实现类对接口实现的难度
 *            将接口中不需要使用的抽象方法交给抽象类完成
 *            这样接口实现类只需要对接口需要方法进行重写
 * Tomcat根据Servlet规范Servlet接口实现类规则：
 *      1.Tomcat有权创建Servlet接口实现类对象
 *      Servlet oneServlet = new OneServlet();
 *      2.Tomcat根据实例对象调用service方法处理当前请求
 *      oneServlet.service()，此时service方法中 this=====oneServlet
 *              extends                       extends                        extends
 *  oneServlet-------->(abstract)HttpServlet------->(abstract)GenericServlet------>servlet接口
 *                                                  init
 *                                                  getServletInfo
 *                                                  destroy
 *                                                  getServletConfig
 *  通过父类决定在何种情况下调用子类中的方法---------【设计模式】------模版设计模式
 *
 *  HttpServlet: service() {
 *      if(请求方式 == GET){
 *          this.doGet
 *      }else if(请求方式 == POST){
 *          this.doPost
 *      }
 *  }
 *
 *  OneServlet: doGet doPost
 *
 *      Servlet oneServlet = new OneServlet();
 *      oneServlet.service()
 *  需要掌握的知识：
 *          重写规则
 *          抽象类作用
 *          子类实现接口规则
 *          this指向
 *          继承规则
 *
 */

public class OneServlet extends HttpServlet {
    public OneServlet() {
        System.out.println("OneServlet类被创建实例对象");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送GET请求方式处理");
        System.out.println("OneServlet类负责第一步");
        //重定向解决方案：
        response.sendRedirect("/myweb/two");//【地址格式：/网站名/资源文件名】

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送POST请求方式处理");
    }
}
