package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            /*List<Member> result = em.createQuery("select m from member as m",Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            result.forEach(v -> System.out.println("Member.name = " + v.getName()));*/

//
//            Member a = em.find(Member.class, 1L);
//            Member b = em.find(Member.class, 1l);
//
//            // true
//            System.out.println("result = " + (a == b));

            // 이렇게 쌓아놓고 한번에 보낼 수 있음
/*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("============");
*/

           /* Member member = em.find(Member.class, 1L);
            member.setName("zzzz");

            //em.persist(member);
            // persist를 하지 않아도 변경 update 쿼리가 나감*/










            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
