import java.util.*;

public class hashmap {
	public static void Ini(HashMap<String, Integer> hm){
        hm.put("张三",3);
        hm.put("李四", 7);
        hm.put("王五", 9);
        hm.put("刘六", 5);
        hm.put("田七", 7);
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int temp = 0;
        String[] v = new String[5];
        boolean flag = true;

        Ini(hm);
        Iterator<Map.Entry<String, Integer>> iter = hm.entrySet().iterator();
        Iterator<Map.Entry<String, Integer>> iter2 = hm.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            Map.Entry<String, Integer> entry2;
            while(iter.hasNext()){
                entry2 = iter.next();
                if((entry2.getValue() == entry.getValue()) && (entry.getKey() != entry2.getKey())){
                    for(int i = 0; i < temp; i++){
                        if(v[i] == entry.getKey()){
                            flag = false;
                        }
                    }
                    if(flag == true) {v[temp++] = entry.getKey(); }
                }
            }
            entry2 = iter2.next();
            iter = hm.entrySet().iterator();
            entry = iter.next();
            while(!entry.getKey().equals(entry2.getKey())) 
            {
                entry = iter.next();
            }
        }
        for(int i = 0; i < temp; i++) {
        	hm.remove(v[i]);
        }
        iter = hm.entrySet().iterator();
        int k = 0;
        while(iter.hasNext()) {
        	Map.Entry<String, Integer> entry = iter.next();
        	list.add(entry.getKey());
        	list2.add(entry.getValue());
        	System.out.println("姓名:" + list.get(k) + " 编号:" + list2.get(k));
        	k++;
        }
    }
}
