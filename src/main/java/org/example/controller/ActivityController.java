package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.model.Activity;
import org.example.service.IActivityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@AllArgsConstructor
@RequestMapping("/activity")
public class ActivityController {
    final IActivityService activityService;
    @GetMapping("/getall")
    public Iterable<Activity> getActivity() {
        return activityService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Activity getByIdActivity(@PathVariable("id") Long id) {
        return activityService.findById(id).get();

    }

    @PostMapping(value="/addActivity" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Activity addActivity(@RequestPart("activity")  String activityJson,@RequestPart(value="file",required = false) MultipartFile[] Dfiles) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Activity activity = objectMapper.readValue(activityJson, Activity.class);

        if (Dfiles != null) {
            Set<String> docs = new HashSet<>();
            String uploadDir = "/home/wafaazek/uploads";
            Path uploadPath = Paths.get(uploadDir);
            Files.createDirectories(uploadPath);
            for (MultipartFile dfile : Dfiles) {
                String fileName = System.currentTimeMillis() + "_" + dfile.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(dfile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                docs.add(filePath.toString());
                activity.setDocuments(docs);
            }
        }
        return activityService.save(activity);
    }

    @PutMapping("/updateActivity")
    public Activity updateActivity(@RequestBody Activity u) {
        return activityService.save(u);

    }


    @DeleteMapping("/deleteActivity/{id}")
    public void deleteActivity(@PathVariable("id") Long id) {
        activityService.deleteById(id);
    }

    @GetMapping("/getByContact/{contactId}")
    public List<Activity> getActivitiesForContact(@PathVariable Long contactId) {
        return activityService.findActivitiesByContactId(contactId);
    }

}
