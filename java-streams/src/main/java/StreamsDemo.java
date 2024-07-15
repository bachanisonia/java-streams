import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class StreamsDemo {

	public static void main(String[] args) {
		
		List<String> names = List.of("Foo", "Bar", "Baz");
		
		Stream<String> stream = names.stream();
		
		stream.forEach(System.out::println);
		
		int[] numbers = {1,2,3,4,5}; 
		Arrays.stream(numbers).forEach(System.out::println);;

		Stream.of("mango", "banana", "apple").forEach(System.out::println);
		
		try {
			Files.lines(Paths.get("README.md")).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Stream.generate(new Random()::nextDouble)
				.limit(10)
				.forEach(System.out::println);
		
		Stream.iterate(0, x -> x + 2)
				.limit(10)
				.forEach(System.out::println);
		
		List<Integer> uptoHundred = Stream.iterate(0,  x -> x + 2)
				.limit(100)
				.toList();
		
		System.out.println(uptoHundred);
		
		StringBuffer sb = new StringBuffer("Sonia");
		sb.append(" Bachani");
		System.out.println(sb.toString());
		
	}

}
