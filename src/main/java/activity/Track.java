package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }


    public Coordinate findMinimumCoordinate() {
        if (trackPoints.isEmpty()) {
            throw new IllegalStateException("No points");
        }
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        double minLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < minLat) {
                minLat = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < minLon) {
                minLon = trackPoint.getCoordinate().getLongitude()
            }
        }
        return new Coordinate(minLat, minLon);
    }

    public Coordinate findMaximumCoordinate() {
        if (trackPoints.isEmpty()) {
            throw new IllegalStateException("No points");
        }
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > maxLat) {
                maxLat = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > maxLon) {
                maxLon = trackPoint.getCoordinate().getLongitude()
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    public double getRectangleArea() {
        Coordinate min = findMinimumCoordinate();
        Coordinate max = findMaximumCoordinate();

        return max.getLatitude() - min.getLatitude() *
                max.getLongitude() - min.getLongitude();
    }

public double getFullElevation() {
        double elevationSum = 0.0;
        for(int i = 0; i < trackPoints.size()-1; i++) {
            TrackPoint actual = trackPoints.get(i);
            TrackPoint next = trackPoints.get(i + 1);
            if(actual.higherThan(next)) {
                elevationSum += actual.elevationDifference(next);
            }
        }
        return elevationSum;
}

    public double getFullDecrease() {
        double decreaseSum = 0.0;
        for(int i = 0; i < trackPoints.size()-1; i++) {
            TrackPoint actual = trackPoints.get(i);
            TrackPoint next = trackPoints.get(i + 1);
            if(next.higherThan(actual)) {
                decreaseSum += actual.elevationDifference(next);
            }
        }
        return decreaseSum;
    }

    public double getDistance() {
        double sum = 0;
        TrackPoint prev = trackPoints.get(0);
        for (TrackPoint actual: trackPoints) {
            sum += prev.getDistanceFrom(actual)
            prev = actual
        }
        return sum;
    }
}
