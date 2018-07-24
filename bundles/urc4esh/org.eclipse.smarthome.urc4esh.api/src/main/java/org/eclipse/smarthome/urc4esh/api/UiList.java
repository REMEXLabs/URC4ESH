package org.eclipse.smarthome.urc4esh.api;

import java.util.LinkedList;

import org.openape.api.UiDescriptor;

public class UiList {
    private LinkedList<UiDescriptor> uis;

    public LinkedList<UiDescriptor> getUis() {
        return uis;
    }

    public void setUis(LinkedList<UiDescriptor> uis) {
        this.uis = uis;
    }

    public UiList() {
        uis = new LinkedList<>();
    }

    public static void addUi(UiDescriptor ui) {
        // TODO Auto-generated method stub

    }

}
