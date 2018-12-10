package pl.konrad.feak_news.model.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class ImageService {
    public void addImage(MultipartFile image, int id) throws IOException {

            Files.write(Paths.get("photos/" + id), image.getBytes(), StandardOpenOption.CREATE_NEW);

    }

    public void removeImage(int id ) throws IOException {
        Files.delete(Paths.get("photos/" + id));
    }
}
