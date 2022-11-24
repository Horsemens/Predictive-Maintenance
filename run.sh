ip=$(ipconfig | grep "IPv4" | cut -d: -f2 | cut -d" " -f2 |grep  '^192'| awk 'NR==1')
echo "[INFO] Connecting to broker through IP ${ip}"
for file in $(ls env | grep ".env") 
do
    sed -i -e "/BROKERURL/ c\BROKERURL=tcp://${ip}:8083" env/$file
done

if [ -z $1 ]
then 
    export TAG=development
else
    export TAG=$1
fi

docker compose down
docker compose up