package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ApiModel;

import jakarta.transaction.Transactional;

@Repository//represents repository
public interface ApiRepo extends JpaRepository<ApiModel, Integer>{

	@Query(value="select * from Book where id=:id or title=:title",nativeQuery=true)//sql query implementation
	public List<ApiModel> getInfo(@Param("id") int id,@Param("title") String title);
	
	@Modifying//database data modification
	@Transactional//entire transaction can be rollback to previous state
	@Query(value="delete from Book where id=:s",nativeQuery=true)
	public int deleteInfo(@Param("s")int id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Book SET id = ?1 WHERE id = ?2", nativeQuery = true)
	public int updateInfo(int newid, int oldid);
	
}
