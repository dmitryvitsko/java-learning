import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParcelTest {
    Parcel parcel;
    ParcelBox box = new ParcelBox(50);

    @Test
    public void shouldBeCostParcelPer1kg() {
        parcel = new StandardParcel("Standart", 1, "Minsk", 3);
        assertTrue(parcel.calculateDeliveryCost() == 2);

        parcel = new PerishableParcel("Standart", 1, "Minsk", 3, 4);
        assertTrue(parcel.calculateDeliveryCost() == 3);

        parcel = new FragileParcel("Standart", 1, "Minsk", 3);
        assertTrue(parcel.calculateDeliveryCost() == 4);
    }

    @Test
    public void shouldBeCostParcelPer0kg() {
        parcel = new StandardParcel("Standart", 0, "Minsk", 3);
        assertFalse(parcel.calculateDeliveryCost() == 2);

        parcel = new PerishableParcel("Standart", 0, "Minsk", 3, 4);
        assertFalse(parcel.calculateDeliveryCost() == 3);

        parcel = new StandardParcel("Standart", 0, "Minsk", 3);
        assertFalse(parcel.calculateDeliveryCost() == 4);
    }

    @Test
    public void shouldBeisExpired() {
        PerishableParcel parcel = new PerishableParcel("Standart", 2, "Minsk", 3, 4);
        assertTrue(parcel.isExpired(8));
    }

    @Test
    public void shouldNotBeisExpired() {
        PerishableParcel parcel = new PerishableParcel("Standart", 2, "Minsk", 3, 4);
        assertFalse(parcel.isExpired(6));
    }

    @Test
    public void shouldAddToBox() {
        parcel = new StandardParcel("Standart", 1, "Minsk", 3);

        assertTrue(box.getCurrentWeight() + parcel.getWeight() < box.getMaxWeight());
    }

    @Test
    public void shouldNotAddToBox() {
        parcel = new StandardParcel("Standart", 100, "Minsk", 3);

        assertFalse(box.getCurrentWeight() + parcel.getWeight() < box.getMaxWeight());
    }
}
