import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;


@Description(name = "myUDFTest")
public class UDFTest extends UDF {
    //重写evaluate方法
    public String evaluate(String phone){
        if (phone.length() == 11){
            String res = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
            System.out.println(res);
            return res;
        } else {
            return phone;
        }

    }
}
