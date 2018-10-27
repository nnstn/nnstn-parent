package com.nnstn.toollist.version.svnkit;

import java.util.Collection;
import java.util.Iterator;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class Demo6RepositoryTree {
	
	private static String svnurl = "svn://172.18.232.29:9101";
	private static String username = "appf";
	private static String password = "aaa111";
	

    public static void main(String[] args) {
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
        
        
        try {
			System.out.println("Repository Root："+repository.getRepositoryRoot(true));
			System.out.println("Repository UUID："+repository.getRepositoryUUID(true));
			System.out.println("Repository ："+repository.getLatestRevision());
			listEntries("", repository);
		} catch (SVNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/**
	 * 文件列表
	 */
	public static void listEntries(String path,SVNRepository repository) throws SVNException{
		Collection entries = repository.getDir(path, -1, null,(Collection) null);
		Iterator iterator = entries.iterator();
		while (iterator.hasNext()) {
			SVNDirEntry entry = (SVNDirEntry) iterator.next();
			System.out.println("/" + (path.equals("") ? "" : path + "/")
					+ entry.getName() + " ( author: '" + entry.getAuthor()
					+ "'; revision: " + entry.getRevision() + "; date: "
					+ entry.getDate() + ")");
			if (entry.getKind() == SVNNodeKind.DIR) {
				listEntries((path.equals("")) ? entry.getName(): path + "/" + entry.getName(),repository);
			}
		}

	}
}
