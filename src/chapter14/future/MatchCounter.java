package chapter14.future;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;

public class MatchCounter implements Callable<Integer> {
	private File directory;
	private String keyWard;
	private int count;
	
	public MatchCounter(File directory, String keyWard) {
		this.directory = directory;
		this.keyWard = keyWard;
	}
	
	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for(File file : files) {
				if(file.isDirectory()) {
					MatchCounter match = new MatchCounter(file, keyWard);
					FutureTask<Integer> task = new FutureTask<>(match);
					results.add(task);
					new Thread(task).start();
				}
				else {
					if(search(file)) count++;
				}
			}
			
			for(Future<Integer> result : results) {
				try {
					count += result.get();
				}
				catch(ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		catch(InterruptedException e) {}
		return count;
	}
	
	public boolean search(File file) {
		boolean found = false;
		try {
			try(Scanner in = new Scanner(file)) {
				while(!found && in.hasNextLine()) {
					String line = in.nextLine();
					if(line.contains(keyWard))
						found = true;
				}
				return found;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
