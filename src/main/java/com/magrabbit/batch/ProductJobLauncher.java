package com.magrabbit.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Product job launcher
 * 
 * @author Chiem Lam Mai
 * @since 01-10-2019
 */
@EnableScheduling
@Component
public class ProductJobLauncher{

	/**
	 * The method running the product job in minutes 15/30/45/60 of an hour
	 */
	@SuppressWarnings("resource")
	@Scheduled(cron = "0 */15 * * * *")
	public void run() {

		ApplicationContext context = new ClassPathXmlApplicationContext("product-job-config.xml");

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("productJob");

		try {
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
			System.out.println("Job exit with status : " + jobExecution.getStatus());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			System.err.println("Job product failed");
			e.printStackTrace();
		}
	}
}