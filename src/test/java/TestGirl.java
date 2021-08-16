import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestGirl {
//    public static void main(String[] args) {
//        Girl g1 = new Girl("yangmi", 29);
//        Girl g2 = new Girl("dongjie", 18);
//        Girl g3 = new Girl("fengjie", 38);
//        ArrayList<Girl> girls = new ArrayList<>();
//        girls.add(g1);
//        girls.add(g2);
//        girls.add(g3);
//        Collections.sort(girls);
//        for (Girl g : girls) {
//            System.out.println(g);
//        }
//    }


    public static void main(String[] args) {
        Girl g1 = new Girl("yangmi", 29);
        Girl g2 = new Girl("dongyue", 18);
        Girl g3 = new Girl("fengjie", 38);
        ArrayList<Girl> girls = new ArrayList<>();
        girls.add(g1);
        girls.add(g2);
        girls.add(g3);
// 使用比较器
        Collections.sort(girls, new Comparator<Girl>() {
            @Override
            public int compare(Girl o1, Girl o2) {
                return -(o1.getAge() - o2.getAge());
            }
        });
        for (Girl g : girls) {
            System.out.println(g);
        }
    }
}
