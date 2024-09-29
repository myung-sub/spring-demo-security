package com.fxsong.demo.security.system;

import org.springframework.jdbc.support.JdbcUtils;

public class CamelMap extends DataMap {

    @Override
    public Object put(String key, Object value) {
		String newKey = JdbcUtils.convertUnderscoreNameToPropertyName(key);
        return super.put(newKey, value);
    }

}
