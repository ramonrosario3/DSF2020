package Set.Tets;

import Set.Set;
import Set.ArraySet;

public class SetTest {
    public static void main(String args[]){
        Set<String> StudentsInPhysics = new ArraySet<String>(100);
        Set<String> StudentsInBiology = new ArraySet<String>(100);
        Set<String> StudentsInEnglish = new ArraySet<String>(100);

        StudentsInBiology.add("Kim");
        StudentsInEnglish.add("Tom");
        StudentsInPhysics.add("Tom");
        System.out.println(StudentsInPhysics.isMember("Tom")||StudentsInBiology.isMember("Tom"));
        System.out.println(StudentsInPhysics.union(StudentsInBiology).isMember("Tom"));//

        Set<String> A = new ArraySet<String>();
        Set<String> B = new ArraySet<String>();

        A.add("Tom");
        A.add("Kim");
        A.add("Joe");
        A.add("Ana");
        A.add("Joe");
        A.add("Tim");

        B.add("Joe");
        B.add("Ana");
        B.add("Joe");

        System.out.println(B.isSubset(A));
        System.out.println(B.difference(A).isEmpty());


    }
}
