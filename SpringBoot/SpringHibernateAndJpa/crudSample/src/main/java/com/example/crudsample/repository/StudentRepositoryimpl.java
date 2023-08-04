package com.example.crudsample.repository;

import com.example.crudsample.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> studentQuery = this.entityManager.createQuery("FROM Student ", Student.class);
        return studentQuery.getResultList();
    }

    @Override
    public List<Student> findAllOrderByLastName() {
        TypedQuery<Student> studentQuery = this.entityManager
                .createQuery("FROM Student ORDER BY lastName", Student.class);
        return studentQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> studentQuery = this.entityManager
                .createQuery("FROM Student WHERE lastName=:lastName", Student.class);

        studentQuery.setParameter("lastName", lastName);

        return studentQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Student student = this.entityManager.find(Student.class, id);
        this.entityManager.remove(student);
    }

    @Override
    @Transactional
    public long deleteAll() {
        return this.entityManager.createQuery("DELETE FROM Student ").executeUpdate();
    }
}
