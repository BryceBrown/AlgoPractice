package com.company.hackerrank;

import java.util.*;

/**
 * Created by fatma on 5/24/2017.
 */
public class RoadsAndLibraries {

    public static class Cities {
        public City[] cities;
    }

    public static class City {
        public int cityNumber;
        public boolean visited = false;
        public HashSet<Integer> connectedCities = new HashSet<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            Cities cities = new Cities();

            int numCities = in.nextInt();
            int numRoads = in.nextInt();
            int libCost = in.nextInt();
            int roadCost = in.nextInt();


            //if libraries are cheaper (or the same cost as) roads, just build libraries in every city
            //if roads are cheaper than libraries, find all of the isolated graphs, then do a BFS to determine how many roads need to be built


            HashSet<Integer> citiesLeft = new HashSet<>();
            cities.cities = new City[numCities];
            //build the initial list of cities
            for(int i=0;i < numCities;i++){
                City city = new City();
                city.cityNumber = i;
                cities.cities[i] = city;
                citiesLeft.add(i);
            }

            for(int a1 = 0; a1 < numRoads; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();

                cities.cities[city_1 - 1].connectedCities.add(city_2 - 1);
                cities.cities[city_2 - 1].connectedCities.add(city_1 - 1);
            }

            if(libCost <= roadCost || numRoads == 0){
                System.out.println(libCost * numCities);
                continue;
            }

            int graphs = 0;
            while (citiesLeft.size() > 0){
                graphs++;
                int currentCity = citiesLeft.iterator().next();
                findGraph(citiesLeft, cities, currentCity);
            }
            System.out.println((graphs * libCost) + (numCities - graphs) * roadCost);

        }
    }

    public static void findGraph(HashSet<Integer> citiesLeft, Cities cities, int currentCity){
        PriorityQueue<Integer> nextCities = new PriorityQueue<>();
        citiesLeft.remove(currentCity);
        nextCities.add(currentCity);

        while(!nextCities.isEmpty()){
            int nextCity = nextCities.poll();
            City city = cities.cities[nextCity];
            citiesLeft.remove(nextCity);
            for(Iterator<Integer> iter = city.connectedCities.iterator(); iter.hasNext();) {
                City next = cities.cities[iter.next()];
                if(!next.visited){
                    next.visited = true;
                    nextCities.add(next.cityNumber);
                }
            }
        }


    }

}




