package com.begginers.sim.survey.exception;

public class SurveyResultNotFoundException extends Exception {

    public SurveyResultNotFoundException() {
        super();
    }

    public SurveyResultNotFoundException(String message) {
        super(message);
    }

    public SurveyResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SurveyResultNotFoundException(Throwable cause) {
        super(cause);
    }
}
