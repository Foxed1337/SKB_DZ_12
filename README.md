# SKB_DZ_12
Produser и Consumer - отдельные приложения, для тестирования их нужно запускать вместе. Также для проверки работы Produser'а и Consumer'а необходимо 
установить брокер сообщиний ActiveMQ и в пропертях приложений добавить необходимые даннные для подключения к брокеру.

http://localhost:8090/get-messages - у Cunsumer'а, посмотреть все полученные сообщения

http://localhost:8090/send/{message} - у Producer, отправить сообщение Consumer'у