package pers.sherry.gof.facade.facade;

import pers.sherry.gof.facade.subsystem.Cook;
import pers.sherry.gof.facade.subsystem.Purchase;
import pers.sherry.gof.facade.subsystem.Wash;


/**
 * Facade - 外观(门面)
 */
public class CookDinnerFacade {

    private Purchase purchase;

    private Wash wash;

    private Cook cook;

    public CookDinnerFacade(){
        this.purchase = new Purchase();
        this.wash = new Wash();
        this.cook = new Cook();
    }

    public void cookDinner(){
        purchase.purchase();
        wash.wash();
        cook.cook();
    }

}
