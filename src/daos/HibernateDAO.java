/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import utils.HibernateUtil;

/**
 *
 * @author Slaush
 */
public abstract class HibernateDAO<T>  
{
     
    private final Class<T> type;
    public HibernateDAO()
    {   
        this.type = (Class<T>) ((ParameterizedType) getClass()
                            .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public boolean insert(T record) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(record);
        session.getTransaction().commit();
        return true;
    }
    
    public boolean update(T record)
    {   
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(record);
        session.getTransaction().commit();
        return true;
    }
    
    public boolean delete(T record) 
    {   
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(record);
        session.getTransaction().commit();
        return true;
    }

    
    public List<T> getAll()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(type);
        System.out.println("CRITERIA LIST>"+criteria.list().size());
        return criteria.list();
    }
    
    public List<T> queryByProperty(String propertyName, Object property)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(type);
        criteria.add(Restrictions.like(propertyName, propertyName, MatchMode.EXACT));
       
        return criteria.list();
    }
    
    public List<T> queryByAllProperties(HashMap<String, Object> hash)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(type);
        
        if(hash != null)
        {
            for (Map.Entry<String, Object>  e : hash.entrySet()) 
            {
                String key = e.getKey();
                Object value = e.getValue();                
                criteria.add(Restrictions.like(key, value.toString(), MatchMode.EXACT));
            }
        }
        return criteria.list();
    
    }

    
}
