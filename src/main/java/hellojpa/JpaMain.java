package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 어플리케이션 실행 시점에 하나만 만들어야 함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션 단위마다 만들어야함
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
        /*
        저장
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);
         */

            /*
            조회
            Member findMember = em.find(Member.class,1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
             */

            /*
             * 수정
             * Member findMember = em.find(Member.class,1L);
             * findMember.setName("HelloJPA");
             */

            List<Member> result = em.createQuery("select m from member as m",Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            result.forEach(v -> System.out.println("Member.name = " + v.getName()));




            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
