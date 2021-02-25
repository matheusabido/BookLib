package br.com.abidux.books.booklib;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import net.minecraft.server.v1_8_R3.NBTTagString;

public class BookBuilder {
	
	private String[] pages = new String[0];
	public String author, title;
	public BookBuilder(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	public BookBuilder addPage(String json) {
		// create a new page
		String[] array = new String[pages.length + 1];
		// clone the array
		for (int i = 0; i < pages.length; i++) array[i] = pages[i];
		// insert the new value
		array[array.length - 1] = json;
		// replace the original array
		pages = array;
		return this;
	}
	
	public BookBuilder addPages(String... jsons) {
		for (String json : jsons) addPage(json);
		return this;
	}
	
	public ItemStack build() {
		// create new book
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		// get a nms copy of the item to access the nbt
		net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(book);
		// create new nbt tag
		NBTTagCompound tag = new NBTTagCompound();
		// set the basics
		tag.setString("title", title);
		tag.setString("author", author);
		// create the page list
		NBTTagList pages = new NBTTagList();
		for (String page : this.pages) pages.add(new NBTTagString(page));
		tag.set("pages", pages);
		nmsItem.setTag(tag);
		// return a bukkit copy of the item to create a itemstack
		book = CraftItemStack.asBukkitCopy(nmsItem);
		return book;
	}
	
	public String[] getPages() {
		return pages;
	}
	
}