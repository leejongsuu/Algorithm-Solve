class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoTime = getTimeFromString(video_len);
        int posTime = getTimeFromString(pos);
        int op_startTime = getTimeFromString(op_start);
        int op_endTime = getTimeFromString(op_end);
        
        for(String command : commands) {
            
            if(op_startTime <= posTime && posTime <= op_endTime) {
                posTime = op_endTime;
            }
            
            if(command.equals("next")) {
                posTime += 10;
            } else {
                posTime -= 10;
            }
            
            if(posTime < 0) {
                posTime = 0;
            } else if(posTime > videoTime) {
                posTime = videoTime;
            } else if(op_startTime <= posTime && posTime <= op_endTime) {
                posTime = op_endTime;
            }
        }
        
        return getTimeFromInt(posTime);
    }
    
    private int getTimeFromString(String str) {
        int time = 0;
        
        String[] splited = str.split(":");
        
        int m = Integer.parseInt(splited[0]);
        int s = Integer.parseInt(splited[1]);
        
        return m * 60 + s;
    }
    
    private String getTimeFromInt(int time) {
        
        int m = time / 60;
        int s = time % 60;
        
        StringBuilder sb = new StringBuilder();
        
        if(m < 10) sb.append(0);
        sb.append(m);
        sb.append(":");
        if(s < 10) sb.append(0);
        sb.append(s);
        
        return sb.toString();
    }
}