package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Select {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sqlSessionFactory;
		try (InputStream is = Select.class.getResourceAsStream("/META-INF/mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		try (SqlSession session = sqlSessionFactory.openSession()) {
			BlobTable blobTable = session.selectOne("mybatis.mapper.BlobTableMapper.select", 1);
			try (InputStream is = blobTable.getImage()) {
				Files.copy(is, Paths.get("C:\\temp\\output.png"));
			}
		}
	}
}
