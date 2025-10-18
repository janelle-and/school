import java.util.HashMap;
import java.util.Map;

public class Repository <T extends DatabaseEntity>{

    Map<Long, T> database = new HashMap<Long, T>();

    public void save(T entity){
        database.put(entity.getId(), entity);
    }

    public T findById(long id){
        return database.get(id);
    }
}
