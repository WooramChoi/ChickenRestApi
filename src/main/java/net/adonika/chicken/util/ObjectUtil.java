package net.adonika.chicken.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ObjectUtil {
	
	/**
	 * Object에서 비어있는 필드의 이름을 반환
	 * @param o
	 * @return
	 */
	public static String[] getNullOrZeroFields(Object o) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (Field field: o.getClass().getDeclaredFields() ) {
			field.setAccessible(true);
			try {
				if ( field.get(o) == null ) {
					result.add(field.getName());
				} else {
					if ( ((Number) field.get(o)).intValue() == 0 ) {
						result.add(field.getName());
					}
				}
			} catch (ClassCastException ce) {
				// Null이 아닌 객체를 숫자로 형변환한 케이스
				continue;
			} catch (IllegalArgumentException|IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return result.toArray(new String[result.size()]);
	}
	
	/**
	 * 원본 객체로부터 대상객체 생성
	 * @param from
	 * @param clazz
	 * @return
	 */
	public static <T> T toCastObject(Object from, Class<T> clazz) {
		T result;
		try {
			result = clazz.getDeclaredConstructor().newInstance();
			for( Field field: clazz.getDeclaredFields() ) {
				field.setAccessible(true);
				field.set(result, field.get(from));
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

}
