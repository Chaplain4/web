package main.org.example.util;

import main.org.example.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class SecUtils {
    public static boolean hasRole(HttpServletRequest request, String... roleNames) {
        User user = ServletUtils.getUserFromSession(request);
        if (user == null) { // temp for Stranger
            return false;
        }
        return Arrays.asList(roleNames).contains(user.getRole().getName());
    }
}
