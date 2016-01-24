package com.developer.project.net;

import java.io.IOException;


public class CallWebService {
	public static String WSBaseUrl = "http://192.168.43.108:8080/DemoServlet/";
	Boolean bDebug = false;
	
	public String postData(String UrlPath, String strData) throws IOException {
		String strRetData = "";
		/*RestClient objRestClient = new RestClient(UrlPath);
		try {
			MyLogger.log(MyLogger.LOG_LEVEL_INFO, SyUtil.TAG, "UrlPath=" +UrlPath);
			MyLogger.log(MyLogger.LOG_LEVEL_INFO, SyUtil.TAG, "post=" +strData);
			objRestClient.AddParam("data", strData);
			objRestClient.Execute(RequestMethod.POST);
			if (objRestClient.getResponseCode() == 200) {
				strRetData = objRestClient.getResponse();
				MyLogger.log(MyLogger.LOG_LEVEL_INFO, SyUtil.TAG, "strRetData=" +strRetData);
			} else {
				MyLogger.log(MyLogger.LOG_LEVEL_ERROR,SyUtil.TAG, objRestClient.getErrorMessage());
			}

		}
		catch (IOException e) {
            throw e;
        }catch (Exception e) {
			MyLogger.log(MyLogger.LOG_LEVEL_ERROR,SyUtil.TAG, e.getMessage());
		}*/
		return strRetData;
	}
	
	public String postAuthenticateLogin(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "LoginServlet";
		if(bDebug) {
			return "<res><status><un>yashashvi</un><id>1</id></status></res>";
		}
		return postData(UrlPath, strData);
	}
	
	public String postAuthenticateCode(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "AuthenticateCode";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	
	public String postcheckUserNameAvailable(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "IsUsernameAvailableServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	
	public String postCreateUser(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "RegistrationServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	public String postCreateEvent(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "CreateEventServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	public String postUpdateAttendence(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "UpdateAttendenceServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	public String postGetOngoingEventsCreatedByteacher(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "GetOngoingEventsCreatedByTeacherServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	public String postGetRecentlyHappenedEventsCreatedByTeacher(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "GetRecentlyHappenedEventsCreatedByTeacherServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	public String postGetOngoingEventsForStudent(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "GetOngoingEventsForStudentServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	public String postGetRecentlyHappenedEventsForStudent(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "GetRecentlyHappendEventsForStudentervlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	
	public String postGetAttendenceForEvent(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "AttendenceOfParticularEventServlet";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	
	public String postUplaodFile(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "UploadFile";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
	
	public String postIsFileUplaod(String strData) throws IOException {
		String UrlPath = WSBaseUrl + "IsFileUploaded";
		if(bDebug) {
			return "<res><status>success</status></res>";
		}
		return postData(UrlPath, strData);
	}
}
