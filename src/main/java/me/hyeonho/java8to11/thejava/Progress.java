package me.hyeonho.java8to11.thejava;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter @Setter
public class Progress {

    private Duration studyDuration;

    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
