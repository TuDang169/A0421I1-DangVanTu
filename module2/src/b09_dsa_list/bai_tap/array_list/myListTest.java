package b09_dsa_list.bai_tap.array_list;

public class myListTest {
    public static void main(String[] args) {
        MyList<Person> personMyList= new MyList<>();
        personMyList.add(new Person());
        personMyList.add(new Person());
        personMyList.add(new Person());
        personMyList.add(new Person());
        personMyList.add(new Person());

        MyList<Person> list2 = personMyList.clone();

        System.out.println(personMyList.get(1));
        System.out.println(personMyList.get(2));
    }
}
