package org.codestream.rss;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FeedActivity extends ListActivity {
	private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = (ListView)findViewById(R.id.list_b);
        ArrayList<HashMap<String,String>> items = new ArrayList<HashMap<String,String>>();
        XmlHelper helper = new XmlHelper();
        String xml = helper.getXmlFromUrl(Config.BACKEND_URL);
        Document doc = helper.getDomElement(xml);
        NodeList nl = doc.getElementsByTagName(Config.XmlTags.PARENT_TAG);
        for (int i = 0; i < nl.getLength(); i++){
        	HashMap<String, String> map = new HashMap<String, String>();
        	Element e = (Element) nl.item(i);
        	map.put(Config.XmlTags.KEY_TITLE, helper.getValue(e, Config.XmlTags.KEY_TITLE));
        	map.put(Config.XmlTags.KEY_DESCRIPTION, helper.getValue(e, Config.XmlTags.KEY_DESCRIPTION));
        	items.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(this, items,
				R.layout.list_items,
				new String[] { Config.XmlTags.KEY_TITLE, Config.XmlTags.KEY_DESCRIPTION}, new int[] {
						R.id.text_title, R.id.text_description});

		setListAdapter(adapter);
    }
}
