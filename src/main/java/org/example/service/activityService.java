package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Activity;
import org.example.repository.activityRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class activityService implements IActivityService{
    final activityRepository activityRepository;

    @Override
    public List<Activity> findActivitiesByContactId(Long contactId) {
        return activityRepository.findActivitiesByContactId(contactId);

    }

    @Override
    public <S extends Activity> S save(S activity) {
        return activityRepository.save(activity);
    }

    @Override
    public <S extends Activity> Iterable<S> saveAll(Iterable<S> activities) {
        return activityRepository.saveAll(activities);
    }

    @Override
    public Optional<Activity> findById(Long idActivity) {
        return activityRepository.findById(idActivity);
    }

    @Override
    public boolean existsById(Long idActivity) {
        return activityRepository.existsById(idActivity);
    }

    @Override
    public Iterable<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Iterable<Activity> findAllById(Iterable<Long> longs) {
        return activityRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return activityRepository.count();
    }


    @Override
    public void deleteById(Long idActivity) {
        activityRepository.deleteById(idActivity);
    }

    @Override
    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        activityRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Activity> activities) {
        activityRepository.deleteAll(activities);
    }

    @Override
    public void deleteAll() {
        activityRepository.deleteAll();
    }


}
