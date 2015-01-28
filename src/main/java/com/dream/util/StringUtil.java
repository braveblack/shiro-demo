package com.dream.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class StringUtil {
	/*
	 * 将字符串分割成long[]数组
	 */
	public long[] stringToLong(String s,String splitString) {
		String stringArray[]=s.split(splitString);
        if (stringArray == null || stringArray.length < 1) {
            return null;
        }
        long longArray[] = new long[stringArray.length];
        for (int i = 0; i < longArray.length; i++) {
            try {
                longArray[i] = Long.valueOf(stringArray[i]);
            } catch (NumberFormatException e) {
                longArray[i] = 0;
                continue;
            }
        }
        return longArray;
    }
	//将string转成List<long>
	public List<Long> StringToList(String s,String splitString){
		String[] stringArray=s.split(splitString);
		List<Long> stringList = new ArrayList<Long>(stringArray.length);
		for(String ss: stringArray){
			stringList.add(Long.valueOf(ss));
		}
		return stringList;
	}
}
