package by.chronology.core.dao.impl;

import by.chronology.common.dao.criteria.DateRangeSearchCriteria;
import by.chronology.core.dao.TimeTagDao;
import by.chronology.core.dao.config.TimeTagDaoImplTestConfiguration;
import by.chronology.core.model.TimeTag;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TimeTagDaoImplTestConfiguration.class})
@Transactional
public class TimeTagDaoImplTest
{
    @Autowired
    TimeTagDao timeTagDao;

    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void setUp()
    {
        final Session session = sessionFactory.getCurrentSession();

        final TimeTag timeTag1 = new TimeTag();
        timeTag1.setTagTimestamp(new Timestamp(getDateInMillis(1985, 5, 28)));
        timeTag1.setLastUpdateTimestamp(new Timestamp(getDateInMillis(2020, 1, 1)));
        timeTag1.setTagName("Birthday Tag Name");
        session.save(timeTag1);

        final TimeTag timeTag2 = new TimeTag();
        timeTag2.setTagTimestamp(new Timestamp(getDateInMillis(1989, 1, 18)));
        timeTag2.setLastUpdateTimestamp(new Timestamp(getDateInMillis(2020, 1, 1)));
        timeTag2.setTagName("Wife Birthday Tag Name");
        session.save(timeTag2);

        final TimeTag timeTag3 = new TimeTag();
        timeTag3.setTagTimestamp(new Timestamp(getDateInMillis(2014, 3, 24)));
        timeTag3.setLastUpdateTimestamp(new Timestamp(getDateInMillis(2020, 1, 1)));
        timeTag3.setTagName("Son Birthday Tag Name");
        session.save(timeTag3);

        session.flush();
        session.clear();
    }

    @Test
    public void getByDates()
    {
        final DateRangeSearchCriteria criteria = new DateRangeSearchCriteria();
        criteria.setStartDate(new Date(getDateInMillis(1985, 5, 27)));
        criteria.setEndDate(new Date(getDateInMillis(1985, 5, 29)));
        final List<TimeTag> byDates = timeTagDao.getByDates(criteria);

        assertThat("Unexpected result list size", byDates.size(), is(1));
        assertThat("Unexpected tag name", byDates.get(0).getTagName(), is("Birthday Tag Name"));
    }

    @Test
    public void getByStart()
    {
        final DateRangeSearchCriteria criteria = new DateRangeSearchCriteria();
        criteria.setStartDate(new Date(getDateInMillis(1985, 5, 27)));
        final List<TimeTag> byDates = timeTagDao.getByDates(criteria);

        assertThat("Unexpected result list size", byDates.size(), is(3));
        assertThat("Unexpected tag name", byDates.get(0).getTagName(), is("Birthday Tag Name"));
        assertThat("Unexpected tag name", byDates.get(1).getTagName(), is("Wife Birthday Tag Name"));
        assertThat("Unexpected tag name", byDates.get(2).getTagName(), is("Son Birthday Tag Name"));
    }

    @Test
    public void getByEnd()
    {
        final DateRangeSearchCriteria criteria = new DateRangeSearchCriteria();
        criteria.setEndDate(new Date(getDateInMillis(1985, 5, 29)));
        final List<TimeTag> byDates = timeTagDao.getByDates(criteria);

        assertThat("Unexpected result list size", byDates.size(), is(1));
        assertThat("Unexpected tag name", byDates.get(0).getTagName(), is("Birthday Tag Name"));
    }

    private long getDateInMillis(int year, int month, int date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTimeInMillis();
    }
}
