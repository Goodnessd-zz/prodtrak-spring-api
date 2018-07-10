package demo.mongo;

import java.util.HashMap;
import java.util.Map;

public abstract class MemoryRepository<TKey, TValue>  {
    protected final Map<TKey, TValue> data = new HashMap<>();
    private final Class<TValue> valueClass;


    protected MemoryRepository(Class<TValue> valueClass) {
        this.valueClass = valueClass;
    }

    public TValue get(TKey id){
        return data.get(id);
    }
}
