package cn.segema.cloud.system.enums;

public enum UserTypeEnum {
	
	REGISTED("注册用户"),
	NO_REGISTED("非注册用户");

	private String typeName;

	UserTypeEnum(String typeName) {
		this.typeName = typeName;
	}

	public String getValue() {
		return typeName;
	}

    public static UserTypeEnum valueOf(Integer type) {
        if (type == null) {
            return null;
        }

        for (UserTypeEnum item : values()) {
            if (item.ordinal() == type) {
                return item;
            }
        }
        return null;
    }
}
