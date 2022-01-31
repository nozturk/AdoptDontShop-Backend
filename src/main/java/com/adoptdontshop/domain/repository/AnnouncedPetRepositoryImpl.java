package com.adoptdontshop.domain.repository;

import com.adoptdontshop.domain.model.AnnouncedPet;
import com.adoptdontshop.enumaration.PetType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AnnouncedPetRepositoryImpl  implements AnnouncedPetRepositoryCustom{
    private static final int PAGE_SIZE = 7;
    private final EntityManager entityManager;

    public AnnouncedPetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AnnouncedPet> findByType(PetType petType, int page) {
        int first = (page - 1) * PAGE_SIZE  ;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AnnouncedPet> cq = cb.createQuery(AnnouncedPet.class);

        Root<AnnouncedPet> announcedPet = cq.from(AnnouncedPet.class);
        List<Predicate> predicates = new ArrayList<>();

        if (petType != null) {
            predicates.add(cb.equal(announcedPet.get("petType"), petType));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq)
                .setFirstResult(first)
                .setMaxResults(PAGE_SIZE)
                .getResultList();
    }
}
