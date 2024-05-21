package com.ssafy.travelcompass.review.model.service.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.review.model.dto.comment.ReviewCommentDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewCommentMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewCommentServiceImpl implements ReviewCommentService {
	private final ReviewCommentMapper reviewCommentMapper;
	

	@Override
	public List<ReviewCommentDto> getCommentsByTripReviewId(int tripReviewId, int offset, int size) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("tripReviewId", tripReviewId);
		map.put("offset", offset);
		map.put("size", size);

		List<ReviewCommentDto> comments = reviewCommentMapper.getCommentsByTripReviewId(map);

		for(ReviewCommentDto comment : comments) {
			List<ReviewCommentDto> replies =  reviewCommentMapper.getRepliesByParentReviewCommentId(comment.getReviewCommentId());
			comment.setReplies(replies);
			comment.setReplyCnt(replies.size());
		}
		
		
		return comments;
	}

	@Override
	public ReviewCommentDto writeComment(ReviewCommentDto comment) throws Exception {
		reviewCommentMapper.writeComment(comment);
		
		ReviewCommentDto result = reviewCommentMapper.findById(comment.getReviewCommentId());
		
		return result;
	}

	@Override
	public ReviewCommentDto writeCommentReply(ReviewCommentDto reply) throws Exception {
		reviewCommentMapper.writeCommentReply(reply);
		
		ReviewCommentDto result = reviewCommentMapper.findById(reply.getReviewCommentId());

		return result;
	}

}
