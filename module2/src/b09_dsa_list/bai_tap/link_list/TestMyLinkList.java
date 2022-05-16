package b09_dsa_list.bai_tap.link_list;

public class TestMyLinkList {

    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student(int id) {
                this.id = id;
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        MyLinkList<Student> myLinkList = new MyLinkList<>();
        Student student1 = new Student(1,"Trung");
        Student student2 = new Student(1,"Hải");
        Student student3 = new Student(1,"Kiên");
        Student student4 = new Student(1,"Lĩnh");

        myLinkList.addFirst(student1);
        myLinkList.addFirst(student2);
        myLinkList.addLast(student3);
        myLinkList.add(3,student4);
        for(int i = 0; i< myLinkList.size(); i++){
            Student student = (Student) myLinkList.get(i);
            System.out.println(student.getName());
        }
    }
}
