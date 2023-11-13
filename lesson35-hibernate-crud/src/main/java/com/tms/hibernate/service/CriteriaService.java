package com.tms.hibernate.service;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.domain.Role;
import com.tms.hibernate.dto.UserSearchDto;
import com.tms.hibernate.entity.TaskEntity;
import com.tms.hibernate.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CriteriaService {
    public void doSearch(UserSearchDto search){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(UserEntity.class, "ue");
        List<UserEntity> result;
        if(search == null){
            result = criteria.list();
        } else{
            List<Criterion> criteriaArrayList = new ArrayList<>();
            if(search.getBirthdayFrom() !=null && search.getBirthdayTo() !=null){
                criteriaArrayList.add(Restrictions.between("birthday", search.getBirthdayFrom(), search.getBirthdayTo()));
            }
            if(Objects.nonNull(search.getRole())){
                criteria.add(Restrictions.eq("role", search.getRole()));
            }
            if(Objects.nonNull(search.getStatus())){
                criteria = criteria.createCriteria("ue.tasks", "ts");
                criteria.add(Restrictions.eq("ts.status", search.getStatus()));
            }
        }
        result = criteria.list();
        for( UserEntity userItem : result){
            System.out.println(userItem);
        }

        transaction.commit();
        session.close();
    }

}
