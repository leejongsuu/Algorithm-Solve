class Solution {
    public String solution(String new_id) {
        
        String result = new KAKAOID(new_id)
            .replaceToLowerCase()
            .filter()
            .toSingleDot()
            .noStartEndDot()
            .noBlack()
            .exceedLength()
            .lengthLessThan2()
            .getKAKAOID();
        
        return result;
    }
    
    private class KAKAOID {
        private String s;
        
        KAKAOID(String s) {
            this.s = s;
        }
        
        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }
        
        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }
        
        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}",".");
            return this;
        }
        
        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }
        
        private KAKAOID noBlack() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }
        
        private KAKAOID exceedLength() {
            if(s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$","");
            return this;
        }
        
        private KAKAOID lengthLessThan2() {
            StringBuffer sb = new StringBuffer(s);
            while(sb.length() < 3) {
                sb.append(sb.charAt(sb.length()-1));
            }
            s = sb.toString();
            return this;
        }
        
        private String getKAKAOID() {
            return s;
        }
    }
}