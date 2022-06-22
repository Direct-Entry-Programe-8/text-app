package lk.ijse.dep8.note.repository;

import lk.ijse.dep8.note.entity.SuperEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class CurdRepositoryImpl<T extends SuperEntity, ID extends Serializable> implements CurdRepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityClassObject;

    public CurdRepositoryImpl() {
        this.entityClassObject = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void deleteById(ID pk) {
        entityManager.refresh(entityManager.getReference(entityClassObject, pk));
    }

    @Override
    public boolean existsById(ID pk) {
        return findById(pk).isPresent();
    }

    @Override
    public Optional<T> findById(ID pk) {
        return Optional.of(entityManager.find(entityClassObject, pk));
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM "+entityClassObject.getName()+" e",entityClassObject).getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM "+ entityClassObject.getName()+" e",Long.class).getSingleResult();
    }
}
