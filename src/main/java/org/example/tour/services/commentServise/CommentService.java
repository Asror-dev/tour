package org.example.tour.services.commentServise;

import org.example.tour.dto.CommentDto;
import org.example.tour.entity.Comment;
import org.example.tour.projection.CommentProjection;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<CommentProjection> getCommentsByTourId(UUID tourId);
    void deletComment(UUID commentId);

    void addComment(CommentDto dto,UUID tourId);

    void changeCommentVisible(UUID commentId);

    List<Comment> getAllComments();
}
