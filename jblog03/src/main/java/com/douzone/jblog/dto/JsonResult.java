package com.douzone.jblog.dto;

public class JsonResult {
	private String result; 
	private Object data; 
	private String message;

	private JsonResult() {
	}

	private JsonResult(boolean result) {
		this.result = result ? "success" : "fail";
		this.data = null;
		this.message = null;
	}

	private JsonResult(String result, Object data) {
		this.result = result;
		this.data = data;
		this.message = null;
	}
	
	public static JsonResult notSelectTest(boolean success) {
		/* delete, insert, update는 각각 한 건 씩 이루어 지기 때문에
		   성공적으로 마무리 되면 return값을 1받으므로 매개변수를 return값==1 넣으면 되고
		   true면 success객체 실패면 fail객체를 return  */
		
		return new JsonResult(success);
	}

	public static JsonResult SelectTest(Object data) {
		/* select는 1건 이상의 data를 return 받기 때문에
		   성공적으로 마무리 되면 data를 받아오므로 매개변수를 select결과를 넣으면 되고
		   null이 아니면 data를 포함한 success객체 실패면 fail객체를 return*/
		if (data!=null) {
			return new JsonResult("success", data);
		} else {
			return new JsonResult("fail");
		}
	}

	public String getResult() {
		return result;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
	
	
	
	
	
	
	private JsonResult(Object data) {
		result = "success";
		this.data = data;
		message = null;
	}
	private JsonResult(String message) {
		result = "fail";
		data = null;
		this.message = message;
	}
	
	public static JsonResult success(Object data) {
		return new JsonResult(data);
	}
	
	public static JsonResult fail(String message) {
		return new JsonResult(message);
	}

}
