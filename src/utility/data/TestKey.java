package utility.data;

public class TestKey {
	
	private String key;
	private String type;
	private String value;
	
	public TestKey(String key, String type, String value) {
		this.key = key;
		this.type = type;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}
}