package cn.sgema.cloud.devtool.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.mapper.SqlRunner;

@Service
public class TableService {

    /**
     * 获取当前数据库所有的表信息
     */
    public List<Map<String, Object>> getAllTables(String dbName) {
        String sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + dbName + "'";
        return SqlRunner.db().selectList(sql);
    }
}
