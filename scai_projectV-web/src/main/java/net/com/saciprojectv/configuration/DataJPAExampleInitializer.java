/**
 * 
 */
package net.com.saciprojectv.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Comment(s): The old way to load the application context configuration of our
 * application is to use the web application deployment descriptor file, which
 * is more commonly known as web.xml . However, because we are using the Spring
 * Framework 3.1 in a Servlet 3.0 environment, we can create a web application
 * configuration class by implementing the WebApplicationInitializer interface.
 * This ensures that Spring Framework automatically detects our configuration
 * class when a servlet container is started.
 * 
 * @author Paulo Garcia
 * @Feb 8, 2014
 * @3:02:44 AM
 * 
 *          Scai Project_V®
 * 
 *          Developed by Paulo Garcia
 */
public class DataJPAExampleInitializer implements WebApplicationInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 * .ServletContext)
	 */
	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		// Loading application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationContext.class);
		// Dispatcher servlet
		ServletRegistration.Dynamic dispatcher = arg0.addServlet("dispatcher",
				new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		// Context loader listener
		arg0.addListener(new ContextLoaderListener(rootContext));
	}

}
