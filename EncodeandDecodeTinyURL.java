import java.util.HashMap;

public class EncodeandDecodeTinyURL {

	public static void main(String[] args) {
		EncodeandDecodeTinyURL obj = new EncodeandDecodeTinyURL();
		System.out.println(obj.decode(obj.encode("https://leetcode.com/problems/design-tinyurl")));
	}

	private HashMap<String, String> encodedMap = new HashMap<>();
	private HashMap<String, String> decodedMap = new HashMap<>();
    
    public String encode(String longUrl) {
        int hash = hash(longUrl);
        String shortUrl = Integer.toHexString(hash);
        encodedMap.put(longUrl, shortUrl);
        decodedMap.put(shortUrl, longUrl);
        
        return "http://tinyurl.com/" + shortUrl;
    }

    public String decode(String shortUrl) {
        String[] splitUrl = shortUrl.split("/");
        return decodedMap.get(splitUrl[splitUrl.length-1]);
    }
    
    private int hash(String s){
        long hash = 0;
        
        for(int i=0;i<s.length();i++){
            hash = hash + s.charAt(i) * 17;
        }
        
        return (int) hash;
    }
}
