package by.chronology.core.model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BaseEntityTest
{
    private TestEntity testEntity;

    @Before
    public void setUp()
    {
        testEntity = new TestEntity(123L, "description");
    }

    @Test
    public void hashCodeObject()
    {
        assertThat("Unexpected hashCode value", testEntity.hashCode(), is(((Object)testEntity).hashCode()));
    }

    @Test
    public void hashCodeInclude() throws NoSuchFieldException
    {
        testEntity.setHashCodeIncludedFields(Arrays.asList(testEntity.getClass().getDeclaredField("id"), testEntity.getClass().getDeclaredField("description")));
        //TODO: Tests need to be completed
        //assertThat("Unexpected hashCode value", testEntity.hashCode(), is(((Object)testEntity).hashCode()));
    }

    @Test
    public void equals()
    {

    }

    private class TestEntity extends BaseEntity
    {
        private Long id;
        private String description;
        private List<Field> hashCodeIncludedFields;

        public TestEntity(Long id, String description)
        {
            this.id = id;
            this.description = description;
        }

        public void setHashCodeIncludedFields(List<Field> hashCodeIncludedFields)
        {
            this.hashCodeIncludedFields = hashCodeIncludedFields;
        }

        @Override
        protected List<Field> getHashCodeIncludedFields()
        {
            return hashCodeIncludedFields;
        }

        @Override
        protected String[] getHashCodeExcludedFields()
        {
            return super.getHashCodeExcludedFields();
        }

        @Override
        protected List<Field> getEqualsIncludedFields()
        {
            return super.getEqualsIncludedFields();
        }

        @Override
        protected String[] getEqualsExcludedFields()
        {
            return super.getEqualsExcludedFields();
        }
    }
}