package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Participant;

@Component("participantService")
public class ParticipantService {

	DatabaseConnector connector;

	public ParticipantService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Participant> getAll() {
		String hql = "FROM Participant";
		Query query = connector.getSession().createQuery(hql);
		return query.list();
	}

	public Participant findByLogin(String login2) {
//		String hql = "FROM Participant WHERE Participant.login=:login";
//		Query query = connector.getSession().createQuery(hql);
//		query.setParameter("login", login2);
//		return (Participant) query.getSingleResult();

		return (Participant) connector.getSession().get(Participant.class, login2);
	}

	public Participant add(Participant participant) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(participant);
		transaction.commit();
		return participant;
	}

	public Participant remove(Participant participant) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().delete(participant);
		transaction.commit();
		return participant;
	}

	public Participant update(Participant participant) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(participant);
		transaction.commit();
		return participant;
	}
}
