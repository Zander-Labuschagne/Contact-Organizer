package zander;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 *
 *
 */
public abstract class Contact
{
    //Instance Vriables
    private SimpleStringProperty name;
    private SimpleStringProperty dayNo;
    private SimpleStringProperty eMail;
    private SimpleStringProperty address;

    /**
     * Default Constructor
     */
    public Contact()
    {
        this("", "", "", "");
    }

    /**
     * Overloaded constructor
     * @param name Name of person
     * @param dayNo Day contact number for this person
     * @param eMail E-Mail address for this person
     * @param address Address for this person
     */
    public Contact(String name, String dayNo, String eMail, String address)
    {
        setName(name);
        setDayNo(dayNo);
        setEMail(eMail);
        setAddress(address);
    }

    /**
     * Assigns name to contact
     * @param name name of the person/contact
     */
    public void setName(String name)
    {
        this.name = new SimpleStringProperty(name);
    }

    /**
     * Assigns day contact number to contact
     * @param dayNo day contact number of contact
     */
    public void setDayNo(String dayNo)
    {
        this.dayNo = new SimpleStringProperty(dayNo);
    }

    /**
     * Assigns E-Mail address of contact
     * @param eMail E-Mail address of contact
     */
    public void setEMail(String eMail)
    {
        this.eMail = new SimpleStringProperty(eMail);
    }

    /**
     * Assigns address of contact
     * @param address Address of contact
     */
    public void setAddress(String address)
    {
        this.address = new SimpleStringProperty(address);
    }

    /**
     * Get the name of the contact
     * @return name of contact
     */
    public String getName()
    {
        return this.name.get();
    }

    /**
     * Get the day contact number of person
     * @return day contact number of contact
     */
    public String getDayNo()
    {
        return this.dayNo.get();
    }

    /**
     * Get the E-Mail address of the person
     * @return eMail address of contact
     */
    public String getEMail()
    {
        return this.eMail.get();
    }

    /**
     * Get the physical address of contact
     * @return address of contact
     */
    public String getAddress()
    {
        return this.address.get();
    }

    /**
     * Get the details of the contact
     * @return string containing the contact details of the contact
     */
    public abstract String getContactDetails();

    /**
     * toString method
     * @return string of contact details
     */
    public abstract String toString();
}
