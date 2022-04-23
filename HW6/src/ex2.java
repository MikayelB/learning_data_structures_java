import java.util.Arrays;

public class ex2 {
    public static void main(String[] args) {
        Person p1 = new Person("Jesus", "Christ", "God", "333");
        Person p2 = new Person("Jesus", "Christ", "God", "333");

        Person p3 = new Person("Hovsepa", "Davtyan", "Hovsepb", "1232123");
        Person p4 = new Person("Hovsepb", "Davtyan", "Hovsepa", "1232123");

        Person p5 = new Person("aaa", "aaa", "aaa", "123");
        Person p6 = new Person("bbb", "aaa", "aaa", "321");


        Person personArr[] = {p1,p2,p3,p4,p5,p6};

        System.out.println("-----Unsorted-----");
        // print at first
        for(int i = 0; i < personArr.length; i++){
            System.out.println(personArr[i].name + " " + personArr[i].surname + " " + personArr[i].patronymic + " " + personArr[i].socialSecurityNumber);
        }

        System.out.println();
        System.out.println("-----Sorted SSN-----");

        // sorting with SSNs
        Arrays.sort(personArr, new CompareSSN());

        // print afterwards
        for(int i = 0; i < personArr.length; i++){
            System.out.println(personArr[i].name + " " + personArr[i].surname + " " + personArr[i].patronymic + " " + personArr[i].socialSecurityNumber);
        }

        System.out.println();
        System.out.println("-----Sorted Name/Surname/Patronymic-----");
        // sorting with name, sirname, and patry...
        Arrays.sort(personArr);


        for(int i = 0; i < personArr.length; i++){
            System.out.println(personArr[i].name + " " + personArr[i].surname + " " + personArr[i].patronymic + " " + personArr[i].socialSecurityNumber);
        }


        // test
//        System.out.print("The result of comparing without ssn: ");
//        System.out.println(p1.compareTo(p2));
//
//        System.out.print("The result of comparing with ssn only: ");
//        System.out.println(CompareSSN.ssnCompare(p1, p2));
    }
}
