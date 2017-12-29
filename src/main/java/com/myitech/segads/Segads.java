package com.myitech.segads;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TTransportException;

import java.util.HashMap;

/*
  +-------------------------------------------+
  | Server                                    |
  | (single-threaded, event-driven etc)       |
  +-------------------------------------------+
  | Processor                                 |
  | (compiler generated)                      |
  +-------------------------------------------+
  | Protocol                                  |
  | (JSON, compact etc)                       |
  +-------------------------------------------+
  | Transport                                 |
  | (raw TCP, HTTP etc)                       |
  +-------------------------------------------+
 */

public class Segads {

    public static void main(String[] args) {
        try {
            SegadsService.Processor  processor = new SegadsService.Processor(new SegadsServiceHandler());
            TServerTransport transport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(transport).processor(processor));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Starting segads server ... ");
                    server.serve();
                }
            }).start();

        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }

}
