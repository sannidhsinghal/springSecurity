package com.sannidh.practice.dialect;

import org.hibernate.dialect.PostgreSQL9Dialect;

import java.sql.Types;

public class JsonbPostgreSQLDialect extends PostgreSQL9Dialect {

    public JsonbPostgreSQLDialect() {
        super();
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
