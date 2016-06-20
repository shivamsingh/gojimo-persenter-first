package com.gojimo.qualifications;

import com.gojimo.entity.Qualification;
import java.util.List;
import rx.Observable;

public interface QualificationModel {
    Observable<List<Qualification>> qualifications();

    Observable<Qualification> qualification(String qualificationId);
}
