package org.cic.template.utils;

public class CommonCode {
	
	public enum AreaType {
		新竹, 台南
    }
	
	public enum SignUpType {
		學生, 業界人士, 學生團報
    }
	
	public enum SexType {
		男, 女
    }

	public enum GraguateType {
		在學, 畢業, 肄業
    }
	
	public enum InvType {
		二聯, 三聯
    }
	
	public enum LevelType {
		高中職, 專科, 學士, 碩士, 博士
    }
	

	public static String getAreaName(String type) {
        if (type.equals("1")) {
        	return AreaType.新竹.toString();
        	
        } else if (type.equals("2")) {
        	return AreaType.台南.toString();
        }

        return "";
    }
	
	public static String getSignUpName(String type) {
        if (type.equals("1")) {
        	return SignUpType.學生.toString();
        	
        } else if (type.equals("2")) {
        	return SignUpType.業界人士.toString();
        }
        else if (type.equals("3")) {
        	return SignUpType.學生團報.toString();
        }

        return "";
    }
	
	public static String getSexName(String type) {
        if (type.equals("1")) {
        	return SexType.男.toString();
        	
        } else if (type.equals("2")) {
        	return SexType.女.toString();
        }

        return "";
    }
	
	public static String getGraguateName(String type) {
        if (type.equals("1")) {
        	return GraguateType.在學.toString();
        	
        } else if (type.equals("2")) {
        	return GraguateType.畢業.toString();
        	
        } else if (type.equals("3")) {
        	return GraguateType.肄業.toString();
        }

        return "";
    }
	
	public static String getInvTypeName(String type) {
        if (type.equals("1")) {
        	return InvType.二聯.toString();
        	
        } else if (type.equals("2")) {
        	return InvType.三聯.toString();
        	
        }

        return "";
    }
	
	public static String getLevelName(String type) {
        if (type.equals("1")) {
        	return LevelType.高中職.toString();
        	
        } else if (type.equals("2")) {
        	return LevelType.專科.toString();
        	
        } else if (type.equals("3")) {
        	return LevelType.學士.toString();
        	
        } else if (type.equals("4")) {
        	return LevelType.碩士.toString();
        	
        } else if (type.equals("5")) {
        	return LevelType.博士.toString();
        	
        }
 
        return "";
    }
}
