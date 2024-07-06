package modernJavaInAction.example;

import java.awt.image.FilteredImageSource;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

public class Part1 {

	public static class Apple{
		public String color;
		public int weight;
		
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	
		public int getWeight() {
			return weight;
		}
		
		public void setWeight(int weight) {
			this.weight = weight;
		}
	}
	
	enum Color {RED, GREEN}
	
	public List<Apple> inventory = new ArrayList<Apple>();
	
	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if("GREEN".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	} // ==> 기존 녹색 필터링 하는 예제
	
	public static List<Apple> filterHeavyApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	} // ==> 기존 무게 필터링 예제
	
	public static boolean isGreenApple(Apple apple) {
		return "GREEN".equals(apple.getColor());
	}
	
//	filterApples(inventory,  Apple ::isGreenApple);
	
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	public interface Predicate<T>{
		boolean test(T t);
	}
	
	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T e : list) {
			if(p.test(e)) { 
				 result.add(e);
			}
		}
		return result;
	}
	
	List<Apple> result1 = filterApples(inventory, (Apple apple) -> "RED".equals(apple.getColor()));
	
	
	inventory.sort(new Comparator<Apple>(){
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	});
	
	inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
}
}