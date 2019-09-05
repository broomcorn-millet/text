import java.util.Properties;

public class datasource {
    public Properties properties;

    @Override
    public String toString() {
        return "datasource{" +
                "properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
