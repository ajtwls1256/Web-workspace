package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";//경로 지정 안하면 resource 밑의 파일 자동으로 읽어옴(셋팅했기때문에 가능)
		try {
			//해당 리소스 경로(xml 파일)을 바탕으로 input 스트림 생성
			InputStream is = Resources.getResourceAsStream(resource);//String resource = "mybatis-config.xml";와 연결하기 위해 resource 폴더명 적어줌
			//현재 메서드와 xml 연결
			//SqlSessionFactory를 만들 수 있는 팩토리 빌더
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//팩토리 빌더를 통해서 SqlSessionFactory 생성
			SqlSessionFactory factory = builder.build(is);//형식만 맞춰주면 자동으로 읽어옴
			//SqlSessionFactory를 가지고 SqlSession을 생성
			session = factory.openSession(false); //false <- 오토 커밋 해제
			//매개변수의 false는 autoCommit 해제 설정
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
}
