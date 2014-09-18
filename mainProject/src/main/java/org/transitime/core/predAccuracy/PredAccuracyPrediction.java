/*
 * This file is part of Transitime.org
 * 
 * Transitime.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPL) as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Transitime.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Transitime.org .  If not, see <http://www.gnu.org/licenses/>.
 */

package org.transitime.core.predAccuracy;

import java.util.Date;

/**
 * For prediction accuracy analysis. For keeping a prediction in memory so
 * that it can be compared to its corresponding arrival/departure to determine
 * the accuracy of the prediction and store that info into the database.
 *
 * @author SkiBu Smith
 *
 */
public class PredAccuracyPrediction {

	private final String routeId;
	private final String directionId;
	private final String stopId;
	// Note: tripId might not always be available from a prediction API
	private final String tripId;
	private final String vehicleId;
	private final Date predictedTime;
	// The time the prediction was read. This allows us to determine
	// how far out into the future the prediction is for.
	private final Date predictionReadTime;
	private final boolean isArrival;
	private final String source;

	/********************** Member Functions **************************/

	/**
	 * @param routeId
	 * @param directionId
	 * @param stopId
	 * @param tripId
	 *            Might not always be available from prediction API so can be
	 *            set to null.
	 * @param vehicleId
	 * @param predictedTime
	 * @param predictionReadTime
	 * @param isArrival
	 * @param sourcen
	 *            Description of the feed
	 */
	public PredAccuracyPrediction(String routeId, String directionId,
			String stopId, String tripId, String vehicleId, Date predictedTime,
			Date predictionReadTime, boolean isArrival, String source) {
		super();
		this.routeId = routeId;
		this.directionId = directionId;
		this.stopId = stopId;
		this.tripId = tripId;
		this.vehicleId = vehicleId;
		this.predictedTime = predictedTime;
		this.predictionReadTime = predictionReadTime;
		this.isArrival = isArrival;
		this.source = source;
	}
	
	public String getRouteId() {
		return routeId;
	}
	
	public String getDirectionId() {
		return directionId;
	}
	
	public String getStopId() {
		return stopId;
	}
	
	public String getTripId() {
		return tripId;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	
	public Date getPredictedTime() {
		return predictedTime;
	}
	
	public Date getPredictionReadTime() {
		return predictionReadTime;
	}
	
	public String getSource() {
		return source;
	}
	
	public boolean isArrival() {
		return isArrival;
	}
	
	@Override
	public String toString() {
		return "PredAccuracyPrediction [" 
				+ "routeId=" + routeId 
				+ ", directionId=" + directionId 
				+ ", stopId=" + stopId 
				+ ", tripId=" + tripId
				+ ", vehicleId=" + vehicleId 
				+ ", predictedTime=" + predictedTime 
				+ ", predictionReadTime=" + predictionReadTime
				+ ", predictionLengthMsec=" + 
					(predictedTime.getTime() - predictionReadTime.getTime())
				+ ", isArrival=" + isArrival
				+ ", source=" + source 
				+ "]";
	}
	
}
