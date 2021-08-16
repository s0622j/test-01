public class Girl implements Comparable<Girl> {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // … setter and getter …


    @Override
    public String toString() {
        return "Girl{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Girl o) {
        return this.age - o.age;
    }
}
