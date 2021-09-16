set TAG=%1

if "%TAG%" == "" then
   echo "TAG nao definida. Utilizando latest"
   TAG="latest"

copy target/*.jar app.jar

set IMAGEM=yurialcantara03/gymcontrol:%TAG%

echo %IMAGEM%

docker build -t %IMAGEM% .

echo "para subir a imagem ao repositorio, executar um "
echo "$ docker push %IMAGEM% "
echo 

