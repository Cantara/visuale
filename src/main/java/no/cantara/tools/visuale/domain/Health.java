package no.cantara.tools.visuale.domain;

public class Health {
    /**
     * "Status": "true",
     * "Version": "0.62.38-SNAPSHOT [Quadim CV Backend API - 172.31.33.86  fe80:0:0:0:473:a6ff:feb8:2e76%eth0  172.31.33.86  0:0:0:0:0:0:0:1%lo  127.0.0.1]",
     * "IndexSizes": "OverlordIndex:5 - OverlordProfileIndex:9 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4",
     * "Database Backend": "jdbc:h2:mem:overlordbase",
     * "DatabaseSizes": "Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 3 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 1",
     * "now": "2020-03-24T18:34:35.987Z",
     * "running since": "2020-03-23T09:11:49.070Z"
     */

    private String status = "";
    private String version = "";
    private String now = "";
    private String running_since = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getRunning_since() {
        return running_since;
    }

    public void setRunning_since(String running_since) {
        this.running_since = running_since;
    }

    @Override
    public String toString() {
        return "Health{" +
                "status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", now='" + now + '\'' +
                ", running_since='" + running_since + '\'' +
                '}';
    }
}
