package com.kosmo88.logistics_erp.wms.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

//dto Function을 사용하는 방법 3가지
//1. 싱글톤으로 사용  2. 상속하여 사용  3.정적 메소드로 사용
// - dto에 다형성을 적용해야 하는 상황인가??
// - 싱글톤과 정적메소드 사용시 각각의 장단점
// - 관점. 캡슐로 사용할지 메서드처럼 사용할지
// - 객체지향에서 static을 너무 남발하면 객체지향 언어의 장점을 잃는다
//commondto로 대체하여 commondto를 상속하는 방식으로 전환
public class DtoFunction {
	// setter나 getter 메서드 이름으로 카멜 표기법 프로퍼티 이름 반환

	private Log log = Log.ENABLE;

	// 전달되는 파라미터 이름과 Dto의 프로퍼티 이름이 다를 경우
	// 파라미터 Map에서 이름을 참조하여 가져온 후 Dto로 넣을 때 사용한다
	public static String adjustParamName(String param) {
		// 1. _이 있으면 제거하고 뒤의 글자롤 대문자로 바꾼다
		System.out.println("변경 전 이름 : " + param);
		if (!param.contains("_")) {
			System.out.println("변경사항 없음");
			return param;
		} else {
			int index;
			StringBuffer stringBuffer2;
			stringBuffer2 = new StringBuffer(param);
			while (stringBuffer2.indexOf("_") > 0) {
				index = stringBuffer2.indexOf("_");
				stringBuffer2.deleteCharAt(index);
				stringBuffer2.replace(index, index + 1, (char) (stringBuffer2.charAt(index) - 32) + "");
			}
			String newString = stringBuffer2.toString();
			System.out.println("새 이름 : " + newString);
			return stringBuffer2.toString();
		}
	}

	public static String methodNameToProperty(String methodName) {
		char[] methodNameArray = methodName.substring(3).toCharArray();
		methodNameArray[0] = (char) (methodNameArray[0] + 32);
		return new String(methodNameArray);
	}

	// setter나 getter메서드의 이름을 칼럼명으로 변경. 칼럼명은 대문자로 튀어나오기 때문에 대문자로 지정
	public static String methodNameToColumn(String methodName) {
		return methodName.substring(3).toUpperCase();
	}

	// Number을 getObject로 받으면 BicDecimal이 되기 때문에 integer로 바꾸어 주어야함
	// 혹시 문제생기면 instanceof로 바꾸기
	// dao쪽으로 옮길까 고민중
	public static Object convertColumnType(Object columnValue) {
		String type = columnValue.getClass().getSimpleName();
		Object convertedValue = null;
		switch (type) {
		case "BigDecimal":
			BigDecimal bigDecimal = (BigDecimal) columnValue;
			convertedValue = bigDecimal.intValue();
			break;
		default:
			convertedValue = columnValue;
		}
		return convertedValue;
	}

	public static Set<?> getDtoSetFromParamMap(Map<String, String[]> paramMap, Class<? extends Object> clazz,
			int index) {
		logMethodStart();
		MyLog.logReqParamMap(paramMap);

		String param;
		String paramValue;
		String prop;
		String propType;
//		Set<String> settedPropSet = new HashSet<>();
		Set<String> paramSet = paramMap.keySet();

		Method[] methods = clazz.getDeclaredMethods();

		Set<Object> dtoSet = new HashSet<>();

		// 일단 총 갯수가 2개 이상인 파라미터에 대해서만 작동하도록 돌려막기....
		for (int i = 0; i < index; i++) {
			try {
				Object dto = clazz.newInstance();
				Iterator<String> paramItr = paramSet.iterator();
				while (paramItr.hasNext()) {
					param = paramItr.next();
					if (paramMap.get(param).length < index)
						continue;
					paramValue = paramMap.get(param)[i];
//					param = adjustParamName(param);
//					System.out.println("요청 파라미터 : " + param + "  값 : " + paramValue);

					// dto에서 프로퍼티 가져오기
					for (Method method : methods) {
						prop = methodNameToProperty(method.getName());
						if (method.getName().contains("set") && prop.equals(param) && !paramValue.equals("")) {
							try {

								// 이걸 여기서가 아니라 처음부터 받아와서 해야돼.
								System.out.println(" - " + dto.getClass().getSimpleName() + " " + method.getName()
										+ "실행 - " + paramValue + " => " + prop);
//								paramType = paramValue.getClass().getSimpleName();
								propType = method.getParameters()[0].getType().getSimpleName();
//								System.out.println("파라미터 타입 : " + paramType + " 프로퍼티 타입 : " + propType);

//								if (paramType == propType)
//									method.invoke(dto, paramValue);
//								else {
								System.out.println("invoke : " + paramValue.getClass().getSimpleName() + " "
										+ paramValue + " => " + prop);
								switch (propType) {
								case "String":
									method.invoke(dto, paramValue);
									break;
								case "int":
									method.invoke(dto, Integer.parseInt(paramValue));
									break;
								case "Double":
									method.invoke(dto, Double.parseDouble(paramValue));
									break;
								case "Boolean":
									method.invoke(dto, Boolean.parseBoolean(paramValue));
									break;
								case "Date":
									method.invoke(dto, java.sql.Date.valueOf(paramValue));
									break;
								}
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
				System.out.println("dtoSet <= Dto : " + dto);
				dtoSet.add(dto);
			} catch (InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
		// 확인용
		System.out.println("---- 쎗팅된 dtoSet");
		dtoSet.stream().forEach((d) -> System.out.println(d));
		System.out.println("뭬야");
		return dtoSet;
	}

	// 보류 : get으로 대체
	// 요청 파라미터로 Dto 초기화(insert 하기 전 dto에 데이터 담을 때 사용)
	// 요청 파라미터의 name 과 프로퍼티 이름은 같아야 한다
	// set한 프로퍼티의 목록을 Set으로 리턴하면 좋을것같다
	public static Set<String> setDtoFromParamMap(Map<String, String[]> paramMap, Object dto) {
		logMethodStart();

		String param;
		String[] paramValue;
		String prop;
		Set<String> settedPropSet = new HashSet<>();
		Set<String> paramSet = paramMap.keySet();
		Iterator<String> paramItr = paramSet.iterator();

		String paramType;
		String propType;

		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		// 파라미터 이름,값 가져오기
		// 하나의 키에 대해 값이 여러개일 수 있다
		// 1. 하나인지 여러개인지 체크
		// 2. 각 값에 대해서 다 대입하도록? > 타입이 컬렉션이어야 한다
		while (paramItr.hasNext()) {
			param = paramItr.next();
			paramValue = paramMap.get(param);
//			param = adjustParamName(param);
//			System.out.println("요청 파라미터 : " + param + "  값 : " + Arrays.toString(paramValue));

			// dto에서 프로퍼티 가져오기
			for (Method method : methods) {
				prop = methodNameToProperty(method.getName());
				if (method.getName().contains("set") && prop.equals(param) && !paramValue.equals("")) {
					try {
						for (int i = 0; i < paramValue.length; i++) {
							System.out.println(" - " + dto.getClass().getSimpleName() + " " + method.getName() + "실행 - "
									+ paramValue[i] + " => " + prop);
							paramType = paramValue[i].getClass().getSimpleName();
							propType = method.getParameters()[0].getType().getSimpleName();
							System.out.println("파라미터 타입 : " + paramType + " 프로퍼티 타입 : " + propType);

							if (paramType == propType)
								method.invoke(dto, paramValue[i]);
							else {
								System.out.println("paramvalue" + " " + paramValue.getClass().getSimpleName() + " "
										+ paramValue[i]);
								switch (propType) {
								case "String":
									method.invoke(dto, paramValue[0]);
									break;
								case "int":
									method.invoke(dto, Integer.parseInt(paramValue[0]));
									break;
								case "Double":
									method.invoke(dto, Double.parseDouble(paramValue[0]));
									break;
								case "Boolean":
									method.invoke(dto, Boolean.parseBoolean(paramValue[0]));
									break;
								case "Date":
									method.invoke(dto, java.sql.Date.valueOf(paramValue[0]));
									break;
								}
//								method.invoke(dto, castParamType(paramValue, propType));
							}
						}
//						if (paramValue.length == 1) {
//							method.invoke(dto, paramValue[0]);
//							settedPropSet.add(prop);
//						} else if (paramValue.length > 1) {
						// 파라미터 값이 여러개일 경우의 처리 필요
						// 여러개이면 아마 콜렉션에 추가하는 식으로
						// 이럴 경우엔 setter가 add가 될 것이다
//						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// 확인용
		checkSettedProperties(dto);
		return settedPropSet;
	}

	// 보류 : clss를 받도록 개선
	public static Object getDtoFromParamMap(Map<String, String[]> paramMap, Object dto) {
		logMethodStart();
//	Enumeration<String> parameterEnum = request.getParameterNames();

		String param;
		String[] paramValue;
		String prop;
		Set<String> settedPropSet = new HashSet<>();
		Set<String> paramSet = paramMap.keySet();
		Iterator<String> paramItr = paramSet.iterator();

		String paramType;
		String propType;

		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		// 파라미터 이름,값 가져오기
		// 하나의 키에 대해 값이 여러개일 수 있다
		// 1. 하나인지 여러개인지 체크
		// 2. 각 값에 대해서 다 대입하도록? > 타입이 컬렉션이어야 한다
		while (paramItr.hasNext()) {
			param = paramItr.next();
			paramValue = paramMap.get(param);
			param = adjustParamName(param);

			System.out.println("요청 파라미터 : " + param + "  값 : " + Arrays.toString(paramValue));

			// dto에서 프로퍼티 가져오기
			for (Method method : methods) {
				prop = methodNameToProperty(method.getName());
				if (method.getName().contains("set") && prop.equals(param) && !paramValue.equals("")) {
					try {
						for (int i = 0; i < paramValue.length; i++) {
							System.out.println(" - " + dto.getClass().getSimpleName() + " " + method.getName() + "실행 - "
									+ paramValue[i] + " => " + prop);
							paramType = paramValue[i].getClass().getSimpleName();
							propType = method.getParameters()[0].getType().getSimpleName();
							System.out.println("파라미터 타입 : " + paramType + " 프로퍼티 타입 : " + propType);

							if (paramType == propType)
								method.invoke(dto, paramValue[i]);
							else {
								System.out.println("paramvalue" + " " + paramValue.getClass().getSimpleName() + " "
										+ paramValue[i]);
								switch (propType) {
								case "String":
									method.invoke(dto, paramValue[0]);
									break;
								case "int":
									method.invoke(dto, Integer.parseInt(paramValue[0]));
									break;
								case "Double":
									method.invoke(dto, Double.parseDouble(paramValue[0]));
									break;
								case "Boolean":
									method.invoke(dto, Boolean.parseBoolean(paramValue[0]));
									break;
								case "Date":
									method.invoke(dto, java.sql.Date.valueOf(paramValue[0]));
									break;
								}
//							method.invoke(dto, castParamType(paramValue, propType));
							}
						}
//					if (paramValue.length == 1) {
//						method.invoke(dto, paramValue[0]);
//						settedPropSet.add(prop);
//					} else if (paramValue.length > 1) {
						// 파라미터 값이 여러개일 경우의 처리 필요
						// 여러개이면 아마 콜렉션에 추가하는 식으로
						// 이럴 경우엔 setter가 add가 될 것이다
//					}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// 확인용
		checkSettedProperties(dto);
		return dto;
	}

	// 보류 : clss를 받도록 개선
	public static Object getDtoFromParamMap(Map<String, String[]> paramMap, Class<?> clazz) {
		logMethodStart();
//		Enumeration<String> parameterEnum = request.getParameterNames();

		String param;
		String[] paramValue;
		String prop;
		Set<String> settedPropSet = new HashSet<>();
		Set<String> paramSet = paramMap.keySet();
		Iterator<String> paramItr = paramSet.iterator();

		String paramType;
		String propType;

		Object dto = null;

		try {
			dto = clazz.newInstance();

			Method[] methods = clazz.getDeclaredMethods();
			// 파라미터 이름,값 가져오기
			// 하나의 키에 대해 값이 여러개일 수 있다
			// 1. 하나인지 여러개인지 체크
			// 2. 각 값에 대해서 다 대입하도록? > 타입이 컬렉션이어야 한다
			while (paramItr.hasNext()) {
				param = paramItr.next();
				paramValue = paramMap.get(param);
				param = adjustParamName(param);

				System.out.println("요청 파라미터 : " + param + "  값 : " + Arrays.toString(paramValue));

				// dto에서 프로퍼티 가져오기
				for (Method method : methods) {
					prop = methodNameToProperty(method.getName());
					if (method.getName().contains("set") && prop.equals(param) && !paramValue.equals("")) {

						for (int i = 0; i < paramValue.length; i++) {
							System.out.println(" - " + dto.getClass().getSimpleName() + " " + method.getName() + "실행 - "
									+ paramValue[i] + " => " + prop);
							paramType = paramValue[i].getClass().getSimpleName();
							propType = method.getParameters()[0].getType().getSimpleName();
							System.out.println("파라미터 타입 : " + paramType + " 프로퍼티 타입 : " + propType);

							if (paramType == propType)
								method.invoke(dto, paramValue[i]);
							else {
								System.out.println("paramvalue" + " " + paramValue.getClass().getSimpleName() + " "
										+ paramValue[i]);
								switch (propType) {
								case "String":
									method.invoke(dto, paramValue[0]);
									break;
								case "int":
									method.invoke(dto, Integer.parseInt(paramValue[0]));
									break;
								case "Double":
									method.invoke(dto, Double.parseDouble(paramValue[0]));
									break;
								case "Boolean":
									method.invoke(dto, Boolean.parseBoolean(paramValue[0]));
									break;
								case "Date":
									method.invoke(dto, java.sql.Date.valueOf(paramValue[0]));
									break;
								}
//								method.invoke(dto, castParamType(paramValue, propType));
							}
						}
					}
//						if (paramValue.length == 1) {
//							method.invoke(dto, paramValue[0]);
//							settedPropSet.add(prop);
//						} else if (paramValue.length > 1) {
					// 파라미터 값이 여러개일 경우의 처리 필요
					// 여러개이면 아마 콜렉션에 추가하는 식으로
					// 이럴 경우엔 setter가 add가 될 것이다
//						}

				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			e.printStackTrace();
		}

		// 확인용
		checkSettedProperties(dto);
		return dto;
	}

	// db조회 결과 ResultSet로 dto를 초기화
	public static void setDtoWithResultSetRow(Object dto, ResultSet rs) {
		logMethodStart();
		String column;
		String columnType;// 확인용
		Object columnValue;
		try {
			int columnCount = rs.getMetaData().getColumnCount();

			// resultSet의 다음 값을 불러와 dto에 저장
			// !주의 : getObject로 NUMBER을 가져오면 int가 아닌 BicDemical로 전달된다
			for (int i = 1; i <= columnCount; i++) {
				column = rs.getMetaData().getColumnName(i);
				columnType = rs.getMetaData().getColumnTypeName(i);
				switch (columnType) {
				case "NUMBER":
					columnValue = rs.getInt(i);
					break;
				case "VARCHAR2":
					columnValue = rs.getString(i);
					break;
				default:
					columnValue = rs.getObject(i);
					break;
				}
				System.out.println(i + "번째 칼럼 : " + column + " 타입 : " + columnType + " 값 : " + columnValue);
				setPropertyWithColumn(dto, column, columnValue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// dto와 칼럼이름, 값만 가지고오면 알아서 매칭해서 저장
	// Collection 변수이면 add하기 추가....
	public static void setPropertyWithColumn(Object dto, String column, Object columnValue) {
		logMethodStart();
		// dto에서 메서드 이름 뽑아오기
		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		String property;
		String methodName = "";
		Object convertedColumnValue = columnValue;

		for (Method method : methods) {
			try {
				methodName = method.getName();
				property = methodNameToColumn(methodName);
//				if (methodName.contains("set") && property.equals(column) && columnValue!=null) {// 칼럼이름은 대문자로 튀어나온다
				if (methodName.contains("set") && property.contains(column) && columnValue != null) {// 칼럼이름은 대문자로 튀어나온다
					convertedColumnValue = convertColumnType(columnValue);
					System.out.println("칼럼 " + column + "과 일치하는 메서드 발견 : " + methodName + "실행");
					System.out.println(property + "의 값을 " + convertedColumnValue + "로 초기화");
					method.invoke(dto, convertedColumnValue);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	// dto의 모든 프로퍼티 셋 반환
	public static Set<String> getAllPropertySet(Object dto) {
		logMethodStart();
		Set<String> propertySet = new HashSet<>();
		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		String methodName;
		String property;

		for (Method method : methods) {
			methodName = method.getName();
			property = methodNameToProperty(methodName);
			propertySet.add(property);
		}
		return propertySet;
	}

	// VO의 모든 프로퍼티 키, 값 Map 반환
	public static Map<String, Object> getAllPropertyMap(Object dto) {
		logMethodStart();
		String property = "";
		Object propertyValue;
		Map<String, Object> propertieMap = new HashMap<>();

		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();

		System.out.println(dto.getClass().getSimpleName() + "의 프로퍼티 목록");
		for (Method method : methods) {
			// Class에는 다른 get메서드가 존재한다
			if (method.getName().contains("get")) {
				property = methodNameToProperty(method.getName());

				try {
					propertyValue = method.invoke(dto);
					System.out.print("프로퍼티 : " + property + " 값 : " + propertyValue);
					propertieMap.put(property, propertyValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return propertieMap;
	}

	// 값이 있는 프로퍼티만 Map 으로 반환
	public static Map<String, Object> getValidPropertyMap(Object dto) {
		logMethodStart();
		String property;
		Object propertyValue;
		Map<String, Object> propertieMap = new HashMap<>();

		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();

		System.out.println(dto.getClass().getSimpleName() + "의 프로퍼티 목록");
		for (Method method : methods) {
			// Class에는 다른 get메서드가 존재한다
			if (method.getName().contains("get")) {
				property = methodNameToProperty(method.getName());

				try {
					propertyValue = method.invoke(dto);
					if (propertyValue != null && propertyValue != "") {
						System.out.println("프로퍼티 : " + property + " 값 : " + method.invoke(dto));
						propertieMap.put(property, method.invoke(dto));
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return propertieMap;
	}

	// PreparedStatement에 순서를 맞추기 위해 List 사용
	// 프로퍼티 값이 존재하는지 미리 확인.. 근데 이러면 자원 낭비가 너무 많이 된다
	public static List<String> getValidPropertyList(Object dto) {
		logMethodStart();
		String property;
		Object propertyValue;
		List<String> propertyList = new ArrayList<>();

		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();

		System.out.println("memberDto의 프로퍼티 목록");
		for (Method method : methods) {
			if (method.getName().contains("get")) {
				try {
					property = methodNameToProperty(method.getName());
					propertyValue = method.invoke(dto);
					if (propertyValue != null && propertyValue != "") {
						System.out.println("프로퍼티 : " + property + " 값 : " + method.invoke(dto));
						propertyList.add(property);
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return propertyList;
	}

	public static List<Object> getValidPropertyValueList(Object dto) {
		logMethodStart();
		String property;
		Object propertyValue;
		List<Object> propertyValueList = new ArrayList<>();

		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();

		System.out.println("memberDto의 프로퍼티 목록");
		for (Method method : methods) {
			if (method.getName().contains("get")) {
				try {
					property = methodNameToProperty(method.getName());
					propertyValue = method.invoke(dto);
					if (propertyValue != null && propertyValue != "") {
						System.out.println("프로퍼티 : " + property + " 값 : " + method.invoke(dto));
						propertyValueList.add(propertyValue);
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		// 확인
		List<String> propertyList = getValidPropertyList(dto);
		Iterator<String> propertyItr = propertyList.iterator();
		Iterator<Object> propertyValueItr = propertyValueList.iterator();
		System.out.println("ㅇList에 저장된 프로퍼티 값 ");
		while (propertyValueItr.hasNext() && propertyItr.hasNext()) {
			System.out.println("프로퍼티 : " + propertyItr.next() + " 값 : " + propertyValueItr.next());
		}
		return propertyValueList;
	}

	public static void checkSettedProperties(Object dto) {
		logMethodStart();
		String checkPropertyName;
		Object checkPropertyValue;
		Map<String, Object> dtoPropertyMap = getValidPropertyMap(dto);
		Iterator<String> dtoPropertyItr = dtoPropertyMap.keySet().iterator();
		while (dtoPropertyItr.hasNext()) {
			checkPropertyName = dtoPropertyItr.next();
			checkPropertyValue = dtoPropertyMap.get(checkPropertyName);
			System.out.println("저장된 프로퍼티 : " + checkPropertyName + " 값 : " + checkPropertyValue);
		}
	}

	public static void printDtoInfo(Object dto) {
		logMethodStart();
		Class clazz = dto.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		String methodName;
		System.out.print("dto 정보 : ");
		try {
			for (Method method : methods) {
				methodName = method.getName();
				if (methodName.contains("get"))
					System.out.print(methodName + " : " + method.invoke(dto) + " ");
			}
			System.out.println("");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void logMethodStart() {
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
		System.out.print("----------------");
		System.out.print(
				stackTraceElement.getClassName().substring((stackTraceElement.getClassName().lastIndexOf(".") + 1)));
		System.out.print(" " + stackTraceElement.getMethodName() + "실행");
		System.out.println("---------------");
	}

	public static void logMethodEnd() {
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
		System.out.print("----------------");
		System.out.print(
				stackTraceElement.getClassName().substring((stackTraceElement.getClassName().lastIndexOf(".") + 1)));
		System.out.print(" " + stackTraceElement.getMethodName() + "끝");
		System.out.println("---------------");
	}

	public void setLog(boolean value) {
		if (value == true) {
			log = Log.ENABLE;
		} else {
			log = Log.DISABLE;
		}

	}

	public static Object castParamType(String paramValue, Object propType) {
		Object result = null;
		switch (propType.getClass().getSimpleName()) {
		case "String":
			return paramValue;
		case "Integer":
			return Integer.parseInt(paramValue);
		case "Double":
			return Double.parseDouble(paramValue);
		case "Boolean":
			return Boolean.parseBoolean(paramValue);
		case "Date":
			return java.sql.Date.valueOf(paramValue);
		}
		return "result";
	}

	public static Object castParamType(String[] paramValue, Object propType) {
		Object result = null;
		switch (propType.getClass().getSimpleName()) {
		case "String":
			return paramValue;
		case "Integer":
			return Integer.parseInt(paramValue[0]);
		case "Double":
			return Double.parseDouble(paramValue[0]);
		case "Boolean":
			return Boolean.parseBoolean(paramValue[0]);
		case "Date":
			return java.sql.Date.valueOf(paramValue[0]);
		}
		return "result";
	}

}

enum Log {
	ENABLE, DISABLE
}
