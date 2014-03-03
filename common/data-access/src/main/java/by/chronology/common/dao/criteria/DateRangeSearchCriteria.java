package by.chronology.common.dao.criteria;

import java.util.Date;

/**
 * Common search criteria based on start and end dates.
 *
 * @author Tsimafei_Shchytkavets
 */
public class DateRangeSearchCriteria
{
    private Date startDate;
    private Date endDate;

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
}
