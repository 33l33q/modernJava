package modernJavaInAction.example;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import modernJavaInAction.example.Part1.Apple;

public class Part3 {

	
	private static final Color GREEN = null;

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
	
	
	Supplier<Apple> c1 = Apple::new;
	Apple a1 = c1.get();
	
	Supplier<Apple> c2 = () -> new Apple(); //람다표현식은 디폴트 생성자를 가진 Apple을 만든다!
	Apple a2 = c2.get();

	Function<Integer, Apple> c3 = (weight) -> new Apple();
	Apple a3 = c3.apply(110);
	
//	Function<Integer, Apple> c4 = Apple::new;
//	Apple a4 = c4.apply(110);

	
	List<Integer> weights = Arrays.asList(7,2,4,10);
//	List<Apple> apples = map2(weights, Apple::new);
	
	BiFunction<Color, Integer, Apple> c5 = (color, weight) -> new Apple(color, weight);
	BiFunction<Color, Integer, Apple> c6 = Apple::new;
	Apple a5 = c5.apply(GREEN, 110);
	
	Arrays inventory;
	

	//1단계 코드 전달
	public class AppleComparator implements Comparator<Apple>{
		public int compare(Apple a1, Apple a2) {
			return Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight()));
		}
	}
	inventory.sort(new AppleComparator());
	
	//2단계 익명 클래스 사용
	inventory.sort(new Comparator<Apple>() {
		public int compare(Apple a1, apple a2) {
			return Integer.valueOf(a1.getWeight()).compareTo(a2.getWeight());
		}
	}); 
	
	//3단계 람다 표현식 사용
	inventory.sort((Apple a1, Apple a2) -> Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight())));

	inventory.sort((a1, a2) -> Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight())));

	Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
	
	inventory.sort(comparing(apple -> apple.getWeight()));
	inventory.sort(comparing(Apple::getWeight));

	
	
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
