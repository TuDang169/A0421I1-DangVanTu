import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCalculatorServlet", value = "/result")
public class DiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        Float price = Float.parseFloat(request.getParameter("price"));
        Float percent = Float.parseFloat(request.getParameter("percent"));

        double discount = price * percent * 0.01;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Description: "      + description   + "</h1>");
        writer.println("<h1>Price: "            + price         + "</h1>");
        writer.println("<h1>percent: "          + percent       + "</h1>");
        writer.println("<h1>Discount Amount: "  + discount      + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
