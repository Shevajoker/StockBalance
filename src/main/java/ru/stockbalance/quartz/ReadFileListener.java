package ru.stockbalance.quartz;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

public class ReadFileListener extends QuartzInitializerListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		super.contextInitialized(sce);
		
		ServletContext ctx = sce.getServletContext();
		StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QUARTZ_FACTORY_KEY);
		try {
			Scheduler schelder = factory.getScheduler();
			JobDetail jobDetail = JobBuilder.newJob(ReadFileJob.class).build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("ReadFileJob")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 45 8 1/1 * ? *"))
					.startNow()
					.build();
			
			schelder.scheduleJob(jobDetail, trigger);
			schelder.start();
		} catch (Exception e) {
			System.out.println("ERROR---" + e.getMessage());
		}
		
	}

	
	
}
