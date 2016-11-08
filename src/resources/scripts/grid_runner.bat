::cd "d:\IF065\Offering Demo\oms_test_framework\src\resources\scripts"
start java -jar selenium-server-standalone-2.53.1.jar -role hub
start java -jar selenium-server-standalone-2.53.1.jar -role node -nodeConfig nodes_windows_config.json
start http://localhost:4444/grid/console#
cd ..\..\..
mvn clean test -Dsuite=grid
