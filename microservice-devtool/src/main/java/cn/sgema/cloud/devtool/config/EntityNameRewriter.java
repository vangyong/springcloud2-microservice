package cn.sgema.cloud.devtool.config;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;
import java.util.List;
import org.springframework.util.StringUtils;

@Data
public class EntityNameRewriter extends InjectionConfig {

	private String entityName;

	@Override
	public void initMap() {
		if (!StringUtils.isEmpty(entityName)) {
			List<TableInfo> tableInfoList = this.getConfig().getTableInfoList();
			if (tableInfoList != null) {
				tableInfoList.get(0).setComment(entityName);
			}
		}
	}
}
