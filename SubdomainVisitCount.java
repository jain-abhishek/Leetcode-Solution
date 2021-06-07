import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

	public static void main(String[] args) {
		SubdomainVisitCount obj = new SubdomainVisitCount();
		List<String> list = obj.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
		System.out.println(list);
	}

	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> domainMap = new HashMap<>();

		for(String domain : cpdomains){
			List<String> subDomains = new ArrayList<>();

			int count = 0;
			int k = 0;

			while(domain.charAt(k) != ' ')
				k++;
			count = Integer.parseInt(domain.substring(0, k));    

			subDomains.add(domain.substring(k+1, domain.length()));

			for(int i=k+1;i<domain.length();i++){    
				if(domain.charAt(i) == '.')
					subDomains.add(domain.substring(i+1, domain.length()));//
			}

			for(String subDomain : subDomains){
				domainMap.put(subDomain, domainMap.getOrDefault(subDomain, 0)+count);
			}
		}

		List<String> visitCounts = new ArrayList<>();     
		for(Map.Entry<String, Integer> entry : domainMap.entrySet()){
			visitCounts.add(entry.getValue() + " "+entry.getKey());
		}

		return visitCounts;
	}
}
