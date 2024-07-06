package org.example.tour.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    @GetMapping("/get")
    public void getFile(HttpServletResponse response, @RequestParam String path) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        InputStream inputStream = new FileInputStream(
                path
        );
        FileCopyUtils.copy(inputStream,outputStream);
    }
}
