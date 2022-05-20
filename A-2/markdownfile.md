> ### __Dockerize both the microservices and upload in Google container registry or IBM registry or docker hub__
* docker build -t margiibm/convertcurrency .  
* docker push margiibm/convertcurrency
* docker run -p 8000:8080 -d margiibm/convertcurrency
 
* docker build -t margiibm/currency . 
* docker push margiibm/currency  
* docker run -p 8001:8081 -d margiibm/currency

> ### __Invoke the MS-1 microservice from MS-2 using DNS discovery__
* C:\Users\vmware19\Downloads\K8S>kubectl apply -f convertcurrency.yaml
* C:\Users\vmware19\Downloads\K8S>kubectl apply -f currency.yaml 
* C:\Users\vmware19\Downloads\K8S>kubectl apply -f currencyconfig.yaml
 
* C:\Users\vmware19\Downloads\K8S>kubectl exec -it mynginx -- curl currency/cf/currency/EUR/amount/80
![DNS Discovery](./DNSdiscovery.jpg)

>### __Set up 3 instances of MS-1 and load balance the call from MS-2 to MS-1__
Sample program to sending multiple request:
```shell script
PS C:\Users\vmware19\Downloads\K8S>kubectl exec -it mynginx /bin/sh
#i=1
#while [ "$i" -le 1000 ]; do       
>curl currency/cf/currency/EUR/amount/80;
>i=$(( i + 1))
>done 
3107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.03107875.0 
```
> ### __Protect both microservices with a KONG Ingress rate limiting plugin of 20 Requests per minute__
* PS C:\Users\vmware19\Downloads\K8S>kubectl apply -f ./convertcurrency.yaml -f ./currency.yaml
* PS C:\Users\vmware19\Downloads\K8S>kubectl apply -f ./currencyingress.yaml
* PS C:\Users\vmware19\Downloads\K8S>kubectl apply -f ./currencyratelimit.yaml
![ingress Result](./ingress.jpg)

 
