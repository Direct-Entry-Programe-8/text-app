package lk.ijse.dep8.note.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CurdRepository <T, ID extends Serializable> extends SuperRepository{

    T save(T entity);

    void deleteById(ID pk);

    boolean existsById(ID pk);

    Optional<T> findById(ID pk);

    List<T> findAll();

    long count();
}
