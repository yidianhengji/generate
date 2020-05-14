package com.pg.generate.gen;

public enum GenEnum {
    TYPE_VARCHAR("varchar"),
    TYPE_DATETIME("datetime"),
    TYPE_INT("int");

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
