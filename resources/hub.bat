echo off
Title Server HUB on port 4444
echo Setting up Project LOcation
set projectLocation = D:\NewWorkspace\desiredCapability\resources
pushd %projectLocation%

Echo Loading HUb on deafult port 4444
java -jar selenium-server-standalone-3.141.59.jar -role hub
pause