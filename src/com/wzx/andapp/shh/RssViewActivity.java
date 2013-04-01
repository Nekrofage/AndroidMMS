package com.wzx.andapp.shh;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wzx.andapp.rss.bo.RSSFeed;
import com.wzx.andapp.rss.bo.RSSItem;
import com.wzx.andapp.rss.sax.RSSHandler;

public class RssViewActivity extends Activity implements OnItemClickListener
{
//	public final String RSS_URL = "http://rubyjin.cn/blog/rss";
	
	public final String RSS_URL = "http://rss.news.sohu.com/rss/guonei.xml";
	
	public final String tag = "RSSReader";
	private RSSFeed feed = null;
	
	/** Called when the activity is first created. */

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.rss_main);
        feed = getFeed(RSS_URL);
        showListView();
        
    }

    
    private RSSFeed getFeed(String urlString)
    {
    	try
    	{
    	   URL url = new URL(urlString);

           SAXParserFactory factory = SAXParserFactory.newInstance();
           SAXParser parser = factory.newSAXParser();
           XMLReader xmlreader = parser.getXMLReader();
           
           RSSHandler rssHandler = new RSSHandler();
           xmlreader.setContentHandler(rssHandler);

           InputSource is = new InputSource(url.openStream());    
           xmlreader.parse(is);
  
           return rssHandler.getFeed();
    	}
    	catch (Exception ee)
    	{
    		ee.printStackTrace();
    		return null;
    	}
    }

    
    private void showListView()
    {
        ListView itemlist = (ListView) findViewById(R.id.itemlist);     
        if (feed == null)
        {
        	setTitle("���ʵ�RSS��Ч");
        	return;
        }

        SimpleAdapter adapter = new SimpleAdapter(this, feed.getAllItemsForListView(),
       		 android.R.layout.simple_list_item_2, new String[] { RSSItem.TITLE,RSSItem.PUBDATE },
       		 new int[] { android.R.id.text1 , android.R.id.text2});
        itemlist.setAdapter(adapter);
        itemlist.setOnItemClickListener(this);  
        itemlist.setSelection(0);
        
    }
    
    
     public void onItemClick(AdapterView parent, View v, int position, long id)
     {
    	 Intent itemintent = new Intent(this,RssItemDetailActivity.class);
         
    	 Bundle b = new Bundle();
    	 b.putString("title", feed.getItem(position).getTitle());
    	 b.putString("description", feed.getItem(position).getDescription());
    	 b.putString("link", feed.getItem(position).getLink());
    	 b.putString("pubdate", feed.getItem(position).getPubDate());
    	 
    	 itemintent.putExtra("android.intent.extra.rssItem", b);
         startActivityForResult(itemintent, 0);
     }
    
}