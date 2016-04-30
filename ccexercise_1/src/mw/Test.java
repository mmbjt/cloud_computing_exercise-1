package mw;

import java.util.Locale;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// TODO Auto-generated method stub
		String registryURL = 	"http://134.169.47.184:4222/juddi";
		String queryManagerURL = registryURL + "/inquiry";
		String lifeCycleManagerURL = registryURL + "/publish";
		MWRegistryAccess MWRA = new MWRegistryAccess();
		MWRA.openConnection(queryManagerURL, lifeCycleManagerURL);
		
		/*if(args.length == 2 && args[0].equals("LIST")){
			MWRA.listWSDLs(args[1]);
			//MWRA.listWSDLs("MWFacebookService");
			//MWRA.listWSDLs("MWPathService");
		}*/
		MWRA.listWSDLs("MWFacebookService");
		MWRA.closeConnection();
		
	}

}
