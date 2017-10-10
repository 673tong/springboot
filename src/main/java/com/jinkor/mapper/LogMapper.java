package com.jinkor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jinkor.model.Log;


@Mapper
public interface LogMapper {

	@Insert("insert into log(log_name,log_time) values(#{log_name},#{log_time})")
	public int insert(Log log);
	
	@Select("select * from log where id = #{id}")
	public Log queryForBean(Long id);
	
	@Select("select * from log")
	public List<Log> queryForList();
	
	@Update("update log set log_name = #{log_name},log_time = #{log_time} where id = #{id}")
	public int update(Log log);
	
	@Delete("delete from log where id = #{id}")
	public int delete(Long id);
}
