package zander;

import javafx.beans.property.SimpleStringProperty;

/**
 * Class to manage business contacts
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 *
 *
 */

public class BusinessContact extends Contact
{
    //Instance Vriables
    private SimpleStringProperty faxNo;
    private SimpleStringProperty company;
    private SimpleStringProperty position;

    /**
     * Default constructor
     */
    public BusinessContact()
    {
        this("", "", "", "", "", "", "");
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
     *
     * @return
     */
    @Override
    public String toString()
    {
        return null;
    }

    /**
     * Overloaded constructor
     * @param name Name of person
     * @param dayNo Day contact number for this person
     * @param faxNo Faximile number
     * @param eMail E-Mail address for this person
     * @param address Address for this person
     * @param company Name of company
     * @param position position of contact at company
     */
    public BusinessContact(String name, String dayNo, String faxNo, String eMail, String address, String company, String position)
    {
        super(name, dayNo, eMail, address);
        setFaxNo(faxNo);
        setCompany(company);
        setPosition(position);
    }

    /**
     * Assigns the fax number to contact
     * @param faxNo fax number
     */
    public void setFaxNo(String faxNo)
    {
        this.faxNo = new SimpleStringProperty(faxNo);
    }

    /**
     * Assigns the name of the company of contact
     * @param company
     */
    public void setCompany(String company)
    {
        this.company = new SimpleStringProperty(company);
    }

    /**
     * Assigns the position of contact at company
     * @param position position of contact at company
     */
    public void setPosition(String position)
    {
        this.position = new SimpleStringProperty(position);
    }

    /**
     * Get the fax number of contact
     * @return faxNo of the contact
     */
    public String getFaxNo()
    {
        return this.faxNo.get();
    }

    /**
     * Get the company name of contact
     * @return the name of the company of the contact
     */
    public String getCompany()
    {
        return this.company.get();
    }

    /**
     * Get the position of contact at company
     * @return position of the contact at company
     */
    public String getPosition()
    {
        return this.position.get();
    }
}
