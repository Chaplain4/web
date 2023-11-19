package main.org.example.servlets;


import main.org.example.jdbc.impl.UserDAOImpl;
import main.org.example.model.User;
import main.org.example.util.HTMLTableBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users")
public class UsersServlet  extends HttpServlet {

    private UserDAOImpl dao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<User> users = dao.all();
        if(users.size() > 0){
            HTMLTableBuilder htmlTableBuilder = new HTMLTableBuilder("Users List",
                    true, users.size(), 8, 14, 14, 14);
            htmlTableBuilder.addTableHeader("ID", "NAME", "EMAIL", "DETAILS", "IS ACTIVE", "ROLE", "CREATED", "UPDATED");
            for (User user: users) {
                htmlTableBuilder.addRowValues(user.getId(), user.getName(), user.getEmail(),
                        user.getDetails(), user.getIsActive() ? "YES": "NO",
                        user.getRole().getName(), user.getCreated_ts(), user.getUpdated_ts());
            }
            String template = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Users</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<USERS>\n" +
                    "</body>\n" +
                    "</html>";
            template = template.replace("<USERS>", htmlTableBuilder.build());
            resp.setContentType("text/html");
            resp.getWriter().println(template);
        }
    }
}
