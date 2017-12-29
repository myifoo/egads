/**
 * The first thing to know about are types. The available types in Thrift are:
 *
 *  bool        Boolean, one byte
 *  i8 (byte)   Signed 8-bit integer
 *  i16         Signed 16-bit integer
 *  i32         Signed 32-bit integer
 *  i64         Signed 64-bit integer
 *  double      64-bit floating point value
 *  string      String
 *  binary      Blob (byte array)
 *  map<t1,t2>  Map from one type to another
 *  list<t1>    Ordered list of one type
 *  set<t1>     Set of unique elements of one type
 *
 * Did you also notice that Thrift supports C style comments?
 */

 // include "extension.thrift"

 namespace java com.myitech.segads

 struct TimeSeries {
        1:i64 timestamp,
        2:double value,
 }

/**
 * TODO handle errors and exceptions later
 */
service SegadsService {
        i32 init(), // init a session for time series analysis
        // diff: (type, order)
        bool config(1:i32 sid, 2:map<string, string> params), // config
//        string reset(1:i32 sid, 2:string name, 3:string value),
        bool close(1:i32 sid), // close the session with sid
        bool upload(1:i32 sid, 2:list<TimeSeries> tseries), // upload new TimeSeries values to specific session
        bool train(1:i32 sid), // create a new model
        //bool update(1:i32 sid, 2:list<TimeSeries> tseries),// add new time series and update model
        list<TimeSeries> predict(1:i32 sid, 2:i32 len), // return predict values list
        list<TimeSeries> fetch(),
        /*
         * (order, type, url)
         */
        string diff(1:map<string, string> params),
        string undiff(1:map<string, string> params),
}
