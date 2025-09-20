class Router {

    class Packet {
        public int source, dest, timestamp;
        Packet(int source, int dest, int timestamp) {
            this.source = source;
            this.dest = dest;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            Packet packet = (Packet) obj;
            return source == packet.source &&
                    dest == packet.dest &&
                    timestamp == packet.timestamp;
        }

        @Override public int hashCode() {
            return Objects.hash(source, dest, timestamp);
        }
    }

    HashSet<Packet> hset;                  
    Deque<Packet> dq;                               
    HashMap<Integer, List<Integer>> destmap;       
    int limit;
    public Router(int memoryLimit) {
        limit = memoryLimit;
        hset = new HashSet<>();
        dq = new ArrayDeque<>();
        destmap = new HashMap<>();
    }
    
    public boolean addPacket(int source, int dest, int timestamp) {
        Packet packet = new Packet(source, dest, timestamp);

        if(hset.contains(packet)) {
            return false;
        }

        if(dq.size() == limit) {
            Packet p = dq.remove();
            hset.remove(p);

            List<Integer> timestamps = destmap.get(p.dest); 

            timestamps.remove(0);
            if (timestamps.isEmpty()) {
                destmap.remove(p.dest);
            }
        }

        hset.add(packet);
        dq.offer(packet);

        destmap.computeIfAbsent(dest, k -> new ArrayList<>());
        destmap.get(dest).add(timestamp);

        return true;
    }


    public int[] forwardPacket() {

        // O(1)
        if (dq.isEmpty()) {
            return new int[0];
        }

        Packet p = dq.remove();
        hset.remove(p);

        List<Integer> timestamps = destmap.get(p.dest); 
        
        timestamps.remove(0); 
        if (timestamps.isEmpty()) {
            destmap.remove(p.dest);
        }

        return new int[]{p.source, p.dest, p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
         if (!destmap.containsKey(destination)) {
            return 0;
        }

        List<Integer> list = destmap.get(destination);
        int left = lowerBound(list, startTime);          
        int right = upperBound(list, endTime);            
        return right - left;
    }


    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int target) {

        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

