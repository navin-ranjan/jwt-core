package com.inn.navin.jwt.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inn.navin.jwt.user.dao.UserDao;
import com.inn.navin.jwt.user.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	Logger logger = org.apache.logging.log4j.LogManager.getLogger(UserDaoImpl.class);

	/**
	 * To call the session factory method
	 */
	@Autowired
	private EntityManager entityManager;

	//add user
	@Transactional
	public String addUser(User user) {
		if (user != null)
			entityManager.persist(user);
		else
			return "data not found !";
		return "Data Add Sucessfully";
	}

	//get all users
	@Override
	public List<User> findAllUser() {
	  logger.info("Insider the get all user on repo");
	  CriteriaBuilder cb=entityManager.getCriteriaBuilder();
    CriteriaQuery<User> creQuery=cb.createQuery(User.class);
    Root<User> root=creQuery.from(User.class);
    creQuery.select(root);
    TypedQuery<User> query= entityManager.createQuery(creQuery);
    return query.getResultList();
	}
	
	    //Update user
	    @Transactional
		@Override
		public User updateUser(User user) {
			return entityManager.merge(user);
		}

	    //Get user by id
		@Override
		public User getUserById(int id) {
		  return entityManager.find(User.class, id); 
		}
		
		//get user details
		@Override
		public User getUserDetails(String name, String email, String number) {
			logger.info("Inside @getUserDetails with name:{},email:{} and number:{}", name, email, number);
			try {
				CriteriaBuilder cb = entityManager.getCriteriaBuilder();
				CriteriaQuery<User> createQuery = cb.createQuery(User.class);
				Root<User> root = createQuery.from(User.class);
				List<Predicate> predicateList = new ArrayList<>();
				if (name != null) {
					predicateList.add(cb.equal(root.get("name"), name));
				}

				if (email != null) {
					predicateList.add(cb.equal(root.get("email"), email));
				}
				if (number != null) {
					predicateList.add(cb.equal(root.get("number"), number));
				}

				createQuery.where(predicateList.toArray(new Predicate[0]));
				TypedQuery<User> query = entityManager.createQuery(createQuery);
				return query.getSingleResult();
			} catch (Exception ex) { 
				return null;
			}
		}

		@Transactional
		@Override
		public void deleteUser(int id) {
			User user = entityManager.find(User.class, id);
			entityManager.remove(user);		
			}
}
