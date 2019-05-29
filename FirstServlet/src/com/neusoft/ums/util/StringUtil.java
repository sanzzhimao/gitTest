package com.neusoft.ums.util;

public class StringUtil {
	
	public static String getStringJionWithDaoHao(String[] str){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length;i++){
			sb.append(str[i]);
			if(i!=str.length-1)sb.append(",");
		}
		return sb.toString();
	}
}
