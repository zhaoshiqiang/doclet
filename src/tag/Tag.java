package tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoshiqiang on 2016/9/10.
 */
public class Tag implements Serializable{
    private String name;    //标签名称
    private int type;   //1 string; 2 split
    private List<String> items;    //分割后每项名称
    private String symbol;  //分割符号
    private List<String> itemvalues;   //标签名称对应的值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<String> getItemvalues() {
        return itemvalues;
    }

    public void setItemvalues(List<String> itemvalues) {
        this.itemvalues = itemvalues;
    }

    public List transformTagvalue(){
        if (type == 1){
            //string
            return itemvalues;
        }else if (type == 2){
            //split
            List<Map> tagvalues = new ArrayList<Map>();
            for (String itemvalue : itemvalues){
                Map<String,String> itemmap = new HashMap<String,String>();
                String[] values = itemvalue.split(symbol);
                for (int i =0; i<values.length ; i++){
                    System.out.println(items.get(i) + "-------" + values[i]);
                    itemmap.put(items.get(i),values[i]);
                }
                tagvalues.add(itemmap);
            }
            return tagvalues;
        }else {
            return null;
        }
    }
}
