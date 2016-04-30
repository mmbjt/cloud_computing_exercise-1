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
		MWRA.listWSDLs("MWFacebookService");
		String uri = "http://10.101.8.30:12346/MWMyPathSrv";
		MWRA.authenticate("gruppe8", "");
		MWRA.registerService("gruppe8", "MWPathService", uri + "?wsdl");
		
		MWRA.closeConnection();
		
	}

}
