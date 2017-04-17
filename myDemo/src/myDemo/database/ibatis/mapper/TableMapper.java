package myDemo.database.ibatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myDemo.database.ibatis.modal.Table;

//myDemo.database.ibatis.mapper.TableMapper
public interface TableMapper {
	public int countAll();
	public List<String> selectAllColumn(@Param("model")Table model);
}
