package modernJavaInAction.example;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import modernJavaInAction.example.Part1.Apple;

public class Quiz6 {
	ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
	ToIntFunction<String> stringToInt2 = Integer::parseInt;

	BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
	BiPredicate<List<String>, String> contains2 = List::contains;
	
	 
	//Predicate<String> startWithNumber = (String string) -> this.startWithNumber(string);
	//Predicate<String> startWithNumber2 = this::startWithNumber;
	
}
