import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    String line_session = "";

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        /*
         * 使用Pattern.CASE_INSENSITIVE（大小写不敏感的匹配）和Pattern.MULTILINE（多行模式）标记，忽略大小写地匹配所有以java开头的行
         */

        Matcher m = p.matcher("java has regex\nJava has regex\n"
                + "JAVA has pretty good regular expression\n"
                + "Regular expressions are in JavA");
        while (m.find()) {
            System.out.println(m.group());//输出已匹配的部分
        }

        ///////////////////////////////////////////////////////////
        comments();
        g();

        /////////////////////////////////////////////////////////

        PatternDemo filter = new PatternDemo();
//        filter.evaluate(args[0], args[1], args[2]);
        String flag = filter.evaluate("755074",
                "969001",
                "(00:00 ~ 20:40)755074(21:40) ---> ( +1,04:20) 969001( +1, 02:20) fff ---> (03:45) 757902(06:00) ---> (07:15)757012(08:15 ~ 23:59)");
        System.out.println(flag);

    }

    public static void comments() {
        /*
         * 不使用Pattern.COMMENTS(不启动注释)
         */
        String s = "123";
        Pattern p1 = Pattern.compile(" (\\d+)+#test comments");
        Matcher m1 = p1.matcher(s);
        System.out.println(m1.matches());//false
        /*
         * 正则表达式中使用启动注释的标记
         */
        Pattern p2 = Pattern.compile("(?x) (\\d+)+#test comments");
        Matcher m2 = p2.matcher(s);
        System.out.println(m2.matches());//true
        /*
         * 参数中使用Pattern.COMMENTS以启动注释
         */
        Pattern p3 = Pattern.compile("  (\\d+)+#test comments", Pattern.COMMENTS);
        Matcher m3 = p3.matcher(s);
        System.out.println(m3.matches());//true


    }

    public static void g() {
        //需要截取的字符串
        String splitStr = "[user:name] = select name from user";
        // 定义规则
        String pattern = "(\\[+)(\\w+)\\:(\\w+)(\\]+)";
        //Pattern.compile函数
        Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(splitStr);
        while (matcher.find()) { //表示往下遍历
            //截取出来的字符串 [user:name]
            String allcon = matcher.group(0);
            System.out.println("allcon匹配的结果为" + allcon);
            //截取的开始位置 [
            String tableJoin1 = matcher.group(1);
            System.out.println("tableJoin1匹配的结果为" + tableJoin1);
            //截取出来的表名 user
            String tableName = matcher.group(2);
            System.out.println("tableName匹配的结果为" + tableName);
            //截取出来的字段名 name
            String filed = matcher.group(3);
            System.out.println("filed匹配的结果为" + filed);
            //截取的结束位置 ]
            String tableJoin4 = matcher.group(4);
            System.out.println("tableJoin4匹配的结果为" + tableJoin4);
        }
    }


    public String evaluate(String resp_org_name, String actual_next_name, String rout_line) {
        String flag = "0";

        boolean b = rout_line instanceof String;
        if (b == false) return flag;
        Pattern pattern = Pattern.compile("(\\)[A-Za-z0-9\\f\\r\\t\\n\\sMOT]+\\()");
        Matcher matcher = pattern.matcher(rout_line);
        System.out.println(matcher.find());
        System.out.println(matcher.group().replaceAll("\\s*", "").substring(1, 7));
        System.out.println(matcher.group(0));

        List<String> org_detail = new ArrayList();

        while (matcher.find()) {
            String org = matcher.group().replaceAll("\\s*", "").substring(1, 7);
            // System.out.println(org);
            org_detail.add(org);
        }

        if (org_detail.size() < 2) return flag;

        for (int i = 0; i < org_detail.size(); i++) {

            String rout_resp_name = org_detail.get(i);

            // 判断逻辑：责任中心=线路中心任意节点，实际下一个中心=线路中心的下一个节点
            if (rout_resp_name.equals(resp_org_name)) {
                // System.out.println("责任中心节点名称：" + rout_resp_name);
                String rout_next_name = org_detail.get(i + 1);
                // System.out.println("实际下一个节点名称：" + rout_next_name);
                if (rout_next_name.equals(actual_next_name))
                    flag = "1";
                break;
            }
        }

        return flag;

    }


}

