package SimulatedAnnealing;

public class SimulatedAnnealing {
	
	private SingleTour best;//best solution
	
	public void simulation() {
		double temperature = 10000;
		double coolingRate = 0.03;
		
		SingleTour currentSolution = new SingleTour();
		currentSolution.generateIndividual();
		
		System.out.println("Initial solution distance: "+currentSolution.getDistance());
		
		best = new SingleTour(currentSolution.getTour());
		
		while (temperature>1) {
			SingleTour newSolution = new SingleTour(currentSolution.getTour());
			
			//generate random integer in number of cities (for swapping)
			int randomIndex1 = (int) (newSolution.getTourSize() * Math.random());
			City city1 = newSolution.getCity(randomIndex1);
			
			int randomIndex2 = (int) (newSolution.getTourSize() * Math.random());
			City city2 = newSolution.getCity(randomIndex1);
			
			newSolution.setCity(randomIndex2, city1);
			newSolution.setCity(randomIndex1, city2);
			
			double currentEnergy = currentSolution.getDistance();
			double neighborEnergy = newSolution.getDistance();
			
			if(acceptanceProbability(currentEnergy, neighborEnergy, temperature)>Math.random()) {
				currentSolution = new SingleTour(newSolution.getTour());
			}
			
			if(currentSolution.getDistance()<best.getDistance())
				best = new SingleTour(currentSolution.getTour());
			
			temperature *= 1-coolingRate;
		}
	}
	
	private double acceptanceProbability(double currentEnergy, double neighborEnergy, double temperature) {
		//we accept these bad moves to get global optimum and avoid local optimum
		if(neighborEnergy < currentEnergy)
			return 1;
		//System.out.println(temperature);
		return Math.exp((currentEnergy-neighborEnergy)/temperature);
	}

	public SingleTour getBest() {
		return best;
	}

}
