/**
 * Custom Ariadne Location object
 * 
 * Copyright (C) 2012-2013 Dieter Adriaenssens
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @package org.ruleant.ariadne
 * @author  Dieter Adriaenssens <ruleant@users.sourceforge.net>
 */
package org.ruleant.ariadne;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.location.Location;

/**
 * Custom Ariadne Location object
 * 
 * This object inherits from a Location object, but overrides the getString() method
 * 
 * @author  Dieter Adriaenssens <ruleant@users.sourceforge.net>
 */
public class Ariadne_Location extends Location {
	/**
	 * Constructor
	 *
	 * @param provider
	 */
	public Ariadne_Location(String provider) {
		super (provider);
	}
	
	/**
	 * Constructor
	 *
	 * @param location
	 */
	public Ariadne_Location(Location location) {
		super (location);
	}

	/**
	 * Overrides the toString() method, implementing a formatted String
	 *
	 * @param context Context of the application
	 * @return String
	 */
	public String toString(Context context) {
		String locationText = "";

		// Format location
		locationText += " "  + context.getResources().getString(R.string.latitude) + ": ";
		locationText += getLatitude() + "°\n";
		locationText += " "  + context.getResources().getString(R.string.longitude) + ": ";
		locationText += getLongitude() + "°\n";
		if (hasAltitude()) {
			locationText += " "  + context.getResources().getString(R.string.altitude) + ": ";
			locationText += getAltitude() + "m\n";
		}
		if (hasBearing()) {
			locationText += " "  + context.getResources().getString(R.string.bearing) + ": ";
			locationText += getBearing() + "°\n";
		}
		if (hasSpeed()) {
			locationText += " "  + context.getResources().getString(R.string.speed) + ": ";
			locationText += getSpeed() + "m/s\n";
		}
		if (hasAccuracy()) {
			locationText += " "  + context.getResources().getString(R.string.accuracy) + ": ";
			locationText += getAccuracy() + "m\n";
		}

		// Format Timestamp
		if (getTime() > 0) {
			Date date = new Date(getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSSz");
			locationText += " "  + context.getResources().getString(R.string.timestamp) + ": ";
			locationText += formatter.format(date);
		}

		// raw
		if (MainActivity.DEBUG_LEVEL >= 6) {
			locationText += "\n\n";
			locationText += " "  + context.getResources().getString(R.string.raw) + ": ";
			locationText += super.toString();
		}

		return locationText;
	}
}
