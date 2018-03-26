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
package org.scada_lts.purge_data.remove_event;

import org.scada_lts.config.ScadaConfig;
import org.scada_lts.purge_data.remove_event.model.ConfigRemoveEvent;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Create by at Grzesiek Bylica
 *
 * @author grzegorz.bylica@gmail.com
 */
@Service
public class ServiceConfigRemoveEvent {


    private ConfigRemoveEvent cfgRemEvents;
    private boolean validate;

    public void init() {
         cfgRemEvents = readSetings();
         validate = validate(cfgRemEvents);
    }

    public ConfigRemoveEvent getCfgRemEvents() {
        return cfgRemEvents;
    }

    public boolean isValidate() {
        return validate;
    }


    private ConfigRemoveEvent readSetings() {
        try {
            boolean enabled = ScadaConfig.getInstance().getBoolean(ScadaConfig.ENABLE_REMOVE_EVENTS, false);
            byte timeOfStart = ScadaConfig.getInstance().getByte(ScadaConfig.TIME_OF_EVENT_REMOVAL_START, (byte) 1);
            byte removeOlderThen = ScadaConfig.getInstance().getByte(ScadaConfig.REMOVE_EVENTS_OLDER_THEN_IN_MONTHS, (byte) 3);

            return new ConfigRemoveEvent(enabled, removeOlderThen, timeOfStart);
        } catch (IOException e) {
            throw new RuntimeException("Problem  with read config:"+e.getMessage());
        }
    }


    private boolean validate(ConfigRemoveEvent cfg) {

        // check if the value is between 0-23
        boolean checkTimeOfStart = (cfg.getTimeOfStart() > 0) && (cfg.getTimeOfStart()<23);

        // check if the value is greater than 1
        boolean checkRemoveOlderThen = (cfg.getOlderThen() > 1);

        return checkTimeOfStart && checkRemoveOlderThen && cfg.isEnable();
    }



}
