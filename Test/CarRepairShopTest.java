//import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

//import static org.junit.jupiter.api.Assertions.*;

class CarRepairShopTest {

    @Test
   public void loadCarSaab() {
        Saab95 saab95 = new Saab95(4,125,0, Color.black, "Saab95");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>(2);
        saab95RepairShop.loadCar(saab95);
        assertEquals(saab95, saab95RepairShop.getCars().get(0));
    }

    @Test
   public void removeCar() {
        Saab95 saab1 = new Saab95(4,125,0, Color.black, "Saab95");
        Saab95 saab2 = new Saab95(4,125,0, Color.black, "Saab95");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>(2);
        saab95RepairShop.loadCar(saab1);
        saab95RepairShop.loadCar(saab2);
        saab95RepairShop.removeCar(saab1);
        assertEquals(saab2, saab95RepairShop.getCars().get(0));

    }

    @Test
   public void doesMaxSizeWork() {
        Saab95 saab1 = new Saab95(4,125,0, Color.black, "Saab95");
        Saab95 saab2 = new Saab95(4,125,0, Color.black, "Saab95");
        Saab95 saab3 = new Saab95(4,125,0, Color.black, "Saab95");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>(2);
        saab95RepairShop.loadCar(saab1);
        saab95RepairShop.loadCar(saab2);
        saab95RepairShop.loadCar(saab3);
        saab95RepairShop.removeCar(saab1);
        assertEquals(saab2, saab95RepairShop.getCars().get(0));

    }

}