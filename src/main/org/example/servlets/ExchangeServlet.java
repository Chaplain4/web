package main.org.example.servlets;

import main.org.example.util.EmailUtils;
import main.org.example.util.ServletUtils;
import main.org.example.util.XMLCurrencyParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static main.org.example.util.ServletUtils.info;

@WebServlet("/exchange")
public class ExchangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.openJSP(req, resp, "exchange");
        ServletUtils.forward(req, resp, "exchange");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (Integer.parseInt(req.getParameter("amount")) <= 0) {
            String result = "wrong amount!";
            req.setAttribute("result", result);
            ServletUtils.openJSP(req, resp, "exchange-result");
        } else {
            Double amount = Double.parseDouble(req.getParameter("amount"));
            String currency = req.getParameter("currency");
            Double rate = 0.0;
            String option = req.getParameter("option");
            switch (currency) {
                case "USD": {
                    rate = Double.parseDouble(XMLCurrencyParser.getCurrency("840"));
                    info(req, "currency -> send");
                    break;
                }
                case "EUR": {
                    rate = Double.parseDouble(XMLCurrencyParser.getCurrency("978"));
                    info(req, "currency -> send");
                    break;
                }
                default: {
                    rate = Double.parseDouble(XMLCurrencyParser.getCurrency("643"));
                    info(req, "currency -> send");
                    break;
                }
            }
            switch (option) {
                case "buy": {
                    Double result = ((1 / rate) * amount) / 1.02;
                    String res1 = String.format("%.2f",result);
                    req.setAttribute("result", res1 + " " + currency);
                    ServletUtils.openJSP(req, resp, "exchange-result");
                    break;
                }
                case "sell": {
                    Double result = (rate * amount) / 1.02;
                    String res1 = String.format("%.2f",result);
                    req.setAttribute("result", res1  + " BYN");
                    ServletUtils.openJSP(req, resp, "exchange-result");
                    break;
                }
            }
        }
    }
}

