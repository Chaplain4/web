package main.homework.servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import static main.org.example.util.ServletUtils.info;

//Создайте planets.html где пользователю предлагается ввести свой вес и выбрать планету на которой он находится.
// После ввода происходит GET request и начинает работать WeightServlet, который обрабатывает данные (извлекает
// поверхностную гравитацию и вес объекта) и выводит ваш вес на планете.

@WebServlet("/weight")
public class Task3 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        info(req, "weight -> doGet()");
        RequestDispatcher rd = req.getRequestDispatcher("/planets.html");
        rd.forward(req, resp); //move forward with the same params and so on
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        info(req, "weight -> doPost()");
        PrintWriter pw = resp.getWriter();
        String planet = req.getParameter("planet");
        Double weight = Double.valueOf(req.getParameter("weight"));
        double mass = weight/Planet.EARTH.surfaceGravity();
        Planet p;

        System.out.println(planet);
        switch (planet) {
            case "MERCURY": {
                p = Planet.MERCURY;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "VENUS": {
                p = Planet.VENUS;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "EARTH": {
                p = Planet.EARTH;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "MARS": {
                p = Planet.MARS;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "JUPITER": {
                p = Planet.JUPITER;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "SATURN": {
                p = Planet.SATURN;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "URANUS": {
                p = Planet.URANUS;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            case "NEPTUNE": {
                p = Planet.NEPTUNE;
                String response = String.format("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
                pw.println(response);
                break;
            }
            default: {
                pw.println("Error");
            }
        }
    }
}


enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS (4.869e+24, 6.0518e6),
    EARTH (5.976e+24, 6.37814e6),
    MARS (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27, 7.1492e7),
    SATURN (5.688e+26, 6.0268e7),
    URANUS (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);
    private final double mass; // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }
    // universal gravitational constant (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;
    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("86"); // my Weight on Eart
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
    }
}
