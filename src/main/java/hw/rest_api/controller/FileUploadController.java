package hw.rest_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileUploadController {
    private static final String uploadDir = "uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty file");
        }

        try {
            String projectDir = System.getProperty("user.dir");
            File uploadDirFile = new File(projectDir + File.separator + "uploads");

            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            File dest = new File(uploadDirFile, file.getOriginalFilename());
            file.transferTo(dest);

            return ResponseEntity.ok("File uploaded successfully: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error when uploading: " + e.getMessage());
        }
    }

}
