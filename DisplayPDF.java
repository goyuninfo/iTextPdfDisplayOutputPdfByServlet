package ca.i88;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/pdf")
public class DisplayPDF extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {DisplayPDF
        response.setContentType("application/pdf");
        ServletOutputStream out;
        out = response.getOutputStream();
        BufferedOutputStream bout;
        try (FileInputStream fin = new FileInputStream("/tmp/i88.ca.pdf"); BufferedInputStream bin = new BufferedInputStream(fin)) {
            bout = new BufferedOutputStream(out);
            int ch = 0;
            while ((ch = bin.read()) != -1) {
                bout.write(ch);
            }
        }
        bout.close();
        out.close();
    }
}
