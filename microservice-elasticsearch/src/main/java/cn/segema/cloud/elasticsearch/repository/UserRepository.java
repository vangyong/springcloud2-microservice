package cn.segema.cloud.elasticsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.elasticsearch.domain.User;
import cn.segema.cloud.elasticsearch.vo.UserPersonalVO;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	// @Select("SELECT CONTRACTID,CONTTRRACTNAME,TOTALMONEY FROM
	// spring_cloud_study.contract WHERE contractid=#{0};")
	// public Map<String, Object> getTableData(int pageNum, int pageSize, String
	// username);

	@Query("select new cn.segema.cloud.elasticsearch.vo.UserPersonalVO(u.userId,u.userName,u.nickName,p.personalId,p.personalName)"
			+ " from User u,UserPersonal up,Personal p where u.userName = ?1 and u.userId=up.user and up.personal = p.personalId ")
	public List<UserPersonalVO> findByUserName(String userName);

	/*
	 * @Query("SELECT u" + " from User u  where u.userName = ?1 ") public
	 * List<User> findByUserName(String userName);
	 */
}
