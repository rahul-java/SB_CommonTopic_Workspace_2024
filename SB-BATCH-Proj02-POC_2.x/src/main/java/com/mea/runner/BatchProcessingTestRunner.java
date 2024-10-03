package com.mea.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessingTestRunner implements CommandLineRunner {

	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;
	
	
	@Override
	public void run(String... args) throws Exception {

		//Run the job
		JobParameters parameter=new JobParametersBuilder().addDate("SYS_Date", new Date()).toJobParameters();
		JobExecution execution=launcher.run(job, parameter);
		System.out.println("Execution Status ::: "+execution.getExitStatus());
		
		System.out.println("Press any key to Continue...");
		System.in.read();
	}

}
