package org.example;

public interface OfficeInterface {
    public int getOfficeSpace();
    public void setOfficeSpace(int officeSpace);
    public void allocateOfficeSpace(int squareMeters);
    public void equipMeetingRoom(boolean projector, boolean whiteboard);
    public void addDesks(int desksToAdd);
    public void removeDesks(int desksToRemove);
    public void addProjector(boolean hasProjector);
    public void addWhiteboard(boolean hasWhiteboard);
    public String writeAddressToFile();
}