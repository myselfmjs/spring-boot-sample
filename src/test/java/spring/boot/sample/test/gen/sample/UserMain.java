/**
 * 
 */
package spring.boot.sample.test.gen.sample;

import com.google.common.collect.Maps;
import spring.boot.sample.gen.model.GenTable;
import spring.boot.sample.gen.model.GenColumn;
import spring.boot.sample.gen.utils.ConvertUtils;
import spring.boot.sample.gen.utils.GenUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
/**
 * 用户表
 * @author majunsheng
 */
public class UserMain {

	private static String[][] columns = new String[][]{
            {
                    "uid",/*列名*/
                    "",/*描述*/
                    "int",/*JDBC类型*/
                    "java.lang.Integer",/*JAVA类型*/
                    "uid",/*JAVA字段名:*/
                    "1",/*是否主键:1,是，0,非*/
                    "1",/*是否编辑:1,是，0,非*/
                    "1",/*是否列表:1,是，0,非*/
                    "0",/*是否查询:1,是，0,非*/
                    GenColumn.QUERY_TYPE_EQ,/*查询方式:*/
                    GenColumn.SHOW_TYPE_INPUT,/*显示方式:*/
                    "",/*字典类型:*/
                    "@NotNull"/*校验器:(多个#号隔开)*/,
                    ""/*字段长度:*/
            },
            {
                    "username",/*列名*/
                    "",/*描述*/
                    "varchar",/*JDBC类型*/
                    "java.lang.String",/*JAVA类型*/
                    "username",/*JAVA字段名:*/
                    "0",/*是否主键:1,是，0,非*/
                    "1",/*是否编辑:1,是，0,非*/
                    "1",/*是否列表:1,是，0,非*/
                    "0",/*是否查询:1,是，0,非*/
                    GenColumn.QUERY_TYPE_EQ,/*查询方式:*/
                    GenColumn.SHOW_TYPE_INPUT,/*显示方式:*/
                    "",/*字典类型:*/
                    "@Length(max=255)"/*校验器:(多个#号隔开)*/,
                    "255"/*字段长度:*/
            },
            {
                    "password",/*列名*/
                    "",/*描述*/
                    "varchar",/*JDBC类型*/
                    "java.lang.String",/*JAVA类型*/
                    "password",/*JAVA字段名:*/
                    "0",/*是否主键:1,是，0,非*/
                    "1",/*是否编辑:1,是，0,非*/
                    "1",/*是否列表:1,是，0,非*/
                    "0",/*是否查询:1,是，0,非*/
                    GenColumn.QUERY_TYPE_EQ,/*查询方式:*/
                    GenColumn.SHOW_TYPE_INPUT,/*显示方式:*/
                    "",/*字典类型:*/
                    "@Length(max=255)"/*校验器:(多个#号隔开)*/,
                    "255"/*字段长度:*/
            }
    };

    public static void main(String[] args) {
        Map<String, Object> configs = Maps.newHashMap();
        configs.put("packageName", "spring.boot.sample"); //基础包路径
        configs.put("moduleName", "sample");  //模块名
        configs.put("entityType","grid"); //tree为树机构，grid为表格格式
        configs.put("schema", "test");     //库名称
        configs.put("tableName", "user"); //表名称
        configs.put("ClassName", "User"); //java实体类名
        configs.put("functionName", "用户表"); //表功能
        configs.put("functionAuthor", "majunsheng");//作者

        GenTable table = new GenTable();
        table.setSchema("test");
        table.setTable("user");
        GenUtils.parseTableColumn(table, columns);
        configs.put("table", table);
        configs.put("dbName", "mysql");

        //生成实体
        GenUtils.genJavaFile(configs, "entity", "entity");
        //生成DAO对象
        GenUtils.genJavaFile(configs, "dao", "dao");
        //生成DAO的xml
        GenUtils.genMybatisXml(configs);
        //生成搜索VO的xml
        GenUtils.genJavaFile(configs, "search", "vo");
        //生成Service
        GenUtils.genJavaFile(configs, "service", "service");
        //生成Controller
        GenUtils.genJavaFile(configs, "controller", "web");
        //生成List页面
        GenUtils.genJspFile(configs, "list");
        //生成Form页面
        GenUtils.genJspFile(configs, "form");
    }

}