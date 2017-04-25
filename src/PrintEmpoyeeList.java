import org.quartz.*;

import javax.swing.*;
import java.util.ArrayList;

public  class PrintEmpoyeeList implements Job {
    private   static ArrayList<Employe> empoyeList;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        empoyeList=SetEmployeeList.getEmpoyeList();
        for (Employe employe : empoyeList) {
            System.out.println(employe.getName()+" "+employe.getSurName());
        }
        System.out.println("**********************");
        System.out.println("Total="+empoyeList.size());
        System.out.println("**********************");

    }
}
