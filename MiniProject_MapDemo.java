package collegeSY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

public class MiniProject_MapDemo {

	public static void main(String[] args) {
		MapGraph g = new MapGraph();
		Scanner sc = new Scanner(System.in);
		ArrayList<String> fav = new ArrayList<>();
		
		
		//DataSet - source, detsination, distance, time
		
		g.addEdge("Pune", "Mumbai", 148,172);
        g.addEdge("Pune", "Thane", 200, 184);
        g.addEdge("Pune", "Raigad", 136.6, 233);
        g.addEdge("Pune", "Ahmednagar", 125.5, 180);
        g.addEdge("Pune", "Satara", 112.4, 135);
        g.addEdge("Pune", "Solapur", 253.3, 274);
        g.addEdge("Nashik", "Ahmednagar", 156.7, 226);
        g.addEdge("Nashik", "Palghar", 147.4, 209);
        g.addEdge("Nashik", "Aurangabad", 197.1, 229);
        g.addEdge("Nashik", "Jalgaon", 249.7, 284);
        g.addEdge("Aurangabad", "Jalna", 59.1, 73);
        g.addEdge("Aurangabad", "Nashik", 197.1, 238);
        g.addEdge("Aurangabad", "Beed", 125.1, 131);
        g.addEdge("Aurangabad", "Jalgaon", 156.8, 252);
        g.addEdge("Aurangabad", "Buldhana", 137.5, 201);
        g.addEdge("Aurangabad", "Ahmednagar", 114, 135);
        g.addEdge("Mumbai", "Raigad", 167.6, 163);
        g.addEdge("Mumbai", "Palghar", 108.3, 158);
        g.addEdge("Palghar", "Ahmednagar", 286, 399);
        g.addEdge("Thane", "Palghar", 91.7, 122);
        g.addEdge("Thane", "Mumbai", 22.7, 36);
        g.addEdge("Thane", "Raigad", 108, 282);
        g.addEdge("Thane", "Ahmednagar", 231, 319);
        g.addEdge("Raigad", "Ratnagiri", 232, 331);
        g.addEdge("Ahmednagar", "Solapur", 275.7, 304);
        g.addEdge("Ahmednagar", "Beed", 128.2, 156);
        g.addEdge("Ratnagiri", "Satara", 191.7, 241);
        g.addEdge("Ratnagiri", "Kolhapur", 131.6, 197);
        g.addEdge("Satara", "Kolhapur", 121.9, 115);
        g.addEdge("Satara", "Sangli", 121.6, 129);
        g.addEdge("Satara", "Solapur", 235.4, 294);
        g.addEdge("Kolhapur", "Sangli", 46.7, 68);
        g.addEdge("Sangli", "Solapur", 187.6, 239);
        g.addEdge("Solapur", "Osmanabad", 67.8, 76);
        g.addEdge("Osmanabad", "Beed", 115.8, 116);
        g.addEdge("Osmanabad", "Latur", 72.5, 111);
        g.addEdge("Beed", "Latur", 135.9, 164);
        g.addEdge("Beed", "Parbhani", 147.4, 165);
        g.addEdge("Beed", "Jalna", 102.2, 114);
        g.addEdge("Latur", "Nanded", 137.4, 222);
        g.addEdge("Latur", "Parbhani", 130.2, 191);
        g.addEdge("Nanded", "Parbhani", 69.1, 115);
        g.addEdge("Nanded", "Buldhana", 243.3, 337);
        g.addEdge("Parbhani", "Jalna", 13.5, 202);
        g.addEdge("Parbhani", "Buldhana", 208.0, 295);
        g.addEdge("Jalna", "Buldhana", 112.8, 146);
        g.addEdge("Jalgaon", "Buldhana", 131.2, 172);
		
        
        int ch=0;
		do {
			System.out.println("\n-----------City-Route Tracker System------------ ");
			System.out.println("\n1. Display the adjacent cities of each city, the distance between and the time needed to reach them");
			System.out.println("2. Display the routes to adjacent cities of a particular city");
			System.out.println("3. Display the routes to all the cities from a particular city");
			System.out.println("4. Display the shortest path between two cities");
			System.out.println("5. Show your favourite places ");
			System.out.println("6. Exit.\nEnter your choice: ");
			ch=sc.nextInt();
			
			switch(ch) {
			case 1: g.display();break;
			case 2: System.out.println("Enter the city name: ");
			      		String city = sc.next();
			      		g.displayAllAdj(city);
			      		break;
			case 3: System.out.println("Enter the city name: ");
			 			String city1 = sc.next();
			 			g.displayAllRoutes(city1);
			 			break;
			case 4: System.out.println("Enter the starting city: ");
			 			String src = sc.next();
			 			System.out.println("Enter the destination city: ");
			 			String dest = sc.next();
			 			g.shortestPath(src, dest);
			 			int k =1;
			 			do {
			 				System.out.println("1.Add destination to your favourites ");
			 				System.out.println("2.Continue ");
			 				k = sc.nextInt();
			 				if(k==1) {
			 					fav.add(dest);
			 					break;
			 				}
			 				else {
			 					break;
			 				}
			 			}while(k!=2);
			 			break;
			case 5:
				System.out.println(fav);
				
				break;
			case 6: break;
			default: System.out.println("Wrong choice entered.");
			 			  break;
			}
		  }while(ch!=6);
    	}	
	}


class Edge{
	
	//nbr = adjacent city
	String nbr;
	double distance;
	int time;
	//Constructor 
	Edge(String nbr,double distance){
		this.nbr=nbr;
		this.distance=distance;
	}
	Edge(String nbr,double distance,int time){
		this.nbr=nbr;
		this.distance=distance;
		this.time = time;
	}
	
}

class MapGraph{
	
	
	Scanner sc = new Scanner(System.in);
	
	//Map for storing Source as key and Edge as Value 
	Map<String, List<Edge>> map = new HashMap<>();

	
	
	//Adding edge in the map for source and destination vertex
	public void addEdge(String source,String destination,double distance, int time) {
		
		//if map doesn't contain source key, adding key and initialising it with new LinkedList of Edge
		if(!map.containsKey(source)) {
			map.put(source, new LinkedList<Edge>());
		}
		
		//if map doesn't contain destination key, adding key and initialising it with new LinkedList of Edge
		if(!map.containsKey(destination)) {
			map.put(destination, new LinkedList<Edge>());
		}
		
		//else adding the edge 
		map.get(source).add(new Edge(destination,distance,time));
		map.get(destination).add(new Edge(source,distance,time));
		
		
		
		
	}

	public void display() {
		
		    //Iterating through map key-value pair
			for (Entry<String, List<Edge>> entry : map.entrySet()) {
				
				//Printing starting city 
				System.out.println("From "+entry.getKey()+" To  ");
			    List<Edge> list = entry.getValue();
			    
			    //Traversing all the adjacent cities of the starting key city
			    for(Edge i: list) {
			    System.out.print("   "+i.nbr);
			    System.out.print(" :: Distance:  "+i.distance+" km  ");
		
			    System.out.print(":: Time Required : "+(i.time)/60+" hr "+(i.time)%60+" min ");
			     System.out.println();
			    }
			    System.out.println();
			}
	}
	
	
	//Taking source from user and displaying all adjacent cities alongwith
	// distance and time 
	public void displayAllAdj(String source) {
		if(!map.containsKey(source)) {
			System.out.println("Place not found !");
			return;
		}
		System.out.println("All direct routes from "+source+" are : ");
		List<Edge> list= map.get(source);
		for(Edge i: list) {
		    System.out.println("  "+i.nbr);
		    System.out.println("  Distance: "+i.distance+" km ");
		    System.out.print("  Time required:  "+(i.time)/60+" hr "+(i.time)%60+" min ");
		    System.out.println("\n");
		    }
		
		   
		
	}
	
	public void displayAllRoutes(String source) {
		if(!map.containsKey(source)) {
			System.out.println("Place not found !");
			return;
		}
		System.out.println("All routes from "+source+" are : ");
		System.out.println();
		for(String i : map.keySet()) {
		  shortestPath(source,i);
		}
		
	}
	
	
	
	
public Double shortestPath(String src,String dest) {
		
		//if map doesn't contain source or destination city , printing the error message 
		if(!map.containsKey(src)||!map.containsKey(dest)) {
			System.out.println("Place not found !");
			return (double) 0;
		}
		
		//Creating hashmap for storing current shortest distance to a particular city
		Map<String,Double> dist = new HashMap<>();
		//Creating hashmap for storing current time to a particular city
		Map<String,Integer> timeData = new HashMap<>();
		
		
		//Creating hashmap for storing parent of each node
		Map<String,String> route = new HashMap<>();
		route.put(src, src);
		
		//initially setting distance of each vertex to infinity (except source)
		for(String i:map.keySet()) {
			    dist.put(i, Double.MAX_VALUE);
			}
		
		//Initial time of each vertex is 0 
		for(String i:map.keySet()) {
		    timeData.put(i, 0);
		}
		
		dist.put(src, (double) 0);
		
		Queue<String> queue = new LinkedList<>();
		
		//Returning if source and destination are same 
		if(src==dest) {
			return (double) 0;
		}
		//Adding src to the queue
        queue.add(src);
	
         
	   while(!queue.isEmpty()) {	
	        
		    String s = queue.poll();
		    //Returning if source and destination are same
		    if(s==dest) {
		    	break;
		    }
		    //Traversing through adjacent cities of s
			for(Edge edge: map.get(s)) {
				if(dist.get(s)+edge.distance<dist.get(edge.nbr)) {
					//Relaxation thm
					//If the  distance of the city is smaller than the current distnce , replacing it with smaller one
					dist.put(edge.nbr, dist.get(s)+edge.distance);
					//Updating time map simultaneously
					timeData.put(edge.nbr,timeData.get(s)+edge.time);
					
					route.put(edge.nbr, s);
					queue.add(edge.nbr);
				}
			}
		
	}
	
	//Printing path
	String str = dest;
	String val = route.get(dest);
    while(val!=src) {
    	str = val+" -> "+str;
    
    	val = route.get(val);
    	
    }
    
  
	System.out.println();	
    System.out.println(src+" -> "+str);
    System.out.println("Total Time required : "+timeData.get(dest)/60+" hr "+timeData.get(dest)%60+" min ");
    System.out.println("Total Distance : "+dist.get(dest)+" km");
	
	return dist.get(dest);	
	}
	
	
}


/********************* OUTPUT *************************/
/*
 
 
-----------City-Route Tracker System------------ 

1. Display the adjacent cities of each city, the distance between and the time needed to reach them
2. Display the routes to adjacent cities of a particular city
3. Display the routes to all the cities from a particular city
4. Display the shortest path between two cities
5. Show your favourite places 
6. Exit.
Enter your choice: 
1
From Latur To  
   Osmanabad :: Distance:  72.5 km  :: Time Required : 1 hr 51 min 
   Beed :: Distance:  135.9 km  :: Time Required : 2 hr 44 min 
   Nanded :: Distance:  137.4 km  :: Time Required : 3 hr 42 min 
   Parbhani :: Distance:  130.2 km  :: Time Required : 3 hr 11 min 

From Raigad To  
   Pune :: Distance:  136.6 km  :: Time Required : 3 hr 53 min 
   Mumbai :: Distance:  167.6 km  :: Time Required : 2 hr 43 min 
   Thane :: Distance:  108.0 km  :: Time Required : 4 hr 42 min 
   Ratnagiri :: Distance:  232.0 km  :: Time Required : 5 hr 31 min 

From Satara To  
   Pune :: Distance:  112.4 km  :: Time Required : 2 hr 15 min 
   Ratnagiri :: Distance:  191.7 km  :: Time Required : 4 hr 1 min 
   Kolhapur :: Distance:  121.9 km  :: Time Required : 1 hr 55 min 
   Sangli :: Distance:  121.6 km  :: Time Required : 2 hr 9 min 
   Solapur :: Distance:  235.4 km  :: Time Required : 4 hr 54 min 

From Ahmednagar To  
   Pune :: Distance:  125.5 km  :: Time Required : 3 hr 0 min 
   Nashik :: Distance:  156.7 km  :: Time Required : 3 hr 46 min 
   Aurangabad :: Distance:  114.0 km  :: Time Required : 2 hr 15 min 
   Palghar :: Distance:  286.0 km  :: Time Required : 6 hr 39 min 
   Thane :: Distance:  231.0 km  :: Time Required : 5 hr 19 min 
   Solapur :: Distance:  275.7 km  :: Time Required : 5 hr 4 min 
   Beed :: Distance:  128.2 km  :: Time Required : 2 hr 36 min 

From Jalna To  
   Aurangabad :: Distance:  59.1 km  :: Time Required : 1 hr 13 min 
   Beed :: Distance:  102.2 km  :: Time Required : 1 hr 54 min 
   Parbhani :: Distance:  13.5 km  :: Time Required : 3 hr 22 min 
   Buldhana :: Distance:  112.8 km  :: Time Required : 2 hr 26 min 

From Sangli To  
   Satara :: Distance:  121.6 km  :: Time Required : 2 hr 9 min 
   Kolhapur :: Distance:  46.7 km  :: Time Required : 1 hr 8 min 
   Solapur :: Distance:  187.6 km  :: Time Required : 3 hr 59 min 

From Nashik To  
   Ahmednagar :: Distance:  156.7 km  :: Time Required : 3 hr 46 min 
   Palghar :: Distance:  147.4 km  :: Time Required : 3 hr 29 min 
   Aurangabad :: Distance:  197.1 km  :: Time Required : 3 hr 49 min 
   Jalgaon :: Distance:  249.7 km  :: Time Required : 4 hr 44 min 
   Aurangabad :: Distance:  197.1 km  :: Time Required : 3 hr 58 min 

From Nanded To  
   Latur :: Distance:  137.4 km  :: Time Required : 3 hr 42 min 
   Parbhani :: Distance:  69.1 km  :: Time Required : 1 hr 55 min 
   Buldhana :: Distance:  243.3 km  :: Time Required : 5 hr 37 min 

From Mumbai To  
   Pune :: Distance:  148.0 km  :: Time Required : 2 hr 52 min 
   Raigad :: Distance:  167.6 km  :: Time Required : 2 hr 43 min 
   Palghar :: Distance:  108.3 km  :: Time Required : 2 hr 38 min 
   Thane :: Distance:  22.7 km  :: Time Required : 0 hr 36 min 

From Parbhani To  
   Beed :: Distance:  147.4 km  :: Time Required : 2 hr 45 min 
   Latur :: Distance:  130.2 km  :: Time Required : 3 hr 11 min 
   Nanded :: Distance:  69.1 km  :: Time Required : 1 hr 55 min 
   Jalna :: Distance:  13.5 km  :: Time Required : 3 hr 22 min 
   Buldhana :: Distance:  208.0 km  :: Time Required : 4 hr 55 min 

From Solapur To  
   Pune :: Distance:  253.3 km  :: Time Required : 4 hr 34 min 
   Ahmednagar :: Distance:  275.7 km  :: Time Required : 5 hr 4 min 
   Satara :: Distance:  235.4 km  :: Time Required : 4 hr 54 min 
   Sangli :: Distance:  187.6 km  :: Time Required : 3 hr 59 min 
   Osmanabad :: Distance:  67.8 km  :: Time Required : 1 hr 16 min 

From Kolhapur To  
   Ratnagiri :: Distance:  131.6 km  :: Time Required : 3 hr 17 min 
   Satara :: Distance:  121.9 km  :: Time Required : 1 hr 55 min 
   Sangli :: Distance:  46.7 km  :: Time Required : 1 hr 8 min 

From Thane To  
   Pune :: Distance:  200.0 km  :: Time Required : 3 hr 4 min 
   Palghar :: Distance:  91.7 km  :: Time Required : 2 hr 2 min 
   Mumbai :: Distance:  22.7 km  :: Time Required : 0 hr 36 min 
   Raigad :: Distance:  108.0 km  :: Time Required : 4 hr 42 min 
   Ahmednagar :: Distance:  231.0 km  :: Time Required : 5 hr 19 min 

From Buldhana To  
   Aurangabad :: Distance:  137.5 km  :: Time Required : 3 hr 21 min 
   Nanded :: Distance:  243.3 km  :: Time Required : 5 hr 37 min 
   Parbhani :: Distance:  208.0 km  :: Time Required : 4 hr 55 min 
   Jalna :: Distance:  112.8 km  :: Time Required : 2 hr 26 min 
   Jalgaon :: Distance:  131.2 km  :: Time Required : 2 hr 52 min 

From Osmanabad To  
   Solapur :: Distance:  67.8 km  :: Time Required : 1 hr 16 min 
   Beed :: Distance:  115.8 km  :: Time Required : 1 hr 56 min 
   Latur :: Distance:  72.5 km  :: Time Required : 1 hr 51 min 

From Palghar To  
   Nashik :: Distance:  147.4 km  :: Time Required : 3 hr 29 min 
   Mumbai :: Distance:  108.3 km  :: Time Required : 2 hr 38 min 
   Ahmednagar :: Distance:  286.0 km  :: Time Required : 6 hr 39 min 
   Thane :: Distance:  91.7 km  :: Time Required : 2 hr 2 min 

From Pune To  
   Mumbai :: Distance:  148.0 km  :: Time Required : 2 hr 52 min 
   Thane :: Distance:  200.0 km  :: Time Required : 3 hr 4 min 
   Raigad :: Distance:  136.6 km  :: Time Required : 3 hr 53 min 
   Ahmednagar :: Distance:  125.5 km  :: Time Required : 3 hr 0 min 
   Satara :: Distance:  112.4 km  :: Time Required : 2 hr 15 min 
   Solapur :: Distance:  253.3 km  :: Time Required : 4 hr 34 min 

From Jalgaon To  
   Nashik :: Distance:  249.7 km  :: Time Required : 4 hr 44 min 
   Aurangabad :: Distance:  156.8 km  :: Time Required : 4 hr 12 min 
   Buldhana :: Distance:  131.2 km  :: Time Required : 2 hr 52 min 

From Aurangabad To  
   Nashik :: Distance:  197.1 km  :: Time Required : 3 hr 49 min 
   Jalna :: Distance:  59.1 km  :: Time Required : 1 hr 13 min 
   Nashik :: Distance:  197.1 km  :: Time Required : 3 hr 58 min 
   Beed :: Distance:  125.1 km  :: Time Required : 2 hr 11 min 
   Jalgaon :: Distance:  156.8 km  :: Time Required : 4 hr 12 min 
   Buldhana :: Distance:  137.5 km  :: Time Required : 3 hr 21 min 
   Ahmednagar :: Distance:  114.0 km  :: Time Required : 2 hr 15 min 

From Beed To  
   Aurangabad :: Distance:  125.1 km  :: Time Required : 2 hr 11 min 
   Ahmednagar :: Distance:  128.2 km  :: Time Required : 2 hr 36 min 
   Osmanabad :: Distance:  115.8 km  :: Time Required : 1 hr 56 min 
   Latur :: Distance:  135.9 km  :: Time Required : 2 hr 44 min 
   Parbhani :: Distance:  147.4 km  :: Time Required : 2 hr 45 min 
   Jalna :: Distance:  102.2 km  :: Time Required : 1 hr 54 min 

From Ratnagiri To  
   Raigad :: Distance:  232.0 km  :: Time Required : 5 hr 31 min 
   Satara :: Distance:  191.7 km  :: Time Required : 4 hr 1 min 
   Kolhapur :: Distance:  131.6 km  :: Time Required : 3 hr 17 min 


-----------City-Route Tracker System------------ 

1. Display the adjacent cities of each city, the distance between and the time needed to reach them
2. Display the routes to adjacent cities of a particular city
3. Display the routes to all the cities from a particular city
4. Display the shortest path between two cities
5. Show your favourite places 
6. Exit.
Enter your choice: 
2
Enter the city name: 
Pune
All direct routes from Pune are : 
  Mumbai
  Distance: 148.0 km 
  Time required:  2 hr 52 min 

  Thane
  Distance: 200.0 km 
  Time required:  3 hr 4 min 

  Raigad
  Distance: 136.6 km 
  Time required:  3 hr 53 min 

  Ahmednagar
  Distance: 125.5 km 
  Time required:  3 hr 0 min 

  Satara
  Distance: 112.4 km 
  Time required:  2 hr 15 min 

  Solapur
  Distance: 253.3 km 
  Time required:  4 hr 34 min 


-----------City-Route Tracker System------------ 

1. Display the adjacent cities of each city, the distance between and the time needed to reach them
2. Display the routes to adjacent cities of a particular city
3. Display the routes to all the cities from a particular city
4. Display the shortest path between two cities
5. Show your favourite places 
6. Exit.
Enter your choice: 
3
Enter the city name: 
Beed
All routes from Beed are : 


Beed -> Latur
Total Time required : 2 hr 44 min 
Total Distance : 135.9 km

Beed -> Ahmednagar -> Pune -> Raigad
Total Time required : 9 hr 29 min 
Total Distance : 390.29999999999995 km

Beed -> Ahmednagar -> Pune -> Satara
Total Time required : 7 hr 51 min 
Total Distance : 366.1 km

Beed -> Ahmednagar
Total Time required : 2 hr 36 min 
Total Distance : 128.2 km

Beed -> Jalna
Total Time required : 1 hr 54 min 
Total Distance : 102.2 km

Beed -> Osmanabad -> Solapur -> Sangli
Total Time required : 7 hr 11 min 
Total Distance : 371.2 km

Beed -> Ahmednagar -> Nashik
Total Time required : 6 hr 22 min 
Total Distance : 284.9 km

Beed -> Jalna -> Parbhani -> Nanded
Total Time required : 4 hr 40 min 
Total Distance : 216.5 km

Beed -> Ahmednagar -> Thane -> Mumbai
Total Time required : 8 hr 31 min 
Total Distance : 381.9 km

Beed -> Parbhani
Total Time required : 2 hr 45 min 
Total Distance : 147.4 km

Beed -> Osmanabad -> Solapur
Total Time required : 3 hr 12 min 
Total Distance : 183.6 km

Beed -> Osmanabad -> Solapur -> Sangli -> Kolhapur
Total Time required : 8 hr 19 min 
Total Distance : 417.9 km

Beed -> Ahmednagar -> Thane
Total Time required : 7 hr 55 min 
Total Distance : 359.2 km

Beed -> Jalna -> Buldhana
Total Time required : 4 hr 20 min 
Total Distance : 215.0 km

Beed -> Osmanabad
Total Time required : 1 hr 56 min 
Total Distance : 115.8 km

Beed -> Ahmednagar -> Palghar
Total Time required : 9 hr 15 min 
Total Distance : 414.2 km

Beed -> Ahmednagar -> Pune
Total Time required : 5 hr 36 min 
Total Distance : 253.7 km

Beed -> Aurangabad -> Jalgaon
Total Time required : 6 hr 23 min 
Total Distance : 281.9 km

Beed -> Aurangabad
Total Time required : 2 hr 11 min 
Total Distance : 125.1 km

Beed -> Beed
Total Time required : 0 hr 0 min 
Total Distance : 0.0 km

Beed -> Ahmednagar -> Pune -> Satara -> Ratnagiri
Total Time required : 11 hr 52 min 
Total Distance : 557.8 km

-----------City-Route Tracker System------------ 

1. Display the adjacent cities of each city, the distance between and the time needed to reach them
2. Display the routes to adjacent cities of a particular city
3. Display the routes to all the cities from a particular city
4. Display the shortest path between two cities
5. Show your favourite places 
6. Exit.
Enter your choice: 
4
Enter the starting city: 
Mumbai
Enter the destination city: 
Nanded

Mumbai -> Thane -> Ahmednagar -> Aurangabad -> Jalna -> Parbhani -> Nanded
Total Time required : 14 hr 40 min 
Total Distance : 509.4 km
1.Add destination to your favourites 
2.Continue 
1

-----------City-Route Tracker System------------ 

1. Display the adjacent cities of each city, the distance between and the time needed to reach them
2. Display the routes to adjacent cities of a particular city
3. Display the routes to all the cities from a particular city
4. Display the shortest path between two cities
5. Show your favourite places 
6. Exit.
Enter your choice: 
5
[Nanded]

-----------City-Route Tracker System------------ 

1. Display the adjacent cities of each city, the distance between and the time needed to reach them
2. Display the routes to adjacent cities of a particular city
3. Display the routes to all the cities from a particular city
4. Display the shortest path between two cities
5. Show your favourite places 
6. Exit.
Enter your choice: 
6

 
 
 
 
 */
