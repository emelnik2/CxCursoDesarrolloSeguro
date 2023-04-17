import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DomXssServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private void outputResponse(final HttpServletResponse response, final String uri)throws ServletException, IOException{
        File file = new File(uri);

        //set headers and output the response
        BufferedInputStream input;
        ServletOutputStream outputStream = response.getOutputStream();
        setHeaders(response);
        byte[] byteBuf = new byte[1024];
        try {
            input = new BufferedInputStream(new FileInputStream(file));
            int read;
            do{
                read = input.read(byteBuf, 0, byteBuf.length);
                if(read > 0) {
                    outputStream.write(byteBuf, 0, read);
                }
            }while (read >=0);
            input.close();
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
