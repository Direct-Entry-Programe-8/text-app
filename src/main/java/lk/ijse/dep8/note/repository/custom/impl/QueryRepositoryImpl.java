package lk.ijse.dep8.note.repository.custom.impl;

import lk.ijse.dep8.note.entity.User;
import lk.ijse.dep8.note.repository.CurdRepositoryImpl;
import lk.ijse.dep8.note.repository.custom.QueryRepository;
import lk.ijse.dep8.note.repository.custom.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryRepositoryImpl implements QueryRepository {
    @PersistenceContext
    private EntityManager entityManager;


}
