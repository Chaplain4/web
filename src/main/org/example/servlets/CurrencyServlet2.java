package main.org.example.servlets;

import main.org.example.util.ServletUtils;
import main.org.example.util.XMLCurrencyParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/currencies")
public class CurrencyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usdCurrency = XMLCurrencyParser.getCurrency("840");
        String euroCurrency = XMLCurrencyParser.getCurrency("978");
        String rubCurrency = XMLCurrencyParser.getCurrency("643");
        String cnyCurrency = XMLCurrencyParser.getCurrency("156");
        Map<String, String> currenciesMap = new HashMap<>();
        currenciesMap.put("840", usdCurrency);
        currenciesMap.put("978", euroCurrency);
        currenciesMap.put("643", rubCurrency);
        currenciesMap.put("156", cnyCurrency);
        req.setAttribute("map", currenciesMap);
        ServletUtils.forward(req, resp, "/currencies.jsp");
    }
}
