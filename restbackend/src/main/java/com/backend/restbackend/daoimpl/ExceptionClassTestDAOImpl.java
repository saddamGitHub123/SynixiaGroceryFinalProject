/**
 * 
 */
package com.backend.restbackend.daoimpl;


import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.restbackend.dao.ExceptionClassDAO;
import com.backend.restbackend.exception.dto.ExceptionClassTest;
import com.backend.restbackend.exception.dto.UnknownColumnException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


/**
 * @author Sk Saddam Hosan
 */
@Repository("exceptionClassDAO")
@Transactional
public class ExceptionClassTestDAOImpl implements ExceptionClassDAO {
private static final Logger log = LoggerFactory.getLogger(ExceptionClassTestDAOImpl.class);

	
	
	@Autowired
	private SessionFactory sessionFactory;



	/* (non-Javadoc)
	 * @see com.backend.restbackend.dao.ExceptionClassDAO#save(com.backend.restbackend.exception.dto.ExceptionClassTest)
	 */
	@Override
	public boolean save(ExceptionClassTest exceptionClassTest) throws UnknownColumnException{

		log.debug("Inserting information into exception database using save() method");

		try {
			
			sessionFactory.getCurrentSession().persist(exceptionClassTest);
			
			
			/* int age = exceptionClassTest.getAge();
	            String selectProductsByShopId = "FROM ExceptionClassTest WHERE age = :age ";
	            List<ExceptionClassTest> list= sessionFactory
						.getCurrentSession()
						.createQuery(selectProductsByShopId, ExceptionClassTest.class)
							.setParameter("age", age)
							//.setParameter("active", true)
								.getResultList();

			if ((list != null) && (list.size() > 0)) {
				//userFound= true;
				log.debug("get successful,Product list is found");
				//return list;
				return true;
			}
			
				log.debug("get successful,Product List is not found ");
				log.debug("Rutrring from exception save() method");
				return false; */
			 
			
			//sessionFactory.getCurrentSession().persist(exceptionClassTest);

			return true;
		}catch(ConstraintViolationException sq) {
		   // SQLException cause = (SQLException) e.getCause();
		    //evaluate cause and find out what was the problem
		   // System.out.println(cause.getMessage());
			System.out.println("This is hibernate exception");
		    throw new UnknownColumnException(sq.getMessage(),sq);
		}catch (NullPointerException re) {
			log.error("Exception Type : ", re);
			//SQLException cause = (SQLException) re.getCause();
			//System.out.println(cause.getMessage());
			//Exception ex = (Exception)re.getCause();
			//System.out.println(ex.getMessage());
			//System.out.println(re.getMessage());
			//String erroreMsg = re.getMessage();
			throw new UnknownColumnException(re.getMessage(),re);
		}catch (RuntimeException re) {
			log.error("Exception Type : ", re);
			//SQLException cause = (SQLException) re.getCause();
			//System.out.println(cause.getMessage());
			//Exception ex = (Exception)re.getCause();
			//System.out.println(ex.getMessage());
			//System.out.println(re.getMessage());
			//String erroreMsg = re.getMessage();
			throw new UnknownColumnException(re.getMessage(),re);
		}
		/*catch(JDBCException e) {
		    SQLException cause = (SQLException) e.getCause();
		    //evaluate cause and find out what was the problem
		    System.out.println(cause.getMessage());
		    throw new UnknownColumnException("SQL Exception", e);
		}
		/*catch (RuntimeException ex) {
	        throw new UnknownColumnException("Failed to save information ! SQL Exception", ex);
	    } /*catch (Exception re) {
			log.error("get failed", re);
			throw re;
		}*/ finally {
			/*
			 * if (sessionFactory != null) { sessionFactory.close(); }
			 */
		}
	}

}
