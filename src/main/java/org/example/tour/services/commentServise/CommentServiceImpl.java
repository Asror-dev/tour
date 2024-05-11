package org.example.tour.services.commentServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.Comment;
import org.example.tour.repository.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    @Override
    public List<Comment> getCommentsByTourId(UUID tourId) {
        return commentRepo.getCommentByTourId(tourId);
    }
}
