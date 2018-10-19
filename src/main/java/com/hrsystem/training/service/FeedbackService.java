package com.hrsystem.training.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.Feedback;
import com.hrsystem.training.repository.FeedbackRepository;



@Service
@Transactional
public class FeedbackService implements IFeedbackService{
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback save(Feedback entity) {
		return feedbackRepository.save(entity);
	}
	@Override
	public Optional<Feedback> findById(Long id) {
		return feedbackRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		
		return feedbackRepository.existsById(id);
	}


	@Override
	public long count() {
		return feedbackRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		feedbackRepository.deleteById(id);
	}

	@Override
	public Page<Feedback> findAll(Specification<Feedback> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		System.out.println("feedback");
		return feedbackRepository.findAll(spec, pageable);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAllById(idLists);
		if(feedbacks!=null) {
			feedbackRepository.deleteAll(feedbacks);
		}
	}
	@Override
	public Feedback findFeedbackById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Feedback> feedback = feedbackRepository.findById(id);
		    if (!feedback.isPresent()) {
		        return null;
		    }
		    return feedback.get();
	}

	@Override
	public void insertFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		feedbackRepository.save(feedback);     
	}

	@Override
	public void deleteFeedback(Long id) {
		// TODO Auto-generated method stub
		feedbackRepository.deleteById(id);
	}
	@Override
	public Page<Feedback> findFeedbackByEnroll(Specification<Feedback> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return feedbackRepository.findFeedbackByEnroll(spec, pageable);
	}

}
