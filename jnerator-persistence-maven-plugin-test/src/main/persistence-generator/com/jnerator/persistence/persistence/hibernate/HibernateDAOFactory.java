package com.jnerator.persistence.persistence.hibernate;

import com.jnerator.persistence.persistence.DAOFactory;
import com.jnerator.persistence.persistence.EventsDefinitionDAO;
import com.jnerator.persistence.persistence.TenantsDAO;
import com.jnerator.persistence.persistence.EventParticipantsSurveyTemplateDAO;
import com.jnerator.persistence.persistence.CompetenciesDAO;
import com.jnerator.persistence.persistence.JobCategoriesDAO;
import com.jnerator.persistence.persistence.EventParticipantsRespondentsDAO;
import com.jnerator.persistence.persistence.EventDashboardDAO;
import com.jnerator.persistence.persistence.EventParticipantsDetailDAO;
import com.jnerator.persistence.persistence.EventParticipantsSurveyTemplateAnswersDAO;
import com.jnerator.persistence.persistence.RelationsDAO;
import com.jnerator.persistence.persistence.BehaviorsDAO;
import com.jnerator.persistence.persistence.EventParticipantsDAO;
import com.jnerator.persistence.persistence.UsersProfileDAO;
import com.jnerator.persistence.persistence.DimensionsDAO;

/**
 * Generated at Mon May 02 23:14:50 ART 2011
 *
 * @see http://www.hibernate.org/43.html
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 */
public class HibernateDAOFactory extends DAOFactory {

	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventsDefinitionDAO()
	 */
	@Override
	public EventsDefinitionDAO buildEventsDefinitionDAO() {
		return new EventsDefinitionHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildTenantsDAO()
	 */
	@Override
	public TenantsDAO buildTenantsDAO() {
		return new TenantsHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventParticipantsSurveyTemplateDAO()
	 */
	@Override
	public EventParticipantsSurveyTemplateDAO buildEventParticipantsSurveyTemplateDAO() {
		return new EventParticipantsSurveyTemplateHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildCompetenciesDAO()
	 */
	@Override
	public CompetenciesDAO buildCompetenciesDAO() {
		return new CompetenciesHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildJobCategoriesDAO()
	 */
	@Override
	public JobCategoriesDAO buildJobCategoriesDAO() {
		return new JobCategoriesHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventParticipantsRespondentsDAO()
	 */
	@Override
	public EventParticipantsRespondentsDAO buildEventParticipantsRespondentsDAO() {
		return new EventParticipantsRespondentsHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventDashboardDAO()
	 */
	@Override
	public EventDashboardDAO buildEventDashboardDAO() {
		return new EventDashboardHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventParticipantsDetailDAO()
	 */
	@Override
	public EventParticipantsDetailDAO buildEventParticipantsDetailDAO() {
		return new EventParticipantsDetailHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventParticipantsSurveyTemplateAnswersDAO()
	 */
	@Override
	public EventParticipantsSurveyTemplateAnswersDAO buildEventParticipantsSurveyTemplateAnswersDAO() {
		return new EventParticipantsSurveyTemplateAnswersHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildRelationsDAO()
	 */
	@Override
	public RelationsDAO buildRelationsDAO() {
		return new RelationsHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildBehaviorsDAO()
	 */
	@Override
	public BehaviorsDAO buildBehaviorsDAO() {
		return new BehaviorsHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildEventParticipantsDAO()
	 */
	@Override
	public EventParticipantsDAO buildEventParticipantsDAO() {
		return new EventParticipantsHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildUsersProfileDAO()
	 */
	@Override
	public UsersProfileDAO buildUsersProfileDAO() {
		return new UsersProfileHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildDimensionsDAO()
	 */
	@Override
	public DimensionsDAO buildDimensionsDAO() {
		return new DimensionsHibernateDAO();
	}
	
}
