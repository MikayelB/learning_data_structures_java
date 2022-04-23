public class Person implements Comparable<Person>{
    String name;
    String surname;
    String patronymic;
    String socialSecurityNumber;

    public Person (String name, String surname, String patronymic, String socialSecurityNumber){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // getters
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getPatronymic(){return patronymic;}
    public String getSocialSecurityNumber(){return socialSecurityNumber;}

    // setters


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }

    public void setSocialSecurityNumber(String ssn){
        this.socialSecurityNumber = ssn;
    }


    @Override
    public int compareTo(Person person) {
        // -1 O1 < O2  if 1st is smaller
        // 0  O1 = O2  if equal
        // 1  O1 > O2  if 2nd is smaller

        int n = compareStrings(name, person.name);
        if (n != 0 ) return n;

        int n1 = compareStrings(surname, person.surname);
        if( n1 != 0) return n1;

        int n2 = compareStrings(patronymic, person.patronymic);
        if(n2 != 0) return n2;

        return 0;
    }

    private int compareStrings(String st1, String st2){

        if(st1.length() > st2.length()){
            return 1;
        } else if(st1.length() < st2.length()){
            return -1;
        }
        if(st1.equals(st2)){
            return 0;
        } else{
            int i = 0;
            while(st1.charAt(i) == st2.charAt(i)){
                i++;
            }

            if(st1.charAt(i) > st2.charAt(i)){
                return 1;
            } else{return -1;}
        }

    }
}
