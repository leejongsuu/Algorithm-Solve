class Solution {
    class ID {
        String id;
        
        public ID(String id) {
            this.id = id;
        }
        
        public String getId() {
            return id;
        }
        
        public ID toLowerCase() {
            id = id.toLowerCase();
            return this;
        }
        
        public ID filtering() {
            id = id.replaceAll("[^a-z0-9-_.]", "");
            return this;
        }
        
        public ID removeDotMoreThan2() {
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }
        
        public ID removeFirstAndLastDot() {
            id = id.replaceAll("^[.]|[.]$", "");
            return this;
        }
        
        public ID addWords() {
            id = id.isEmpty() ? "a" : id;
            return this;
        }
        
        public ID lengthMoreThan16() {
            if(id.length() >= 16) {
                id = id.substring(0, 15).replaceAll("[.]$", "");;
            }
            return this;
        }
        
        public ID lengthLessThan2() {
            char c = id.charAt(id.length() - 1);
            while(id.length() <= 2) {
                id += String.valueOf(c);
            }
            return this;
        }
    }
    
    public String solution(String new_id) {
        return new ID(new_id)
            .toLowerCase()
            .filtering()
            .removeDotMoreThan2()
            .removeFirstAndLastDot()
            .addWords()
            .lengthMoreThan16()
            .lengthLessThan2()
            .getId();
    }
}