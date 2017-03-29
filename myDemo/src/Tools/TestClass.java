package Tools;

import Tools.String.StringControl;

public class TestClass {
	private static String tarZhuanYeCode = "1012 1014 1024 1032 1034 1052 1054 1064 1072 1074 1084 1092 1094 1102 1104 1114 1122 1132 1134 1142 1144 2012 2014 2024 2034 2042 2054 2064 2072 2074 2084 3012 3014 3024 3032 3034 3042 3044 3052 3054 3064 3072 3074 3082 3084 3092 3102 3104 3112 3114 3124 3132 3134 3142 3144 3152 3164 3174 3182 3192 ";
	private static String tarXueZhi = " 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 5 5 5 5 5 5 5 5 5 5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5 ";
	public static void main(String[] args) {
		StringControl sc = new StringControl();
		String res = sc.changeToSqlInsertValueOrIn(tarZhuanYeCode, "\\s");
		System.out.println(res);
	}
}
