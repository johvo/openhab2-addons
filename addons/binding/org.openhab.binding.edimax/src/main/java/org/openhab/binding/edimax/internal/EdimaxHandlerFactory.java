/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.edimax.internal;

import static org.openhab.binding.edimax.EdimaxBindingConstants.*;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.edimax.handler.EdimaxHandler;
import org.openhab.binding.edimax.handler.EdimaxMeterHandler;

/**
 * The {@link EdimaxHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Falk Harnisch - Initial contribution
 */
public class EdimaxHandlerFactory extends BaseThingHandlerFactory {

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(SP1101W)) {
            return new EdimaxHandler(thing);
        }
        if (thingTypeUID.equals(SP2101W)) {
            return new EdimaxMeterHandler(thing);
        }

        return null;
    }
}