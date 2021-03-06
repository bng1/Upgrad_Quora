package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public QuestionEntity createQuestion(QuestionEntity questionEntity){
        entityManager.persist(questionEntity);
        return questionEntity;
    }

    public List<QuestionEntity> getAllQuestions(){
        try{
            return entityManager.createNamedQuery("allQuestions",QuestionEntity.class).getResultList();
        }
        catch (NoResultException nre){
            return null;
        }
    }

    public List<QuestionEntity> getAllQuestionsByUser(String userUuid){
        try{
            return entityManager.createNamedQuery("allQuestionsByUserId",QuestionEntity.class).setParameter("uuid",userUuid).getResultList();
        }
        catch (NoResultException nre){
            return null;
        }
    }

    public QuestionEntity getQuestionByQuestionUuid(String questionUuid){
        try{
            return entityManager.createNamedQuery("questionById",QuestionEntity.class).setParameter("uuid",questionUuid).getSingleResult();
        }
        catch (NoResultException nre){
            return null;
        }
    }

    public QuestionEntity updateQuestion(QuestionEntity questionEntity){
        entityManager.merge(questionEntity);
        return questionEntity;
    }

    public void deleteQuestion(QuestionEntity questionEntity){
        entityManager.remove(questionEntity);
    }
}
