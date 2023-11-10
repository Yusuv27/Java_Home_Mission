import java.awt.*;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HomeMission {

    public static void main(String[] args){
        Map<String, String> FirstPhone = new HashMap<>();
        System.out.println("Телефоны без сортировки: ");
        FirstPhone.put("89000000001","Иванов");
        FirstPhone.put("89000000002","Юрий");
        FirstPhone.put("89000000003","Иванов");
        FirstPhone.put("89000000004","Саша");
        FirstPhone.put("89000000005","Иванов");
        FirstPhone.put("89000000006","Оля");
        FirstPhone.put("89000000007","Сергей");
        FirstPhone.put("89000000008","Настя");
        FirstPhone.put("89000000009","Настя");
        FirstPhone.put("89000000010","Сергей");
//        System.out.println(FirstPhone);
//        System.out.println();
        ArrayList<String> arrayKey = new ArrayList<>();
        ArrayList<String> arrayValue = new ArrayList<>();
        arrayKey.addAll(FirstPhone.keySet()); // Key из основной телефонной книжки
        arrayValue.addAll(FirstPhone.values());// Value из основной телефонной книжки
        for (int i = 0; i < arrayKey.size(); i++) {
            System.out.println(arrayValue.get(i)+" = "+arrayKey.get(i));
        }
        System.out.println();
        System.out.println("После сортировки: ");
//        System.out.println(arrayKey);
//        System.out.println(arrayValue);
//        System.out.println();

        LinkedHashMap<String,Integer> counter = new LinkedHashMap<>();
        int count=0;
            for (int i = 0; i < FirstPhone.size(); i++) {
                if(counter.containsKey(arrayValue.get(i))){
                    Integer oldValue = counter.get(arrayValue.get(i));
                    counter.put(arrayValue.get(i),oldValue+1 );
                }else{
                    counter.put(arrayValue.get(i),1);
                }
            }
//        System.out.println(counter);// Счетчик
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> counterList = new ArrayList<>();
        name.addAll(counter.keySet());
        counterList.addAll(counter.values());

//        System.out.println();
//        System.out.println(name);
//        System.out.println(counterList);
//        System.out.println();

        int num;
        String numname;
        for (int j = 0; j < counter.size(); j++) {
            for (int i = 0; i < counter.size() - 1; i++) {
                if (counterList.get(i) < counterList.get(i + 1)) {
                    num = counterList.get(i);
                    counterList.set(i, counterList.get(i + 1));
                    counterList.set(i + 1, num);

                    numname = name.get(i);
                    name.set(i, name.get(i + 1));
                    name.set(i + 1, numname);
                }
            }
        }
//        System.out.println(name); // Фамилия
//        System.out.println(counterList);// Счетчик сколько раз повторился
//        System.out.println();

        for (int i = 0; i < name.size(); i++) {
            for (int j = 0; j < arrayKey.size(); j++) {
                if (arrayValue.get(j).contains(name.get(i))){
                    System.out.println(name.get(i)+" = "+arrayKey.get(j));
                }
            }
        }
    }
}
