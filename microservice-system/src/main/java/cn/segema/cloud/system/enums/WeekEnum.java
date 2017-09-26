package cn.segema.cloud.system.enums;

public enum WeekEnum {
	
	MONDAY("星期一"),
	TUESDAY("星期二"), 
	WEDNESDAY("星期三"),
	THURSDAY("星期四"),
	FRIDAY("星期五"), 
	SATURDAY("星期六"),
	SUNDAY("星期天");

	private String typeName;

	WeekEnum(String typeName) {
		this.typeName = typeName;
	}

	public String getValue() {
		return typeName;
	}

    public static WeekEnum valueOf(Integer type) {
        if (type == null) {
            return null;
        }

        for (WeekEnum item : values()) {
            if (item.ordinal() == type) {
                return item;
            }
        }
        return null;
    }
}
