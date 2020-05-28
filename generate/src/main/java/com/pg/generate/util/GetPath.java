package com.pg.generate.util;

public class GetPath {

    // 项目所在的路径
    private static final String ProjectPath = "F:\\shop\\generate\\generate";
    // java地址
    private static final String JavaPath = "src\\main\\java";
    // 项目包名
    private static final String JavaPackagePath = "com\\pg\\generate";
    // 项目包
    private static final String myPackage = "com.pg.generate";
    // mapper地址
    private static final String mapperPath = "src\\main\\resources\\mapper";

    public static String getPath() {
        return ProjectPath + "\\" + JavaPath + "\\" + JavaPackagePath;
    }

    public static String getMapperPath() {
        return ProjectPath + "\\" + mapperPath;
    }
}
