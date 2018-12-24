package pers.sherry.gof.facade;

import pers.sherry.gof.facade.facade.CookDinnerFacade;

/**
 * 10. Facade Pattern 外观模式(门面模式)
 */
public class FacadePattern {

    public static void main(String[] args) {
        CookDinnerFacade facade = new CookDinnerFacade();
        facade.cookDinner();
    }
}
