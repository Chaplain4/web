package main.org.example.servlets;

import main.org.example.util.EmailUtils;
import main.org.example.util.HTMLTableBuilder;
import main.org.example.util.XMLCurrencyParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static main.org.example.util.ServletUtils.*;


@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        info(req, "currency -> doGet()");
        PrintWriter pw = resp.getWriter();
        try {
            String mail = req.getParameter("email");
            String currency = req.getParameter("code");
            switch (currency) {
                case "USD": {
                    String rate = XMLCurrencyParser.getCurrency("840");
                    EmailUtils.send(mail, "Latest USD Currency", "<b>" + rate + "</b>");
                    info(req, "currency -> send");
                    break;
                }
                case "EUR": {
                    String rate = XMLCurrencyParser.getCurrency("978");
                    EmailUtils.send(mail, "Latest EUR Currency", "<b>" + rate + "</b>");
                    info(req, "currency -> send");
                    break;
                }
                case "RUB": {
                    String rate = XMLCurrencyParser.getCurrency("643");
                    EmailUtils.send(mail, "Latest RUB Currency", "<b>" + rate + "</b>");
                    info(req, "currency -> send");
                    break;
                }
                default: {
                    String rate = XMLCurrencyParser.getCurrency("840");
                    EmailUtils.send(mail, "Latest USD Currency", "<b>" + rate + "</b>");
                    info(req, "currency -> send");
                    rate = XMLCurrencyParser.getCurrency("978");
                    EmailUtils.send(mail, "Latest EUR Currency", "<b>" + rate + "</b>");
                    info(req, "currency -> send");
                    rate = XMLCurrencyParser.getCurrency("643");
                    EmailUtils.send(mail, "Latest RUB Currency", "<b>" + rate + "</b>");
                    info(req, "currency -> send");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("some error");
            info(req, "currency -> ERROR: " + e.getCause());
        }
        pw.println("Check your email");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        info(req, "currency -> doPost()");
        PrintWriter pw = resp.getWriter();
        try {
            String mail = req.getParameter("email");
            String usdCurrency = XMLCurrencyParser.getCurrency("840");
            String euroCurrency = XMLCurrencyParser.getCurrency("978");
            String rubCurrency = XMLCurrencyParser.getCurrency("643");
            String cnyCurrency = XMLCurrencyParser.getCurrency("156");
            Date date = new Date();
            HTMLTableBuilder builder = new HTMLTableBuilder("currencies", true, 4, 4, 5, 5, 5);
            builder.addTableHeader("Name", "Code", "Value", "Date");
            builder.addRowValues("USD", "840", usdCurrency, date.toString());
            builder.addRowValues("EUR", "978", euroCurrency, date.toString());
            builder.addRowValues("RUB", "643", rubCurrency, date.toString());
            builder.addRowValues("CNY", "156", cnyCurrency, date.toString());
            String table = builder.build();
            EmailUtils.send(mail,"Latest rates", table);
            info(req, "currency -> send");
            resp.setContentType("text/html");
            pw.println(table);
            pw.println("<h1>Check your email as well</h1>");


        } catch (Exception e) {

        }
    }
}
