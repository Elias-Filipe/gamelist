package com.eliasfilipe.gamelist.dto;

public class ReplacementListDTO {

    private Integer sourceIndex;
    private Integer DestinationIndex;

    public ReplacementListDTO() {}

    public ReplacementListDTO(Integer sourceIndex, Integer destinationIndex) {
        this.sourceIndex = sourceIndex;
        DestinationIndex = destinationIndex;
    }

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestinationIndex() {
        return DestinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        DestinationIndex = destinationIndex;
    }
}
