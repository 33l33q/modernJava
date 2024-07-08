package modernJavaInAction.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import modernJavaInAction.example.Part1.Apple;

public class Part3 {

	
	Comparator<Apple> byWeight = new Comparator<Apple>() {
		public int compare(Apple a1, Apple a2) {
			Integer a1Weight = a1.getWeight();
			Integer a2Weight = a2.getWeight();
			return a1Weight.compareTo(a2Weight);
		}
	};
	
	Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight()));
			
	    
//	(String s) -> s + "size";

//	(int x, int y) -> {
//		System.out.println("result");
//		System.out.println(x+y);
//	}

//	() -> 42;

	//함수 디스크립터
	public static void process(Runnable r) {
		r.run();
	}

	//실행 어라운드 패턴 적용
	public String processFile() throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			return br.readLine();
		}
	}
	
	public interface BufferReaderProcessor{
		String process(BufferedReader b) throws IOException;
	}
	
	public static String processFile(BufferReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			return p.process(br);
		}
	}
	
	//함수형 인터페이스 사용할 때
	public List<String> listOfString = new ArrayList<String>();
	
/*	@FunctionalInterface
	public interface Predicate<T>{
		boolean test(T t);
	}
	
	Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
	
	public <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<>();
		for(T t : list) {
			if(p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}
	
	List nonEmpty = filter(listOfString, nonEmptyStringPredicate); */
	
	@FunctionalInterface
	public interface IntPredicate{
		boolean test(int t);
	}
	
	IntPredicate evenNumbers = (int i) -> {return i % 2 == 0;};

	@FunctionalInterface
	public interface Predicate<Integer>{
		boolean test(int t);
	}
	
	Predicate<Integer> evenNumbers2 = (int i) -> {return i % 2 == 0;};
	
	
	@FunctionalInterface
	public interface Function<T, R>{
		R apply(T t);
	}
	
	public <T, R> List<R> map2(List<T> list, Function <T, R> f){
		List<R> result = new ArrayList<>();
		for(T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Part3 part3 = new Part3();

		Runnable r1 = () -> System.out.println("hello world");
		Runnable r2 = new Runnable() {
			
			public void run() {
				System.out.println("22222222222");
			}
		};
		
		process(r1);
		process(r2);
		process(() -> System.out.println("hello world 3") );
	
		try{
			String oneLine = processFile((BufferedReader br) -> br.readLine());	
		}catch (Exception e) {

		}	
	
		List<Integer> l = part3.map2(Arrays.asList("lambdas","in","action"),(String s) -> s.length());
		System.out.println(l);
	}
	
}
