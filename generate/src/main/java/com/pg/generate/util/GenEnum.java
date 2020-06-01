package com.pg.generate.util;

public enum GenEnum {
    TYPE_VARCHAR("varchar"),
    TYPE_DATETIME("datetime"),
    TYPE_INT("int"),
    TYPE_JAVA_VARCHAR("String"),
    TYPE_JAVA_DATETIME("Date"),
    TYPE_JAVA_INT("Integer")

    ;

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    GenEnum(String typeName) {
        this.typeName = typeName;
    }
}
