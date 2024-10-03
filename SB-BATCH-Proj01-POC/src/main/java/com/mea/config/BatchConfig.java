package com.mea.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.mea.listener.JobMonitoringListener;
import com.mea.processor.BookItemProcessor;
import com.mea.reader.BookItemReader;
import com.mea.writer.BookItemWriter;

@Configuration

public class BatchConfig {

	@Autowired
	private BookItemReader reader;
	@Autowired
	private BookItemWriter writer;
	@Autowired
	private BookItemProcessor processor;
	@Autowired
	private JobMonitoringListener listener;
	
	@Bean(name="step1")
	public Step createStep1(JobRepository repository, PlatformTransactionManager ptxManager) {
		System.out.println("BatchConfig.createStep1()");
		return new StepBuilder("step1", repository)
				.<String,String>chunk(3,ptxManager)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	@Bean(name="job1")
	public Job createJob(JobRepository repository,Step step1)
	{
		System.out.println("BatchConfig.createJob()");
		return new JobBuilder("job1", repository)
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.build();
	}
}
