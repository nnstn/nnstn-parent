package com.nnstn.toollist.version.svnkit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNProperty;
import org.tmatesoft.svn.core.SVNPropertyValue;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 *	显示文件内容操作
 */
public class Demo7DisplayFile {
	
	private static String svnurl = "svn://172.18.232.29:9101";
	private static String username = "appf";
	private static String password = "aaa111";
	private static String filepath = "test/初始提交测试.txt";
	

    public static void main(String[] args) {
    	/**==============================================================================**/
        //  1.对版本库进行初始化
        SVNRepositoryFactoryImpl.setup();
        SVNRepository repository = null;
        try {
        	//根据svnurl实例化svn版本库
			repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(svnurl));
			//版本库认证信息
			ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password.toCharArray());
			repository.setAuthenticationManager(authManager);
		} catch (SVNException e) {
			e.printStackTrace();
			System.out.println("创建版本库失败：【"+svnurl+"】 退出系统");
			System.exit(1);
		}
        /**==============================================================================**/
        //存放查看文件的属性名属性值
        SVNProperties properties = new SVNProperties();
        //输出流存放查看文件的内容
        ByteArrayOutputStream contents = new ByteArrayOutputStream();
        //获取版本库中文件的类型状态(是否存在，是目录还是文件)  -1表示获取版本库最新版本
        try {
			SVNNodeKind nodekind = repository.checkPath(filepath, -1);
			System.out.println("文件类型："+nodekind);
			if(nodekind ==SVNNodeKind.NONE){
				System.out.println("被访问的文件不存在:"+filepath);
				System.exit(1);;
			}else if(nodekind ==SVNNodeKind.DIR){
				System.out.println("被访问的文件是一个目录，不在demo范围内:"+filepath);
				System.exit(1);;
			}
			repository.getFile(filepath, -1, properties, contents);
		} catch (SVNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //获取文件的mimeType
        String mimeType = properties.getStringValue(SVNProperty.MIME_TYPE);
        //判断是否是文本类型
        boolean istext = SVNProperty.isTextMimeType(mimeType);
        System.out.println("文件是否是文本："+istext);
        
        //显示文件所有属性
        Iterator<String> iterator = properties.nameSet().iterator();
        while(iterator.hasNext()){
        	String name =iterator.next();
        	System.out.println(name +"||"+properties.getStringValue(name));
        }
        //显示文件内容
        if(istext){
        	System.out.println("文件内容：");
        	System.out.println("===================================");
        	try {
				contents.writeTo(System.out);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	System.out.println("===================================");
        }
        
        
    }

}
