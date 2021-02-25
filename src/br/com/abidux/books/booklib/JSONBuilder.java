package br.com.abidux.books.booklib;

public class JSONBuilder {
	
	private TextBuilder[] text;
	public JSONBuilder(TextBuilder... text) {
		this.text = text;
	}
	
	// build the json code
	// example: "[{\"text\":\"example\",\"clickEvent\":\"action\":\"run_command\",\"value\":\"/gamemode 1\"},{\"text\":\"example 2\",\"clickEvent\":\"action\":\"run_command\",\"value\":\"/gamemode 2\"}]"
	public String build() {
		StringBuilder value = new StringBuilder("[");
		for (TextBuilder builder : text) {
			String result = builder.build();
			value.append(result).append(",");
		}
		return value.substring(0, value.length() - 1) + "]";
	}
	
	public enum ClickAction {
		RUN_COMMAND,
		SUGGEST_COMMAND,
		OPEN_URL;
	}

	public enum HoverAction {
		SHOW_ITEM,
		SHOW_TEXT;
	}
	
}