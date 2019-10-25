package com.example.homework2borgerkong;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * A class to simulate some data source existing. Use to practice intents and lists/RecyclerView
 * before going into APIs.
 *
 * Example usage:
 *      Article articleObject1 = FakeDatabase.getArticleById(1);
 *      System.out.println(articleObject1.getHeadline());
 *
 * Output:
 *      Diamonds, Warlords and Mercenaries: Russia’s New Playbook in Africa
 */

public class Database {


    /***
     * Retrieves an Article object using the provided id.
     */
    public static MenuItem getMenuItemById(int itemID) {
        return menuItems.get(itemID);
    }


    public static ArrayList<MenuItem> getAllMenuItems() {
        return new ArrayList<MenuItem>((List) Arrays.asList(menuItems.values().toArray()));
    }

    private static final HashMap<Integer, MenuItem> menuItems = new HashMap<>();

    static {
        menuItems.put(3, new MenuItem(
                3,
                "Schmear Bagel",
                "Plain whipped cream cheese",
                7,
                R.drawable.schmear
        ));
        menuItems.put(2, new MenuItem(
                2,
                "Uber Schmear Bagel",
                "Jalapeno and plain whipped cream cheese",
                9,
                R.drawable.uberschmear
        ));

        menuItems.put(4, new MenuItem(
                4,
                "Lox Bagel",
                "Smoked salmon, capers, red onion, fresh dill, cream cheese",
                15,
                R.drawable.lox
        ));

        menuItems.put(12, new MenuItem(
                12,
                "PBJ Time Bagel",
                "Peanut butter, pomegranate, strawberry rose jam",
                9,
                R.drawable.pbj
        ));

        menuItems.put(13, new MenuItem(
                13,
                "Charlie Rose Bagel",
                "Plain cream cheese, strawberry rose jam",
                8,
                R.drawable.charlierose
        ));

        menuItems.put(6, new MenuItem(
                6,
                "Uptown Elvis Bagel",
                "Nutella, banana, puffed rice",
                10,
                R.drawable.elvis
        ));

        menuItems.put(7, new MenuItem(
                7,
                "Broadway Smash Bagel",
                "Avocado, watercress, heirloom tomato, za'atar, olive oil",
                14,
                R.drawable.broadway
        ));

        menuItems.put(8, new MenuItem(
                8,
                "Beestie Boy Bagel",
                "Poached nashi pear, honey, cinnamon, ricotta",
                10,
                R.drawable.beestieboy
        ));

        menuItems.put(9, new MenuItem(
                9,
                "Corney Island",
                "Pulled corned beef, mustard, caramelised onion",
                14,
                R.drawable.corney
        ));

        menuItems.put(10, new MenuItem(
                10,
                "Pastrami Hangover",
                "Pastrami, egg, American cheese, caramelised onion, potato bun",
                14,
                R.drawable.hangover
        ));

        menuItems.put(11, new MenuItem(
                11,
                "Katz Me if You Can",
                "Pastrami, deli mustard, NY rye, Classic!",
                16,
                R.drawable.katz
        ));

        menuItems.put(1, new MenuItem(
                1,
                "Pastrami Reuben",
                "Pastrami, sauerkraut, gruyere, Thousand Island, NY rye",
                16,
                R.drawable.pastrami
        ));

        menuItems.put(5, new MenuItem(
                5,
                "Crown Heights",
                "Corned beef, seeded mustard cream, confit onion, cucumber, NY rye",
                15,
                R.drawable.crown
        ));

        menuItems.put(14, new MenuItem(
                14,
                "Fish Tanked",
                "Whiskey-cured ocean trout, dill and capers labneh, red onion slaw, pumpernickel bagel",
                16,
                R.drawable.fish
        ));

        menuItems.put(15, new MenuItem(
                15,
                "N'da Turkey Club",
                "Roast turkey, bacon, heirloom tomatoes, gruyere, pain de mie sandwich bread",
                7,
                R.drawable.turkey
        ));

    }
}
