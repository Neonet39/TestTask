package Service;

import java.util.List;

/**
 * Created by Evgeny on 08.09.2017.
 */
public interface ServiceCofe<T> {
    List<T> getAssortmentCoffe();
    void setOrderCoffe(T orderCoffe);
}
