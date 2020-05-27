package cn.sgema.cloud.devtool.repository;
//package cn.sgema.cloud.devtools.repository;
//
//import java.util.List;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import cn.sgema.cloud.devtools.domain.Tables;
//
//@Repository
//public interface TableRepository extends JpaRepository<Tables, String> {
//
//    //获取当前数据库所有的表信息
//    @Query("SELECT TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = ?1 ") 
//	 public List<User> getAllTables(String dbName); 
//}
