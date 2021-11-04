import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 一进多出
 * 输入数据:多组kv对的组织机构  210901:210901,773023:000000,969047:969047,771001:771001
 * 输出数据:有效线路路段多行KV
 * 210901-969047
 * 969047-771001
 */

public class SplitWaringOrgUDF extends GenericUDTF {
    //输出数据的集合
    private ArrayList<String> list = new ArrayList<String>();

    //初始化方法
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        //输出数据的默认列名，可以被别名覆盖
        List<String> names = new ArrayList<String>();
        names.add("word");
        //输出数据的类型
        List<ObjectInspector> columnType  = new ArrayList<ObjectInspector>();
        columnType.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        StructObjectInspector outputOI = ObjectInspectorFactory.getStandardStructObjectInspector(names, columnType );
        return outputOI;

    }

    //处理输入数据的方法
    @Override
    public void process(Object[] objects) throws HiveException {
        //提取输出数据
        String input = objects[0].toString();
//        String string = objects[1].toString();
        String string = ",";
        //分割
        String[] word = input.split(string);
        //遍历数组
        for (int i = 0; i < word.length; i++) {
            //清空集合
            list.clear();
            //将数据存入集合
            list.add(word[i]);
            //输出集合
//            forward(list);
            System.out.println(word[i]);
        }
    }

    @Override
    public void close() throws HiveException {

    }

    public static void main(String[] args) throws HiveException {
        SplitWaringOrgUDF orgUdf = new SplitWaringOrgUDF();
        String s1 = "210901,969047,969047,771001";
        String s2 = ",";

        Object[] args0 = new Object[]{s1};

        System.out.println(args0.length);
        orgUdf.process(args0);

    }
}





/**
 * 一进多出
 * 输入数据：a,b,c,d
 * 输出数据:a
 * b
 * c
 * d
 *

 */
/*
public class UDTFTest01 extends GenericUDTF {
    //输出数据的集合
    private ArrayList<String> list = new ArrayList<>();

    //初始化方法
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        //输出数据的默认列名，可以被别名覆盖
        List<String> names = new ArrayList<>();
        names.add("word");
        //输出数据的类型
        List<ObjectInspector> fieldOIs = new ArrayList<>();
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        StructObjectInspector outputOI = ObjectInspectorFactory.getStandardStructObjectInspector(names, fieldOIs);
        return outputOI;
    }

    //处理输入数据的方法
    @Override
    public void process(Object[] objects) throws HiveException {
        //提取输出数据
        String input = objects[0].toString();
        String string = objects[1].toString();
        //分割
        String[] word = input.split(string);
        //遍历数组
        for (int i = 0; i < word.length; i++) {
            //清空集合
            list.clear();
            //将数据存入集合
            list.add(word[i]);
            //输出集合
            forward(list);
        }
    }

    //收尾方法
    @Override
    public void close() throws HiveException {

    }
*/