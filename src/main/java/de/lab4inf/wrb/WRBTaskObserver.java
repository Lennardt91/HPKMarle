package de.lab4inf.wrb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class WRBTaskObserver {

	ExecutorService exec = Executors.newCachedThreadPool();
	List<Callable<Object>> callables = new ArrayList<Callable<Object>>();	
	
	
	/**
	 * Geht Linked List der Aufgaben durch und loescht fertige heraus, bis diese leer ist!
	 */
	public void waitAllDone(){
		
		try {
			exec.invokeAll(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdown();
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
		callables.add(Executors.callable(runnable));

	}
	
	
}
