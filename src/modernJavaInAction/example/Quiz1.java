package modernJavaInAction.example;

import java.util.List;

public class Quiz1 {
	
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
	
	
	public interface AppleFormat {
		String accept(Apple a);
	}
	
	public class AppleFancyFormat implements AppleFormat  {
		public String accept(Apple a) {
			String e = a.getWeight() > 150 ? "heavy" : "light";
			return "A " + e + " apple is " + a.getColor();
		}
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormat af) {
		for(Apple apple : inventory) {
			af.accept(apple);
		}
	}
	 
	

}
