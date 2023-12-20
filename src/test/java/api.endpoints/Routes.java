package api.endpoints;
// The routes file will only contain the URL of the project
public class Routes {
        public static String base_url="https://testswitch-api.paytabs.net/IssApi/v1";

        //Security Module
        public static String token_url=base_url+"/auth/generateToken";

        //Corporate Module
        public static String create_corporate_url=base_url+"/hierarchy/create";
        public static String update_corporate_url=base_url+"/hierarchy/update";

        public static String getCreate_corporate_url=base_url+"/hierarchy/get";


        public static String get_corporate_account_url=base_url+"/auto-collect/institutions/accounts/get-details";
        public static String get_corporate_balance_url=base_url+"/auto-collect/institutions/accounts/get-balance";

        public static String get_corporate_transactions_url=base_url+"/auto-collect/institutions/accounts/get-txn-details";

}
