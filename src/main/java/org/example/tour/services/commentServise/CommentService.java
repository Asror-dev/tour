package org.example.tour.services.commentServise;

import org.example.tour.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> getCommentsByTourId(UUID tourId);
}
