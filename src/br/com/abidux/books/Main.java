package br.com.abidux.books;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.abidux.books.booklib.BookBuilder;
import br.com.abidux.books.booklib.JSONBuilder;
import br.com.abidux.books.booklib.TextBuilder;
import br.com.abidux.books.booklib.JSONBuilder.ClickAction;
import br.com.abidux.books.booklib.JSONBuilder.HoverAction;

public class Main extends JavaPlugin {
	
	// example class
	
	private static ItemStack item;
	
	@Override
	public void onEnable() {
		TextBuilder page = new TextBuilder().setMessage("§9Line")
						   .setHoverEvent(HoverAction.SHOW_TEXT, "§9Hover Event")
						   .setClickEvent(ClickAction.RUN_COMMAND, "Command to execute");
		JSONBuilder builder = new JSONBuilder(page);
		item = new BookBuilder("abidux", "test").addPage(builder.build()).build();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("get")) {
			((Player)sender).getInventory().addItem(item);
		}
		return false;
	}
	
}