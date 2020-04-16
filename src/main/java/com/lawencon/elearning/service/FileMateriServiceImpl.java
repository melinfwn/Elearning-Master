package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.lawencon.elearning.dao.FileMateriDao;
import com.lawencon.elearning.dao.MateriDao;
import com.lawencon.elearning.dao.MateriHeaderDao;
import com.lawencon.elearning.model.FileMateri;
import com.lawencon.elearning.model.Materi;
import com.lawencon.elearning.model.MateriHeader;
import com.lawencon.elearning.model.Pengajar;

@Service
@Transactional
public class FileMateriServiceImpl implements FileMateriService {

	@Autowired
	@Qualifier("materi_repo_hibernate")
	private FileMateriDao fileMateriService;

	@Autowired
	private MateriHeaderDao headerService;

	@Override
	public FileMateri insertMateri(MultipartFile file, String topic, String pId, String cId) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileMateri materi = new FileMateri();
		materi.setJudulMateri(fileName);
		materi.setTypeFile(file.getContentType());
		materi.setFileMateri(file.getBytes());
		materi.setActiveFlag('Y');
		MateriHeader mHeader = null;
		MateriHeader mHeader2 = new MateriHeader();
		Materi cat = new Materi();
		Pengajar pengajar = new Pengajar();
		try {
			mHeader = headerService.findByTopicCategoryTrainer(topic, cId, pId);
//			System.out.println(mHeader.getHeaderId());
		} catch (Exception e) {
		}
		if (mHeader == null) {
			cat.setId(cId);
			pengajar.setPengajarId(pId);
			
			mHeader2.setMateri(cat);
			
			mHeader2.setPengajar(pengajar);
			mHeader2.setTopic(topic);
			materi.setHeader(headerService.insertHeader(mHeader2));
			return fileMateriService.insertMateri(materi);
		} else {
			materi.setHeader(mHeader);
			return fileMateriService.insertMateri(materi);
		}
	}

	@Override
	public List<Map<String, Object>> findMateri(String category, String pengajar, String topik) throws Exception {
		return fileMateriService.findMateri(category, pengajar, topik);
	}

	@Override
	public List<Map<String, Object>> findByCategory(String category) throws Exception {
		return fileMateriService.findByCategory(category);
	}

	@Override
	public List<Map<String, Object>> findByCategoryAndTrainer(String category, String trainer) throws Exception {
		return fileMateriService.findByCategoryAndTrainer(category, trainer);
	}

}
