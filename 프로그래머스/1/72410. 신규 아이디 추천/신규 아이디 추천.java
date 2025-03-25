class Solution {
    
    public class ID {
        String id;
        
        public ID(String id) {
            this.id = id;
        }
        
        public String getId() {
            return this.id;
        }
        
        public ID toLowerCase() {
            id = id.toLowerCase();
            return this;
        }
        
        public ID toFiltering() {
            id = id.replaceAll("[^a-z0-9-_.]", "");
            return this;
        }
        
        public ID replaceOneDot() {
            id = id.replaceAll("[.]{2,}",".");
            return this;
        }
        
        public ID removeFirstOrEndDot() {
            id = id.replaceAll("^[.]|[.]$","");
            return this;
        }
        
        public ID noBlank() {
            if(id.isEmpty()) {
                id += "a";
            }
            return this;
        }
        
        public ID noGreaterThan16() {
            if(id.length() >= 16) {
                id = id.substring(0, 15);
            }
            id = id.replaceAll("[.]$", "");
            return this;
        }
        
        public ID addWords() {
            while(id.length() <= 2) {
                id += String.valueOf(id.charAt(id.length() - 1));
            }
            return this;
        }
    }
    public String solution(String new_id) {
        return new ID(new_id)
            .toLowerCase()
            .toFiltering()
            .replaceOneDot()
            .removeFirstOrEndDot()
            .noBlank()
            .noGreaterThan16()
            .addWords()
            .getId();
    }
}