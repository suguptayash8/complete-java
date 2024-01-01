package callable;

import java.util.ArrayList;
import java.util.List;

public class CustomCallableImpl implements CustomCallable<List> {
    @Override
    public List<Double> call() {
        List<Double> data = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            for (int j = 0; j< 1000; j++){
                data.add(Math.floor(Math.random()*10));
            }
        }
        return data;
    }
}
