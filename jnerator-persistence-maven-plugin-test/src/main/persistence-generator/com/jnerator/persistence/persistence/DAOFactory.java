package com.jnerator.persistence.persistence;

import com.jnerator.persistence.persistence.hibernate.HibernateDAOFactory;

/**
 * Generated at Mon May 02 23:14:50 ART 2011
 *
 * @see http://www.hibernate.org/328.html
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 */

public abstract class DAOFactory {

	private static final DAOFactory HIBERNATE = new HibernateDAOFactory();

	public static final DAOFactory DEFAULT = HIBERNATE;
	
    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }
	
	public abstract EventsDefinitionDAO buildEventsDefinitionDAO();
	
	public abstract TenantsDAO buildTenantsDAO();
	
	public abstract EventParticipantsSurveyTemplateDAO buildEventParticipantsSurveyTemplateDAO();
	
	public abstract CompetenciesDAO buildCompetenciesDAO();
	
	public abstract JobCategoriesDAO buildJobCategoriesDAO();
	
	public abstract EventParticipantsRespondentsDAO buildEventParticipantsRespondentsDAO();
	
	public abstract EventDashboardDAO buildEventDashboardDAO();
	
	public abstract EventParticipantsDetailDAO buildEventParticipantsDetailDAO();
	
	public abstract EventParticipantsSurveyTemplateAnswersDAO buildEventParticipantsSurveyTemplateAnswersDAO();
	
	public abstract RelationsDAO buildRelationsDAO();
	
	public abstract BehaviorsDAO buildBehaviorsDAO();
	
	public abstract EventParticipantsDAO buildEventParticipantsDAO();
	
	public abstract UsersProfileDAO buildUsersProfileDAO();
	
	public abstract DimensionsDAO buildDimensionsDAO();
	
}
