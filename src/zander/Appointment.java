package zander;

/**
 * Class to handle appointments with Contacts
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 *
 *
 */

public class Appointment
{
    //Instance Vriables
    private String date;
    private String time;
    private String place;
    private String name;
    private String description;

    /**
     * Default Constructor
     */
    public Appointment()
    {

    }

    /**
     * Overloaded Constructor
     * @param date Date of Appointment
     * @param time of Appointment
     * @param place Place of Appointment
     * @param name Name of contact for Appointment
     * @param description Description of Appointment
     */
    public Appointment(String date, String time, String place, String name, String description)
    {
        setDate(date);
        setTime(time);
        setPlace(place);
        setName(name);
        setDescription(description);
    }

    /**
     * Assigns the date to the Appointment
     * @param date Date of appointmengt
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * Assigns the time to the Appointment
     * @param time Time of Appointment
     */
    public void setTime(String time)
    {
        this.time = time;
    }

    /**
     * Assigns the place to the meeting
     * @param place Place of appointment
     */
    public void setPlace(String place)
    {
        this.place = place;
    }

    /**
     * Assigns the name of the contact to meet with
     * @param name of contact to meet with
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Assigns the description to the Appointment
     * @param description Description of Appointment
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get the date of the Appointment
     * @return Date of Appointment
     */
    public String getDate()
    {
        return this.date;
    }

    /**
     * Get the time of appointment
     * @return Time of appointment
     */
    public String getTime()
    {
        return this.time;
    }

    /**
     * Get the place of appointment
     * @return place of appointment
     */
    public String getPlace()
    {
        return this.place;
    }

    /**
     * Get the name of contact to meet with
     * @return name of contact
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Compare two appointments
     * @param other Other appointment to compare with
     * @return true if the appointments clash
     */
    public boolean equals(Appointment other)
    {
        return false;
    }

    /**
     * Get string representation of object
     * @return string representation of object
     */
    public String toString()
    {
        return "";
    }
}
