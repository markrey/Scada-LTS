/*
    Mango - Open Source M2M - http://mango.serotoninsoftware.com
    Copyright (C) 2006-2011 Serotonin Software Technologies Inc.
    @author Matthew Lohbihler
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.serotonin.mango.view.event;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.serotonin.util.SerializationHelper;

public class RangeEventValue implements Serializable {
    private double from;
    private double to;
    private String shortText;
    private String longText;
    private String colour;

    /**
     * Required by DWR. Should not be used otherwise.
     */
    public RangeEventValue() {
        // no op
    }

    /**
     * Required by DWR. Should not be used otherwise.
     */
    public void setFrom(double from) {
        this.from = from;
    }

    /**
     * Required by DWR. Should not be used otherwise.
     */
    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    /**
     * Required by DWR. Should not be used otherwise.
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Required by DWR. Should not be used otherwise.
     */
    public void setTo(double to) {
        this.to = to;
    }

    public RangeEventValue(double from, double to, String shortText, String longText, String colour) {
        this.from = from;
        this.to = to;
        this.shortText = shortText;
        this.longText = longText;
        this.colour = colour;
    }

    boolean contains(double d) {
        return d >= from && d <= to;
    }

    public double getFrom() {
        return from;
    }

    public String getShortText() {
        return shortText;
    }

    public String getLongText() {
        return longText;
    }

    public double getTo() {
        return to;
    }

    public String getColour() {
        return colour;
    }

    //
    // /
    // / Serialization
    // /
    //
    private static final long serialVersionUID = -1;
    private static final int version = 1;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(version);
        out.writeDouble(from);
        out.writeDouble(to);
        SerializationHelper.writeSafeUTF(out, shortText);
        SerializationHelper.writeSafeUTF(out, longText);
        SerializationHelper.writeSafeUTF(out, colour);
    }

    private void readObject(ObjectInputStream in) throws IOException {
        int ver = in.readInt();

        // Switch on the version of the class so that version changes can be elegantly handled.
        if (ver == 1) {
            from = in.readDouble();
            to = in.readDouble();
            shortText = SerializationHelper.readSafeUTF(in);
            longText = SerializationHelper.readSafeUTF(in);
            colour = SerializationHelper.readSafeUTF(in);
        }
    }
}
