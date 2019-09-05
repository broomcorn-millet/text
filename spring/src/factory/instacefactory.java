package factory;

import java.util.HashMap;
import java.util.Map;

public class instacefactory {
    private Map<String,car> cars=null;

    public instacefactory() {
        cars =new HashMap<String,car>();
        cars.put("audi",new car("audi",30000));
        cars.put("ford",new car("ford",40000));
    }

    public car getcar(String brand){
       return cars.get(brand);
    }
}
