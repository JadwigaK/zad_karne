package ex4;

/**
 * Created by Jadwiga on 2016-10-15.
 */
public class Main {

    public static void main(String[] args) {
        BiMap<String, String> map = new BiMapImpl<String, String>();

        map.put("Ala", "Kowa");
        map.put("Ela", "Hipa");
        map.put("Ania", "Repa");
        System.out.println("mapa: " + map);

        map.forcePut("Hania", "Kowa");
        System.out.println("mapa po: " + map);

        BiMap<String, String> inMap = map.inverse();
        System.out.println("mapa po inverse: "+inMap);

        inMap.put("Kasia", "Kowa");
        System.out.println("mapa po nowym put: "+inMap);

        inMap.put("Zosia", "Kowa");
        System.out.println("mapa po nowym put jeszcze raz: "+inMap);
    }

}
