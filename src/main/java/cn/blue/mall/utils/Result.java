package cn.blue.mall.utils;

import java.util.HashMap;

/**
 * 封装返回的ajax值
 * 
 * @author Blue
 *
 */
public class Result extends HashMap<String, Object> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Result() {
	}

	public static Result success() {
		return new Result().setCode(200);
	}

	public static Result error(int code) {
		return new Result().setCode(code);
	}

	public Result add(String key, Object value) {
		this.put(key, value);
		return this;
	}

	public Result setCode(int code) {
		this.put("code", code);
		return this;
	}

	public int getCode() {
		return this.getValue("code");
	}

	public Result setMsg(String msg) {
		this.put("msg", msg);
		return this;
	}

	public String getMsg() {
		return this.getValue("msg");
	}

	public <T> T getValue(String key) {
		return (T) this.get(key);
	}
}
