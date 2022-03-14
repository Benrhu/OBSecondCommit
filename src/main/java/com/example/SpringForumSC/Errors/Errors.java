package com.example.SpringForumSC.Errors;

public class Errors {

    private int errorLine;
    private ErrorType errorType;

    public Errors(ErrorType errorType) {
        this.errorLine = errorLine;
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return this.errorType.getDescription() + errorLine;
    }

    public int getErrorLine() {
        return errorLine;
    }

    public void setErrorLine(int errorLine) {
        this.errorLine = errorLine;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}


