package de.kolpa.thb;

import de.kolpa.thb.pizzapronto.PizzaVO;

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

        System.out.println(pizzaVO);

        try {
            PizzaVO klon = pizzaVO.clone();
            System.out.println(klon);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
