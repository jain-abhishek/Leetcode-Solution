import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class AccountsMerge {

	public static void main(String[] args) {
		AccountsMerge obj =  new AccountsMerge();
		List<List<String>> accounts = new ArrayList<>();

		List<String> account1 = new ArrayList<>();
		account1.add("John");
		account1.add("johnsmith@mail.com");
		account1.add("john_newyork@mail.com");

		List<String> account2 = new ArrayList<>();
		account2.add("John");
		account2.add("john00@mail.com");
		account2.add("john01@mail.com");
		account2.add("john02@mail.com");
		account2.add("john03@mail.com");
		account2.add("john04@mail.com");
		account2.add("johnsmith@mail.com");

		List<String> account3 = new ArrayList<>();
		account3.add("Mary");
		account3.add("mary@mail.com");

		List<String> account4 = new ArrayList<>();
		account4.add("John");
		account4.add("johnnybravo@mail.com");
		
		List<String> account5 = new ArrayList<>();
		account5.add("John");
		account5.add("john05@mail.com");
		account5.add("john06@mail.com");
		account5.add("john01@mail.com");

//		List<String> account1 = new ArrayList<>();
//		account1.add("David");
//		account1.add("David0@m.co");
//		account1.add("David1@m.co");
//
//		List<String> account2 = new ArrayList<>();
//		account2.add("David");
//		account2.add("David3@m.co");
//		account2.add("David4@m.co");
//
//		List<String> account3 = new ArrayList<>();
//		account3.add("David");
//		account3.add("David4@m.co");
//		account3.add("David5@m.co");
//		
//		List<String> account4 = new ArrayList<>();
//		account4.add("David");
//		account4.add("David2@m.co");
//		account4.add("David3@m.co");
//
//		List<String> account5 = new ArrayList<>();
//		account5.add("David");
//		account5.add("David1@m.co");
//		account5.add("David2@m.co");
//		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		accounts.add(account5);
		
		obj.accountsMerge(accounts);
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> connections = new HashMap<>();
        Map<String, String> emailToNameMap = new HashMap<>();
        
        boolean flag = false;
        
        for(int i=0;i<accounts.size();i++){
            List<String> account = accounts.get(i);
            int j;
            for(j=1;j<account.size();j++){
                emailToNameMap.put(account.get(j), account.get(0));
                if(!connections.containsKey(account.get(j))){
                	connections.put(account.get(j), account.get(1));    
                }
                else{
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                flag = false;
                String root = findRoot(account.get(j), connections);
                for(j=1;j<account.size();j++){
                    emailToNameMap.put(account.get(j), account.get(0));
                    connections.put(findRoot(account.get(j), connections), root);   
                }
            }
        }
        
        Map<String, SortedSet<String>> mergedMap = new HashMap<>();

        for(Map.Entry<String, String> connection : connections.entrySet()) {
        	String value = findRoot(connection.getValue(), connections);
        	if(!mergedMap.containsKey(value)) {
        		SortedSet<String> set = new TreeSet<>();
        		set.add(connection.getKey());
        		mergedMap.put(value, set);
        	}
        	else {
        		SortedSet<String> set = mergedMap.get(value);
        		set.add(connection.getKey());
        		mergedMap.put(value, set);
        	}
        }
        
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        for(Map.Entry<String, SortedSet<String>> map : mergedMap.entrySet()) {
        	List<String> mergedAccount = new ArrayList<>();
        	mergedAccount.add(emailToNameMap.get(map.getKey()));
        	for(String account : map.getValue()) {
        		mergedAccount.add(account);
        	}
        	mergedAccounts.add(mergedAccount);
        }
        
        return mergedAccounts;
    }
    
    private String findRoot(String email, Map<String, String> connections){
    	if(!connections.containsKey(email)) {
    		return email;
    	}
    	
        while(connections.get(email) != email) {
        	connections.put(email, connections.get(connections.get(email))); //path compression
			email = connections.get(email);
		}
		
		return email;
    }
}
