public class Demo {
    public static void main(String[] args) {
        String newCall = evaluate("12345678911");
        System.out.println("---------------" + newCall);
    }


    public static String evaluate(String phone){
        if (phone.length() == 11){
            String res = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
            System.out.println(res);
            return res;
        } else {
            return phone;
        }

    }
}


