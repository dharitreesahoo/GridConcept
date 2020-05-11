echo off
Title Node1 on port 5569
set projectLocation = D:\NewWorkspace\desiredCapability\resources
pushd %projectLocation%

java -Dwebdriver.ie.driver="D:\NewWorkspace\desiredCapability\resources\IEDriverServer.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.99.1:4444/grid/register -port 5569
