package cn.sgema.cloud.devtool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sgema.cloud.devtool.domain.DemoUser;

@Mapper
public interface UserDao {

	@Select("select 1 from dual")
	int testSqlConnent();

	@Select("select user_id, user_name, nick_name from demo_user where user_name = #{name} ")
//	@ResultMap("userResults")
	DemoUser selectUserByName(@Param("name") String name);
}
