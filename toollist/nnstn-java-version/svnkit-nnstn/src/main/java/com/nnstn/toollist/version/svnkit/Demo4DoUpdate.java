package com.nnstn.toollist.version.svnkit;

import java.io.File;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class Demo4DoUpdate {
	public static void main(String[] args) {
		SVNRepositoryFactoryImpl.setup();
		//本地工作副本
		File directory = new File("d:/svndemo");
		
        SVNURL svnurl = null;
        try {
            svnurl = SVNURL.parseURIEncoded("svn://172.18.232.29:9101/");
        } catch (SVNException e) {
            e.printStackTrace();
        }
		DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(false);
		SVNClientManager clientManager  = SVNClientManager.newInstance(options, "appf", "aaa111");
		
		File commitfile = new File("D:/svndemo/test/初始提交测试.txt");
		try {
			if(commitfile.exists()){
				commitfile.delete();
			}
			SVNUpdateClient updateClient = clientManager.getUpdateClient();
			updateClient.setIgnoreExternals(false);
			System.out.println("更新后版本："+commitfile.exists());
			long doUpdate = updateClient.doUpdate(commitfile, SVNRevision.HEAD,SVNDepth.INFINITY ,false, false);
			System.out.println("更新后版本："+doUpdate);
		} catch (SVNException e) {
			e.printStackTrace();
		}
	}
}
