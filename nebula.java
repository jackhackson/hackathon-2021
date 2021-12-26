package com.nebula.hackson;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vesoft.nebula.ErrorCode;
import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.CASignedSSLParam;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.data.SelfSignedSSLParam;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import com.vesoft.nebula.client.graph.net.Session;

public class nebula {
	

	public String donebula(String audioData, String userNo, String ipAddr, String timestamp, String appid,String md5) {

      return doAudioData(audioData);


	}

	

	

	private String  doAudioData(String audioData) {
		String gnql="";
		return gnql;
		// ��ʼд��־
	}
	private String  getData(String ngql) {
		String result="{\"errcode\":-1,\"errmsg\":\""+"error"+"\"}";
		NebulaPool pool = new NebulaPool();
        Session session;
        try {
            NebulaPoolConfig nebulaPoolConfig = new NebulaPoolConfig();
            nebulaPoolConfig.setMaxConnSize(100);
            List<HostAddress> addresses = Arrays.asList(new HostAddress("127.0.0.1", 9669),
                    new HostAddress("127.0.0.1", 9670));
            pool.init(addresses, nebulaPoolConfig);
            session = pool.getSession("root", "nebula", false);
          

            {
                String query =ngql;
                ResultSet resp = session.execute(query);
                if (!resp.isSucceeded()) {
                  
                	result="{\"errcode\":-2,\"errmsg\":\""+"no data"+"\"}";
                }
                result="{\"errcode\":0,\"errmsg\":\""+"success"+"\",\"result\":\""+resp.toString()+"\"}";
            }

           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}

}
