package org.unclesniper.sqlbuild;

import java.util.Map;
import java.util.HashMap;

public class MapBuilder<KeyT, ValueT> {

    private final Map<KeyT, ValueT> collector;

    public MapBuilder(Map<KeyT, ValueT> collector) {
        this.collector = collector;
    }

    public Map<KeyT, ValueT> map() {
        return collector;
    }

    public MapBuilder<KeyT, ValueT> put(KeyT key, ValueT value) {
        collector.put(key, value);
        return this;
    }

    public static <KeyT, ValueT> MapBuilder<KeyT, ValueT> hash() {
        return new MapBuilder<KeyT, ValueT>(new HashMap<KeyT, ValueT>());
    }

}
