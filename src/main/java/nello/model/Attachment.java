package nello.model;

import java.sql.Blob;
import java.sql.Date;

public class Attachment {

    public enum FileType {
        PNG(1), DOCX(2), XLSX(3);
        private int fileType;

        FileType(int fileType) {
            this.fileType = fileType;
        }

        public static FileType getById(int fileTypeId) {
            for (FileType fileType : values()) {
                if (fileType.getValue() == fileTypeId) {
                    return fileType;
                }
            }
            // If no phase is defined the standard is "null"
            return null;
        }

        public int getValue(){
            return fileType;
        }
    }

    public long experimentId;
    public long fileId;
    public String name;
    public long uploaderId;
    public Blob fileData;
    public FileType fileType;
    public boolean isMainPhoto;
    public Date uploadDate;

    public Attachment(long experimentId, long fileId, String name, long uploaderId, Blob fileData, FileType fileType,
                      boolean isMainPhoto, Date uploadDate) {
        this.experimentId = experimentId;
        this.fileId = fileId;
        this.name = name;
        this.uploaderId = uploaderId;
        this.fileData = fileData;
        this.fileType = fileType;
        this.isMainPhoto = isMainPhoto;
        this.uploadDate = uploadDate;
    }

}
