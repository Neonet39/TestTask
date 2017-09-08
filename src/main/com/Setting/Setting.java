package Setting;

import com.sun.scenario.Settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Evgeny on 08.09.2017.
 */
public class Setting {

    private static final Setting INSTANCE = new Setting();

    private final Properties properties = new Properties();

    private Setting() {

        try {
            properties.load(new FileInputStream(new String(this.getClass().getClassLoader().getResource("db.properties").getFile())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Setting getInstance() {
        return INSTANCE;
    }

    public  String value(String key) {

        return this.properties.getProperty(key);
    }
}
