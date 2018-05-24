package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Insert {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sqlSessionFactory;
		try (InputStream is = Insert.class.getResourceAsStream("/META-INF/mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		try (SqlSession session = sqlSessionFactory.openSession();
				InputStream is = Files.newInputStream(Paths.get("C:\\temp\\test.png"))) {
			BlobTable blobTable = new BlobTable();
			blobTable.setKey(1);
			blobTable.setImage(is);
			session.update("mybatis.mapper.BlobTableMapper.insert", blobTable);
			session.commit();
		}
	}
}
