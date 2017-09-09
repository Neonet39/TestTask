package Modal;

import java.util.HashMap;
import java.util.Map;


public class Configuration {
    private Map map = new HashMap<String,String>();

    public String getMap(String key) {
        return (String) map.get(key);
    }

    public void setMap(String key,String value) {
        this.map.put(key,value);
    }
}
