package com.api.util.ApiSecurity;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

/**
 * @author GDS-PDD
 *
 */
public class ApiList extends ArrayList<Entry<String,String>>{

	private static final long serialVersionUID = 1L;

	public void add(String key, String value)
	{
		Entry<String, String> item = new SimpleEntry<String, String>(key, value);

		this.add(item);
	}
	
	public String toString() {
		String delimiter = "&";
		Boolean sort = true;
		Boolean quote = false;
		
		return this.toString(delimiter, sort, quote);
	}
	
	public String toString(String delimiter, Boolean sort, Boolean quote)
	{
		ArrayList<String> list = new ArrayList<String>();

		String format = "%s=%s";
		if (quote) format = "%s=\"%s\"";

		for (Entry<String, String> item : this)
		{
			list.add(String.format(format, item.getKey(), item.getValue()));
		}

		/* Sort statement*/
		if (sort) Collections.sort(list);
	
		return String.join(delimiter, list);
	}
}