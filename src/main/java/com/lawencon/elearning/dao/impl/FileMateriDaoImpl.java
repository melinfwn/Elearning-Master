package com.lawencon.elearning.dao.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.elearning.dao.FileMateriDao;
import com.lawencon.elearning.model.FileMateri;

@Repository("materi_repo_hibernate")
public class FileMateriDaoImpl extends BaseHibernate implements FileMateriDao {

	@Override
	public FileMateri insertMateri(FileMateri materi) throws Exception {
		em.persist(materi);
		return materi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findMateri(String category, String pengajar, String topik) throws Exception {
		Query q = em.createQuery(
				"select m.judulMateri as judul, m.fileMateri as file, m.typeFile as type from FileMateri m left join m.materi as c left outer join m.header as h "
						+ "left outer join m.pengajar as trainer where c.id = :category  and trainer.id = :pengajar and h.id = :topik");
		q.setParameter("category", category);
		q.setParameter("pengajar", pengajar);
		q.setParameter("topik", topik);
		List<Object[]> result = q.getResultList();
		return bMapperHibernate(result, "judul", "file", "type");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByCategory(String category) throws Exception {
		Query q = em.createQuery(
				"select m.judulMateri as judul, m.fileMateri as file, m.typeFile as type from FileMateri m left join m.materi as c where c.id = :category");
		q.setParameter("category", category);
		List<Object[]> result = q.getResultList();
		return bMapperHibernate(result, "judul", "file", "type");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByCategoryAndTrainer(String category, String trainer) throws Exception {
		Query q = em.createQuery(
				"select m.judulMateri as judul, m.fileMateri as file, m.typeFile as type from FileMateri m left join m.materi as c "
						+ "left outer join m.pengajar as trainer where c.id = :category  and trainer.id = :pengajar ");
		q.setParameter("category", category);
		q.setParameter("pengajar", trainer);
		List<Object[]> result = q.getResultList();
		return bMapperHibernate(result, "judul", "file", "type");
	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Materi> findAllActive(String topik) throws Exception {
//		Query q = em
//				.createNativeQuery(
//						"select judul_materi,id,day, week from tb_materi where  and activeflag = ?")
//				.setParameter(1, week).setParameter(2, day).setParameter(3, ActiveFlag.ACTIVE.name());
//		return bMapperHibernate(q.getResultList(), "judul_materi", "id", "day", "week");
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileMateri> findAll() throws Exception {
		Query q = em.createQuery(" from MateriHeader");
		return q.getResultList();
	}

}
