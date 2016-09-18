package ${basepath}.request;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import ${basepath}.LlptHttpJsonRequest;
import ${basepath}.response.getTagListResponse;

public class ${methodname}Request extends LlptHttpJsonRequest<${methodname}Response> {
    private static final String APIPATH = "${uri}";

<#list paramlist as param>
    private String ${param.name};
    public String get${param.name?cap_first}() {return ${param.name};}
    public void set${param.name?cap_first}(String ${param.name}) {this.${param.name} = ${param.name};}

</#list>

    public ${methodname}Request(Listener<${methodname}Response> listener, ErrorListener errorListener) {
        super(Method.POST, APIPATH, listener, errorListener);
        }
        public ${methodname}Request(int method, String partUrl, Listener<${methodname}Response> listener, ErrorListener errorListener) {
            super(method, partUrl, listener, errorListener);
            }
            public Class<${methodname}Response> getResponseClass() {return ${methodname}Response.class;}

                public String GetApiPath() {return APIPATH;}

                public Map<String, String> GetParameters() {
                Map<String, String> map = new HashMap<String, String>();
			<#list paramlist as param>
                map.put("${param.name}",${param.name});
			</#list>
                return map;
                }
                }