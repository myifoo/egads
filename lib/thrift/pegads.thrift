 namespace java com.myitech.segads

 service PegadsService {
    /*
     * (type, period, starttime, size)
     */
    string synthetic(1:map<string, string> params), // return data.csv url
    string acf(1:string tsUrl, 2:double start, 3:i32 period), // return acf_xx_xx.png url of acf result
    string pacf(1:string tsUrl, 2:double start, 3:i32 period), //
    /*
     * (order, type, url)
     */
    string diff(1:map<string, string> params),
    string undiff(1:map<string, string> params),
//    string correlation(), //
//    string autocorrelation(), //
//    string pacf(),
 }