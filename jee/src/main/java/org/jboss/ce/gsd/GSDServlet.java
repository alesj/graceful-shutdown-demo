package org.jboss.ce.gsd;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public class GSDServlet extends HttpServlet {
    private static final Random RAND = new Random();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int secs = Math.abs(RAND.nextInt(120)); // 2min
        try {
            log(String.format("In process for %ssec ...", secs));
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException(e);
        }
    }
}
