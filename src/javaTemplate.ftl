package com.bluemobi.bluecollar.network.request;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.bluemobi.bluecollar.network.LlptHttpJsonRequest;
import com.bluemobi.bluecollar.network.response.getTagListResponse;

public class <#list methodname as a>${a}</#list>Request extends LlptHttpJsonRequest<<#list methodname as a>${a}</#list>Response> {
	private static final String APIPATH = "<#list uri as a>${a}</#list>";

	<#list param as a>

		private String ${a.name};
		public String get${a.name?cap_first}() {return ${a.name};}
		public void set${a.name?cap_first}(String ${a.name}) {this.${a.name} = ${a.name};}
		
	</#list>

	public <#list methodname as a>${a}</#list>Request(Listener<<#list methodname as a>${a}</#list>Response> listener, ErrorListener errorListener) {
			super(Method.POST, APIPATH, listener, errorListener);
		}
	public <#list methodname as a>${a}</#list>Request(int method, String partUrl, Listener<<#list methodname as a>${a}</#list>Response> listener, ErrorListener errorListener) {
			super(method, partUrl, listener, errorListener);
		}
	public Class<<#list methodname as a>${a}</#list>Response> getResponseClass() {return <#list methodname as a>${a}</#list>Response.class;}

	public String GetApiPath() {return APIPATH;}

	public Map<String, String> GetParameters() {
			Map<String, String> map = new HashMap<String, String>();
		<#list param as a>
			map.put("${a.name}",${a.name});
		</#list>
			return map;
		}
}