class SolutionJan12025 {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        int fleets = position.length;
        for( int i = 0; i < position.length; i++){
            int[] car = new int[]{position[i],speed[i]};
            cars.add(car);
        }
        Collections.sort(cars,(a,b)->(Integer.compare(a[0],b[0])));
        for(int i = position.length-1; i >= 1;i--){
            if (willCatch(cars.get(i-1),cars.get(i),target)) {
                cars.set(i-1, cars.get(i));
                fleets--;
            }
        }

        return fleets;
    }

    public boolean willCatch(int[] a, int[] b, int target ){ //ceiling or double
        if (a[1] < b[1]) return false;
        double t = (double) (b[0]- a[0])/ (double)(a[1]-b[1]);
        double overtake = a[0] + t*a[1];
        System.out.println(overtake + " " +target);
        return overtake <= target;
    } 
}

class SolutionSep92024 {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Car[] cars = new Car[position.length];
        for ( int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars);

        Car leader = cars[cars.length-1];
        int fleets = 1;

        for( int i = cars.length-2; i >= 0; i--){
            if ( !willCatch(cars[i],leader,target)){
                fleets++;
                leader = cars[i];
            }
        }
        
        return fleets;

    }

    //returns true if a will catch b before targer
    public boolean willCatch(Car a, Car b, int target){
        if (a.speed <= b.speed) { return false;}
        double hours = (double)(a.pos-b.pos)/(b.speed-a.speed);
        double catched = a.pos + (hours * a.speed);
        return (catched <= target);

    }
}

/*
   fleet leader = last car
   fleets = 1
   for ( second to last car to last car){
        if !willCatch(car, leader){
            leader = car;
            fleets ++;
        }
   }
*/

class Car implements Comparable<Car>{
    int pos;
    int speed;

    public Car(int pos, int speed){
        this.pos = pos;
        this.speed = speed;
    }

    @Override 
    public int compareTo(Car c){
        return pos - c.pos;
    }
}
