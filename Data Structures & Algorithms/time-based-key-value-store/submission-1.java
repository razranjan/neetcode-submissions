class TimeStampValue {

    int timestamp;
    String value;

    public TimeStampValue(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;

    }

}

class TimeMap {

    Map<String, List<TimeStampValue>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {

        List<TimeStampValue> timeStampList = keyTimeMap.getOrDefault(key, new ArrayList<>());

        timeStampList.add(new TimeStampValue(timestamp, value));
        keyTimeMap.put(key, timeStampList);
        
    }
    
    public String get(String key, int timestamp) {
        List<TimeStampValue> timeStampList = keyTimeMap.get(key);

        if (timeStampList == null) return "";


        Collections.sort(timeStampList, (a,b) -> a.timestamp-b.timestamp);

        int low = 0;
        int high = timeStampList.size() -1;

        if ( timestamp < timeStampList.get(0).timestamp) return "";

        if (timestamp >= timeStampList.get(timeStampList.size() -1).timestamp)
        {
            return timeStampList.get(timeStampList.size() -1).value;
        } 

        while(low <= high){

            int mid = (low + high)/2;

            if (timeStampList.get(mid).timestamp == timestamp || (mid+1 <= timeStampList.size() - 1 && timeStampList.get(mid+1).timestamp > timestamp && timeStampList.get(mid).timestamp < timestamp)){
                return timeStampList.get(mid).value;
}   
else if (timeStampList.get(mid).timestamp < timestamp){
    low = mid+1;
}
else {
    high = mid-1;
}
}

        return null;
    }
}
