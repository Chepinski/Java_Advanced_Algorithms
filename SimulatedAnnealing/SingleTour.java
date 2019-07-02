package SimulatedAnnealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {
	// 1 valid solution for a tour (maybe not one of the best)
	private List<City> tour = new ArrayList<>();
	private double distance = 0; // set initial distance to 0

	public SingleTour() {// add each city from Repository to tour
		for (int i = 0; i < Repository.getNumberOfCities(); ++i) {
			tour.add(null);
		}
	}

	public SingleTour(List<City> tour) {
		List<City> currentTour = new ArrayList<>();
		// initialize to avoid null pointer exceptions
		for (int i = 0; i < tour.size(); ++i)
			currentTour.add(null);
		// set currentTour index to tour.get(i)
		for (int i = 0; i < tour.size(); ++i)
			currentTour.set(i, tour.get(i));

		this.tour = currentTour;
	}

	public List<City> getTour() {
		return this.tour;
	}

	public void generateIndividual() {// make tour by scrambling cities
		for (int cityIndex = 0; cityIndex < Repository.getNumberOfCities(); ++cityIndex)
			setCity(cityIndex, Repository.getCity(cityIndex));
			Collections.shuffle(tour);
	}

	public double getDistance() {
		if (distance == 0) {
			int tourDistance = 0;

			for (int cityIndex = 0; cityIndex < getTourSize(); ++cityIndex) {

				City fromCity = getCity(cityIndex);
				City destinationCity;

				if (cityIndex + 1 < getTourSize()) {
					destinationCity = getCity(cityIndex + 1);
				} else
					destinationCity = getCity(0);

				tourDistance += fromCity.distanceTo(destinationCity);
				
			}
			this.distance = tourDistance;
		}
		return this.distance;
	}

	public void setCity(int cityIndex, City city) {
		this.tour.set(cityIndex, city);
		this.distance = 0; // reinitialize distance to 0

	}

	public City getCity(int tourPosition) {
		return tour.get(tourPosition);
	}

	public int getTourSize() {
		return this.tour.size();
	}

	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < getTourSize(); ++i)
			s += getCity(i) + " -> ";

		return s;
	}

}
