package com.upgrad.quora.service.business;

import com.upgrad.quora.service.common.LoginStatus;
import com.upgrad.quora.service.common.QuoraErrors;
import com.upgrad.quora.service.dao.QuestionDao;
import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserAuthEntity;
import com.upgrad.quora.service.exception.AuthenticationFailedException;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class QuestionService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public QuestionEntity createQuestion(QuestionEntity questionEntity, String accessToken) throws AuthenticationFailedException,AuthorizationFailedException{
        UserAuthEntity userAuthEntity = userDao.getUserAuthByAccessToken(accessToken);
        if(userAuthEntity == null){
            throw new AuthorizationFailedException(QuoraErrors.INVALID_ACCESS_TOKEN);
        }
        if(ZonedDateTime.now().isAfter(userAuthEntity.getExpiresAt())){
            throw new AuthorizationFailedException(QuoraErrors.EXPIRED_ACCESS_TOKEN);
        }
        if(!LoginStatus.LOGGED_IN.equals(LoginStatus.valueOf(userAuthEntity.getUser().getLoginStatus()))){
            throw new AuthenticationFailedException(QuoraErrors.USER_NOT_SIGNED_IN);
        }
        questionEntity.setUser(userAuthEntity.getUser());
        return questionDao.createQuestion(questionEntity);
    }
}