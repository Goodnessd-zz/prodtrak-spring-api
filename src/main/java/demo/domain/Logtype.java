package demo.domain;

public enum LogType {

    STUDY_GROUP("Study Group"),
    OFFICE_HOURS("Office Hours"),
    PERSONAL_STUDY("Personal Study");

    final String logType;

    LogType(String logType){this.logType = logType;}


    @Override
    public String toString() {
        return logType;
    }
}
