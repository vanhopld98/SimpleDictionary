import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", value = "/translate")
public class DictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin Chao");
        dictionary.put("how", "The Nao");
        dictionary.put("book", "Quyen Vo");
        dictionary.put("computer", "May Tinh");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if (result != null) {
            writer.println("Word : " + search+"<br>");
            writer.println("Result : " + result);
        } else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }
}
