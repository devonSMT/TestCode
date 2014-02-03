package com.siliconmtn.spider;

import java.util.HashMap;

/****************************************************************************
 * <b>Title</b>: SpiderMessage.javaIncomingDataWebService.java <p/>
 * <b>Project</b>: SpiderProjectRAMDataFeed <p/>
 * <b>Description: </b>
 * <b>Copyright:</b> Copyright (c) 2014<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Devon
 * @version 1.0
 * @since 9:10:27 AM<p/>
 * <b>Changes: </b>
 ****************************************************************************/

public class SpiderInfo {

	//create a hashMap
	private HashMap<String, String> info = new HashMap<String, String>();
	
	/**
	 * Class constructor
	 */
	public SpiderInfo(){
		//get all messages
		this.getAllInformation();
	}
	
	/**
	 * Give a key String and return it's value from map
	 * @param parser
	 * @return
	 */
	public String getInfo(String information){
		return info.get(information);
	}
	
	/**
	 * Sets map for all messages used for project
	 * @return
	 */
	public HashMap<String, String> getAllInformation(){
		info.put("GET_HTTP", "GET http://");
		info.put("HREF=", "href=");
		info.put("<A", "<a");
		info.put("</A>", "</a>");
		info.put("SMT_MENU", "smt_menu");
		info.put("</UL>", "</ul>");
		info.put("END_TAG", ">");
		return info;
	}
}
