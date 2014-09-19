package by.chronology.core.model;

import by.chronology.common.util.ReflectionUtil;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The most base entity class with some common methods implementation
 * (e.g {@link #hashCode()} and {@link #equals(Object)}).
 *
 * @author Tsimafei_Shchytkavets
 */
@MappedSuperclass
public class BaseEntity
{
    @Override
    public int hashCode()
    {
        if (getHashCodeIncludedFields() != null)
        {
            final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
            for (Field field : getHashCodeIncludedFields())
            {
                try
                {
                    field.setAccessible(true);
                    hashCodeBuilder.append(field.get(this));
                }
                catch (IllegalAccessException e)
                {
                    throw new RuntimeException("hashCode() failed trying to get() " + field.getName());
                }
                return hashCodeBuilder.toHashCode();
            }
        }
        if (getHashCodeExcludedFields() != null)
        {
            return HashCodeBuilder.reflectionHashCode(13, 7, this, false, (Class<? super BaseEntity>) getClass(), getHashCodeExcludedFields());
        }

        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (null == obj)
            return false;
        if (!ReflectionUtil.isClassEquals(getClass(), obj.getClass()))
            return false;

        final List<Field> equalsIncludedFields = getEqualsIncludedFields();
        if (null != equalsIncludedFields)
        {
            return compare(obj, equalsIncludedFields);
        }

        if (null != getEqualsExcludedFields())
        {
            return compare(obj, prepareInclusionFieldsFromExclusions());
        }

        return false;
    }

    private boolean compare(final Object object, final List<Field> fieldList)
    {
        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        boolean hasNonNullValue = false;
        for (Field field : fieldList)
        {
            try
            {
                field.setAccessible(true);
                final Object thisValue = field.get(this);
                final Object objectValue = field.get(object);
                hasNonNullValue = hasNonNullValue || thisValue != null || objectValue != null;
                equalsBuilder.append(thisValue, objectValue);
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException("hashCode() failed trying to get() " + field.getName());
            }
        }
        return hasNonNullValue && equalsBuilder.isEquals();
    }

    private List<Field> prepareInclusionFieldsFromExclusions()
    {
        final ArrayList<Field> inclusions = new ArrayList<Field>();
        final List<String> excludedFields = Arrays.asList(getEqualsExcludedFields());
        for (Class testClass = getClass(); testClass != null; testClass = testClass.getSuperclass())
        {
            final Field[] fields = testClass.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields)
            {
                if (!excludedFields.contains(field.getName())
                        && (field.getName().indexOf('$') == -1)
                        && !Modifier.isTransient(field.getModifiers())
                        && (!Modifier.isStatic(field.getModifiers())))
                {
                    inclusions.add(field);
                }
            }
        }
        return Collections.unmodifiableList(inclusions);
    }

    @Transient
    protected List<Field> getHashCodeIncludedFields()
    {
        return null;
    }

    @Transient
    protected String[] getHashCodeExcludedFields()
    {
        return null;
    }

    @Transient
    protected List<Field> getEqualsIncludedFields()
    {
        return null;
    }

    @Transient
    protected String[] getEqualsExcludedFields()
    {
        return null;
    }
}
