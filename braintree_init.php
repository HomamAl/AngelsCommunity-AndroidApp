<?php 
	session_start();
	require_once("lib/autoload.php");
	if(file_exists(__DIR__ . "/../.env"))
	{
		$dotenv= new Dotenv\Dotenv(__DIR__ . "/../");
		$dotenv->load();
	}
	Braintree_Configuration::environment("sandbox");
	Braintree_Configuration::merchantId("9jxq5djysvrnjchr");
	Braintree_Configuration::publicKey("hk4tv27ckj7zswnm");
	Braintree_Configuration::privateKey("581b1b1a2042eed6f502ee3325d81272");
 ?>