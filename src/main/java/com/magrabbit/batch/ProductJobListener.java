package com.magrabbit.batch;

import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Product JobListener
 * 
 * @author Chiem Lam Mai
 * @since 01-10-2019
 */
public class ProductJobListener implements JobExecutionListener {

	private Date start, stop;

	/**
	 * Handle before starting the job
	 * 
	 * @param jobExecution
	 */
	@Override
	public void beforeJob(JobExecution jobExecution) {
		start = new Date();
		System.out.println("Product job starts at :" + start);
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Handle before stopping the job
	 * 
	 * @param jobExecution
	 */
	@Override
	public void afterJob(JobExecution jobExecution) {
		stop = new Date();
		System.out.println("------------------------------------------------");
		System.out.println("Product job stops at :" + stop);

		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("Product job completed successfully");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			System.err.println("Product job failed with following exceptions");
		}
	}
}