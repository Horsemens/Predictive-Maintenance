if [ -z $1 ]
then 
    export TAG=development
else
    export TAG=$1
fi

docker compose down
docker compose up