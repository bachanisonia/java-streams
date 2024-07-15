import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {
		
		Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
		
		Stream<Integer> limitedStream = numbers.limit(5);

		limitedStream.forEach(System.out::println);
		
		// If you use the same above streams, it fails at runtime with error - 
		// stream has already been operated upon or closed
		numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
		Stream<Integer> evenStream = numbers.filter(x -> x % 2==0);

		evenStream.limit(2).forEach(System.out::println);
		
		numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
		
		// The order of intermediate operations matter.
		// Here we limit the stream before we do the even no check
		numbers.limit(2).filter(x -> x%2 == 0).forEach(System.out::println);
		
		System.out.println();
		
		Stream<String> names = Stream.of("apple", "banana", "mango", "strawberry");
		names
			.limit(2)
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		System.out.println();
		
		names = Stream.of("apple", "banana", "mango", "strawberry");
		
		names
			.map(String::toUpperCase)
			.peek(str -> System.out.println("Peek Result : " + str))
			.filter(name -> name.length() < 6)
			.forEach(System.out::println);
		
		// Can't print it. 
		//names.forEach(String::toUpperCase);
		
		numbers = Stream.of(1,2,1, 3,4,8, 5,6,5, 4, 7,8,9,10);
		numbers.distinct()
				.sorted()
				.forEach(System.out::println);
		
		Stream<Integer> oddNumbers = Stream.of(1, 3, 5, 7, 9);
		Stream<Integer> evenNumbers = Stream.of(2, 4, 6, 8, 10);
		
		// Unless you use sorted operation, it concats the streams as it is
		Stream.concat(oddNumbers, evenNumbers).sorted().forEach(System.out::println);
		
		Stream<Student> studentStream = Stream.of(new Student(1, "Foo"), new Student(2, "Bar"), new Student(3, "AB"));
		
		studentStream.filter(s -> s.getName().length() > 2).map(Student::getName).forEach(System.out::println);
	}

}


class Student { 
	int id;
	String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
