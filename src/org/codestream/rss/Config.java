package org.codestream.rss;

public final class Config {
	public static final String BACKEND_URL = "http://dou.ua/forums/feed";
	
	public static final class XmlTags {
		public static final String PARENT_TAG = "item";
		public static final String KEY_TITLE = "title";
		public static final String KEY_LINK = "link";
		public static final String KEY_DESCRIPTION = "description";
		public static final String KEY_CREATOR = "dc:creator";
		public static final String PUB_DATE_KEY ="pubDate";
		public static final String KEY_GUID = "guid";
	}
}
