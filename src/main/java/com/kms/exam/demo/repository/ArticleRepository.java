package com.kms.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kms.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	// INSERT INTO article SET title = ?, `body` = ?, regDate = NOW(), updateDate =
	// NOW();
	@Insert("INSERT INTO article SET title = #{title}, `body` = #{body}, regDate = NOW(), updateDate =NOW()")
	public void writeArticle(@Param("title") String title, @Param("body") String body);

	// SELECT * FROM article WHERE id = ?;
	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id);

	// DELETE FROM article WHERE id = ?;
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(@Param("id") int id);

	// UPDATE article SET title = ?, `body` = ? , updateDate = NOW() WHERE id = ?;
	@Update("UPDATE article SET updateDate=NOW(), title = #{title}, `body` = #{body} WHERE id = #{id}")
	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);

	// SELECT * FROM article ORDER BY DESC;
	@Select("SELECT * FROM article")
	public List<Article> getArticles();

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
}
