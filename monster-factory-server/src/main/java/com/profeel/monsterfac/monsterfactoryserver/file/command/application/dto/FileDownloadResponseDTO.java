package com.profeel.monsterfac.monsterfactoryserver.file.command.application.dto;

import java.util.Arrays;

/**
 * <pre>
 * Class : FileDownloadResponseDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public class FileDownloadResponseDTO {

    private byte[] fileData;
    private String originalFileName;

    protected FileDownloadResponseDTO(){}

    public FileDownloadResponseDTO(byte[] fileData, String originalFileName) {
        this.fileData = fileData;
        this.originalFileName = originalFileName;

    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    @Override
    public String toString() {
        return "FileDownloadResponseDTO{" +
                "fileData=" + Arrays.toString(fileData) +
                ", originalFileName='" + originalFileName + '\'' +
                '}';
    }
}
