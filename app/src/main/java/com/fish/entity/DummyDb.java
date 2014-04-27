package com.fish.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by warrior on 14-4-26.
 */
public class DummyDb {

    public static List<FishEntity> fishList;
    public static List<StoreEntity> storeList;
    public static List<OrderEntity> orderList;
    private static List<FishEntity> list1;
    private static List<FishEntity> list2;
    private static List<FishEntity> list3;
    private static List<FishEntity> list4;

    static {
        list1 = new ArrayList<FishEntity>();
        FishEntity fishEntity = new FishEntity().setName("带鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("黄花鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("鲶鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("草鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("鲨鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("沙丁鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("三文鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("金枪鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("秋刀鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("黑鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("金鱼").setArea("东估渔港");
        list1.add(fishEntity);
        fishEntity = new FishEntity().setName("螺丝").setArea("东估渔港");
        list1.add(fishEntity);

        list2 = new ArrayList<FishEntity>();
        fishEntity = new FishEntity().setName("带鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("黄花鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("鲶鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("草鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("鲨鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("沙丁鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("三文鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("金枪鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("秋刀鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("黑鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("金鱼").setArea("北估渔港");
        list2.add(fishEntity);
        fishEntity = new FishEntity().setName("螺丝").setArea("北估渔港");
        list2.add(fishEntity);

        list3 = new ArrayList<FishEntity>();
        fishEntity = new FishEntity().setName("带鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("黄花鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("鲶鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("草鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("鲨鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("沙丁鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("三文鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("金枪鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("秋刀鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("黑鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("金鱼").setArea("南门渔港");
        list3.add(fishEntity);
        fishEntity = new FishEntity().setName("螺丝").setArea("南门渔港");
        list3.add(fishEntity);

        list4 = new ArrayList<FishEntity>();
        fishEntity = new FishEntity().setName("带鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("黄花鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("鲶鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("草鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("鲨鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("沙丁鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("三文鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("金枪鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("秋刀鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("黑鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("金鱼").setArea("西大街渔港");
        list4.add(fishEntity);
        fishEntity = new FishEntity().setName("螺丝").setArea("西大街渔港");
        list4.add(fishEntity);

        fishList = list1;


        storeList = new ArrayList<StoreEntity>();
        StoreEntity se = new StoreEntity();
        se.setName("张三");
        storeList.add(se);
        se = new StoreEntity();
        se.setName("李四");
        storeList.add(se);
        se = new StoreEntity();
        se.setName("王五");
        storeList.add(se);
        se = new StoreEntity();
        se.setName("赵四");
        storeList.add(se);
        se = new StoreEntity();
        se.setName("Bobo");
        storeList.add(se);
        se = new StoreEntity();
        se.setName("OMZ");
        storeList.add(se);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 3, 26, 15, 12);
        orderList = new ArrayList<OrderEntity>();
        OrderEntity oe = new OrderEntity();
        oe.setName("张三").setPrice(10.2f).setWeight(200).setOrderDt(calendar.getTime()).setStatus(1);
        orderList.add(oe);
        oe = new OrderEntity();
        calendar.set(2014, 2, 29, 12, 35);
        oe.setName("李四").setPrice(10.2f).setWeight(200).setOrderDt(calendar.getTime());
        orderList.add(oe);
        oe = new OrderEntity();
        calendar.set(2014, 2, 20, 12, 22);
        oe.setName("王五").setPrice(8.2f).setWeight(300).setOrderDt(calendar.getTime());
        orderList.add(oe);
    }

    public static List<FishEntity> portList(int position) {
        List<FishEntity> portList = new ArrayList<FishEntity>();
        portList.add(list1.get(position));
        portList.add(list2.get(position));
        portList.add(list3.get(position));
        portList.add(list4.get(position));
        return portList;
    }

}
