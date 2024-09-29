package com.fxsong.demo.security.system;

import java.io.Serial;
import java.util.LinkedHashMap;

public class DataMap extends LinkedHashMap<String, Object> {

    @Serial
    private static final long serialVersionUID = 1L;

    public String getString(String key) {
        return (String) super.get(key);
    }

    public Integer getInteger(String key) {
        return (Integer) super.get(key);
    }

    public Long getLong(String key) {
        return (Long) super.get(key);
    }

    public Double getDouble(String key) {
        return (Double) super.get(key);
    }

    public Float getFloat(String key) {
        return (Float) super.get(key);
    }
}
