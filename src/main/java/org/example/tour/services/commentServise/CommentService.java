package org.example.tour.services.commentServise;

import org.example.tour.dto.CommentDto;
import org.example.tour.entity.Comment;
import org.example.tour.projection.CommentProjection;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    void deletComment(UUID commentId);

    void addComment(CommentDto dto);

    void changeCommentVisible(UUID commentId);
    List<Comment> getCommentVisble(Boolean visible);

    List<Comment> getAllComments();
}
