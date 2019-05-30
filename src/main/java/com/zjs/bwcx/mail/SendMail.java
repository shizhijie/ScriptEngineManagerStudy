package com.zjs.bwcx.mail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SendMail {
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				SendMail.send("hello====!!!!");
			}
		};
		
		//ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000000; i++) {
			executorService.submit(runnable);
		}
		executorService.shutdown();
	}
	
	public static void send(String msg) {
		System.out.println(Thread.currentThread().getName()+"  正在发送短信==>>"+msg);
	}
}
