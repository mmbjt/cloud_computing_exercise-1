package mw.facebookclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
//import javax.xml.registry.infomodel.Service;

import javax.xml.ws.Service ;

import mw.path.MWMyPathService;
import mw.path.MWNoPathException;
import mw.path.MWMyPathService;
import mw.path.MWPathServiceInterface;
import mw.pathclient.MWNoPathException_Exception;
import mw.pathclient.MWPathService;
import mw.pathclient.MWPathService_Service;

public class MWClient {
	private MWMyFacebookService MyFacebookService;
	private MWPathService MyPathService;
	//MWFacebookService ist class, und MWMyFacebookService ist  interface
	// Durch  MWFacebookService().getMWMyFacebookServicePort() kann man von Server --
	//das MWMyFacebookService.class bekommen
	
	// MWPathService_Service class, und MWPathService ist  interface
	// Durch  MWPathService_Service().getMWPathServicePort() kann man von Server --
   //das MWPathService.class bekommen
	public MWClient(){
		MyFacebookService  = new MWFacebookService().getMWMyFacebookServicePort();
		MyPathService = new MWPathService_Service().getMWPathServicePort();
	}
	
	public void searchIDs(String name){
		StringArray arrayofId = MyFacebookService.searchIDs(name);
		List<String> idList = arrayofId.getItem();
		if(idList.size() == 0){
			System.out.println("no found!!");
		}
		else{
			for(int i=0;i<idList.size();i++){
				String id = idList.get(i);
				System.out.println(id);
			}
		}
	}
	
	public void getFriends(String id){
		try {
			StringArray arrayOfFriend = MyFacebookService.getFriends(id);
			List<String> friendList = arrayOfFriend.getItem();
			List<String> idOfFriendList = new ArrayList<String>();
			if(friendList.size() == 0){
				System.out.println("no found!!");
			}
			//Durch friendList kann man  eine  Liste des IDs von jedem Freund bekommen -->idOfFriend
			for(int i=0;i<friendList.size();i++){
				String idOfFriend = friendList.get(i);
				idOfFriendList.add(idOfFriend);
				//System.out.println( idOfFriend);
			}
			//Durch  die Liste des IDs von jedem Freund kann die Namen von jedem Freund bekommt werden
			for(int i=0;i<idOfFriendList.size();i++){
				String name = MyFacebookService.getName(idOfFriendList.get(i));
				System.out.println(name);
			}
		} catch (MWUnknownIDException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  calculatePath(String startID, String endID) {
		try {
			System.out.println("*********");
			mw.pathclient.StringArray pa = MyPathService.calculatePath(startID, endID);
			System.out.println("*********");
			List<String> path = pa.getItem();
			for(String p: path){
				System.out.println(p+"\n");
			}
			System.out.println("*********");

		} catch (MWNoPathException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws MalformedURLException, MWNoPathException {
		// TODO Auto-generated method stub
		MWClient client = new MWClient();
		//client. getFriends("1694452301");
		//client.searchIDs("Samy Kartit");
		//client.calculatePath("1832770518", "100000690315984");
		if(args.length == 2 && args[0].equals("SEARCH")){
			client.searchIDs(args[1]);
		}
		else if(args.length == 2 && args[0].equals("FRIENDS")){
			client. getFriends(args[1]);
		}
		else if(args.length == 3 && args[0].equals("PATH")){
			client.calculatePath(args[1], args[2]);
		}
		else{
			System.out.println("error");
		}
	}

}
