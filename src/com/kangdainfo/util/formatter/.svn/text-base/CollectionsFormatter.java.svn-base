package com.kangdainfo.util.formatter;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFormatter {


	private static List<Integer> convertToList(int array[]) {
		if(array==null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i < array.length; i++) {
			list.add(new Integer(array[i]));
		}
		return list;
	}
	private static List<Short> convertToList(short array[]) {
		if(array==null) {
			return null;
		}
		List<Short> list = new ArrayList<Short>();
		for(int i=0; i < array.length; i++) {
			list.add(new Short(array[i]));
		}
		return list;
	}
	private static List<Float> convertToList(float array[]) {
		if(array==null) {
			return null;
		}
		List<Float> list = new ArrayList<Float>();
		for(int i=0; i < array.length; i++) {
			list.add(new Float(array[i]));
		}
		return list;
	}
	private static List<Double> convertToList(double array[]) {
		if(array==null) {
			return null;
		}
		List<Double> list = new ArrayList<Double>();
		for(int i=0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		return list;
	}
	private static List<Object> convertToList(Object array[]) {
		if(array==null) {
			return null;
		}
		List<Object> list = new ArrayList<Object>();
		for(int i=0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}
	
	public static String format(int array[]) {
		return format(convertToList(array));
	}
	public static String format(short array[]) {
		return format(convertToList(array));
	}
	public static String format(float array[]) {
		return format(convertToList(array));
	}
	public static String format(double array[]) {
		return format(convertToList(array));
	}
	public static String format(Object array[]) {
		return format(convertToList(array));
	}
	
	public static String format(List<?> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if(list!=null) {
			for(int i=0; i < list.size(); i++) {
				sb.append(list.get(i));
				if(i!=list.size()-1) {
					sb.append(",");
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	
	
	
}
