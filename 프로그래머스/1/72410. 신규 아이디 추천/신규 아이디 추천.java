class Solution {
    public String solution(String new_id) {
        String answer = new KAKAOID(new_id)
            .replaceToLowerCase()
            .filter()
            .singleDot()
            .removeFirstEndDot()
            .emptyThenAdd()
            .lengthThan16()
            .lengthLess2()
            .getKAKAOID();
            
        return answer;
    }
    
    private class KAKAOID {
        private String s;
        
        KAKAOID(String s) {
            this.s = s;
        }
        
        public KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }
        
        public KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9-._]", "");
            return this;
        }
        
        public KAKAOID singleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }
        
        public KAKAOID removeFirstEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }
        
        public KAKAOID emptyThenAdd() {
            if(s.isEmpty()) s = "a";
            return this;
        }
        
        public KAKAOID lengthThan16() {
            if(s.length() >= 16) s = s.substring(0, 15);
            s = s.replaceAll("[.]$", "");
            return this;
        }
        
        public KAKAOID lengthLess2() {
            StringBuilder sb = new StringBuilder(s);
            while(sb.length() <= 2) {
                sb.append(sb.charAt(sb.length()-1));
            }
            s = sb.toString();
            return this;
        }
        
        public String getKAKAOID() {
            return s;
        }
    }
}