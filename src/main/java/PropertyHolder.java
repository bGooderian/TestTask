import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHolder {
    private final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    String authorizationToken;
    String apiUrl;

    Properties property = new Properties();

    {
        try {
            File jarPath = new File(PropertyHolder.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propPath = jarPath.getParentFile().getAbsolutePath();
            //fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);


            property.load(new FileInputStream(propPath+"/config.properties"));
            authorizationToken = property.getProperty("AuthorizationToken");
            apiUrl = property.getProperty("apiUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
