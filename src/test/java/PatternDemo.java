import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
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

/*
典型的调用顺序是
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();在仅使用一次正则表达式时，可以方便地通过此类定义 matches 方法。此方法编译表达式并在单个调用中将输入序列与其匹配。语句
        boolean b = Pattern.matches("a*b", "aaaaab");等效于上面的三个语句，尽管对于重复的匹配而言它效率不高，因为它不允许重用已编译的模式。
        此类的实例是不可变的，可供多个并发线程安全使用。Matcher 类的实例用于此目的则不安全。


        一、两种表达方式表达意义的区别：
        1、\s代表正则表达式中的一个空白字符（可能是空格、制表符、其他空白）。
        2、\\s代表字符\和字符s，因为\在正则中有特殊意义，所有需要转义，写成了\\ 。
        二、表达的作用的区别：
        1、\s用于匹配空白字符。
        2、\\s用于匹配字符串中的\和s，两个字符。
        扩展资料：
        另外，正则表达式的() [] {}也有不同的意思
        1、() 是为了提取匹配的字符串。表达式中有几个()就有几个相应的匹配字符串。
        2、(\s*)表示连续空格的字符串。
        3、[]是定义匹配的字符范围。比如 [a-zA-Z0-9] 表示相应位置的字符要匹配英文字符和数字。[\s*]表示空格或者*号。
        4、{}一般用来表示匹配的长度，比如 \s{3} 表示匹配三个空格，\s[1,3]表示匹配一到三个空格。
        (0-9) 匹配 '0-9' 本身。 [0-9]* 匹配数字（注意后面有 *，可以为空）
        [0-9]+ 匹配数字（注意后面有 +，不可以为空）{1-9} 写法错误。
        [0-9]{0,9} 表示长度为 0 到 9 的数字字符串。
        5、过滤内容里面有数或空格数字
        preg_replace("/\d{1,}\s{0,1}/", "xxxxxxxx", $signaturecontent);

        字符
        x 字符 x
        \\ 反斜线字符
        \0n 带有八进制值 0 的字符 n (0 <= n <= 7)
        \0nn 带有八进制值 0 的字符 nn (0 <= n <= 7)
        \0mnn 带有八进制值 0 的字符 mnn（0 <= m <= 3、0 <= n <= 7）
        \xhh 带有十六进制值 0x 的字符 hh
        \uhhhh 带有十六进制值 0x 的字符 hhhh
        \t 制表符 ('\u0009')
        \n 新行（换行）符 ('\u000A')
        \r 回车符 ('\u000D')
        \f 换页符 ('\u000C')
        \a 报警 (bell) 符 ('\u0007')
        \e 转义符 ('\u001B')
        \cx 对应于 x 的控制符

        字符类
        [abc] a、b 或 c（简单类）
        [^abc] 任何字符，除了 a、b 或 c（否定）
        [a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围）
        [a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集）
        [a-z&&[def]] d、e 或 f（交集）
        [a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去）
        [a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去）

        预定义字符类
        . 任何字符（与行结束符可能匹配也可能不匹配）
        \d 数字：[0-9]
        \D 非数字： [^0-9]
        \s 空白字符：[ \t\n\x0B\f\r]
        \S 非空白字符：[^\s]
        \w 单词字符：[a-zA-Z_0-9]
        \W 非单词字符：[^\w]

        POSIX 字符类（仅 US-ASCII）
        \p{Lower} 小写字母字符：[a-z]
        \p{Upper} 大写字母字符：[A-Z]
        \p{ASCII} 所有 ASCII：[\x00-\x7F]
        \p{Alpha} 字母字符：[\p{Lower}\p{Upper}]
        \p{Digit} 十进制数字：[0-9]
        \p{Alnum} 字母数字字符：[\p{Alpha}\p{Digit}]
        \p{Punct} 标点符号：!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
        \p{Graph} 可见字符：[\p{Alnum}\p{Punct}]
        \p{Print} 可打印字符：[\p{Graph}\x20]
        \p{Blank} 空格或制表符：[ \t]
        \p{Cntrl} 控制字符：[\x00-\x1F\x7F]
        \p{XDigit} 十六进制数字：[0-9a-fA-F]
        \p{Space} 空白字符：[ \t\n\x0B\f\r]
        边界匹配器
        ^ 行的开头
        $ 行的结尾
        \b 单词边界
        \B 非单词边界
        \A 输入的开头
        \G 上一个匹配的结尾
        \Z 输入的结尾，仅用于最后的结束符（如果有的话）
        \z 输入的结尾

        Greedy 数量词
        X? X，一次或一次也没有
        X* X，零次或多次
        X+ X，一次或多次
        X{n} X，恰好 n 次
        X{n,} X，至少 n 次
        X{n,m} X，至少 n 次，但是不超过 m 次

 */
