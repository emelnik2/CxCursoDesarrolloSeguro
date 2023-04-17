import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

public class DomXssMitigationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String escapedName = StringEscapeUtils.escapeHtml4(name);
        String html = "<html><head><title>Greeting Page</title></head><body><h1>Hello " + escapedName + "!</h1></body></html>";
        response.getWriter().append(html);
    }
}
