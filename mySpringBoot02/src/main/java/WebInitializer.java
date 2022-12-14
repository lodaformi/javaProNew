import com.loda.config.MvcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Author loda
 * @Date 2022/11/18 17:38
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */


//实现java config第一步写个类实现spring的接口
public class WebInitializer implements WebApplicationInitializer {
    //web容器（例如tomcat）会在启动的时候去调用onStartup () ServletContext web上下文对象
    //servlet 3.0版本以后提出的一个新规范SPI
    //“你”的项目里面如果有某些类或者某些方法需要在启动的时候被Tomcat(Web容器)调用的话
    //首先,在你项目的根目录META-INF/services/javax.servlet.ServletContainerInitializer目录下建立一个文件
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //用java注解的方式去初始化spring 上下文环境
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        // 注册Mvc 配置信息
        //spring程序(容器)上下文对象
        //        ClassPathXmlApplieationContext
        ctx.register(MvcConfig.class);
        // 设置ServletContext 上下文信息
        ctx.setServletContext(servletContext);
        // 配置转发器Dispatcher
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        // 启动时即实例化Bean
        servlet.setLoadOnStartup(1);
    }
}
