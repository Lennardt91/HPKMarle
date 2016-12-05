package de.lab4inf.wrb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WRBTaskObserver {

	ExecutorService exec = Executors.newCachedThreadPool();
	
	
	/**
	 * Geht Linked List der Aufgaben durch und loescht fertige heraus, bis diese leer ist!
	 */
	public void waitAllDone(){
		
		exec.shutdown();
		try {
			exec.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Faehrt sofort den ExecutorService herunter
	 */
	public void shutdownNow(){
		exec.shutdownNow();
	}
	
	/**
	 * Uebergibt eine Variable an den ExecutorService und wartet, falls dieser noch beschaeftigt ist
	 * @param runnable Runnable die sofort ausgefuehrt werden soll
	 */
	public void doRunnable(Runnable runnable){
		try{
		exec.submit(runnable);
		} catch (OutOfMemoryError e){
			try {
				Thread.sleep(2);
			}catch(InterruptedException e1){
				e1.printStackTrace();
			}finally{
				doRunnable(runnable);
			}
		}
	}
	
	
	
}
