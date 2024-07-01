package himedia.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// ClassPath의 XML을 기반으로 컨텍스트 만들기
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("config/applicationContext.xml"); 
		
		// 타입(Class)으로 찾기
//		User user = ac.getBean(User.class);
//		System.out.println(user);
		
		// id와 name으로 찾기
		User user1 = (User)ac.getBean("user"); // id 검색
		User user2 = (User)ac.getBean("member"); // name 검색
		
		System.out.println(user1 == user2 ); // 스프링 턴테이너는 기본적으로 Singleton Factory
		System.out.println(ac.isSingleton("user"));
		
		User user3 = (User)ac.getBean("user3");
		System.out.println(user1 == user3);
		
		// 생성자 매개변수 전달
		User user4 = (User)ac.getBean("user4");
		System.out.println("user4:" + user4);
		
		// Setter를 이용한 필드 생성
		User user5 = (User)ac.getBean("user5");
		System.out.println("user5:" + user5);
		
		// 참조 주입
		Friend friend6 = (Friend)ac.getBean("friend6"); // 주입될 객체
		System.out.println("friend6:" + friend6);
		User user6 = (User)ac.getBean("user6");
		System.out.println("user6:" + user6);
		
		// 집합 객체 주입
		User user7 = (User)ac.getBean("user7");
		System.out.println("user7:" + user7);
		
	}
}
