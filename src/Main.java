import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Trigger triggerPrint = TriggerBuilder.newTrigger()
                .withIdentity("triggerPrint", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/60 * * * * ?"))
                .build();

                JobDetail jobDetailPrint = JobBuilder.newJob(PrintEmpoyeeList.class)
                        .withIdentity("PrintEmpoyeeList", "group1").build();

        JobDetail jobDetailSet = JobBuilder.newJob(SetEmployeeList.class)
                .withIdentity("SetEmployeeList", "group").build();


        Trigger triggerSet = TriggerBuilder.newTrigger()
                .withIdentity("triggerSet", "group")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                .build();

                Scheduler  scheduler = new StdSchedulerFactory().getScheduler();

                scheduler.scheduleJob(jobDetailPrint, triggerPrint);
                scheduler.scheduleJob(jobDetailSet, triggerSet);
                scheduler.start();
                Thread.currentThread().join();
                scheduler.shutdown();

        }
    }


