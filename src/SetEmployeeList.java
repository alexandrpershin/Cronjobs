import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by apersin on 07-Apr-17.
 */

public  class SetEmployeeList implements Job {
    private   static ArrayList<Employe> empoyeList= new ArrayList<>();
    private   static Random random =new Random();



    public static ArrayList<Employe> getEmpoyeList(){

        return empoyeList;
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

         empoyeList.add( new Employe(getNames(),getSurNames()));


    }


    static String getNames(){
        String[] names= {"Alexandr","Ivan","Ignat","Petr","Adam","Helen","Iunona","Elvira","John","Vladimir","Marin","Sharlotta","Artem",
                "Vasile","Roman","Vladislav", "Evghenii","Dmitri","Stas","Valerii" };
        int select = random.nextInt(names.length);

        return  names[select];
    }

    public static String getSurNames(){
        String[] surNames={"Pershin","Smith","Traciuc","Chiosa","Oprea","Barbu","Efros","Gladeanu","Gruia","Belii","Cruz","Parpalac",
                "Placinta","Para","Cudalb", "Raducan","Panasenco","Lazar","Cusnir"};
        int select = random.nextInt(surNames.length);

        return  surNames[select];
    }
}
