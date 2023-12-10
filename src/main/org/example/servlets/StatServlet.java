package main.org.example.servlets;

import main.org.example.jdbc.impl.StatDAOImpl;
import main.org.example.model.Stat;
import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stat")
public class StatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.openJSP(req, resp, "statistics_form");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatDAOImpl sdi = new StatDAOImpl();
        Stat stat = new Stat();
        stat.setName(req.getParameter("name"));
        stat.setEmail(req.getParameter("email"));
        stat.setAge(Integer.valueOf(req.getParameter("age")));
        stat.setEducation(req.getParameter("role"));
        String wouldRecommend = "";
        if (req.getParameter("recommend-1") != null) {
            wouldRecommend = "Yes";
        } else if (req.getParameter("recommend-2") != null) {
            wouldRecommend = "No";
        } else {
            wouldRecommend = "Maybe";
        }
        stat.setWouldRecommend(wouldRecommend);
        StringBuilder languagesKnown = new StringBuilder("");
        if (req.getParameter("inpC") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", C");
            } else {
                languagesKnown.append("C");
            }
        }
        if (req.getParameter("inpC++") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", C++");
            } else {
                languagesKnown.append( "C++");
            }
        }
        if (req.getParameter("inpC#") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", C#");
            } else {
                languagesKnown.append("C#");
            }
        }
        if (req.getParameter("inpJava") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", Java");
            } else {
                languagesKnown.append("Java");
            }
        }
        if (req.getParameter("inpPython") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", Python");
            } else {
                languagesKnown.append("Python");
            }
        }
        if (req.getParameter("inpJavaScript") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", JavaScript");
            } else {
                languagesKnown.append("JavaScript");
            }
        }
        if (req.getParameter("inpReact") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", React");
            } else {
                languagesKnown.append("React");
            }
        }
        if (req.getParameter("inpAngular") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", Angular");
            } else {
                languagesKnown.append("Angular");
            }
        }
        if (req.getParameter("inpDjango") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", Django");
            } else {
                languagesKnown.append("Django");
            }
        }
        if (req.getParameter("inpSpring") != null) {
            if (languagesKnown.length() > 0) {
                languagesKnown.append(", Spring");
            } else {
                languagesKnown.append("Spring");
            }
        }
        stat.setLanguagesKnown(languagesKnown.toString());
        stat.setComments(req.getParameter("comment"));
        sdi.create(stat);
    }
}

