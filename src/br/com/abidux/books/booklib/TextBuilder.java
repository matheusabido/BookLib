package br.com.abidux.books.booklib;

import br.com.abidux.books.booklib.JSONBuilder.ClickAction;
import br.com.abidux.books.booklib.JSONBuilder.HoverAction;

public class TextBuilder {
	
	private String message;
	private String[] events = new String[2];
	
	public TextBuilder setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public TextBuilder setClickEvent(ClickAction action, String value) {
		events[0] = ",\"clickEvent\":{\"action\":\"" + action.toString().toLowerCase() + "\",\"value\":\"" + value + "\"}";
		return this;
	}
	
	public TextBuilder setHoverEvent(HoverAction action, String value) {
		events[1] = ",\"hoverEvent\":{\"action\":\"" + action.toString().toLowerCase() + "\",\"value\":\"" + value + "\"}";
		return this;
	}
	
	public String build() {
		return "{\"text\":\"" + message + "\"" + (events[0] != null ? events[0] : "") + (events[1] != null ? events[1] : "") + "}";
	}
	
}