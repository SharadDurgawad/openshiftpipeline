package com.hello.hello;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
	   System.out.println("Fixed Rate Task");
	}
}
