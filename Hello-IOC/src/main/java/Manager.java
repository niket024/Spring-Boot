import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Manager {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = new AnnotationConfigApplicationContext(IOCConfiguration.class);
		Person p1 = applicationContext.getBean(Person.class);
		System.out.println(p1 == null ? null : "ok");
	}
}
