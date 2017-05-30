package zander;

import javafx.beans.property.SimpleStringProperty;

/**
 * Class to manage personal contacts
 *
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 */

public class PersonalContact extends Contact
{
    //Instance Vriables
    private SimpleStringProperty homeNo;
    private SimpleStringProperty birthday;

    /**
     * Default Constructor
     */
    public PersonalContact()
    {
        this("", "", "", "", "", "");
    }

    /**
     *
     * @return
     */
    @Override
    public String getContactDetails()
    {
        return null;
    }

    /**
     * Overloaded Constructor
     * @param name Name of contact
     * @param dayNo Day contact number of contact
     * @param homeNo Home contact number of contact
     * @param birthday Birthday of contact
     * @param eMail E-Mail address of contact
     * @param address Home address of contact
     */
    public PersonalContact(String name, String dayNo, String homeNo, String birthday, String eMail, String address)
    {
        super(name, dayNo, eMail, address);
        setHomeNo(homeNo);
        setBirthday(birthday);
    }

    /**
     * Assigns home contact number to contact
     * @param homeNo Home contact number of contact
     */
    public void setHomeNo(String homeNo)
    {
        this.homeNo = new SimpleStringProperty(homeNo);
    }

    /**
     * Assigns birthday to contact
     * @param birthday Birthday of contact to setFaxNo
     */
    public void setBirthday(String birthday)
    {
        this.birthday = new SimpleStringProperty(birthday);
    }

    /**
     * Get the Home contact number
     * @return this.homeNo home contact number of contact
     */
    public String getHomeNo()
    {
        return this.homeNo.get();
    }

    /**
     * Get the birthday of contact
     * @return birthday Birthday of contact
     */
    public String getBirthday()
    {
        return this.birthday.get();
    }


    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return null;
    }
}
