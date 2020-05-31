package guru.springframework.jsonexample;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.*;

public class SimpleJettyService {
    public static void run(final Class<? extends Servlet> servlet){
        final Server server = new Server(8000);
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(servlet,"/*");
        server.setHandler(servletHandler);
        try{
            server.dumpStdErr();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
