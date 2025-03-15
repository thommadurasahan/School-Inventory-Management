package com.beginners.sim.survey.exception;

public class SurveyNotFoundException extends Exception {

    public SurveyNotFoundException() {
        super();
    }

    public SurveyNotFoundException(String message) {
        super(message);
    }

    public SurveyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SurveyNotFoundException(Throwable cause) {
        super(cause);
    }
}
