package com.test.nan;

public class ThreadPriority implements Runnable {
	
	public void run()
	{
		System.out.println(Thread.currentThread());
	}
	public static void main(String[] args) 
	{
		ThreadPriority a = new ThreadPriority();
		Thread t = new Thread(a, "NewThread");

		System.out.println("Priority of Thread: " +t.getPriority());
		System.out.println("Name of Thread: " +t.getName());
		t.start();
	}
}
