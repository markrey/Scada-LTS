/*
 * (c) 2018 grzegorz.bylica@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.scada_lts.purge_data.remove_event.model;

import java.util.Objects;

/**
 * Create by at Grzesiek Bylica
 *
 * @author grzegorz.bylica@gmail.com
 */
public class ConfigRemoveEvent {

    /**
     * Enabled remove events
     */
    private boolean enable;

    /**
     * Months expressed in an int greater than 1 for determining which events are to be deleted
     */
    private byte olderThen;

    /**
     * The time at which the removal of old events will start once a day "0-23"
     */
    private byte timeOfStart;

    public ConfigRemoveEvent(boolean enable, byte olderThen, byte timeOfStart) {
        this.enable = enable;
        this.olderThen = olderThen;
        this.timeOfStart = timeOfStart;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public byte getOlderThen() {
        return olderThen;
    }

    public void setOlderThen(byte olderThen) {
        this.olderThen = olderThen;
    }

    public byte getTimeOfStart() {
        return timeOfStart;
    }

    public void setTimeOfStart(byte timeOfStart) {
        this.timeOfStart = timeOfStart;
    }

    @Override
    public String toString() {
        return "ConfigRemoveEvent{" +
                "enable=" + enable +
                ", olderThen=" + olderThen +
                ", timeOfStart=" + timeOfStart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigRemoveEvent that = (ConfigRemoveEvent) o;
        return enable == that.enable &&
                olderThen == that.olderThen &&
                timeOfStart == that.timeOfStart;
    }

    @Override
    public int hashCode() {

        return Objects.hash(enable, olderThen, timeOfStart);
    }
}
