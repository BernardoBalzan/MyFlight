package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;

	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static double distancia(Geo geo, Geo geo2) {
		double distancia;
		distancia = (2*6371) * (Math.asin(Math.sqrt(Math.pow(Math.sin((Math.toRadians(geo.getLatitude()) - Math.toRadians(geo2.getLatitude())) / 2), 2)) +
										(Math.pow(Math.sin((Math.toRadians(geo.getLongitude()) - Math.toRadians(geo.getLongitude())) / 2), 2)) * 
										Math.cos(Math.toRadians(geo.getLatitude())) * Math.cos(Math.toRadians(geo2.getLatitude()))) );
		return distancia;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return String.format("Latitude: %.4f ; Longitude: %.4f",latitude, longitude);
	}
}
