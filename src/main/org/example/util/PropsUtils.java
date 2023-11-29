package main.org.example.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PropsUtils {

    private Properties props;

    public PropsUtils(String path) throws IOException {
        props = new Properties();
        props.load(new FileInputStream(path));
    }

    public List<String> getUrlPatterns(String roleName) {
        Object val = props.get(roleName.toUpperCase(Locale.ROOT).replace(' ','_')); // Manager -> MANAGER
        List<String> urls = Arrays.asList(((String) val).split(", "));
        return urls;
    }

    public static void main(String[] args) throws IOException {
        PropsUtils utils = new PropsUtils("src/main/resources/ROLES_URL+PATTERNS_MAPPING.properties");
        List<String> urls = utils.getUrlPatterns("General_user");
        System.out.println(urls.size());
    }
}
