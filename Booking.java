// TODO -- create the Booking class (separate file: Booking.java)
public class Booking
{
    private String bookingName;
    private int nights;
    private int guests;

    Booking()
    {
        bookingName = null;
        nights = 0;
        guests = 0;
    }

    Booking(String bookingName, int nights, int guests)
    {
        this.bookingName = bookingName;
        this.nights = nights;
        this.guests = guests;
    }

    public void setBookingName(String bookingName)
    {
        this.bookingName = bookingName;
    }

    public String getBookingName()
    {
        return bookingName;
    }

    public void setNights(int nights)
    {
        this.nights = nights;
    }

    public int getNights()
    {
        return nights;
    }

    public void setGuests(int guests)
    {
        this.guests = guests;
    }

    public int getGuests()
    {
        return guests;
    }

    public double calculateCharge()
    {
        final double SITE_CHARGE = 14.50;
        final double GUEST_CHARGE = 4.95;
        final double SITE_CHARGE_DISCOUNT1 = 12.50;
        final double GUEST_CHARGE_DISCOUNT1 = 3.95;
        final double SITE_CHARGE_DISCOUNT2 = 10.50;
        final double GUEST_CHARGE_DISCOUNT2 = 2.95;
        final int DISCOUNT_LIMIT1 = 5;
        final int DISCOUNT_LIMIT2 = 10;
        double charge = 0.0;

        if (nights > DISCOUNT_LIMIT2)
        {
            charge = DISCOUNT_LIMIT1 * (SITE_CHARGE + (guests * GUEST_CHARGE)); // no discount range
            charge += (DISCOUNT_LIMIT2 - DISCOUNT_LIMIT1)
                * (SITE_CHARGE_DISCOUNT1 + (guests * GUEST_CHARGE_DISCOUNT1)); // first discount range
            charge += (nights - DISCOUNT_LIMIT2)
                * (SITE_CHARGE_DISCOUNT2 + (guests * GUEST_CHARGE_DISCOUNT2)); // second discount range
        }
        else if (nights > DISCOUNT_LIMIT1)
        {
            charge = DISCOUNT_LIMIT1 * (SITE_CHARGE + (guests * GUEST_CHARGE)); // no discount range
            charge += (nights - DISCOUNT_LIMIT1)
                * (SITE_CHARGE_DISCOUNT1 + (guests * GUEST_CHARGE_DISCOUNT1)); // second discount range
        }
        else
        {
            charge = nights * (SITE_CHARGE + (guests * GUEST_CHARGE)); // no discount range
        }

            return charge;
	}
}