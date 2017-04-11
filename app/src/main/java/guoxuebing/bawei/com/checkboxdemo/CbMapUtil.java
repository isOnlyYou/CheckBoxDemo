package guoxuebing.bawei.com.checkboxdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by acer on 2017/4/11.
 */
public class CbMapUtil<T> {
    /**
     * 控制CheckBox的map
     */
    private HashMap<T,Boolean> map;

    public CbMapUtil() {
        map = new HashMap<>();
    }

    public CbMapUtil(HashMap<T, Boolean> map) {
        if(map==null){
            throw new NullPointerException();
        }
        this.map = map;
    }

    //get方法
    public HashMap<T, Boolean> getMap() {
        return map;
    }

    //set方法
    public void setMap(HashMap<T, Boolean> map) {
        if(map==null){
            throw new NullPointerException();
        }
        this.map = map;
    }

    /**
     * map中是否所有的boolean都为true
     * @return true已全部选中 false未全部选中
     */
    public boolean is_selected_all(){
        //map无数据则直接返回false
        if(map.isEmpty()){
            return false;
        }

        //遍历map集合
        Set<Map.Entry<T, Boolean>> set = map.entrySet();

        //使用迭代器
        Iterator<Map.Entry<T, Boolean>> iterator = set.iterator();

        while(iterator.hasNext()){
            Map.Entry<T, Boolean> entry = iterator.next();
            //有一个false 即返回false
            if(!entry.getValue()){
                return false;
            }
        }

        return true;
    }

    /**
     * 全选 或者 反选
     * @param flag 将map中的value全部设置成该值
     */
    public void set_all_value(boolean flag){
        //遍历map集合
        Set<Map.Entry<T, Boolean>> set = map.entrySet();

        //将map的value都设置成flag
        for (Map.Entry<T, Boolean> m : set) {
            m.setValue(flag);
        }

    }

    /**
     * 获取相应条目的选中状态
     * @param t 泛型
     * @return boolean 条目的选中状态
     */
    public boolean get_value(T t){
        if(t==null){
            throw new NullPointerException();
        }
        return map.get(t);
    }

    /**
     * 向map中添加一个元素
     * @param t 泛型
     * @param flag 添加时的value值
     */
    public void put_item(T t, Boolean flag){
        if (t==null){
            throw new NullPointerException();
        }
        map.put(t, flag);
    }

    /**
     * 添加或改变一个元素时 检查map中所有的value是否都为true
     * @param t 添加的元素
     * @param flag 添加时的value值
     * @return 添加后map中的value值是否都为true 是返回true 否返回false
     */
    public boolean put_and_check(T t, Boolean flag){
        put_item(t,flag);
        if(flag==false){
            return false;
        }
        return is_selected_all();
    }

    /**
     * 向map中添加多条数据
     * @param list 需要添加的list集合
     * @param flag 默认的value值
     */
    public void put_items(List<T> list, Boolean flag){
        if(list==null){
            throw new NullPointerException();
        }
        for (T t : list) {
            map.put(t, flag);
        }
    }

    /**
     * 清空map中的所有信息
     */
    public void clear_map(){
        map.clear();
    }
}
