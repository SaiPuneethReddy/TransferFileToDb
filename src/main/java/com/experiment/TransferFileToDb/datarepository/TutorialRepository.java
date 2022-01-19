package com.experiment.TransferFileToDb.datarepository;

import com.experiment.TransferFileToDb.datamodel.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}