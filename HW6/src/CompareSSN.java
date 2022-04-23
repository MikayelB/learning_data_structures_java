import java.util.Comparator;

public class CompareSSN implements Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2) {
        if(p1.socialSecurityNumber.length() > p2.socialSecurityNumber.length()){
            return 1;
        } else if(p1.socialSecurityNumber.length() < p2.socialSecurityNumber.length()){
            return -1;
        }


        if(p1.socialSecurityNumber.equals(p2.socialSecurityNumber)){
            return 0;
        } else{
            int i = 0;
            while(p1.socialSecurityNumber.charAt(i) == p2.socialSecurityNumber.charAt(i)){
                i++;
            }

            if(p1.socialSecurityNumber.charAt(i) > p2.socialSecurityNumber.charAt(i)){
                return 1;
            } else{return -1;}
        }
    }


    // for single test use (same code as above just in a static method
    public static int ssnCompare(Person p1, Person p2) {
        if(p1.socialSecurityNumber.length() > p2.socialSecurityNumber.length()){
            return 1;
        } else if(p1.socialSecurityNumber.length() < p2.socialSecurityNumber.length()){
            return -1;
        }


        if(p1.socialSecurityNumber.equals(p2.socialSecurityNumber)){
            return 0;
        } else{
            int i = 0;
            while(p1.socialSecurityNumber.charAt(i) == p2.socialSecurityNumber.charAt(i)){
                i++;
            }

            if(p1.socialSecurityNumber.charAt(i) > p2.socialSecurityNumber.charAt(i)){
                return 1;
            } else{return -1;}
        }
    }
}
