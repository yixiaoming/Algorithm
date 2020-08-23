import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Main
 */



public class Main {
    public static class House {
        public House(String name, int area, int count, String desc) {
            this.name = name;
            this.area = area;
            this.count = count;
            this.desc = desc;
        }
    
        public String name;
        public int area;
        public int count;
        public String desc;
    }
    
    public static void main(String[] args) {
        ArrayList<House> houses = new ArrayList<>();
        houses.add(new House("A1", 184, 108, "四室两厅双卫"));
        houses.add(new House("A2", 162, 108, "四室两厅双卫"));
        houses.add(new House("B1", 141, 30, "四室两厅双卫"));
        houses.add(new House("C1", 108, 72, "三室两厅一卫"));
        houses.add(new House("B2,B3", 100, 30, "三室两厅一卫"));
        houses.add(new House("D1", 80, 26, "二室两厅一卫"));
        houses.add(new House("D2,D3", 60, 26, "一室两厅一卫"));

        for (House house : houses) {
            int area = house.area;
            float price = (area - 60) * 24198 + 60 * 24198 * 0.85F + 2000 * area;
            float priceLeft = price - 700000 - price * 0.3F;
            System.out.printf("%6s %7s  套数:%3d  面积:%3d  总价:%.1f  首付:% 10.1f  公积金贷款:%d  剩余贷款:% 10.1f \n", house.name, house.desc, house.count, house.area,
                    price, price * 0.3, 700000, priceLeft);
        }
    }
}