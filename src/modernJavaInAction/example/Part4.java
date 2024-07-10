package modernJavaInAction.example;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Part4 {
	
	
	
/*	List<String> highCaloricDishes = new ArrayList<>();
	
	Iterator<String> iterator = menu.iterator();
	
	while(iterator.hasNext()) {
		Dish dish = iterator.next();
		if(dish.getCalories() > 300) {
			highCaloricDishes.add(dish.getName());
		}
	} */
	
	public static void main(String[] args) {
		
		ArrayList<Dish> menu = new ArrayList<>();
		List<String> highCaloricDishes = Dish.menu.stream()
				.filter( dish -> dish.getCalories() > 300 )
				.map(Dish::getName)
				.collect(Collectors.toList());
		
		System.out.println(highCaloricDishes);

	}
	
}
