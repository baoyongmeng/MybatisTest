package com.zhuoshi.Test.DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SqlBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBsource {
	
	public SqlSession getSession() {
		
		Reader reader =null;
		try {
			reader = Resources.getResourceAsReader("com/zhuoshi/Test/config/Mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
		
	}

}

