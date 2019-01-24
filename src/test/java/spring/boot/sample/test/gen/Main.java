package spring.boot.sample.test.gen;


import spring.boot.sample.gen.utils.GenUtils;


public class Main {

    public static final String ENTITY_TYPE_GRID = "grid";
    public static final String ENTITY_TYPE_TREE = "tree";

    static {
        String packageName = "spring.boot.sample";
        String dbName = GenUtils.MYSQL;
        String dbIp = "127.0.0.1";
        String dbPort = "3306";
        String db = "test";
        String username = "root";
        String password = "root";
        GenUtils.init(packageName, dbName, dbIp, dbPort, db, username, password);
    }

    public static void main(String[] args) {
        createUser();
    }

    private static void createUser() {
        String schema = "test";
        String tableName = "employee";
        String moduleName = "sample";
        String className = "Employee";
        Boolean webFlag = true;
        Boolean serviceFlag = true;
        GenUtils.createMain(schema, tableName, moduleName, className, ENTITY_TYPE_GRID,
                "用户表", "majunsheng", serviceFlag, webFlag);
    }
}
