# cloud_computing_exercise

=======================================ccexercise_1============================================

http://134.169.47.184:4222/juddi

http://134.169.47.184:4223/MWFacebookService?wsdl

sudo wsimport -p mw.facebookclient -d bin -s src -keep http://134.169.47.184:4223/MWFacebookService?wsdl

sudo wsimport -p mw.pathclient -d bin -s src -keep http://localhost:12345/MWPathSrv?wsdl
sudo chmod 777 ./ -R

java -cp ./:jaxr-api.jar:jarx-impl-mwcc.jar mw/MWRegistryAccess LIST MWFacebookServiced

Nicolas Van den Abeele
Alan Fish Williams
Seth Raul Vettel ❼
Ole-Kjetil Gjelstad
Penya Motera del Valles
Ireneusz Kuzdub
Arlradio Fmsimphony
Míra Masár
Samy Kartit

==========================================ccexercise_2======================================================
openstack1
1. ~/.ssh$ ssh -i id_rsa cloud@134.169.47.28
2. cd /opt/cc-services/ccexercise/bin
3. java -cp ./:jaxr-api.jar:ja-impl-mwcc.jar mw/path/MWPathPubishSrv
4. MWPathPubishSrv.java -->ip= 192.168.0.4:12345
5. MWCacheClient.java -->ip = 192.168.0.4:12346
openstack2
1. ~/.ssh$ ssh -i id_rsa cloud@134.169.47.28
2. cd /opt/cc-services/ccexercise/bin
3. java -cp ./:jaxr-api.jar:jarx-impl-mwcc.jar mw/cache/MWCache
4. MWCache.java -->ip = 192.168.0.4:12346
sftp
1. sftp cloud@134.169.47.28
2. lcd ./workspace/
3. cd /opt/cc-services/
4. put -r ./ccexercise ./

local computer
1. cd  ./workspace/ccexercise/
2. wsimport -p mw.pathclient -d bin -s src -keep http://134.169.47.28:12345/MWPathSrv?wsdl
3. MWClient.java ip-->134.169.47.28:12345



