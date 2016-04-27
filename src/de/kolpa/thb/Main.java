package de.kolpa.thb;

import de.kolpa.thb.pizzapronto.KochVO;
import de.kolpa.thb.pizzapronto.KundeVO;
import de.kolpa.thb.pizzapronto.PizzaVO;

import java.awt.*;
import java.time.LocalDate;


/**
 * Created by Kolpa on 25.04.2016 use at own risk might be horribly broken...
 * Use git push --force Luke
 */
public class Main {

    public static void main(String[] args) {
        PizzaVO pizzaVO = new PizzaVO();
        pizzaVO.setName("Seife");
        pizzaVO.setPreis(200);
        pizzaVO.setZutaten(new String [] {
                "Salz",
                "Pfeffer",
                "Seife",
                "Bohnerwachs"
        });

        PizzaVO pizzaVO1 = pizzaVO.clone();

        pizzaVO1.setZutaten(new String[] {
                "Kaffe"
        });

        System.out.println(pizzaVO1);

        System.out.println(pizzaVO);

        KochVO kochVO = new KochVO("Weasley", "Torsten", Color.RED);

        System.out.println(kochVO);

        KundeVO kundeVO = new KundeVO("Weasley", "Torben", "männlich", LocalDate.of(191280, 10, 1));

        System.out.println(kundeVO);
    }
}
