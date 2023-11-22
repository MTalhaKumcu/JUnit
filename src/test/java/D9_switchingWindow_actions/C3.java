package D9_switchingWindow_actions;

import org.junit.Test;

import java.time.LocalTime;

public class C3 {

    @Test
    public void test1() {

        int x = 3;
        LocalTime baslangic = LocalTime.now();
        int baslangicSecond = baslangic.getSecond();
        int secControl = 100;
        int bitisSaniyesi = baslangicSecond + x > 60 ? baslangicSecond + x - 60 : baslangicSecond + x;
        while (bitisSaniyesi != secControl) {
            secControl = LocalTime.now().getSecond();
        }
        System.out.println("baslangic" + baslangicSecond);
        System.out.println("saniye konrtol"+ secControl);
    }
}
