import model.LPAStudent;
import model.LPAStudentComparator;
import util.QueryList;

import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();
        for(int i=0;i<50;i++){
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        PrintList(queryList);

        System.out.println(".".repeat(60));

        System.out.println("Matches");
        var matches = queryList
                .getMatches("percentComplete","50")
                .getMatches("Course","Python");
        PrintList(matches);
        System.out.println(".".repeat(60));

        matches.sort(new LPAStudentComparator());
        PrintList(matches);


        System.out.println(".".repeat(60));
        System.out.println("Ordered");
        matches.sort(null);
        PrintList(matches);
    }

    //We can not use PrintList for LPAStudents
    public static void PrintList(List<?> students){
        for(var student : students){
            System.out.println(student);
        }
    }




}