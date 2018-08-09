package com.nnstn.demo.spring.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void executorAsyncTask(Integer i){
		System.out.println("异步执行任务："+ i);
	}
	@Async
	public void executorAsyncTaskPlus(Integer i){
		System.out.println("异步执行任务+1："+ (i+1));
	}
}
